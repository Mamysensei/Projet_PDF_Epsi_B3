package window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PopUp extends JDialog {
    
    private String popUpTitle = "Nom du fichier à créer";
    
    public PopUp(String absolutePath, File[] fileList) throws FileNotFoundException, IOException {
        JOptionPane fileNamePopUp = new JOptionPane();
        String answer = fileNamePopUp.showInputDialog(null, popUpTitle, "", JOptionPane.QUESTION_MESSAGE);
        
        // appel de la méthode de fusion des PDF
        OpenFile newFile = new OpenFile();
        newFile.mergeFiles(absolutePath, answer, fileList);       
    }
}
 