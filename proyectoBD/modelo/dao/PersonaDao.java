package modelo.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.vo.PersonaVo;
/**
 * Clase que permite el acceso a la base de datos
 * @author pmelendez
 *
 */
public class PersonaDao
{
	public void registrarPersona(PersonaVo miPersona)
	{
		Conexion conex= new Conexion();
                PreparedStatement pst = null; 
                String sql = "INSERT INTO persona(id,nombre,edad,profesion,telefono) VALUES (?,?,?,?,?)";
 
		try {
                    pst = conex.getConnection().prepareStatement(sql);
                    pst.setInt(1, miPersona.getIdPersona());
                    pst.setString(2, miPersona.getNombrePersona());
                    pst.setInt(3, miPersona.getEdadPersona());
                    pst.setString(4, miPersona.getProfesionPersona());                  
                    pst.setInt(5, miPersona.getTelefonoPersona());
                    pst.executeUpdate();
      		    JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",
                                                  JOptionPane.INFORMATION_MESSAGE);
		    conex.getConnection().close();
		    conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public PersonaVo buscarPersona(int codigo) 
	{
		Conexion conex= new Conexion();
		PersonaVo persona= new PersonaVo();
		boolean existe=false;
                PreparedStatement pst = null; 
                String sql = "SELECT * FROM persona where id = ? ";
		try {	
		     pst= conex.getConnection().prepareStatement(sql);
		     pst.setInt(1, codigo);
		     ResultSet res = pst.executeQuery();
		     while(res.next()){
			   existe=true;
			   persona.setIdPersona(Integer.parseInt(res.getString("id")));
			   persona.setNombrePersona(res.getString("nombre"));
			   persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
			   persona.setProfesionPersona(res.getString("profesion"));
			   persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
			 }
			res.close();
			conex.desconectar();					
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error, no se conecto");
				System.out.println(e);
			}
		
			if (existe) {
				return persona;
			}
			else return null;				
	}

	public void modificarPersona(PersonaVo miPersona) {
		
		Conexion conex= new Conexion();
                PreparedStatement pst = null; 
		try{
		    String sql="UPDATE persona SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
	            pst = conex.getConnection().prepareStatement(sql);	
                    pst.setInt(1, miPersona.getIdPersona());
                    pst.setString(2, miPersona.getNombrePersona());
                    pst.setInt(3, miPersona.getEdadPersona());
                    pst.setString(4, miPersona.getProfesionPersona());
                    pst.setInt(5,miPersona.getTelefonoPersona());
                    pst.setInt(6, miPersona.getIdPersona());
                    pst.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmaci�n",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarPersona(int codigo)
	{
	    Conexion conex= new Conexion();
            PreparedStatement pst = null; 
	try {
      	    String sql="DELETE FROM persona WHERE id = ? ";
	    pst = conex.getConnection().prepareStatement(sql);	
            pst.setInt(1, codigo);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",
                                                JOptionPane.INFORMATION_MESSAGE);
	    conex.getConnection().close();
  	    conex.desconectar();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
