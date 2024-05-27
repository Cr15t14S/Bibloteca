<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">        
        <title>CRUD</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-5">
                <div class="card-body">
                    <form action="ControlCTO" method="post">
                        <div class="form-group">
                            <label>isbn</label>
                            <input type="text" value="${LibroDTO.getIsbn()}" name="txtIsbn" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNombre()}" name="txtNombre" class="form-control">                        
                        </div>
                        <div class="form-group">
                            <label>Autor</label>
                            <input type="text" value="${empleado.getAutor()}" name="txtAutor" class="form-control">                        
                        </div>
                        <div class="form-group">
                            <label>Editorial</label>
                            <input type="text" value="${empleado.getAnio()}" name="txtAnio" class="form-control">                        
                        </div>
                        <div class="form-group">
                            <label>Año</label>
                            <input type="text" value="${empleado.getNombre()}" name="txtNombre" class="form-control">                        
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Isbn</th>
                            <th>Nombre</th>
                            <th>Autor</th>
                            <th>Editorial</th>
                            <th>Año</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="libro" items="${Lista}">

                            <tr>
                                <td>${libro.getIsbn()}</td>
                                <td>${libro.getNombre()}</td>
                                <td>${libro.getAutor()}</td>
                                <td>@${libro.getEditorial()}</td>
                                <td>@${libro.getAnio()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ControlCTO?menu=Libro_Crud&accion=Modificar&id=${libro.getIsbn()}">Editar</a>
                                    <a class="btn btn-danger" href="ControlCTO?menu=Libro_Crud&accion=Modificar&id=${libro.getIsbn()}">Eliminar</a>
                                </td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

    </body>
</html>