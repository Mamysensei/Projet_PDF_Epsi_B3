package window;
	import java.awt.Desktop;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import org.apache.pdfbox.io.MemoryUsageSetting;
	import org.apache.pdfbox.multipdf.PDFMergerUtility;

 
	public class OpenFile {
		
	    public void mergeFiles(String absolutePath, String givenName, File[] fileList) throws FileNotFoundException, IOException {
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
	        
	        loadFile(newFilePath);
	        
	        System.out.println(newFilePath);
	    }
	    
	    public void loadFile(String lastPDFCreated) throws IOException {
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

