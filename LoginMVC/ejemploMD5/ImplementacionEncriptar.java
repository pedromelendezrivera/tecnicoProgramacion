package ejemploMD5;

/**
 *
 * @author PMELENDEZ
 */
public class ImplementacionEncriptar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println(Encriptar.md5("mensaje encriptado"));
         System.out.println(Encriptar.md5("mensaje encriptado con algoritmo md5"));
         
         System.out.println(Encriptar.sha1("mensaje encriptado"));
         System.out.println(Encriptar.sha1("mensaje encriptado con algoritmo sha1"));
    }
    
}
