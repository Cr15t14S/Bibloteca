package control;

import conexiones.MySQL_BD;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

public class TextConexion {

    public static void main(String[] args) {
        try {
            MySQL_BD.getInstance();
            LibroDAO dao = new LibroDAO();
            
            // Leer todos los libros
            List<LibroDTO> lista = dao.readAll();
            for (LibroDTO i : lista) {
                System.out.println(i.toString());
            }
            MySQL_BD.getInstance().cerrarConexion();
            
            // Crear un nuevo libro
            LibroDTO nuevoLibro = new LibroDTO(12345678, "El Quijote", "Miguel de Cervantes", "Editorial ABC", 1605);
            boolean creado = dao.create(nuevoLibro);
            System.out.println("Libro creado: " + creado);

            // Leer un libro por ISBN
            LibroDTO libroLeido = dao.read(new LibroDTO(978958612));
            if (libroLeido != null) {
                System.out.println("Libro leído: " + libroLeido);

                // Actualizar el libro
                libroLeido.setNombre("Don Quijote de la Mancha");
                libroLeido.setAnio(1000);
                boolean actualizado = dao.update(libroLeido);
                System.out.println("Libro actualizado: " + actualizado);

                // Leer todos los libros después de la actualización
                System.out.println("Lista de todos los libros después de la actualización:");
                lista = dao.readAll();
                for (LibroDTO libro : lista) {
                    System.out.println(libro);
                }
            } else {
                System.out.println("Libro no encontrado para lectura y actualización.");
            }

            // Eliminar el libro
            boolean eliminado = dao.delete(new LibroDTO(12345678));
            System.out.println("Libro eliminado: " + eliminado);

            // Verificar que el libro fue eliminado
            LibroDTO libroEliminado = dao.read(new LibroDTO(12345678));
            System.out.println("Libro después de eliminar: " + libroEliminado);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            MySQL_BD.getInstance().cerrarConexion();
        }
    }
}
