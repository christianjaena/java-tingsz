package terminal;
 
import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TerminalWindow extends javax.swing.JFrame {
    LinkedList soldItems;
 
    public TerminalWindow() throws Exception {
        initComponents();
        soldItems = new LinkedList();
        initForm();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itemNumberField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        orNumberField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        qtyField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        concludeButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        soldItemsButton = new javax.swing.JButton();
        timeField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Date:");

        jLabel2.setText("Item#:");

        jLabel4.setText("OR#:");

        jLabel5.setText("Qty:");

        addButton.setText("Add to Cart");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(itemsTable);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setText("TOTAL");

        totalLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalLabel.setText("PhP 0.00");

        concludeButton.setText("Conclude Transaction");
        concludeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concludeButtonActionPerformed(evt);
            }
        });

        inventoryButton.setText("Inventory");
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
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

        jLabel7.setText("Time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inventoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soldItemsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(19, 19, 19)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateField)
                            .addComponent(timeField)
                            .addComponent(itemNumberField))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addButton)
                                    .addComponent(orNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(concludeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(orNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(concludeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soldItemsButton)
                    .addComponent(salesButton)
                    .addComponent(inventoryButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(itemNumberField.getText().isEmpty()) {
            error("The item number is empty", this);
            return;
        }
        try {
            int itemNumber = Integer.parseInt(itemNumberField.getText());
            int qty = Integer.parseInt(qtyField.getText());
            
            Item item = Item.getItemById(itemNumber);
            SoldItemDetails soldItem = new SoldItemDetails(
                    item.getId(), item.getName(), item.getDescription(), qty, item.getPrice()
            );
            
            soldItems.add(soldItem);
            refreshTable();
            itemNumberField.setText(null);
            qtyField.setText("1");
            
        } catch (NumberFormatException e) {
            error("Invalid entry for item number and/or Qty.", this);
        } catch (Exception e){
            error(e.getMessage(), this);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void concludeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concludeButtonActionPerformed
        float tender = Float.parseFloat(JOptionPane.showInputDialog("Enter amount to tender: "));
        float total = Float.parseFloat(totalLabel.getText());
        float change = tender - total;  
        
        try {
            PreparedStatement sales = DB.getConnection().prepareStatement(
                    "INSERT INTO sales(date, time, total, pmt_type) VALUES(?,?,?, 'cash')", PreparedStatement.RETURN_GENERATED_KEYS);
            sales.setString(1, dateField.getText());
            sales.setString(2, timeField.getText());
            sales.setString(3, totalLabel.getText());
            sales.executeUpdate();
            ResultSet ids = sales.getGeneratedKeys();
            ids.first();
            int generatedId = ids.getInt(1);
            PreparedStatement sItems = DB.getConnection().prepareStatement(
            "INSERT INTO sold_items (sales_id, item_id, qty, price) values(?,?,?,?)");
            
            ListIterator iter = soldItems.listIterator();
            while(iter.hasNext()){
                SoldItemDetails sid = (SoldItemDetails)iter.next();
                sItems.setInt(1, generatedId);
                sItems.setInt(2, sid.getItem_id());
                sItems.setInt(3, sid.getQty());
                sItems.setFloat(4, sid.getPrice());
                sItems.addBatch();     
            }
            sItems.executeBatch();
        } catch (SQLException e) {
           error(e.getMessage(), this);
        }catch(Exception e){
            error(e.getMessage(), this);
        }
        JOptionPane.showMessageDialog(this,"The change is " + change, "Change", JOptionPane.INFORMATION_MESSAGE);
        soldItems.clear();
        refreshTable();
        initForm();
    }//GEN-LAST:event_concludeButtonActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        Inventory invent = null;
        try {
            invent = new Inventory();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        invent.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_inventoryButtonActionPerformed

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
    private void refreshTable(){
        int n = soldItems.size();
        Object contents[][] = new Object[n][5];
        String headers[] = {"Name", "Description", "Price", "Qty", "Subtotal"};
        Object[] itemsArray = soldItems.toArray();
        float total = 0f;
        for (int i = 0; i < itemsArray.length; i++) {
            SoldItemDetails itm = (SoldItemDetails)itemsArray[i];
            
            contents[i][0] = itm.getName();
            contents[i][1] = itm.getDescription();
            contents[i][2] = itm.getPrice();
            contents[i][3] = itm.getQty();
            float tl = itm.getQty() * itm.getPrice();
            total += tl;
            contents[i][4] = tl;
            
        }
        
        DefaultTableModel model = new DefaultTableModel(contents, headers){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
             
        };
        itemsTable.setModel(model);
        
        totalLabel.setText(String.format("%.2f",total));
       
        
    }
    
    private void initForm() {
        java.sql.Date date = java.sql.Date.valueOf(LocalDate.now());
        java.sql.Time time = java.sql.Time.valueOf(LocalTime.now());
        dateField.setText(date.toString());
        timeField.setText(time.toString());
        
        
        try {
            ResultSet rs = DB.getConnection().createStatement().executeQuery("SELECT id FROM sales ORDER BY id DESC LIMIT 0, 5");
            int orNumber = 1;
            if(rs.first()){
               orNumber = rs.getInt("id") + 1;
            }
            orNumberField.setText(String.format("%010d",orNumber));
        }catch(SQLException e){
            error(e.getMessage(), this);
        }
        catch(Exception e) {
           error(e.getMessage(), this);
        }
    }
    private void error(String msg, Component parent){
        javax.swing.JOptionPane.showMessageDialog(parent, msg, "Error!", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(TerminalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerminalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerminalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerminalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TerminalWindow().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TerminalWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();
       
        System.out.println("client connected.");
        
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        
        String str = bf.readLine();
        System.out.println("client:" + str);
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("hello");
        pr.flush();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton concludeButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JTextField itemNumberField;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orNumberField;
    private javax.swing.JTextField qtyField;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton soldItemsButton;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
