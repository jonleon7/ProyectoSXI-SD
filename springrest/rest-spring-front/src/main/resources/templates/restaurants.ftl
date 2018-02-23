<!DOCTYPE html>
<html lang="en">
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
<!-- Navigation bar -->
<nav class="navbar navbar-expand-md navbar-white fixed-top bg-dark">
    <a class="navbar-brand" href="index.jsp">Restaurant Show M Da Wei</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault" >
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Inici <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <!--Boton de busqueda-->
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

        </div>
    </div>

    <div class="container">
        <!-- mostramos el restaurante con su ID y las opiniones de los usuarios -->

        <table width="100%"class="nombre">
            <tr>
                <th>Tipo</th>
                <th>Nombre</th>
                <th>Direccion</th>
                <th>Telefono</th>
            </tr>
        </table>
        <script
                src="http://code.jquery.com/jquery-3.3.1.min.js"
                integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
                crossorigin="anonymous">

        </script>
        <tr>
            <script>
                $(document).ready(function () {
                    console.log($("#myTitle").html());
                    $.get("/rest/api/restaurantes", function (data) {
                        console.log(data);
                        var contentHtml = "<h2>Nombre</h2>";
                        $.each(data, function( index, value ) {
                            contentHtml ="";
                            var nombre= "<td>"+value.nombre+"</td>";
                            var direccion= "<td>"+value.direccion+"</td>";
                            var telefono= "<td>"+value.telefono+"</td>";
                            var tipo= "<td>"+value.tipo+"</td>";
                            contentHtml += "<tr>"+ tipo + nombre + direccion + telefono + "</tr>";
                            $(".nombre").append(contentHtml);
                        });

                        console.log("Load was performed.");
                    });
                });
            </script>
        <hr>
    </div> <!-- /container -->
</main>
<footer class="container">
    <p>&copy; Jonathan De León Sola 2017</p>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>