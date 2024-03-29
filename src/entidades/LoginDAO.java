package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log (String correo, String pass){
    login lg = new login();
    String sql = "SELECT * FROM usuario WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,correo);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            if (rs.next()) {
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setCorreo(rs.getString("correo"));
                lg.setPass(rs.getString("pass"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lg;
    }
    public List ListarUsuario(){
    List<login> ListaUsuario= new ArrayList();
    String sql = "SELECT * FROM usuario";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           login lg = new login();
           lg.setId(rs.getInt("id"));
           lg.setNombre(rs.getString("nombre"));
           lg.setCorreo(rs.getString("correo"));
           lg.setPass(rs.getString("pass"));
           lg.setCuenta(rs.getString("cuenta"));
           ListaUsuario.add(lg);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaUsuario;
    }    
}
