/*
 * Created on Sep 24, 2008
 *
 */

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JPanel;
import com.qoppa.pdfViewer.PDFViewerBean;

public class SimpleFrame extends JFrame
{
    private JPanel jPanel = null;
    private PDFViewerBean PDFViewerBean = null;

    public static void main (String [] args)
    {
        SimpleFrame sf = new SimpleFrame();
        sf.setVisible(true);
    }
    /**
     * This method initializes 
     * 
     */
    public SimpleFrame() 
    {
    	super();
    	initialize();
    }

    /**
     * This method initializes this
     * 
     */
    private void initialize() 
    {
        this.setBounds(new Rectangle(0, 0, 800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getJPanel());
    	this.setTitle("Qoppa Software - jPDFViewer Sample");
    	this.setLocationRelativeTo(null);
    }

    /**
     * This method initializes jPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getJPanel()
    {
        if (jPanel == null)
        {
            jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
            jPanel.add(getPDFViewerBean(), BorderLayout.CENTER);
        }
        return jPanel;
    }

    /**
     * This method initializes PDFViewerBean	
     * 	
     * @return com.qoppa.pdfViewer.PDFViewerBean	
     */
    private PDFViewerBean getPDFViewerBean()
    {
        if (PDFViewerBean == null)
        {
            PDFViewerBean = new PDFViewerBean();

            // Buttons from the toolbar can be removed and added here:
            // PDFViewerBean.getToolbar().getjbOpen().setVisible(false);
        }
        return PDFViewerBean;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"