package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.vo.PersonaVO;

/**
 *
 * @author ADSI1324116
 */
public class PersonaDAO {
    
    public void registrarPersona(PersonaVO miPersona){
           Conexion conex = new Conexion();
           PreparedStatement pst = null;
           String sql = "INSERT INTO persona(id,nombre,edad,profesion,telefono) VALUES(?,?,?,?,?)";
    
           try{
                pst= conex.getConnection().prepareStatement(sql);
                pst.setInt(1, miPersona.getIdPersona());
                pst.setString(2, miPersona.getNombrePersona());
                pst.setInt(3, miPersona.getEdadPersona());
                pst.setString(4, miPersona.getProfesionPersona());
                pst.setInt(5, miPersona.getTelefonoPersona());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro ibgresado a la base de datos", "Información",
                                              JOptionPane.INFORMATION_MESSAGE);
                conex.getConnection().close();
                conex.desconectar();
           }catch(SQLException ex){
               System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "No se agrego el registro a la base de datos", "Información",
                                              JOptionPane.INFORMATION_MESSAGE);
           }
    }
    
     	public PersonaVO buscarPersona(int codigo) 
	{
            PersonaVO persona= new PersonaVO();
            Conexion conex= new Conexion(); 
            PreparedStatement pst = null; 
            String sql = "SELECT * FROM persona where id = ? ";
        try {
            pst = conex.getConnection().prepareStatement(sql);
            pst.setInt(1, codigo);
            
        } catch (SQLException ex) { 
      		JOptionPane.showMessageDialog(null, "Error, no se conecto");}
	    			
	
        return persona;
        } 
            
}
