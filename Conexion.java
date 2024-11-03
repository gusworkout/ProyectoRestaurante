//INSTALAR LA LIBRERIRA MYSQLCONNECTOR 
//     https://downloads.mysql.com/archives/c-j/


import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


public class Conexion {
        
         Connection con=null;
        
        String driver = "com.mysql.jdbc.Driver";
        String user= "root";
        String password="";
        String port="3306";
        String database="proyect";
        String ip="localhost";
        
       String cadena="jdbc:mysql://"+ip+":"+port+"/"+database;
       
       
       public Connection establecerConcexion(){
           
           try {
               
               Class.forName("driver");
               con  = DriverManager.getConnection(cadena ,user, password);
               JOptionPane.showMessageDialog(null, "La conexion fue exitosa");
               
           } catch (Exception e){
               JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos, error: "+ e.toString());
           }
           return con;
       }
        
}
