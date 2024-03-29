/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dash
 */
public class ClienteDAO {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
    public boolean RegistrarCliente(Cliente cl){
    String sql = "INSERT INTO clientes (dni,nombre,telefono,direccion,origen) VALUES (?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,cl.getDni());
            ps.setString(2,cl.getNombre());
            ps.setInt(3,cl.getTelefono());
            ps.setString(4,cl.getDireccion());
            ps.setString(5,cl.getOrigen());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
  
    }
    public List ListarCliente(){
    List<Cliente> ListaCl= new ArrayList();
    String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           Cliente cl = new Cliente();
           cl.setId(rs.getInt("id"));
           cl.setDni(rs.getInt("dni"));
           cl.setNombre(rs.getString("nombre"));
           cl.setTelefono(rs.getInt("telefono"));
           cl.setDireccion(rs.getString("direccion"));
           cl.setOrigen(rs.getString("origen"));
           ListaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;
    }
public boolean EliminarCliente(int id){
    String sql= "DELETE FROM clientes WHERE id=?";
    try {
        ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
      
    }finally{
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
public boolean ActualizarCliente(Cliente cl){
    //para ejecutar el query SQL
    String sql = "UPDATE clientes SET dni=?,nombre=?,telefono=?,direccion=?,origen=? WHERE id=?";
    try {
        ps=con.prepareStatement(sql);
        ps.setInt(1,cl.getDni());
        ps.setString(2,cl.getNombre());
        ps.setInt(3,cl.getTelefono());
        ps.setString(4,cl.getDireccion());
        ps.setString(5,cl.getOrigen());
        ps.setInt(6,cl.getId());
        ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
        //cerrando la conexcion
    }finally{
        try {
            con.close();
        } catch (SQLException e) {
            //para capturar el error
            System.out.println(e.toString());
        }
    }
       
        
}
 public Cliente BuscarCliente(int dni){
        Cliente cl = new Cliente();
        String sql = "SELECT * FROM clientes WHERE dni =?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()); {
            cl.setNombre(rs.getString("nombre"));
            cl.setTelefono(rs.getInt("telefono"));
            cl.setDireccion(rs.getString("direccion"));
            cl.setOrigen(rs.getString("origen"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cl;
    }

}
