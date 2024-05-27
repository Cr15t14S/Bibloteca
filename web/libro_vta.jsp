<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos los libros</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <h1>Lista de todos los libros</h1>
            <table class="table table-hover table-dark">
                <thead>
                    <tr>
                        <th scope="col">ISBN</th>
                        <th scope="col">Nombre libro</th>
                        <th scope="col">Autor</th>
                        <th scope="col">Editorial</th>
                        <th scope="col">Año</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="libro" items="${Lista}" >
                        <tr>
                            <td>${libro.getIsbn()}</td>
                            <td>${libro.getNombre()}</td>
                            <td>${libro.getAutor()}</td>
                            <td>@${libro.getEditorial()}</td>
                            <td>@${libro.getAnio()}</td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
