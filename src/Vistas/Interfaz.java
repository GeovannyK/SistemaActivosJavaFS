package Vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.Conn;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;





public class Interfaz extends javax.swing.JFrame {
    

    public Interfaz() {
        initComponents();
        cargarDatosTabla();
    }
    

    
    private void cargarDatosTabla() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Conn conexion = new Conn(); 
            con = conexion.getConexion(); 

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT NumeroActivo, Descripcion, Resguardatario, Area FROM inventario");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); 

            while (rs.next()) {
                Object[] row = new Object[4]; 
                row[0] = rs.getObject("NumeroActivo"); 
                row[1] = rs.getObject("Descripcion"); 
                row[2] = rs.getObject("Resguardatario"); 
                row[3] = rs.getObject("Area"); 
                model.addRow(row); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtResguardatario = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/fsuadec.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("SISTEMA DE ACTIVOS");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setText("Agregar producto");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setText("Numero de activo:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel5.setText("Descripcion:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel6.setText("Area:");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel7.setText("Resguardatario:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de activo", "Descripcion", "Resguardatario", "Area"
            }
        ));
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtResguardatario, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(345, 345, 345))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtResguardatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBorrar)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnCerrar))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void actualizarProducto() {
    String numeroActivo = txtNumero.getText();
    String descripcion = txtDescripcion.getText();
    String resguardatario = txtResguardatario.getText();
    String area = txtArea.getText();
    

    boolean actualizado = actualizarEnBaseDeDatos(numeroActivo, descripcion, resguardatario, area);
    
    if (actualizado) {
        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.");
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    private boolean actualizarEnBaseDeDatos(String numeroActivo, String descripcion, String resguardatario, String area) {
    Conn conexion = new Conn();

    try {
        Connection connection = conexion.getConexion();
        
        if (connection != null) {
         
            String consulta = "UPDATE inventario SET Descripcion = ?, Resguardatario = ?, Area = ? WHERE NumeroActivo = ?";

         
            PreparedStatement statement = connection.prepareStatement(consulta);

         
            statement.setString(1, descripcion);
            statement.setString(2, resguardatario);
            statement.setString(3, area);
            statement.setString(4, numeroActivo);

         
            int filasActualizadas = statement.executeUpdate();

         
            statement.close();

         
            if (filasActualizadas > 0) {
                return true; 
            } else {
                return false;
            }
        } else {
            
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    } finally {
        
        conexion.desconectar();
    }
}


    private void limpiarCampos() {
    txtNumero.setText("");
    txtDescripcion.setText("");
    txtResguardatario.setText("");
    txtArea.setText("");
}

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
            // Obtener los valores modificados de los campos de texto
    String numeroActivo = txtNumero.getText();
    String descripcion = txtDescripcion.getText();
    String resguardatario = txtResguardatario.getText();
    String area = txtArea.getText();

    // Realizar la lógica de actualización en la base de datos
    boolean actualizado = actualizarEnBaseDeDatos(numeroActivo, descripcion, resguardatario, area);

    // Verificar si la actualización fue exitosa
    if (actualizado) {
        // Actualizar la fila correspondiente en la tabla jTable1
        actualizarFilaEnTabla(numeroActivo, descripcion, resguardatario, area);
        JOptionPane.showMessageDialog(this, "Activo actualizado correctamente.");
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar el activo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}





private void actualizarFilaEnTabla(String numeroActivo, String descripcion, String resguardatario, String area) {
    // Actualizar la fila correspondiente en la tabla jTable1
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 0).equals(numeroActivo)) {
            model.setValueAt(descripcion, i, 1);
            model.setValueAt(resguardatario, i, 2);
            model.setValueAt(area, i, 3);
            break;
        }
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded

    }//GEN-LAST:event_jTable1ComponentAdded

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       // Obtener los valores de los campos de texto
    String numeroActivo = txtNumero.getText().trim();
    String descripcion = txtDescripcion.getText().trim();
    String resguardatario = txtResguardatario.getText().trim();
    String area = txtArea.getText().trim();

    // Verificar que ningún campo esté vacío
    if (numeroActivo.isEmpty() || descripcion.isEmpty() || resguardatario.isEmpty() || area.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Detener la ejecución del método si algún campo está vacío
    }

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        Conn conexion = new Conn(); // Crear una instancia de la clase Conn
        con = conexion.getConexion(); // Obtener conexión llamando al método getConexion() en la instancia
        
        // Consulta SQL para verificar si ya existe un activo con ese número
        String consultaVerificar = "SELECT COUNT(*) FROM inventario WHERE NumeroActivo = ?";
        stmt = con.prepareStatement(consultaVerificar);
        stmt.setString(1, numeroActivo);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                JOptionPane.showMessageDialog(this, "El número de activo ya existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Detener la ejecución si el número de activo ya existe
            }
        }
        
        // Consulta SQL para insertar un nuevo activo en la base de datos
        String consultaInsertar = "INSERT INTO inventario (NumeroActivo, Descripcion, Resguardatario, Area) VALUES (?, ?, ?, ?)";
        
        stmt = con.prepareStatement(consultaInsertar);
        stmt.setString(1, numeroActivo); // Establecer el número de activo como parámetro en la consulta
        stmt.setString(2, descripcion); // Establecer la descripción como parámetro en la consulta
        stmt.setString(3, resguardatario); // Establecer el resguardatario como parámetro en la consulta
        stmt.setString(4, area); // Establecer el área como parámetro en la consulta
        
        int filasInsertadas = stmt.executeUpdate(); // Ejecutar la consulta

        if (filasInsertadas > 0) { // Si se insertó al menos una fila
            JOptionPane.showMessageDialog(this, "Nuevo activo agregado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos(); // Limpiar los campos de texto
            cargarDatosTabla(); // Actualizar la tabla
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar el nuevo activo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al agregar el nuevo activo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String numeroActivo = txtNumero.getText().trim(); // Obtener el número de activo del campo txtNumero

    if (!numeroActivo.isEmpty()) { // Verificar que el campo txtNumero no esté vacío
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conn conexion = new Conn(); // Crear una instancia de la clase Conn
            con = conexion.getConexion(); // Obtener conexión llamando al método getConexion() en la instancia
            
            // Consulta SQL para buscar el registro por número de activo
            String consulta = "SELECT Descripcion, Resguardatario, Area FROM inventario WHERE NumeroActivo = ?";
            
            stmt = con.prepareStatement(consulta);
            stmt.setString(1, numeroActivo); // Establecer el número de activo como parámetro en la consulta
            
            rs = stmt.executeQuery(); // Ejecutar la consulta
            
            if (rs.next()) { // Si se encuentra el registro
                // Obtener los valores de los campos correspondientes
                String descripcion = rs.getString("Descripcion");
                String resguardatario = rs.getString("Resguardatario");
                String area = rs.getString("Area");
                
                // Actualizar los campos de texto con los valores recuperados
                txtDescripcion.setText(descripcion);
                txtResguardatario.setText(resguardatario);
                txtArea.setText(area);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún registro con el número de activo proporcionado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcion.setText("");
                    txtResguardatario.setText("");
                    txtArea.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el registro en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Ingrese un número de activo antes de realizar la búsqueda.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
            String numeroActivo = txtNumero.getText().trim(); // Obtener el número de activo del campo txtNumero

    if (!numeroActivo.isEmpty()) { // Verificar que el campo txtNumero no esté vacío
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conn conexion = new Conn(); // Crear una instancia de la clase Conn
            con = conexion.getConexion(); // Obtener conexión llamando al método getConexion() en la instancia
            
            // Consulta SQL para buscar el registro por número de activo
            String consulta = "SELECT Descripcion, Resguardatario, Area FROM inventario WHERE NumeroActivo = ?";
            
            stmt = con.prepareStatement(consulta);
            stmt.setString(1, numeroActivo); // Establecer el número de activo como parámetro en la consulta
            
            rs = stmt.executeQuery(); // Ejecutar la consulta
            
            if (rs.next()) { // Si se encuentra el registro
                // Obtener los valores de los campos correspondientes
                String descripcion = rs.getString("Descripcion");
                String resguardatario = rs.getString("Resguardatario");
                String area = rs.getString("Area");
                
                // Mostrar ventana de confirmación
                int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de borrar el activo con los siguientes datos?\n\nNúmero de activo: " + numeroActivo + "\nDescripción: " + descripcion + "\nResguardatario: " + resguardatario + "\nÁrea: " + area, "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                
                if (opcion == JOptionPane.YES_OPTION) { // Si el usuario confirma el borrado
                    // Consulta SQL para borrar el registro por número de activo
                    String consultaBorrar = "DELETE FROM inventario WHERE NumeroActivo = ?";
                    stmt = con.prepareStatement(consultaBorrar);
                    stmt.setString(1, numeroActivo); // Establecer el número de activo como parámetro en la consulta
                    int filasBorradas = stmt.executeUpdate(); // Ejecutar la consulta
                    
                    if (filasBorradas > 0) { // Si se borró al menos una fila
                        JOptionPane.showMessageDialog(this, "Activo borrado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos(); // Limpiar los campos de texto
                        cargarDatosTabla(); // Actualizar la tabla
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo borrar el activo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún registro con el número de activo proporcionado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos(); // Limpiar los campos de texto
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el registro en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Ingrese un número de activo antes de realizar el borrado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnBorrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtResguardatario;
    // End of variables declaration//GEN-END:variables
}
