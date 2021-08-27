package conexion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    static String bd = "clinica";
    static String user ="root";
    static String pass="root";
    static String url="jdbc:mysql://localhost:3306/"+bd;
    Connection conn = null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn =(Connection) DriverManager.getConnection(url, user, pass);
            if (conn!=null) {
                System.out.println("exito");
            }
        }catch(Exception e){
            System.out.println("error");
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws Exception{
        conn.close();
    }
}
