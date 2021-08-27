package dao;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Paciente;


public class PacienteDao {
    Conexion conn;
    
    public PacienteDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Paciente user){
        String sql = "insert into paciente values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, user.getIdpaciente());
            ps.setString(2, user.getNombres());
            ps.setString(3, user.getApellidos());
            ps.setString(4, user.getDiagnostico());
            ps.setString(5, user.getIngresado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
    
    
    public List<Paciente>consultarAll(){
        String sql = "select * from paciente";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Paciente user;
            List<Paciente> lista = new LinkedList<>();
            while(rs.next()){
                user = new Paciente(rs.getInt("idpaciente"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidos(rs.getString("apellidos"));
                user.setDiagnostico(rs.getString("diagnostico"));
                user.setIngresado(rs.getString("ingresado"));
                lista.add(user);
            }           
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
