package fenetre;

import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.InputStream;

public class Main extends ApplicationException{
	public Main(String id, InputStream ins) {
		super(id, ins);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
	}

}
