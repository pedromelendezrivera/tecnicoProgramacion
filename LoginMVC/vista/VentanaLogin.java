package vista;

import controlador.ControladorLogin;
import controlador.Hash;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import modelo.dao.UsuarioDao;
import modelo.vo.UsuarioVo;

public class VentanaLogin extends JFrame implements ActionListener{

    public javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    
    private ControladorLogin controladorLogin; 

    public VentanaLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
      	setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 90, 600, 500);
        setResizable(false);
	setLayout(null);
        
        jLabel1 = new JLabel();
        txtUsuario = new JTextField();
        jLabel2 = new JLabel();
        btnEntrar = new JButton();
        txtPassword = new JPasswordField();

        jLabel1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");
        jLabel1.setBounds(150, 150, 100, 50);
        add(jLabel1);
        
        txtUsuario.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        txtUsuario.setBounds(250, 150, 120, 50);
        add(txtUsuario);
        
        jLabel2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password:");
        jLabel2.setBounds(150, 230, 120, 50);
        add(jLabel2);
        
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setBounds(250, 230, 120, 50);
        add(txtPassword);
        
        btnEntrar.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBounds(300, 350, 150, 50);
        btnEntrar.addActionListener(this);
        add(btnEntrar);

    }
    
    
    
      	public void setCoordinadorLogin(ControladorLogin coordinadorLogin) {
		this.controladorLogin = coordinadorLogin;
	}


    public void actionPerformed(ActionEvent e) {
   		if (e.getSource()==btnEntrar) {
                        //getPassword es un array tipo char se debe convertir en String
//                    VentanaMenuPrincipal VentanaMenuPrincipal = new VentanaMenuPrincipal();  
		    UsuarioDao usuarioDao = new UsuarioDao();
                    UsuarioVo mod = new UsuarioVo();      
  
                    String pass = new String(txtPassword.getPassword());
         
                    if (!txtUsuario.getText().equals("") && !pass.equals("")) {
                         String nuevoPass = Hash.sha1(pass);
                         
                         mod.setUsuario(txtUsuario.getText());
                         mod.setPassword(nuevoPass);          
                    
                         if (usuarioDao.login(mod)) {

                             this.dispose();
                             VentanaMenuPrincipal VentanaMenuPrincipal = new VentanaMenuPrincipal();  

                             VentanaMenuPrincipal.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Datos incorrectos");
                            limpiar();
                        }
                        } else {
                           JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
                       }
                }
    }
     
    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }

}
