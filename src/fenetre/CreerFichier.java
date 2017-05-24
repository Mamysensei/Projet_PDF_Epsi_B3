package fenetre;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class CreerFichier extends JDialog {
    
    private String messagePopup = "Nom du fichier à créer";
    
    
    /**
     *  Creation du fichier pdf
     * 
     * @param absolutePath
     * 			Chemin absolu pour la création du fichier
     * @param fileList 
     * 			tableau des fichiers à fusionner 
     *       
     */
    public CreerFichier(String absolutePath, File[] fileList) throws FileNotFoundException, IOException {
        JOptionPane fileNamePopUp = new JOptionPane();
        String answer = fileNamePopUp.showInputDialog(null, messagePopup, "", JOptionPane.QUESTION_MESSAGE);
        
        // appel de la méthode de fusion des PDF
        StockerFichier newFile = new StockerFichier();
        newFile.fusionnerFichier(absolutePath, answer, fileList);       
    }
}
 