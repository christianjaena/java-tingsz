package ccc;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class HomePage extends javax.swing.JFrame {
    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    String option;
    String updateID;
    DefaultTableModel dtm; 
    
    public HomePage() {
        initComponents();
        con = DatabaseConnection.getConnection();
        viewData();
    }
    
    private void viewData() {
        try{
            String sql = "SELECT * FROM contacts";
            pst = con.prepareStatement(sql);
            rst = pst.executeQuery();
            contactListTable.setModel(DbUtils.resultSetToTableModel(rst));
            
        } catch(Exception e) {
            System.out.println(""+e);
        }
        
    }
    public void refreshTable() {
        dtm = (DefaultTableModel) contactListTable.getModel();
        dtm.setRowCount(0);
        viewData();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        coursefield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        fnamefield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lnamefield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        contactnofield = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        emailfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        addContactButton = new javax.swing.JButton();
        subjectcodefield = new javax.swing.JTextField();
        updateContact = new javax.swing.JButton();
        deleteContact = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactListTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        fieldComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 18, 50));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(36, 47, 65));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FIRST NAME");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 220, 10));

        coursefield.setBackground(new java.awt.Color(36, 47, 65));
        coursefield.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        coursefield.setForeground(new java.awt.Color(204, 204, 204));
        coursefield.setBorder(null);
        coursefield.setCaretColor(new java.awt.Color(102, 102, 102));
        jPanel4.add(coursefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 220, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LAST NAME");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 40));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, 10));

        fnamefield.setBackground(new java.awt.Color(36, 47, 65));
        fnamefield.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        fnamefield.setForeground(new java.awt.Color(204, 204, 204));
        fnamefield.setBorder(null);
        fnamefield.setCaretColor(new java.awt.Color(102, 102, 102));
        fnamefield.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(fnamefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CONTACT NUMBER");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 20));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 220, 30));

        lnamefield.setBackground(new java.awt.Color(36, 47, 65));
        lnamefield.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lnamefield.setForeground(new java.awt.Color(204, 204, 204));
        lnamefield.setBorder(null);
        lnamefield.setCaretColor(new java.awt.Color(102, 102, 102));
        jPanel4.add(lnamefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 220, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("(BSBIO, BSMATH, BSIT)");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 160, 40));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 220, 10));

        contactnofield.setBackground(new java.awt.Color(36, 47, 65));
        contactnofield.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        contactnofield.setForeground(new java.awt.Color(204, 204, 204));
        contactnofield.setBorder(null);
        contactnofield.setCaretColor(new java.awt.Color(102, 102, 102));
        jPanel4.add(contactnofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 220, 30));

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 220, 10));

        emailfield.setBackground(new java.awt.Color(36, 47, 65));
        emailfield.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        emailfield.setForeground(new java.awt.Color(204, 204, 204));
        emailfield.setBorder(null);
        emailfield.setCaretColor(new java.awt.Color(102, 102, 102));
        jPanel4.add(emailfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 220, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EMAIL");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 220, 160, 40));

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 220, 10));

        addContactButton.setBackground(new java.awt.Color(20, 29, 35));
        addContactButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        addContactButton.setForeground(new java.awt.Color(204, 204, 204));
        addContactButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ccc/Icons/icons8_Add_32px.png"))); // NOI18N
        addContactButton.setText("ADD CONTACT");
        addContactButton.setBorder(null);
        addContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 180, 40));

        subjectcodefield.setBackground(new java.awt.Color(36, 47, 65));
        subjectcodefield.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        subjectcodefield.setForeground(new java.awt.Color(204, 204, 204));
        subjectcodefield.setBorder(null);
        subjectcodefield.setCaretColor(new java.awt.Color(102, 102, 102));
        jPanel4.add(subjectcodefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 220, 30));

        updateContact.setBackground(new java.awt.Color(20, 29, 35));
        updateContact.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        updateContact.setForeground(new java.awt.Color(204, 204, 204));
        updateContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ccc/Icons/icons8_Update_User_32px.png"))); // NOI18N
        updateContact.setText("UPDATE CONTACT");
        updateContact.setBorder(null);
        updateContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateContactActionPerformed(evt);
            }
        });
        jPanel4.add(updateContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, 40));

        deleteContact.setBackground(new java.awt.Color(20, 29, 35));
        deleteContact.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        deleteContact.setForeground(new java.awt.Color(204, 204, 204));
        deleteContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ccc/Icons/icons8_Trash_Can_32px.png"))); // NOI18N
        deleteContact.setText("DELETE CONTACT");
        deleteContact.setBorder(null);
        deleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactActionPerformed(evt);
            }
        });
        jPanel4.add(deleteContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 180, 40));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("COURSE ");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 290, 140, 40));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SUBJECT CODE");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 360, 180, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 680));

        jPanel2.setBackground(new java.awt.Color(20, 29, 35));

        contactListTable.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        contactListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Contact Number", "Email", "Course", "Subject Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        contactListTable.setShowHorizontalLines(false);
        contactListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(contactListTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 960, 550));

        jPanel3.setBackground(new java.awt.Color(20, 29, 35));
        jPanel3.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 70, 30));

        searchField.setBackground(new java.awt.Color(20, 29, 35));
        searchField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(204, 204, 204));
        searchField.setBorder(null);
        searchField.setCaretColor(new java.awt.Color(102, 102, 102));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel3.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 200, 30));

        fieldComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Field", "First Name", "Last Name", "Contact Number", "Email", "Course", "Subject Code" }));
        fieldComboBox.setBorder(null);
        fieldComboBox.setInheritsPopupMenu(true);
        fieldComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(fieldComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 120, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ccc/Icons/icons8_Search_32px.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 30, 40));

        jSeparator1.setBackground(new java.awt.Color(20, 29, 35));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 210, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ccc/Icons/icons8_Add_User_Group_Man_Man_96px_4.png"))); // NOI18N
        jLabel1.setText(" AFFINITY");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -30, 500, 150));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Manage your contacts in no time.");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 60, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 980, 90));

        setSize(new java.awt.Dimension(1232, 680));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addContactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactButtonActionPerformed
        String fname = fnamefield.getText();
        String lname = lnamefield.getText();
        String contactno = contactnofield.getText();
        String email = emailfield.getText();
        String course = coursefield.getText();
        String subjectcode = subjectcodefield.getText();

        try{
            con = DatabaseConnection.getConnection();
            pst = con.prepareStatement("INSERT INTO contacts(Firstname,Lastname,ContactNumber,Email,Course,SubjectCode) values(?,?,?,?,?,?)");
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, contactno);
            pst.setString(4, email);
            pst.setString(5, course);
            pst.setString(6, subjectcode);
            

            int confirm = JOptionPane.showConfirmDialog(rootPane, "Confirm add contact", "Are you Sure?",JOptionPane.YES_NO_OPTION);
            if(confirm == 0) {
                pst.execute();
                JOptionPane.showMessageDialog(rootPane,"Contact added successfully", "Done", 1);
            }
            clearFields();
            refreshTable();

        }catch(Exception e) {
            System.out.println(""+e);
        }
    }//GEN-LAST:event_addContactButtonActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        if(fieldComboBox.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Please select an option.");
        }else {
            Connection con;
            int id;
            String fname,lname,contactno,email,course,subjectcode;
            try{
            con = DatabaseConnection.getConnection();
            String str1 = searchField.getText();
            String sql = "SELECT * FROM contacts WHERE " + option.trim() + "=?";
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1, str1);
            
            ResultSet rs = pst.executeQuery();
            dtm = (DefaultTableModel) contactListTable.getModel();
            dtm.setRowCount(0);
            if(rs.next()){
                do{   
                     id = rs.getInt("ID");
                     fname = rs.getString("Firstname");
                     lname = rs.getString("Lastname");
                     contactno = rs.getString("ContactNumber");
                     email = rs.getString("Email");
                     course = rs.getString("Course");
                     subjectcode = rs.getString("SubjectCode");
                     dtm.addRow(new Object[]{id,fname,lname,contactno,email,course,subjectcode});
                     
                }while (rs.next());
            }
            } catch(Exception e) {
                System.out.println(""+e);
            }
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void fieldComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldComboBoxActionPerformed
        option = "";
        int index = fieldComboBox.getSelectedIndex();
        if(index <= 0) {
            dtm.setRowCount(0); 
            
        }
        if(index == 1) {
            option = "Firstname";
        }
        if(index == 2) {
            option = "Lastname";
        }
        if(index == 3) {
            option = "ContactNumber";
        }
        if(index == 4) {
            option = "Email";
        }
        if(index == 5) {
            option = "Course";
        }
        if(index == 6) {
            option = "SubjectCode";
        }
    }//GEN-LAST:event_fieldComboBoxActionPerformed
    public void clearFields(){
        fnamefield.setText("");
        lnamefield.setText("");
        contactnofield.setText("");
        subjectcodefield.setText("");   
        emailfield.setText("");
        coursefield.setText("");
        
    }
    
    private void updateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateContactActionPerformed
         if(fnamefield.getText().equals("")||lnamefield.getText().equals("")||contactnofield.getText().equals("")||subjectcodefield.getText().equals("")||emailfield.getText().equals("")||coursefield.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Please Select From Table");
        }else {
            Connection con;
            try{
                con = DatabaseConnection.getConnection();
                String sql = "UPDATE contacts SET Firstname = ?, Lastname = ?, ContactNumber = ?, Email =?, Course = ?, SubjectCode =? WHERE ID=" + updateID;
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, fnamefield.getText());
                pst.setString(2, lnamefield.getText());
                pst.setString(3, contactnofield.getText());
                pst.setString(4, emailfield.getText());
                pst.setString(5, coursefield.getText());
                pst.setString(6, subjectcodefield.getText());
                
                
                int ok = JOptionPane.showConfirmDialog(rootPane,"Confirm Update","Confirm Update?", JOptionPane.YES_NO_OPTION);
                if(ok == 0) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane,"Data is updated successfully", "Done", 1);
                    fnamefield.setText("");
                    lnamefield.setText("");
                    contactnofield.setText("");
                    subjectcodefield.setText("");
                    emailfield.setText("");
                    coursefield.setText("");
                    
                    clearFields();
                    refreshTable();
                }
            }catch(Exception e){
                System.out.println(""+ e);
            }
        }
    }//GEN-LAST:event_updateContactActionPerformed

    private void contactListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactListTableMouseClicked
        
        String data = contactListTable.getValueAt(contactListTable.getSelectedRow(), 0).toString();
        updateID = data;
        Connection con;
        con = DatabaseConnection.getConnection();
        try{
            String sql = "SELECT * FROM contacts where ID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, data);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                fnamefield.setText(rst.getString("Firstname"));
                lnamefield.setText(rst.getString("Lastname"));
                contactnofield.setText(rst.getString("ContactNumber"));
                emailfield.setText(rst.getString("Email"));
                coursefield.setText(rst.getString("Course"));
                subjectcodefield.setText(rst.getString("SubjectCode"));
            }
            pst.close();
           
            
        }catch (Exception e) {
            System.out.println(""+e);
        }
    }//GEN-LAST:event_contactListTableMouseClicked

    private void deleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteContactActionPerformed
           Connection con;
           try{
               con = DatabaseConnection.getConnection();
                String sql = "DELETE FROM contacts WHERE ID=" + updateID;
                PreparedStatement pst = con.prepareStatement(sql);
                
                int ok = JOptionPane.showConfirmDialog(rootPane,"Confirm Delete","Confirm Delete?", JOptionPane.YES_NO_OPTION);
                if(ok == 0) {
                pst.execute(sql);
                JOptionPane.showMessageDialog(rootPane,"Data is deleted successfully", "Done", 1);
                clearFields();
                refreshTable();
                }
           }catch (Exception e) {
               System.out.println(""+ e);
           }
    }//GEN-LAST:event_deleteContactActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addContactButton;
    private javax.swing.JTable contactListTable;
    private javax.swing.JTextField contactnofield;
    private javax.swing.JTextField coursefield;
    private javax.swing.JButton deleteContact;
    private javax.swing.JTextField emailfield;
    private javax.swing.JComboBox<String> fieldComboBox;
    private javax.swing.JTextField fnamefield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField lnamefield;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField subjectcodefield;
    private javax.swing.JButton updateContact;
    // End of variables declaration//GEN-END:variables
}
