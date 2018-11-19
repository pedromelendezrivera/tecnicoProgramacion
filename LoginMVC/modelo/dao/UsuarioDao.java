package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.vo.UsuarioVo;
//import vista.VentanaMenuPrincipal;
/**
 *
 * @author PMELENDEZ
 */
public class UsuarioDao {
    
       public boolean loginUsuario(UsuarioVo usuarioVo)
       {
		Conexion conex= new Conexion();
                PreparedStatement pst = null; 
                
                String sql = "SELECT id, usuario, password, nombre, id_tipo FROM usuarios WHERE usuario = ? LIMIT 1";
                try{
                    pst = conex.getConnection().prepareStatement(sql);
 		    pst.setString(1, usuarioVo.getUsuario());
		    ResultSet res = pst.executeQuery();                   
                    if(res.next()){
                        if(usuarioVo.getPassword().equals(res.getString(3))){
//                           usuarioVo.setId(res.getInt(1));
//                           usuarioVo.setNombre(res.getString(4));
//                           usuarioVo.setIdTipo(res.getInt(5));
                           return true;
                        } else return false;
                    }
                   
                    
                } catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error, no se conecto");
				System.out.println(e);
                }
                 return false;                
       }
               
    
    
    
    
    
    
    	public UsuarioVo buscarUsuario(UsuarioVo usuarioVo) 
	{
		Conexion conex= new Conexion();
		UsuarioVo usuario= new UsuarioVo();
		boolean existe=false;
                PreparedStatement pst = null; 
                String sql = "SELECT id, usuario, password, nombre, id_tipo FROM usuarios WHERE usuario = ? LIMIT 1";
		try {	
		     pst= conex.getConnection().prepareStatement(sql);
		     pst.setString(1, usuarioVo.getUsuario());
		     ResultSet res = pst.executeQuery();
		     while(res.next()){
                         existe=true;   
                         System.out.println("encontrado..");
                         if (usuarioVo.getPassword().equals(res.getString(3))) {
                             usuario.setId(res.getInt(1));
                             usuario.setNombre(res.getString(4));
                             usuario.setIdTipo(res.getInt(5));
                           }
//			   usuario.setUsuario(res.getString("usuario"));
//			   usuario.setPassword(res.getString("password"));    
                     }
			res.close();
			conex.desconectar();					
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error, no se conecto");
				System.out.println(e);
			}
			if (existe) {
				return usuario;
			}
                    else {
 		   JOptionPane.showMessageDialog(null,"Usuario no registrado","Advertencia",JOptionPane.WARNING_MESSAGE);
                          return null;      
                        }				
	}
        
        
        
        public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().getConnection();

        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

  public boolean esEmail(String correo) {
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }

public boolean registrar(UsuarioVo usr) {
        PreparedStatement ps = null;
        Connection con = new Conexion().getConnection();

        String sql = "INSERT INTO usuarios (usuario, password, nombre, correo, id_tipo) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getEmail());
            ps.setInt(5, usr.getIdTipo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
}
