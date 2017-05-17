package properties;

import java.io.File;

public class PropertiesConfiguration {
    
    private File directory = new File(new String("propriete"));
    
    public boolean isFolderCreated() {
        if(directory.exists()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void createFolder() {
        directory.mkdir();
    }
}
