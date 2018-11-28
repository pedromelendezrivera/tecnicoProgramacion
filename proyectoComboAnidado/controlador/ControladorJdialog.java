package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Conexion;
import vista.VistaJDialog;

public class ControladorJdialog implements ItemListener, ActionListener{
    VistaJDialog vistaJDialog;
    DefaultComboBoxModel modeloDepartamentos;
    DefaultComboBoxModel modeloMunicipos;
    
    public ControladorJdialog(VistaJDialog vistaJDialog) {
           this.vistaJDialog = vistaJDialog;
           modeloDepartamentos = new DefaultComboBoxModel();
           modeloMunicipos = new DefaultComboBoxModel();
           llena_departamentos();
           llenar_municipios();
           this.vistaJDialog.jComboDepartamento.addItemListener(this); 
           this.vistaJDialog.jButtonLeer.addActionListener(this);
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        llenar_municipios(e);
    }
    
    private void llenar_municipios(ItemEvent e) {
        modeloMunicipos.removeAllElements();
        String dep = e.getItem().toString();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = new Conexion().getConnection();
        String sql = "select id from tbl_departamentos where nombre = ?";  
        String codDep = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,dep);
            rs = ps.executeQuery();
             while(rs.next()){
               codDep = rs.getString("id");
            }                
            System.out.println(codDep);
            sql = "SELECT nombre FROM tbl_municipios WHERE departamento_id =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, codDep);
            rs = ps.executeQuery();
            while(rs.next()){
                modeloMunicipos.addElement(rs.getString("nombre"));
            } 
            this.vistaJDialog.jComboMunicipio.setModel(modeloMunicipos);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String departamento = this.vistaJDialog.jComboDepartamento.getSelectedItem().toString();
         String municipio = this.vistaJDialog.jComboMunicipio.getSelectedItem().toString();
         this.vistaJDialog.jTextDepartamento.setText(departamento);
         this.vistaJDialog.jTextMunicipio.setText(municipio);
    }
    
}
