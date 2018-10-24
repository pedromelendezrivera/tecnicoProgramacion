package pruebaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author ADSI1324116
 */
public class PruebaBD {
        public static void main(String[] args) {
       
            String bd = "bdusuarios";
            String login = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/"+bd;
            Connection conn = null;
        
           try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+" se realizo ");
         }
 
        }catch(SQLException e){
           System.out.println(e);
        }catch(ClassNotFoundException e){
           System.out.println(e);
        }           
  }
}
