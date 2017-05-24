package fenetre;
import javax.swing.*;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.FontPropertiesManager;
import org.icepdf.ri.util.PropertiesManager;

import pdf.ChoisirFichier;

import java.awt.*;
import java.io.File;
import java.util.ResourceBundle;

import com.qoppa.pdfViewer.PDFViewerBean;

	public class FenetrePrincipale extends JFrame {
	    
	    private String titreFenetre = "PDF Creator";
	    private String selectionDossier = "Sélectionner un dossier";
	    private String dossierNonSelectionne = "Aucun dossier n'a été sélectionné";
	    
	    private File[] listPdfACreer;
	    private File[] listPdfDejaCrees;
	    
	    private String absolutePath;
	    
	    private JFrame frame;
	    
	    private JScrollPane jScrollPane1;
	    private JTextArea listContainer;
	    private JScrollPane jScrollPane2;
	    private JTextArea listeFichiersPDFCrees;
	    
	    private JButton choixFichier;
	    private JButton fusionFichier;
	    private JButton parametres;
        private JButton boutonScrollPanel;
        private JButton boutonEdit;
        private JButton boutonReset;
        
        private PDFViewerBean PDFViewerBean = null;
	    
	    
        /**
         * Constructeur
         * 
         * @param 
         *           
         */
	    public FenetrePrincipale() {
	        initialiser();
	        this.setTitle(titreFenetre);
	        this.setSize(1000, 800);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        fusionFichier.setEnabled(false);
	        this.setVisible(true);
	    }
	   
	    /**
         * Initialisation de la fenêtre et des composants
         * 
         * @param 
         */
	    private void initialiser() {

	    	frame = new JFrame();

	        jScrollPane1 = new JScrollPane();
	        jScrollPane2 = new JScrollPane();
	        
	        listContainer = new JTextArea(); 
	        listeFichiersPDFCrees = new JTextArea();
	        
	        choixFichier = new JButton("Choisir un dossier");
	        fusionFichier = new JButton("Fusionner les PDF");
	        parametres = new JButton("Parametres");
	        boutonScrollPanel = new JButton();
	        boutonEdit = new JButton("Editer un PDF");
	        boutonReset = new JButton("Reset");

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setResizable(false);
	        
	        listContainer.setEditable(false);
	        listContainer.setColumns(20);
	        listContainer.setRows(5);
	        listContainer.setText("Sélectionnez un dossier");
	        listContainer.setFocusable(false);
	        listContainer.setMargin(new java.awt.Insets(10, 10, 10, 10));
	        jScrollPane1.setViewportView(listContainer);

	        listeFichiersPDFCrees.setEditable(false);
	        listeFichiersPDFCrees.setColumns(20);
	        listeFichiersPDFCrees.setRows(5);
	        listeFichiersPDFCrees.setText("Fichiers recemment crées");
	        listeFichiersPDFCrees.setFocusable(false);
	        listeFichiersPDFCrees.setMargin(new java.awt.Insets(10, 10, 10, 10));
	        jScrollPane2.setViewportView(listeFichiersPDFCrees);
	       
	        
	        
	        boutonEdit.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	choisirFichiersDejaCrees();
	            }
	        });
 
	        parametres.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SettingsActionPerformed(evt);
	            }
	        });
	        
	        fusionFichier.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	fusionnerFichier(evt);
	            }
	        });
	        
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
	        
	        this.getContentPane().add(jScrollPane1);
	        this.getContentPane().add(boutonEdit);
	        this.getContentPane().add(jScrollPane2);
	        pack();
	    }

	    /**
         * Evenements lors de la selection du dossiers à fusionner
         * 
         * @param evt
         *            l'evenement à traiter
         */
		private void OpenFolderActionPerformed(java.awt.event.ActionEvent evt) {
			choisirFichierAFusionner();
	    }
		
	    /**
         * Evenements lors de la fermeture de la fenêtre
         * 
         * @param evt
         *            l'evenement à traiter
         */

	    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
	        System.exit(0);
	    }
	    
	    /**
         * Evenements lors de la fusion des fichiers
         * 
         * @param evt
         *            l'evenement à traiter
         */

	    private void fusionnerFichier(java.awt.event.ActionEvent evt) {
	        try {
	            CreerFichier namePopUp = new CreerFichier(absolutePath, listPdfACreer);
	        } catch (Exception e) {
	            System.out.println("Impossible de fusionner les PDF avec l'erreur : " + e);
	        }
	    }
	    

	    /**
         * Evenements lors de l'ouverture des paramêtres
         * 
         * @param evt
         *            l'evenement à traiter
         */
	    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {
	        Parametres settings = new Parametres();
	    }
	    
	    
	    /**
         * Choix des fichiers à Fusionner
         * 
         * @param 
         */
	    private void choisirFichierAFusionner() {
	        JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(new java.io.File("Desktop"));
	        chooser.setDialogTitle(selectionDossier);
	        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        chooser.setAcceptAllFileFilterUsed(false);
	        
	        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	            absolutePath = chooser.getSelectedFile().getAbsolutePath();
	            listPdfACreer = ChoisirFichier.find(absolutePath);
	            afficherNomsFichiers(listPdfACreer, listContainer);
	            fusionFichier.setEnabled(true);
	        } else {
	            listContainer.setText("");
	            listContainer.append(dossierNonSelectionne);
	        }
	    }
	    
	    /**
         * Choix des fichiers déjà fusionner à Editer
         * 
         * @param
         */
	    //Explorateur de fichiers Crées
	    private void choisirFichiersDejaCrees()
	    {
	        JFileChooser chooser = new JFileChooser();
	        chooser.setCurrentDirectory(new java.io.File("PdfFusion"));
	        chooser.setDialogTitle(selectionDossier);
	        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        chooser.setAcceptAllFileFilterUsed(false);
	        
	        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	ViewerComponentExample Pdf = new ViewerComponentExample(chooser.getSelectedFile().getAbsolutePath());

	        } else {
	            listContainer.setText("");
	            listContainer.append(dossierNonSelectionne);
	        }
	    }

	    /**
         * Afficher les noms des fichiers sélectionnés
         * 
         * @param fileList
         *            La liste des fichiers contenus dans le dossiers
         * @param liste 
         * 				La liste où afficher ces noms de fichiers
         */
	    private void afficherNomsFichiers(File[] fileList, JTextArea liste) {
	        String fileNames = "";
	      
	        for (int i = 0; i < fileList.length; i++) {
	           fileNames += fileList[i].getName() + "\n";
	        }
	        
	        liste.setText("");
	        liste.append(fileNames);
	        
	    }
	    
	    
	    /**
         *  Instancie une instance de PDFViewerBean
         * 
         * @param 
         *       
         */
	    private PDFViewerBean getPDFViewerBean()
	    {
	        if (PDFViewerBean == null)
	        {
	            PDFViewerBean = new PDFViewerBean();
	        }
	        return PDFViewerBean;
	    }
		
}
