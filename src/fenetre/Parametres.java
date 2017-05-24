package fenetre;

import javax.swing.*;

import pdf.ProprietesPDF;

public class Parametres extends javax.swing.JFrame {
    
    private String windowTitle = "Réglages";
    private String chooserDialogTitle = "Sélectionnez un dossier";
    
    private JRadioButton AddFooter;
    private JRadioButton AddHeader;
    private JButton CancelBtn;
    private JButton ChangeFilePath;
    private JTextField FilePath;
    private JLabel FilesPathTitle;
    private JButton RecordSettings;
    private JTextField SetFooterContent;
    private JLabel SetFooterTitle;
    private JTextField SetHeaderContent;
    private JLabel SetHeaderLabel;
    private JFileChooser jFileChooser1;
    private JSeparator jSeparator1;
    
    String headerIsActivated = new ProprietesPDF().getHeaderIsActivated();
    String footerIsActivated = new ProprietesPDF().getFooterIsActivated();
    
    private ProprietesPDF model = new ProprietesPDF();

    /**
     * Constructeur
     * 
     * @param 
     *           
     */
    
    public Parametres() {
    	initialisation();
        this.setTitle(windowTitle);
        this.setSize(1500, 1000);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        FilePath.setText(model.getFilePath());
        System.out.println("header activated : " + model.getHeaderIsActivated());
        if(model.getHeaderIsActivated().equals("true")) {
            AddHeader.setSelected(true);
            SetHeaderContent.setEnabled(true);
        } else {
            SetHeaderContent.setEnabled(false);
        }
        System.out.println("footer activated : " + model.getFooterIsActivated());
        if(model.getFooterIsActivated().equals("true")) {
            AddFooter.setSelected(true);
            SetFooterContent.setEnabled(true);
        } else {
            SetFooterContent.setEnabled(false);
        }
        if(!model.getHeaderContent().equals("null")) {
            SetHeaderContent.setText(model.getHeaderContent());
        }
        if(!model.getFooterContent().equals("null")) {
            SetFooterContent.setText(model.getFooterContent());
        }
        this.setVisible(true);
    }

    /**
     * Initialisation de la fenetre 
     * 
     * @param 
     *           
     */
    
    private void initialisation() {

        jFileChooser1 = new javax.swing.JFileChooser();
        AddHeader = new javax.swing.JRadioButton();
        AddFooter = new javax.swing.JRadioButton();
        SetHeaderContent = new javax.swing.JTextField();
        SetHeaderLabel = new javax.swing.JLabel();
        SetFooterTitle = new javax.swing.JLabel();
        SetFooterContent = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        FilePath = new javax.swing.JTextField();
        FilesPathTitle = new javax.swing.JLabel();
        ChangeFilePath = new javax.swing.JButton();
        RecordSettings = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        AddHeader.setText("Ajouter une en-tête sur le PDF généré");
        AddHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddHeaderActionPerformed(evt);
            }
        });

        AddFooter.setText("Ajouter un pied de page sur le PDF généré");
        AddFooter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFooterActionPerformed(evt);
            }
        });

        SetHeaderContent.setEnabled(false);
        SetHeaderContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetHeaderContentActionPerformed(evt);
            }
        });

        SetHeaderLabel.setText("Contenu de l'en-tête :");

        SetFooterTitle.setText("Contenu du pied de page :");

        SetFooterContent.setEnabled(false);

        FilePath.setEnabled(false);

        FilesPathTitle.setText("Destination des fichiers PDF :");

        ChangeFilePath.setText("Modifier le chemin d'écriture");
        ChangeFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeFilePathActionPerformed(evt);
            }
        });

        RecordSettings.setText("Enregistrer les modifications");
        RecordSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordSettingsActionPerformed(evt);
            }
        });

        CancelBtn.setText("Annuler");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FilePath)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ChangeFilePath)
                                        .addGap(0, 238, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(CancelBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RecordSettings))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SetHeaderContent))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FilesPathTitle)
                            .addComponent(AddFooter)
                            .addComponent(AddHeader)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SetFooterTitle)
                                    .addComponent(SetHeaderLabel))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SetFooterContent)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(FilesPathTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangeFilePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetHeaderLabel)
                .addGap(8, 8, 8)
                .addComponent(SetHeaderContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddFooter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetFooterTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetFooterContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecordSettings)
                    .addComponent(CancelBtn))
                .addContainerGap())
        );

        pack();
    }

    /**
     * Changer le chemin des parametres
     * 
     * @param evt
     *            l'evenement à traiter
     */
    private void ChangeFilePathActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Desktop"));
        chooser.setDialogTitle(chooserDialogTitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            FilePath.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    /**
     * Ajout le header dans le PDF
     * 
     * @param evt
     *            l'evenement à traiter
     */
    private void AddHeaderActionPerformed(java.awt.event.ActionEvent evt) {
        if(headerIsActivated.equals("true")) {
            SetHeaderContent.setEnabled(false);
            headerIsActivated = "false";
        } else {
            SetHeaderContent.setEnabled(true);
            headerIsActivated = "true";
        }
    }

    /**
     * Ajotuer le footer dans le PDF
     * 
     * @param evt
     *            l'evenement à traiter
     */
    private void AddFooterActionPerformed(java.awt.event.ActionEvent evt) {
        if(footerIsActivated.equals("true")) {
            SetFooterContent.setEnabled(false);
            footerIsActivated = "false";
        } else {
            SetFooterContent.setEnabled(true);
            footerIsActivated = "true";
        }
    }

    private void SetHeaderContentActionPerformed(java.awt.event.ActionEvent evt) {}

    /**
     * Annuler les modifications
     * 
     * @param evt
     *            l'evenement à traiter
     */
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    /**
     * Sauvegarder les modifications
     * 
     * @param evt
     *            l'evenement à traiter
     */
    private void RecordSettingsActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("header activated : " + AddHeader.isSelected());
        System.out.println("footer activated : " + AddFooter.isSelected());
        model.setProperties(FilePath.getText(), AddHeader.isSelected(), AddFooter.isSelected(), SetHeaderContent.getText(), SetFooterContent.getText());
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parametres().setVisible(true);
            }
        });
    }

 

 
}

