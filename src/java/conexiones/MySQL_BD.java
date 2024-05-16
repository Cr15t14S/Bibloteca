package conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQL_BD {
    private static MySQL_BD instance;
    
    public Connection cnn = null;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String pss = "1234";
    private String nom_bd = "bd_biblioteca";
    private String url = "jdbc:mysql://localhost:3306/";
    
    
    private MySQL_BD(){
        System.out.println("Creando insatancia");
        try{
            Class.forName(driver);
            cnn = DriverManager.getConnection(url+nom_bd, user, pss); 
            System.out.println("Conexion exitosa :DDDDDDD");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error al cargar el drive BD "+ex.getMessage());
        }

        
        
        
    }
    public static synchronized MySQL_BD getInstance() {
        if(instance==null){
            instance = new MySQL_BD();
        }
        return instance;
    }
    public void cerrarConexion(){
        if (cnn != null){
            try {
                cnn.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException ex){
                System.out.println("Error al cerrar la conexion "+ex.getMessage());
            }
        }
        instance = null;
    }
}
