package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Conexion;
import vista.VistaJDialog;

public class ControladorJdialog {
    VistaJDialog vistaJDialog;
    DefaultComboBoxModel modeloDepartamentos;
    DefaultComboBoxModel modeloMunicipos;
    
    public ControladorJdialog(VistaJDialog vistaJDialog) {
           this.vistaJDialog = vistaJDialog;
           modeloDepartamentos = new DefaultComboBoxModel();
           modeloMunicipos = new DefaultComboBoxModel();
           llena_departamentos();
           llenar_municipios();
     
           this.vistaJDialog.setLocationRelativeTo(null);
           this.vistaJDialog.setVisible(true);
    }

    private void llena_departamentos() {
        modeloDepartamentos.removeAllElements();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = new Conexion().getConnection();
        String sql = "select nombre from tbl_departamentos";    
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               modeloDepartamentos.addElement(rs.getString("nombre"));
            }
            System.out.println("ok");
            this.vistaJDialog.jComboDepartamento.setModel(modeloDepartamentos);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    private void llenar_municipios() {
       modeloMunicipos.removeAllElements();
       PreparedStatement ps = null;
       ResultSet rs = null;
       Connection conn = new Conexion().getConnection();
       String sql = "select nombre from tbl_municipios where departamento_id = ?";        
       try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"1");
            rs = ps.executeQuery();
             while(rs.next()){
               modeloMunicipos.addElement(rs.getString("nombre"));
            }                
            this.vistaJDialog.jComboMunicipio.setModel(modeloMunicipos);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
     
    }

    
    
}
