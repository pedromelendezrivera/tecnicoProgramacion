
package controlador;

import javax.swing.JOptionPane;
import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;

public class Validar {
    
    public void validarRegistro(PersonaVO persona){
        PersonaDAO personaDAO = new PersonaDAO();
        
        PersonaVO personaBuscada = personaDAO.buscarPersona(persona.getIdPersona());
        if(personaBuscada == null){
            if(persona.getIdPersona() > 99999 ){
               personaDAO.registrarPersona(persona);
            }else{
                JOptionPane.showMessageDialog(null, "el ID debe ser de más de 5 digitos");
                 }
        }else
         {
              JOptionPane.showMessageDialog(null, "el ID ya existe en la base de datos");       
         }//fin valida    
        }   
}
