import java.awt.EventQueue;

import model.Model;
import view.VistaPrincipal;
import controlador.Controller;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal v = new VistaPrincipal();
					Model m = new Model();
					Controller c = new Controller(v, m);
					c.controla(); 
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
