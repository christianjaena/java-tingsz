package terminal;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Inventory extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    String option;
    String updateID;
    DefaultTableModel dtm; 
    
    public Inventory() throws Exception {
        initComponents();
        con = DB.getConnection();
        viewData();
    }
    private void viewData(){
        try {
            String sql = "SELECT * FROM items";
            pst = con.prepareStatement(sql);
            rst = pst.executeQuery();
            productsTable.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void refreshTable(){
        dtm = (DefaultTableModel) productsTable.getModel();
        dtm.setRowCount(0);
        viewData();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        descField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        terminalButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        soldItemsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Description");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Price");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stock");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, -1));
        jPanel2.add(descField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, -1));
        jPanel2.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, -1));
        jPanel2.add(stockField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, -1));

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 130, -1));

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, -1));

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 500));

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Price", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 590, 450));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setText("Search");

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Name", "Description", "Price", "Stock" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        terminalButton.setText("Terminal");
        terminalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminalButtonActionPerformed(evt);
            }
        });

        salesButton.setText("Sales");
        salesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButtonActionPerformed(evt);
            }
        });

        soldItemsButton.setText("Sold Items");
        soldItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldItemsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(terminalButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(soldItemsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminalButton)
                    .addComponent(salesButton)
                    .addComponent(soldItemsButton))
                .addGap(6, 6, 6))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 590, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        
        String name = nameField.getText();
        String description = descField.getText();
        String price = priceField.getText();
        String stock = stockField.getText();
        
        try {
            con = DB.getConnection();
            pst = con.prepareStatement("INSERT INTO items(name, description, price, qty_stock) values (?,?,?,?)");
            
            pst.setString(1, name);
            pst.setString(2, description);
            pst.setString(3, price);
            pst.setString(4, stock);
            
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Confirm add item", "Are you Sure?",JOptionPane.YES_NO_OPTION);
            if(confirm == 0) {
                pst.execute();
                JOptionPane.showMessageDialog(rootPane,"Item added successfully", "Done", 1);
            }
            clearFields();
            refreshTable();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        if(comboBox.getSelectedIndex() <= 0){
             JOptionPane.showMessageDialog(rootPane, "Please select an option.");
        }else {
            Connection con ;
            int id;
            String name, description, price, stock;
            try {
                con = DB.getConnection();
                String str1 = searchField.getText();
                String sql = "SELECT * FROM items WHERE" + option.trim() + "=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, str1);
                
                ResultSet rs = pst.executeQuery();
                dtm = (DefaultTableModel) productsTable.getModel();
                dtm.setRowCount(0);
                if(rs.next()) {
                    do {                        
                        id = rs.getInt("id");
                        name = rs.getString("name");
                        description = rs.getString("description");
                        price = rs.getString("price");
                        stock = rs.getString("qty_stock");
                    } while (rs.next());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        option = "";
        int index = comboBox.getSelectedIndex();
        if(index <= 0) {
            dtm.setRowCount(0);
        }
        if(index == 1) {
            option = "name";
        }
        if(index == 2) {
            option = "description";
        }
        if(index == 3) {
            option = "price";
        }
        if(index == 4) {
            option = "qty_stock";
        }
        
    }//GEN-LAST:event_comboBoxActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(nameField.getText().equals("")||descField.getText().equals("")||priceField.getText().equals("")||stockField.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Please Select From Table");
        } else {
            Connection con;
            try {
                con = DB.getConnection();
                String sql = "UPDATE items SET name = ?, description = ?, price = ?, qty_stock = ? WHERE id =" + updateID;
                PreparedStatement pst = con.prepareStatement(sql);
            
                pst.setString(1, nameField.getText());
                pst.setString(2, descField.getText());
                pst.setString(3, priceField.getText());
                pst.setString(4, stockField.getText());
                
                int ok = JOptionPane.showConfirmDialog(rootPane,"Confirm Update","Confirm Update?", JOptionPane.YES_NO_OPTION);
                if(ok == 0) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane,"item updated successfully", "Done", 1);
                   
                    nameField.setText("");
                    descField.setText("");
                    priceField.setText("");
                    stockField.setText("");
                    
                    clearFields();
                    refreshTable();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        String data = productsTable.getValueAt(productsTable.getSelectedRow(), 0).toString();
        updateID = data;
        Connection con;
        
        try {
            con = DB.getConnection();
            String sql = "SELECT * FROM items where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, data);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                
                nameField.setText(rst.getString("name"));
                descField.setText(rst.getString("description"));
                priceField.setText(rst.getString("price"));
                stockField.setText(rst.getString("qty_stock"));
            }
            pst.close();
                   
        } catch (Exception e) {
            System.out.println(e);
        }
        
               
    }//GEN-LAST:event_productsTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Connection con;
        try {
            con = DB.getConnection();
            String sql = "DELETE FROM items WHERE id =" + updateID;
            PreparedStatement pst = con.prepareStatement(sql);
            int ok = JOptionPane.showConfirmDialog(rootPane,"Confirm Delete","Confirm Delete?", JOptionPane.YES_NO_OPTION);
                if(ok == 0) {
                pst.execute(sql);
                JOptionPane.showMessageDialog(rootPane,"item deleted successfully", "Done", 1);
                clearFields();
                refreshTable();
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void terminalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminalButtonActionPerformed
        TerminalWindow term = null;
        try {
            term = new TerminalWindow();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        term.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_terminalButtonActionPerformed

    private void salesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButtonActionPerformed
        Sales sales = new Sales();
        sales.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_salesButtonActionPerformed

    private void soldItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldItemsButtonActionPerformed
        Sold sold = new Sold();
        sold.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_soldItemsButtonActionPerformed
    public void clearFields(){
        
        nameField.setText("");
        descField.setText("");
        priceField.setText("");
        stockField.setText("");
    }
 
    public static void main(String args[]) {
   
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inventory().setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton salesButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton soldItemsButton;
    private javax.swing.JTextField stockField;
    private javax.swing.JButton terminalButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
