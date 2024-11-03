//INSTALAR LA LIBRERIRA MYSQLCONNECTOR 
//     https://downloads.mysql.com/archives/c-j/
// DENTRO DE LA INTERFAZ

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


 Connection con;

       //CRUD
          PreparedStatement ps;
           ResultSet rs;


        String user= "root";
        String password="";
        String port="3306";
        String database="proyect";
        String ip="localhost";
        
       String cadena="jdbc:mysql://"+ip+":"+port+"/"+database;
       
       
       public void Connection(){
           con=null;
           try {
               
               Class.forName("com.mysql.cj.jdbc.Driver");
               con  = DriverManager.getConnection(cadena ,user, password);
               JOptionPane.showMessageDialog(null, "La conexion fue exitosa");
               
           } catch (Exception e){
               JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos, error: "+ e.toString());
           }
       }


// INSERTAR

private void CrearButton(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
           Connection con;

    try {
        con = DriverManager.getConnection(cadena ,user, password);
        ps = con.prepareStatement("INSERT INTO persona (clave, nombre) VALUES(?,?) ");
        ps.setString(1, jTextField1.getText());
        ps.setString(2, jTextField2.getText());
 

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Persona Guardada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al Guardar persona");
        }
			
        con.close();

    } catch (Exception e) {
        System.err.println(e);
    }

     
    }    




// ELIMINAR
private void eliminar(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        //ELIMINAR
        
         Connection con;

    try {
        con = DriverManager.getConnection(cadena ,user, password);
        ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
        ps.setInt(1, Integer.parseInt(txtId.getText()));

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Persona Eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar persona");
        }
        
        con.close();

    } catch (NumberFormatException e) {
        System.err.println(e);
    }
    } 
// MODIFICAR
 private void Modificar(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        //MODIFICAR
        
         Connection con;

    try {
        con = DriverManager.getConnection(cadena ,user, password);
        ps = con.prepareStatement("UPDATE persona SET clave=?, nombre=? WHERE id=?");
        ps.setString(1, txtClave.getText());
        ps.setString(2, txtNombre.getText());

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Persona Modificada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar persona");
        }
       
        con.close();

    }  catch (Exception e) {
        System.err.println(e);
    }
    }  

