
package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADSI1324116
 */
public class Conexion {
       static private String bd = "bdusuarios";
       static private String login = "root";
       static private String password = "";
       static private String url = "jdbc:mysql://localhost/"+bd;
       Connection conn = null;

    public Conexion() {
             try{
                //obtenemos el driver de para mysql
                Class.forName("com.mysql.jdbc.Driver");
                //obtenemos la conexiòn
                conn = DriverManager.getConnection(url,login,password);

                if (conn!=null){
                   System.out.println("Conección a base de datos "+bd+" OK");
                }
                }
                catch(SQLException e){
                   System.out.println(e);
                }catch(ClassNotFoundException e){
                   System.out.println(e);
                }catch(Exception e){
                   System.out.println(e);
                }
    }

     /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }
       
  public void desconectar(){
      conn = null;
   }

}
