package fenetre;
	import java.awt.Desktop;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import org.apache.pdfbox.io.MemoryUsageSetting;
	import org.apache.pdfbox.multipdf.PDFMergerUtility;

 
	public class StockerFichier {
		
	    /**
         * Fusion des fichiers
         * 
         * @param absolutePath
         * 			Chemin absolu du stockage
         * @param givenName
         * 			Nom donné au fichier fusionné
         * @param fileList
         *            L'ensemble des fichiers à fusionner
         */
	    public void fusionnerFichier(String absolutePath, String givenName, File[] fileList) throws FileNotFoundException, IOException {
	        PDFMergerUtility PDFmerger = new PDFMergerUtility();
	        for(int i = 0; i < fileList.length; i++) {
	            System.out.println(absolutePath + "/" + fileList[i].getName());
	            PDFmerger.addSource(absolutePath + "/" + fileList[i].getName());
	        }
	        
	        if(!givenName.endsWith(".pdf")) {
	            givenName += ".pdf";
	        }
	        
	        File directory = new File("pdfFusion");
	        if(!directory.exists()) {
	            directory.mkdir();
	        }
	        
	        String newFilePath = "pdfFusion/" + givenName;           
	        PDFmerger.setDestinationFileName(newFilePath);
	        PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
	        
	        chargerFichier(newFilePath);
	        
	        System.out.println(newFilePath);
	    }
	    
	    /**
         * Chaergement du fichier
         * 
         * @param lastPDFCreated
         * 			Nom du dernier PDf crée
         */
	    public void chargerFichier(String lastPDFCreated) throws IOException {
	        if (Desktop.isDesktopSupported()) {
	            final Desktop desktop = Desktop.getDesktop();
	            try {
	                Desktop.getDesktop().open(new File(lastPDFCreated));
	            } catch (Exception e) {
	                System.out.println("Impossible d'ouvrir le fichier avec l'erreur : " + e);
	            }
	        }
	    }
}

