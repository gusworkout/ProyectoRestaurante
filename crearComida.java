//BOTON DE GUARDAR COMIDA EN BD

private void RegistrarComida(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        try {
        conex();
        ps = conex().prepareStatement("INSERT INTO comida (codigo, nombre, precio, cantidad) VALUES(?,?,?,?) ");
        ps.setString(1, txtCodigo.getText());
        ps.setString(2, txtNombre.getText());
        ps.setString(3, txtPrecio.getText());
        ps.setString(4, txtCantidad.getText());
        
 

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Comida Guardada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al Guardar comida");
        }
			
        con.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error" + e);
    }
        
    }               
