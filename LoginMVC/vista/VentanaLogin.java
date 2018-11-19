package vista;

import controlador.CoordinadorLogin;
import java.awt.Font;
import javax.swing.*;

public class VentanaLogin extends JFrame {

    public javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    
    private CoordinadorLogin coordinadorLogin; 

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
        add(btnEntrar);

    }
    
    
    
      	public void setCoordinadorLogin(CoordinadorLogin coordinadorLogin) {
		this.coordinadorLogin = coordinadorLogin;
	}

}


