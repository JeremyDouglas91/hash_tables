import java.io.*;
import java.io.File;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
/**
* The hashTableGui class constructs and graphical user interface Voter Search application
* allowing for fast repeated searching of a database (extracted from a .csv file),
* as well as the loading of new datasets into the application.
*
* @author Jeremy du Plessis
**/
public class hashTableGui extends javax.swing.JFrame {

    private JFileChooser jFileChooser1;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTextField jTextField1;
    private JTextPane jTextPane2;
    private JTextPane jTextPane3;
    private hashtable table1;
    private final String PATH = "data/voter_data.csv";
    /**
   * The hashTableGui constructor instatiates a hashtable object and calls the initcomponents() method.
   * 
   **/
    public hashTableGui() {
        try{
            int size = HashUtil.getSize(new BufferedReader(new FileReader(PATH)));
            table1 = new hashtable(size);
            HashUtil.loadData(new BufferedReader(new FileReader(PATH)), table1);

            initComponents();
            jTextPane2.setText("Welcome to the voter search application. \nVoter data loaded: \""+PATH+"\""+"\nSize of data set: "+table1.getSize()+"\nTable size: "+table1.getTableSize()+"\nAverage Number of Collisions: "+table1.getAverageCollisions());
        }catch(FileNotFoundException e){
            jTextPane2.setText("Error loading data: " + e);
        }
    }
    /**
    * The main method.
    * 
    * @param args the command line arguments
    */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(hashTableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hashTableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hashTableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hashTableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hashTableGui().setVisible(true);
            }
        });
    }
    /**
    * The initComponents method constructs the Voter Search Application Gui and lanuches it.
    * 
    */                        
    private void initComponents() {

        jFileChooser1 = new JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton(); 
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        this.setTitle("Voter Search Application");
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFileChooser1.setCurrentDirectory(new File(System.getProperty("user.home")));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
        jTextPane2.setEditable(false);
        jTextPane3.setEditable(false);
        this.getRootPane().setDefaultButton(jButton2);

        jTextField1.setText("Enter ID Number");
        jLabel1.setText("Search Database:");
        jLabel3.setText("Log");
        
        jLabel4.setText("Load New Database:");
        jButton1.setText("Browse");
        jButton2.setText("Search");

        this.addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent e){
                jTextPane2.requestFocus();
            }
        });

        jTextField1.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                    jTextField1.setText("");
            }
            public void focusLost(FocusEvent e){
            }
        });

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jLabel2.setText("Results:");

        jScrollPane4.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(315, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                                                              
    /**
    * The jButton1ActionPerformed method is called when an event is fired
    * if jButton1 is pressed. The method initiates a search of the hashtable object
    * and returns the result.
    * 
    */ 
    private void jButton1ActionPerformed(ActionEvent evt){

        int result = jFileChooser1.showOpenDialog(this); // open the file chooser

        try{
            if(result == JFileChooser.APPROVE_OPTION ){ // person selects file
                jTextPane2.setText(jTextPane2.getText()+"\nAttempting to load new data...");

                File selectedFile = jFileChooser1.getSelectedFile();

                if(HashUtil.formatIsCorrect(new BufferedReader(new FileReader(selectedFile)))){
                    table1 = new hashtable(HashUtil.getSize(new BufferedReader(new FileReader(selectedFile))));
                    HashUtil.loadData(new BufferedReader(new FileReader(selectedFile)), table1);
                    jTextPane2.setText(jTextPane2.getText()+"\nLoaded data from file: \""+selectedFile.getAbsolutePath()+"\""+"\nSize of data set: "+table1.getSize()+"\nTable size: "+table1.getTableSize()+"\nAverage Number of Collisions: "+table1.getAverageCollisions());
                }
                else{
                    jTextPane2.setText(jTextPane2.getText()+"\nError: Cannot read data from selected file.");
                }
            }
            else{
            }
        }catch(FileNotFoundException e){
        }
    }
    /**
    * The jButton2ActionPerformed method is called when an event is fired
    * if jButton2 is pressed. The metho facilitates the loading of new datasets into
    * the hashtable object.
    * 
    */ 
    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        
        String query = (jTextField1.getText()).trim();

        jTextPane2.setText(jTextPane2.getText()+"\nSearched "+PATH+" for \""+query+"\"");
        
        if(query.equals("") || !(HashUtil.isNumeric(query) && (query.length() == 13))){
            jTextPane3.setText("Incorrect Query. \nPlease enter a 13-digit ID number.");

        }
        else{
            long id = Long.parseLong(query);
            
            try{
                jTextPane3.setText((table1.get(new voter(id, "name", "surname", 10, "gender", "race"), id)).toString());

            }catch(NullPointerException e){
                jTextPane3.setText("Voter Not Found.");
            }
        }
    }                                              
}
