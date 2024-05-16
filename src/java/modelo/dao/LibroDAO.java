package modelo.dao;

import java.util.List;
import modelo.dto.LibroDTO;
import conexiones.MySQL_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LibroDAO implements Contrato<LibroDTO>{
    
    private static final String SQL_READALL = "SELECT * FROM tb_libro ";
    private static final String SQL_INSERT = "INSERT INTO tb_libro (isbn, nombre, autor, editorial, anio) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM tb_libro WHERE isbn = ?";
    private static final String SQL_UPDATE = "UPDATE tb_libro SET nombre = ?, autor = ?, editorial = ?, anio = ? WHERE isbn = ?";
    private static final String SQL_DELETE = "DELETE FROM tb_libro WHERE isbn = ?";
    
    @Override
    public boolean create(LibroDTO nuevo) {
        Connection con = MySQL_BD.getInstance().cnn;
        PreparedStatement psnt = null;
        try {
            psnt = con.prepareStatement(SQL_INSERT);
            psnt.setLong(1, nuevo.getIsbn());
            psnt.setString(2, nuevo.getNombre());
            psnt.setString(3, nuevo.getAutor());
            psnt.setString(4, nuevo.getEditorial());
            psnt.setInt(5, nuevo.getAnio());
            return psnt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
        } finally {
            try {
                if (psnt != null) psnt.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean delete(LibroDTO item) {
        Connection con = MySQL_BD.getInstance().cnn;
        PreparedStatement psnt = null;
        try {
            psnt = con.prepareStatement(SQL_DELETE);
            psnt.setLong(1, item.getIsbn());
            return psnt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        } finally {
            try {
                if (psnt != null) psnt.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean update(LibroDTO filter) {
        Connection con = MySQL_BD.getInstance().cnn;
        PreparedStatement psnt = null;
        try {
            psnt = con.prepareStatement(SQL_UPDATE);
            psnt.setString(1, filter.getNombre());
            psnt.setString(2, filter.getAutor());
            psnt.setString(3, filter.getEditorial());
            psnt.setInt(4, filter.getAnio());
            psnt.setLong(5, filter.getIsbn());
            return psnt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        } finally {
            try {
                if (psnt != null) psnt.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
        return false;
    }

    @Override
public LibroDTO read(LibroDTO dto) {
    LibroDTO libro = null;
    String SQL_READ = "SELECT * FROM tb_libro WHERE isbn = ?";
    Connection con = MySQL_BD.getInstance().cnn;
    PreparedStatement psnt = null;
    ResultSet rs = null;
    try {
        psnt = con.prepareStatement(SQL_READ);
        psnt.setLong(1, dto.getIsbn());
        rs = psnt.executeQuery();
        if (rs.next()) {
            libro = new LibroDTO(
                rs.getLong("isbn"),
                rs.getString("nombre"),
                rs.getString("autor"),
                rs.getString("editorial"),
                rs.getInt("anio")
            );
        }
    } catch (SQLException ex) {
        System.out.println("Error al leer: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (psnt != null) psnt.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar recursos: " + ex.getMessage());
        }
    }
    return libro;
}


    @Override
    public List<LibroDTO> readAll() {
        List<LibroDTO> lista = null;
        Connection con = MySQL_BD.getInstance().cnn;
        PreparedStatement psnt = null;
        ResultSet rs = null;
            try {
                 psnt = con.prepareStatement(SQL_READALL);
                 rs = psnt.executeQuery();
                 lista = new ArrayList<LibroDTO>();
                 
                while (rs.next()){
                    //Crear un objeto de tipo modelo "Libro DTO"
                    LibroDTO libro = new LibroDTO(
                            rs.getLong("isbn"),
                            rs.getString("nombre"),
                            rs.getString("autor"),
                            rs.getString("editorial"),
                            rs.getInt("anio")
                    );
                    lista.add(libro);
                }
            } catch (SQLException ex) {
                System.out.println("Error al  "+ex.getMessage());
            }
            return lista;
    }
    
}
