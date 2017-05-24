package proprietes;

import java.io.File;

public class ConfigurationDossier {
    
    private File directory = new File(new String("propriete"));
    
    
    /**
     *  Verification que le dossier est cré
     * 
     * @param 
     *       
     */
    public boolean isFolderCreated() {
        if(directory.exists()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /**
     *  Creation du  dossier
     * 
     * @param 
     *       
     */
    public void createFolder() {
        directory.mkdir();
    }
}
