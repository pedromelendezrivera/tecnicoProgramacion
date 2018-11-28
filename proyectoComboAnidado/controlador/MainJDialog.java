package controlador;

import java.awt.Frame;
import vista.VistaJDialog;


public class MainJDialog {


    public static void main(String[] args) {
        new ControladorJdialog(new VistaJDialog(new Frame(),false));
    }
    
}

