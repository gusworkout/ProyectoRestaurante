//CREAR LA TABLA PARA MOSTRAR LOS DATOS Y LLAMARLO EN EL CONSTRUCTOR INIT

public void mostrar(){
       conex();
       
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("NOMBRE");
        model.addColumn("PRECIO");
        model.addColumn("CONTIDAD");
        visor.setModel(model);
        
        String [] datos = new String[4];
        
        try{
        ps = conex().prepareStatement("SELECT * FROM comida");
         rs = ps.executeQuery();
         
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
              model.addRow(datos);
          }
        }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
                  }

    //METODO PARA AGREGAR AL CARRITO LOS DATOS DE LA COMIDA

    visor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Verificar si hay una fila seleccionada
                int selectedRow = visor.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener datos de la fila seleccionada
                    String cod = visor.getValueAt(selectedRow, 0).toString();
                    String Name = visor.getValueAt(selectedRow, 1).toString();
                    String precio = visor.getValueAt(selectedRow, 2).toString();
                    String cantidad = visor.getValueAt(selectedRow, 3).toString();

                    // Mostrar los datos en los JTextFields
                    txtField1.setText(cod);
                    txtField2.setText(Name);
                    txtField3.setText(precio);
                    txtField4.setText(cantidad);
                }
            }
        });
        
    }

  //BOTON + DE AGREGAR AL CARRITO
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        try{
        conex();
        ps = conex().prepareStatement("INSERT INTO carrito (codigo, nombre, precio, cantidad) VALUES(?,?,?,?) ");
        ps.setString(1, txtField1.getText());
        ps.setString(2, txtField2.getText());
        ps.setString(3, txtField3.getText());
        ps.setString(4, txtField4.getText());
        
 

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Pedido Guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al Guardar el pedido");
        }
			
        con.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error" + e);
    }
    } 


  //BOTON - DE ELIMINAR DEL CARRITO
   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        

    try{
        conex();
        
        ps = conex().prepareStatement("DELETE FROM carrito WHERE codigo=?");
        ps.setInt(1, Integer.parseInt(txtField1.getText()));

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Persona Eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar persona");
        }
        
        con.close();

    }catch (Exception e) {
        System.err.println(e);
    }
    }     


    
