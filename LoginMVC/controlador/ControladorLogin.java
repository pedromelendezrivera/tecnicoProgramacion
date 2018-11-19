package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.UsuarioDao;
import modelo.vo.UsuarioVo;
import vista.VentanaLogin;
import vista.VentanaMenuPrincipal;

/**
 *
 * @author PMELENDEZ
 */
public class CoordinadorLogin implements ActionListener{
       private VentanaLogin ventanaLogin = new VentanaLogin();

    public VentanaLogin getVentanaLogin() {
        return ventanaLogin;
    }

    public void setVentanaLogin(VentanaLogin ventanaLogin) {
        this.ventanaLogin = ventanaLogin;
        this.ventanaLogin.btnEntrar.addActionListener(this);
    }
       
    public void validarUsuario(UsuarioVo usu) {
          UsuarioDao usuarioDao = new UsuarioDao();
      //    UsuarioVo usuario = new UsuarioVo();         
           if (!usu.getUsuario().equals("") && !usu.getPassword().equals("")) {
               String pass = new String(usu.getPassword());
               String nuevoPass = Hash.sha1(pass);
              usu.setPassword(nuevoPass);
              if(usuarioDao.loginUsuario(usu)){
                  ventanaLogin.dispose();
                  VentanaMenuPrincipal menu = new VentanaMenuPrincipal();
                  menu.setVisible(true);
              }else{
                      JOptionPane.showMessageDialog(null, "Usuario NO encontrado");
                      limpiar();
              }
               
           }else {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
           }
   }
    
    public void limpiar(){
       ventanaLogin.txtUsuario.setText("");
       ventanaLogin.txtPassword.setText("");
    }

   public void actionPerformed(ActionEvent e) {
   		if (e.getSource()== ventanaLogin.btnEntrar) {
                   //capturar el usuario en una instancia UsuarioVo
      UsuarioVo usuarioVo = new UsuarioVo(ventanaLogin.txtUsuario.getText(),String.valueOf(ventanaLogin.txtPassword.getPassword()));
			validarUsuario(usuarioVo);			
		}
    }
}
