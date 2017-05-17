package window;
import javax.swing.*;

import pdf.ChooseFile;

import java.awt.*;
import java.io.File;
import com.qoppa.pdfViewer.PDFViewerBean;

	public class MainWindow extends JFrame {
	    
	    private String windowTitle = "PDF Creator";
	    private String chooserDialogTitle = "Sélectionner un dossier";
	    private String noFolderSelectedMessage = "Aucun dossier n'a été sélectionné";
	    
	    private File[] fileList;
	    private String absolutePath;
	    
	    private JFrame frame;
	   
	    private JMenu Aide;
	    private JMenu Editer;
	    private JMenuItem Exit;
	    private JMenuItem MergePDF;
	    private JMenuItem OpenFolder;
	    private JMenu Preferences;
	    private JMenuItem Settings;
	    private JMenu jMenu2;
	    private JMenu jMenu3;
	    private JMenuBar jMenuBar1;
	    private JMenuBar jMenuBar2;
	    private JMenuItem jMenuItem1;
	    private JMenuItem jMenuItem2;
	    private JPopupMenu jPopupMenu1;
	    private JScrollPane jScrollPane1;
	    private JTextArea listContainer;
	    
	    private JButton choixFichier;
	    private JButton fusionFichier;
	    private JButton parametres;
        private JButton boutonScrollPanel;
        private JButton boutonEdit;
        private JButton boutonReset;
        
        private PDFViewerBean PDFViewerBean = null;
	    
	    
	    // Constructor
	    public MainWindow() {
	        initComponents();
	        this.setTitle(windowTitle);
	        this.setSize(1000, 800);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        Editer.setEnabled(false);
	        fusionFichier.setEnabled(false);
	        this.setVisible(true);
	    }
	    
	    private PDFViewerBean getPDFViewerBean()
	    {
	        if (PDFViewerBean == null)
	        {
	            PDFViewerBean = new PDFViewerBean();

	            // Buttons from the toolbar can be removed and added here:
	            // PDFViewerBean.getToolbar().getjbOpen().setVisible(false);
	        }
	        return PDFViewerBean;
	    }


	    // Initialisation des variables pour la fenêtre
	    private void initComponents() {

	    	frame = new JFrame();
	        jMenuBar2 = new JMenuBar();
	        jMenu2 = new JMenu();
	        jMenu3 = new JMenu();
	        jMenuItem1 = new JMenuItem();
	        jMenuItem2 = new JMenuItem();
	        jPopupMenu1 = new JPopupMenu();
	        jScrollPane1 = new JScrollPane();
	        listContainer = new JTextArea();
	        jMenuBar1 = new JMenuBar();
	        Preferences = new JMenu();
	        OpenFolder = new JMenuItem();
	        Settings = new JMenuItem();
	        Exit = new JMenuItem();
	        Editer = new JMenu();
	        MergePDF = new JMenuItem();
	        Aide = new JMenu();
	        
	        choixFichier = new JButton("Choisir un dossier");
	        fusionFichier = new JButton("Fusionner les PDF");
	        parametres = new JButton("Parametres");
	        boutonScrollPanel = new JButton();
	        boutonEdit = new JButton("Editer le PDF");
	        boutonReset = new JButton("Reset");
	      	      
	        
	        
	        jMenu2.setText("File");
	        jMenuBar2.add(jMenu2);

	        jMenu3.setText("Edit");
	        jMenuBar2.add(jMenu3);

	        jMenuItem1.setText("jMenuItem1");

	        jMenuItem2.setText("jMenuItem2");

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setResizable(false);
	        
	        
	        listContainer.setEditable(false);
	        listContainer.setColumns(20);
	        listContainer.setRows(5);
	        listContainer.setText("Sélectionnez un dossier");
	        listContainer.setFocusable(false);
	        listContainer.setMargin(new java.awt.Insets(10, 10, 10, 10));
	        jScrollPane1.setViewportView(listContainer);

	        Preferences.setText("Fichier");

	        OpenFolder.setText("Ouvrir un dossier");
	        OpenFolder.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                OpenFolderActionPerformed(evt);
	            }
	        });
	        Preferences.add(OpenFolder);
	        OpenFolder.getAccessibleContext().setAccessibleDescription("");

	        Settings.setText("Réglages");
	        parametres.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SettingsActionPerformed(evt);
	            }
	        });
	        Preferences.add(Settings);

	        Exit.setText("Quitter");
	        Exit.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                ExitActionPerformed(evt);
	            }
	        });
	        Preferences.add(Exit);

	        jMenuBar1.add(Preferences);

	        
	        Editer.setText(" Editer");
	        MergePDF.setText("Fusionner les fichiers");
	        
	        fusionFichier.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                MergePDFActionPerformed(evt);
	            }
	        });
	        Editer.add(MergePDF);

	        jMenuBar1.add(Editer);

	        Aide.setText("Aide");
	        Aide.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                AideActionPerformed(evt);
	            }
	        });
	        jMenuBar1.add(Aide);

	        setJMenuBar(jMenuBar1);
	        
	        choixFichier.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                OpenFolderActionPerformed(evt);
	            }
	        });

	        
	        JPanel firstPanel = new JPanel(new GridLayout(3, 1));
	        firstPanel.setPreferredSize(new Dimension(3*100, 100));
	        firstPanel.add(choixFichier);
	        firstPanel.add(fusionFichier);
	       
	        
	        JPanel secondPanel = new JPanel(new GridLayout(1,2));
	        secondPanel.setPreferredSize(new Dimension(100, 2*100));
	        secondPanel.add(parametres);
	        secondPanel.add(boutonReset);
	        
	        firstPanel.add(secondPanel);
	        this.add(firstPanel);
	        
	        GridLayout gl = new GridLayout(2,3,10,10);
	        getContentPane().setLayout(gl);
	        


	        
	        //boutonScrollPanel.setPreferredSize(new Dimension(5*40, 13*40));
	        
	        
	        this.getContentPane().add(jScrollPane1);
	        this.getContentPane().add(boutonEdit);
	        this.getContentPane().add(getPDFViewerBean());

	        pack();
	    }


		private void OpenFolderActionPerformed(java.awt.event.ActionEvent evt) {
	        displayBrowserWindow();
	    }

	    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
	        System.exit(0);
	    }

	    private void MergePDFActionPerformed(java.awt.event.ActionEvent evt) {
	        try {
	            PopUp namePopUp = new PopUp(absolutePath, fileList);
	        } catch (Exception e) {
	            System.out.println("Impossible de fusionner les PDF avec l'erreur : " + e);
	        }
	    }

	    private void AideActionPerformed(java.awt.event.ActionEvent evt) {
	        
	    }

	    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {
	        Settings settings = new Settings();
	    }
	    
	    //Explorateur de fichiers
	    private void displayBrowserWindow() {
	        JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(new java.io.File("Desktop"));
	        chooser.setDialogTitle(chooserDialogTitle);
	        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        chooser.setAcceptAllFileFilterUsed(false);
	        
	        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	            absolutePath = chooser.getSelectedFile().getAbsolutePath();
	            fileList = ChooseFile.find(absolutePath);
	            printFileNames(fileList);
	            fusionFichier.setEnabled(true);
	        } else {
	            listContainer.setText("");
	            listContainer.append(noFolderSelectedMessage);
	        }
	    }
	    
	    //Affichage des noms des fichiers PDF
	    private void printFileNames(File[] fileList) {
	        String fileNames = "";
	        
	        for (int i = 0; i < fileList.length; i++) {
	            fileNames += fileList[i].getName() + "\n";
	        }
	        
	        listContainer.setText("");
	        listContainer.append(fileNames);
	    }

	    //Classe main 
	    
	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new MainWindow().setVisible(true);
	            }
	        });
	    }
	    
	    
	
	
}
