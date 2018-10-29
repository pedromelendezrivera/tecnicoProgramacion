package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            ResultSet res = pst.executeQuery();
            while(res.next()){
                persona.setIdPersona(Integer.parseInt(res.getString("id")));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
                persona.setProfesionPersona(res.getString("profesion"));
                persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
            }
             res.close();
             conex.desconectar();
        } catch (SQLException ex) { 
      		JOptionPane.showMessageDialog(null, "Error, no se conecto");}
	    			
        return persona;
        }
        
        public void modificarPersona(PersonaVO persona){
            Conexion conex = new Conexion();
            PreparedStatement pst = null;
            String sql="UPDATE persona SET id = ?, nombre = ?, edad=?, "
                    + "profesion=?, telefono=? WHERE id = ? ";
        try {
            pst = conex.getConnection().prepareStatement(sql);
            pst.setInt(1, persona.getIdPersona());
            pst.setString(2, persona.getNombrePersona());
            pst.setInt(3, persona.getEdadPersona());
            pst.setString(4, persona.getProfesionPersona());
            pst.setInt(5, persona.getTelefonoPersona());
            pst.setInt(6,persona.getIdPersona() );
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro actualizado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conecion a la BD");
         }      
  }
        
    
            
}
