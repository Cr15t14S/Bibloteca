/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

/**
 *
 * @author Estudiante
 */
public class ControlCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("action");

        if (menu.equals("Libros")) {
            switch (accion) {
                case "Listar":
                    LibroDAO dao = new LibroDAO();
                    if (accion.equalsIgnoreCase("Listar")) {
                        List<LibroDTO> lista = dao.readAll();
                        request.setAttribute("Lista", lista);
                        request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                    }
                    break;
                default: {
                    request.getRequestDispatcher("error.html").forward(request, response);
                }
            }
        }
        if (menu.equals("Libro_Crud")) {
            switch (accion) {
                case "Modificar":
                    LibroDAO dao = new LibroDAO();
                    if (accion.equalsIgnoreCase("Modificar ")){
                        List<LibroDTO> lista = dao.readAll();
                        request.setAttribute("Lista", lista);
                        request.getRequestDispatcher("libro_crud.jsp").forward(request, response);
                    }else{
                        request.getRequestDispatcher("libro_crud.jsp").forward(request, response);
                    }
                    break;
                case "Edidar":
                    //ide = Integer.parseInt(request.getParameter("id"));
                default:{
                    request.getRequestDispatcher("error.html").forward(request, response);
                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
