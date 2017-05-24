package pdf;

import java.io.File;
import java.io.FilenameFilter;

public class ChoisirFichier {
	
    /**
     *  Choix des fichiers dans un répértoire
     * 
     * @param path
     *       Le chemin pour acceder au répértoire
     */
    public static File[] find (String path) {
        File dir = new File(path);
        return dir.listFiles(new FilenameFilter() 
        {
            public boolean accept(File dir, String filename) 
            {
                return filename.endsWith(".pdf");
            }
        } );
    }
}
