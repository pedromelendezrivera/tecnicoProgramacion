package pruebaConexion;

import controlador.Validar;
import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;


/**
 *
 * @author ADSI1324116
 */
public class InsertarPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDAO personadao = new PersonaDAO();
        Validar validar = new Validar();
        PersonaVO persona = new PersonaVO(100002,"Pepe",19,"Instructor",86711111);
        validar.validarRegistro(persona);
       
    }
    
}
