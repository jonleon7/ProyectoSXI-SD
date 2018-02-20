<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iesemilidarder.projectozero.core.dao.Restaurant" %>
<%@ page import="com.iesemilidarder.projectozero.core.base.ReadRestaurant" %>
<%@ page import="java.util.Iterator" %>

<%--
  Created by IntelliJ IDEA.
  User: cicles
  Date: 15/1/2018
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurants</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Restaurant Show M Da Wei</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Inici <span class="sr-only">(current)</span></a>
            </li>
            <!--
            <li class="nav-item">
                <a class="nav-link" href="test">Enllaç 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Enllaç 2</a>
            </li>
            -->
        </ul>
        <form class="form-inline my-2 my-lg-0" action="index.jsp">
            <input class="form-control mr-sm-2" type="text" placeholder="buscar" aria-label="buscar" name="buscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">buscar</button>
        </form>
    </div>
</nav>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Restaurants Show M Da wei</h1>
            <p>U dont know the way? Dont worry, I show u da wei</p>
            <!--  <p><a class="btn btn-primary btn-lg" href="test" role="button">Learn more &raquo;</a></p> -->
        </div>
    </div>

    <div class="container">

        <%

            Restaurant restaurant = (Restaurant) request.getAttribute("id");

                out.println("<p>" + "<img class='img-fluid' src='" + restaurant.getUrl_imagen() + "'>"  + "</p>");
                out.println(
                        "<p>" + restaurant.getName() + "</p>" +
                        "<p>" + restaurant.getType() + "</p>" +
                        "<p>" + restaurant.getAddress() + "</p>" +
                        "<p>" + restaurant.getTelephone() + "</p>" +
                        "<p>" + restaurant.getWebsite() + "</p>"
                );

            for (String opinion :restaurant.getOpinions()) {
                    out.println("<p>" + opinion + "</p>");
            }
        %>
        <hr>
    </div> <!-- /container -->
</main>

<footer class="container">
    <p>&copy; Jonathan De León Sola 2017</p>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
