
package huffmancoding;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class HuffmanGUI extends javax.swing.JFrame {
    
    /*
        HUFFMAN ENCODING
    */
    private static final int ALPHABET_SIZE = 256;
    
    public HuffmanEncodedResult compress(final String data) {
        final int[] freq = buildFrequencyTable(data);
        final Node root = buildHuffmanTree(freq);
        final Map<Character, String> lookupTable = buildLookupTable(root);
        return new HuffmanEncodedResult(generateEncodedData(data, lookupTable), root);
    }

    private static void buildLookupTableImpl(final Node node, final String s, final Map<Character, String> lookupTable) {
        if (!node.isLeaf()) {
            buildLookupTableImpl(node.leftChild, s + '0', lookupTable);
            buildLookupTableImpl(node.rightChild, s + '1', lookupTable);
        } else {
            lookupTable.put(node.character, s);
        }
    }
    
    private static String generateEncodedData(final String data, final Map<Character, String> lookupTable) {
        final StringBuilder builder = new StringBuilder();
        for (final char character : data.toCharArray()) {
            builder.append(lookupTable.get(character));
        }
        return builder.toString();
    }
    
    private static Map<Character, String> buildLookupTable(final Node root) {
        final Map<Character, String> lookupTable = new HashMap<>();
        buildLookupTableImpl(root, "", lookupTable);
        return lookupTable;
    }
    
    private static Node buildHuffmanTree(int[] freq) {
        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] > 0) {
                priorityQueue.add(new Node((char) i, freq[i], null, null));
            }
        }
        if (priorityQueue.size() == 1) {
            priorityQueue.add(new Node('\0', 1, null, null));
        }
        while (priorityQueue.size() > 1) {
            final Node left = priorityQueue.poll();
            final Node right = priorityQueue.poll();
            final Node parent = new Node('\0', left.frequency + right.frequency, left, right);
            priorityQueue.add(parent);
        }
        return priorityQueue.poll();
    }
    static class Node implements Comparable<Node> {
        private final char character;
        private final int frequency;
        private final Node leftChild;
        private final Node rightChild;
        
        private Node(final char character,
                     final int frequency,
                     final Node leftChild,
                     final Node rightChild) {
            this.character = character;
            this.frequency = frequency;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
        
        boolean isLeaf() {
            return this.leftChild == null && this.rightChild == null;
        }

        @Override
        public int compareTo(Node that) {
            final int frequencyComparison = Integer.compare(this.frequency, that.frequency);
            if (frequencyComparison != 0) {
                return frequencyComparison;
            }
            return Integer.compare(this.character, that.character);
        }
    }
    
    private static int[] buildFrequencyTable(final String data) {
        final int[] freq = new int[ALPHABET_SIZE];
        for (final char character : data.toCharArray()) {
            freq[character]++;
        }
        return freq;
    }
    
    public String decompress(final HuffmanEncodedResult result) {
        final StringBuilder resultBuilder = new StringBuilder();
        Node current = result.getRoot();
        int i = 0;
        while (i < result.getEncodedData().length()) {
            while (!current.isLeaf()) {
                char bit = result.getEncodedData().charAt(i);
                if (bit == '1') {
                    current = current.rightChild;
                } else if (bit == '0') {
                    current = current.leftChild;
                } else {
                    throw new IllegalArgumentException("Invalid bit in message!" + bit);
                }
                i++;
            }
            resultBuilder.append(current.character);
          current = result.getRoot();
        }
        return resultBuilder.toString();
    }
    
    static class HuffmanEncodedResult {
        final Node root;
        final String encodedData;
        HuffmanEncodedResult(final String encodedData, final Node root) {
            this.encodedData = encodedData;
            this.root = root;
        }
        
        public Node getRoot() {
            return this.root;
        }
        
        public String getEncodedData() {
            return this.encodedData;
        }
    }
    
    /*
        ------------------------------------------------------------
    */

  
    public HuffmanGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Open");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 80, 30));

        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 23, 70, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 340, 40));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 350, 40));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(10);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 190));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(10);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 340, 190));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel1.setText("Source file: ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("Destination file: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jButton3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jButton3.setText("Encode");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 130, 50));

        jButton4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jButton4.setText("Decode");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 130, 50));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel3.setText("Uncoded File Information");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel4.setText("Coded File Information");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(247, 241, 241));
        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane5.setViewportView(jTextArea5);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 340, 90));

        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new java.awt.Color(247, 241, 241));
        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jTextArea6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane6.setViewportView(jTextArea6);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 350, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            jTextArea2.setText(file.toString());
            sourceFile = true;
            try {
                InputStream is = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                StringBuilder sb = new StringBuilder();
                while (line != null) {
                    sb.append(line).append("\n");
                    line = br.readLine();
                }
                String fileAsString = sb.toString();
                jTextArea3.setText(fileAsString);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_jButton1ActionPerformed
    class ReadFile {
        private String path;
        
        public ReadFile(String filePath) {
            path = filePath;
        }
        public String[] OpenFile() throws IOException {
            FileReader fr = new FileReader(path);
            BufferedReader textReader = new BufferedReader(fr);
            int numberOfLines = 1;
            String[] textData = new String[numberOfLines];
            int i = 0;
            for (int j = 0; j < numberOfLines; j++) {
                textData[i] = textReader.readLine();
            }
            textReader.close();
            return textData;
        }
        int readLines() throws IOException {
            FileReader fileToRead = new FileReader(path);
            BufferedReader bf = new BufferedReader(fileToRead);
            String aLine;
            int numberOfLines = 0;
            while ((aLine = bf.readLine()) != null) {
                numberOfLines++;
            }
            bf.close();
            return numberOfLines;
        }
    }
    
    class WriteFile {
        private String path;
        private boolean appendToFile = false;
        
        public WriteFile(String filePath) {
            path = filePath;
        }
        public WriteFile(String filePath, boolean appendValue) {
            path = filePath;
            appendToFile = appendValue;
        }
        public void writeToFile(String line) throws IOException {
            FileWriter write = new FileWriter(path, appendToFile);
            PrintWriter printLine = new PrintWriter(write);
            printLine.print(line);
            printLine.close();
        }  
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!desFile || !sourceFile) JOptionPane.showMessageDialog(null, "Select source/destination file!");
        else {
            String fileName = dir;
            try {
                clearFile(fileName);
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            ReadFile file = new ReadFile(fileName);
            String[] lines = null;
            try {
                lines = file.OpenFile();
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = 0;
            WriteFile data = new WriteFile(fileName, true);
            final String test = jTextArea3.getText();
            jTextArea6.setText(" File size: " + getBytes(test.length() * 8) + " bytes" + " (" + (test.length() * 8) + " bits" + ")\n"
                               + " Source number of bits: "  + test.length() * 8 + " bits"+ "\n Average Word Length: " + averageWordLength(test) + "\n Source Entropy: " + Entropy.getEntropy(test));
            final HuffmanGUI encoder = new HuffmanGUI();
            final HuffmanEncodedResult result = encoder.compress(test);
            jTextArea5.setText(" File size: " + getBytes(result.encodedData.length()) + " bytes" + " (" + (result.encodedData.length()) + " bits" + ")" +
                                "\n Compression Rate: " + ((double) result.encodedData.length() / (test.length() * 8))
                                + "\n Compressed number of bits: " + result.encodedData.length() + " bits"
                                + "\n Decompressed number of bits: " + encoder.decompress(result).length() * 8 + " bits");
            try {            
                data.writeToFile(result.encodedData);
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextArea4.setText(result.encodedData);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    boolean sourceFile = false;
    boolean desFile = false;
    String dir = "";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            dir = file.toString();
            jTextArea1.setText(file.toString());
            desFile = true;
        } 
    }//GEN-LAST:event_jButton2ActionPerformed
        
    private int getBytes(int bits) {
        int bytes = 8;
        return bits / bytes ;
    }
    
    public static void clearFile(String dir) throws IOException {
        FileWriter fw = new FileWriter(dir, false);
        PrintWriter pw = new PrintWriter(fw, false);
        pw.flush();
        pw.close();
        fw.close();
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!desFile || !sourceFile) JOptionPane.showMessageDialog(null, "Select source/destination file!");
        else {
            String fileName = dir;
            try {
                clearFile(fileName);
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            ReadFile file = new ReadFile(fileName);
            String[] lines = null;
            try {
                lines = file.OpenFile();
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = 0;
            WriteFile data = new WriteFile(fileName, true);
            final String test = jTextArea3.getText();
            final HuffmanGUI encoder = new HuffmanGUI();
            final HuffmanEncodedResult result = encoder.compress(test);
            String decompressed = "";
            try {            
                decompressed = encoder.decompress(result);
                data.writeToFile(decompressed);
                jTextArea5.setText(" File size: " + getBytes(decompressed.length() * 8) + " bytes" + " (" + decompressed.length() * 8 + " bits" + ")\n"
                               + " Source number of bits: "  + decompressed.length() * 8 + " bits"+ "\n Average Word Length: " + averageWordLength(decompressed) + "\n Source Entropy: " + Entropy.getEntropy(decompressed));
            } catch (IOException ex) {
                Logger.getLogger(HuffmanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextArea4.setText(decompressed);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    static class Entropy {
        public static double getEntropy(String s) {
            int n = 0;
            Map<Character, Integer> occ = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char cx = s.charAt(i);
                if (occ.containsKey(cx)) {
                    occ.put(cx, occ.get(cx) + 1);
                } else {
                    occ.put(cx, 1);
                }
                ++n;
            }
            double e = 0.0;
            for (Map.Entry<Character, Integer> entry : occ.entrySet()) {
                char cs = entry.getKey();
                double p = (double) entry.getValue() / n;
                e += p * log2(p);
            }
            return -e;
        }

        private static double log2(double a) {
            return Math.log(a) / Math.log(2);
        }
    }
    
    public static double averageWordLength(String word) {
        String[] wordArray = word.split(" ");
        double totalChars = 0;
        for (String s : wordArray) {
            totalChars += s.length();
        }
        double words = wordArray.length;
        double average = (double) (totalChars/ words);
        return average;
    }
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HuffmanGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    // End of variables declaration//GEN-END:variables
}

