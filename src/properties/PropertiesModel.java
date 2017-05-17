package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesModel {
    private Properties prop = new Properties();
    private String fileName = "propriete/config.properties";
    private File myConfig = new File(fileName);
    private FileOutputStream output = null;
    
    public void setProperties(String filePath, Boolean headerIsActivated, Boolean footerIsActivated, String headerContent, String footerContent) {
        try {
            InputStream file = new FileInputStream(myConfig);
            output = new FileOutputStream(myConfig, false);
            prop.load(file);
            prop.setProperty("generatedPDFFilePath", filePath);
            prop.setProperty("isTextOnTopActivated", headerIsActivated.toString());
            prop.setProperty("isTextOnBottomActivated", footerIsActivated.toString());
            prop.setProperty("headerContent", headerContent);
            prop.setProperty("footerContent", footerContent);
            prop.store(output, null);
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
        }
    }
    
    public String getFilePath() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("generatedPDFFilePath");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    public String getHeaderIsActivated() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("isTextOnBottomActivated");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    public String getFooterIsActivated() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("isTextOnTopActivated");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    public String getHeaderContent() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("headerContent");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    public String getFooterContent() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("footerContent");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
}
