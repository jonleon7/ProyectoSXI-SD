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
                System.out.println("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI) WHERE ROWNUM <= 5");
                rs = stmt.executeQuery("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI ) WHERE ROWNUM <=5");

            }
            else {
                System.out.println("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND LOWER (R.RES_NOM) LIKE '%'+buscar.toLowerCase()+'%') WHERE ROWNUM <=5");
                rs = stmt.executeQuery("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND LOWER (R.RES_NOM) LIKE '%'+buscar.toLowerCase()+'%') WHERE ROWNUM <=5");
            }
            while (rs.next()) {
                //Las columnas que queremos ver
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");


                Restaurant std = new Restaurant();
                std.setName(name);
                std.setAddress(address);
                std.setWebsite(website);
                std.setTelephone(telephone);
                std.setType(type);

                al.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }
}

