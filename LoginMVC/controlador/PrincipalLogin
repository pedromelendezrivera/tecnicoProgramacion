package controlador;
import vista.VentanaLogin;

/**
 *
 * @author PMELENDEZ
 */
public class PrincipalLogin {
        ControladorLogin controladorLogin = new ControladorLogin();
        VentanaLogin ventanaLogin = new VentanaLogin();
        
        public static void main(String[] args) {
            new PrincipalLogin();
	}
        
          public PrincipalLogin() {
              controladorLogin.setVentanaLogin(ventanaLogin);
              ventanaLogin.setCoordinadorLogin(controladorLogin);
              ventanaLogin.setVisible(true);
             
          }
}
