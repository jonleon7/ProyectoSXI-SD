package com.iesemilidarder.projectozero.core;
//Importaciones de sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReadRestaurant {
    //ArrayList para leer restaurantes
    public static List<Restaurant> readRestaurants(String buscar) {
        ArrayList al = new ArrayList();
        try {
            //Ponemos que usamos base de datos Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");

            Statement stmt = con.createStatement();
            //Ponemos el SELECT de lo que queremos ver
            ResultSet rs;

            if (buscar == null || buscar.equals("")){
                System.out.println("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <= 5");
                rs = stmt.executeQuery("SELECT * FROM (SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <=5");
            }
            else {
                System.out.println("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND LOWER (R.RES_NOM) LIKE '%'+buscar.toLowerCase()+'%' ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <=5");
                rs = stmt.executeQuery("SELECT * FROM (SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND LOWER (R.RES_NOM) LIKE '%'+buscar.toLowerCase()+'%' ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <=5");
            }

            while (rs.next()) {
                //Las columnas que queremos ver
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String id = rs.getString("RES_CODI");
                String url_imagen = rs.getString("RES_URL_IMG");


                Restaurant std = new Restaurant();
                std.setName(name);
                std.setAddress(address);
                std.setWebsite(website);
                std.setTelephone(telephone);
                std.setType(type);
                std.setId(id);
                std.setUrl_imagen(url_imagen);


                al.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }

    //segundo metodo
    public Restaurant readDB(String id) {
        Restaurant rstt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");

            //sacar el restaurante de la base de datos
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, " +
                    "R.RES_CODI, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE " + id+ "= R.RES_CODI " +
                    "AND R.RES_TRS_CODI = TR.TRS_CODI");

            if (rs.next()){
                rstt = new Restaurant();

                rstt.setName(rs.getString("RES_NOM"));
                rstt.setAddress(rs.getString("RES_ADRECA"));
                rstt.setTelephone(rs.getString("RES_TELEFON"));
                rstt.setType(rs.getString("TRS_DESCRIPCIO"));
                rstt.setWebsite(rs.getString("RES_WEB"));
                rstt.setId(rs.getString("RES_CODI"));
                rstt.setUrl_imagen(rs.getString("RES_URL_IMG"));


                // Sacar los comentarios de la base de datos
                Statement stamt = con.createStatement();
                ResultSet rst;

                rst = stamt.executeQuery("SELECT O.OPI_OBSERVACIO, U.USU_NOM FROM RESTAURANTS R, OPINIONS O, USUARIS U WHERE R.RES_CODI = O.OPI_RES_CODI AND " + id + "=R.RES_CODI AND O.OPI_USU_CODI = U.USU_CODI");

                while (rst.next()){

                    rstt.getOpinions().add(rst.getString("USU_NOM"));
                    rstt.getOpinions().add(rst.getString("OPI_OBSERVACIO"));
                }
                stamt.close();
            }
            stmt.close();
            con.close();

        } catch (Exception x) {
            System.out.println(x.toString());
        }
        return rstt;
    }

}

