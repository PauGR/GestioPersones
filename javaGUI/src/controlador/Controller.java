package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.Model;
import model.Persona;
import view.VistaPrincipal;
import view.VistaRegistre;

public class Controller {

	private VistaPrincipal vistaPrincipal;
	private VistaRegistre vistaRegistre;
	private Model model;
	private boolean editar;
	private FileWriter w;
	private BufferedReader r;
	private String ruta = "dadesGuardades.csv";
	private File f = new File(ruta);

	public void guardaDades(String s1, String s2, String s3, String s4, int s5) {
		Persona p = new Persona(s1, s2, s3, s4, s5);

		model.add(model.getTotalReg(), p);
	}

	public void actualitza(String s1, String s2, String s3, String s4, int s5) {
		Persona p = new Persona(s1, s2, s3, s4, s5);

		model.add(model.getTotalReg(), p);
	}

	public void afegirDades(Persona s) {
		model.getDades().add(s);
		model.setTotalReg(model.getTotalReg() + 1);

	}

	public void llegirCSV() {

		String llistatTemp[] = new String[5];
		boolean existeixCSV = new File(ruta).exists();

		if (existeixCSV) {

			String espai = "";
			String separador = ";";

			try {
				r = new BufferedReader(new FileReader(f));
				while ((espai = r.readLine()) != null) {

					llistatTemp = espai.split(separador);
					afegirDades(new Persona(llistatTemp[0], llistatTemp[1], llistatTemp[2], llistatTemp[3],
							Integer.parseInt(llistatTemp[4])));
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (r != null) {
					try {
						r.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void escriureCSV() {

		int l = 0;
		f.delete();
		if (!model.getDades().isEmpty()) {
			try {
				w = new FileWriter(f);
				while (l < model.getDades().size()) {
					String[] s = { model.getDades().get(l).getDni(), model.getDades().get(l).getNom(),
							model.getDades().get(l).getCognom1(), model.getDades().get(l).getCognom2(),
							String.valueOf(model.getDades().get(l).getEdat()) };

					for (int i = 0; i < 5; i++) {
						if (i == 4) {
							w.append(s[i] + "\n");
						} else {
							w.append(s[i] + ";");
						}
					}
					l++;
				}
				w.flush();
				w.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void controla() {

		vistaRegistre = new VistaRegistre();
		vistaPrincipal.afegirComponent(vistaRegistre);
		habilitarBotons();
		vistaPrincipal.getBtnDesa().setEnabled(false);
		vistaPrincipal.getBtncancela().setEnabled(false);
		llegirCSV();

		if (!model.getDades().isEmpty()) {
			emplenarCampsRegistre(model.getDades().get(0));
			model.setIndex(0);
			vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
		} else {
			vistaPrincipal.setLblEstat("no hi ha registres");

		}

		// listeners
		vistaPrincipal.getBtnNou().addActionListener(e -> nou());
		vistaPrincipal.getBtnDesa().addActionListener(e -> guardar());
		vistaPrincipal.getBtnPrimer().addActionListener(e -> omplirFormulariPrimerRegistre());
		vistaPrincipal.getBtnDarrer().addActionListener(e -> omplirFormulariUltimRegistre());
		vistaPrincipal.getBtnSegent().addActionListener(e -> seguent());
		vistaPrincipal.getBtnAnterior().addActionListener(e -> anterior());
		vistaPrincipal.getBtnEsborra().addActionListener(e -> confirmacio());
		vistaPrincipal.getBtncancela().addActionListener(e -> cancela());
		vistaPrincipal.getBtnEdita().addActionListener(e -> editar());

		vistaPrincipal.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		vistaPrincipal.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				escriureCSV();
				vistaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public void cancela() {
		emplenarCampsRegistre(model.getDades().get(model.getIndex()));
		vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
		habilitarBotons();
		desHabilitarRegistre();
		vistaPrincipal.getBtncancela().setEnabled(false);
		vistaPrincipal.getBtnDesa().setEnabled(false);

	}

	public void seguent() {

		if ((model.getIndex() + 1) < model.getTotalReg()) {
			emplenarCampsRegistre(model.getDades().get(model.getIndex() + 1));
			model.setIndex(model.getIndex() + 1);
			vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
		}
	}

	public void confirmacio() {

		int confirmacio = JOptionPane.showConfirmDialog(vistaPrincipal, "Es borrarà la persona.\nVol continuar?",
				"Borrar persona", JOptionPane.OK_CANCEL_OPTION);

		if (confirmacio == JOptionPane.OK_OPTION) {
			esborra();
		}

	}

	public void esborra() {

		if (model.getTotalReg() > 1) {
			model.getDades().remove(model.getIndex());
			model.setTotalReg(model.getTotalReg() - 1);

			if (model.getIndex() != 0) {
				model.setIndex(model.getIndex() - 1);
			} else {
				model.setIndex(model.getIndex());
			}
			emplenarCampsRegistre(model.getDades().get(model.getIndex()));
			vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
		}

		else {
			model.getDades().clear();
			buidarRegistre();
			vistaPrincipal.setLblEstat("no hi ha registres");
			model.setIndex(0);
			model.setTotalReg(0);
			deshabilitarBotons();
			vistaPrincipal.getBtnNou().setEnabled(true);

		}
	}

	public void anterior() {

		if (model.getIndex() - 1 >= 0) {
			emplenarCampsRegistre(model.getDades().get(model.getIndex() - 1));
			model.setIndex(model.getIndex() - 1);
			vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
		}
	}

	public void omplirFormulariPrimerRegistre() {
		emplenarCampsRegistre(model.getDades().get(0));
		model.setIndex(0);
		vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
	}

	public void omplirFormulariUltimRegistre() {
		emplenarCampsRegistre(model.getDades().getLast());
		model.setIndex(model.getTotalReg() - 1);
		vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
	}

	public void emplenarCampsRegistre(Persona p) {
		desHabilitarRegistre();

		vistaRegistre.getTxtDni().setText(p.getDni());
		vistaRegistre.getTxtNom().setText(p.getNom());
		vistaRegistre.getTxtCognom().setText(p.getCognom1());
		vistaRegistre.getTxtCognom2().setText(p.getCognom2());
		vistaRegistre.getTxtEdat().setText(String.valueOf(p.getEdat()));

	}

	public Controller(VistaPrincipal vista, Model model) {
		this.vistaPrincipal = vista;
		this.model = model;
	}

	public void nou() {
		vistaPrincipal.getLblEstat().setText("nou registre");
		buidarRegistre();
		habilitarRegistre();
		deshabilitarBotons();
		vistaPrincipal.getBtnDesa().setEnabled(true);
		vistaPrincipal.getBtncancela().setEnabled(true);
	}

	public void editar() {
		vistaPrincipal.getLblEstat().setText("editant registre");
		deshabilitarBotons();
		habilitarRegistre();
		vistaPrincipal.getBtnDesa().setEnabled(true);
		vistaPrincipal.getBtncancela().setEnabled(true);
		editar = true;
	}

	public void guardar() {
		int edatInt;
		try {
			edatInt = Integer.parseInt((vistaRegistre.getTxtEdat().getText()));

			if (edatInt < 1000 && edatInt > 0) {
				String dni = vistaRegistre.getTxtDni().getText();
				String cognom = vistaRegistre.getTxtCognom().getText();
				String cognom2 = vistaRegistre.getTxtCognom2().getText();

				String nom = vistaRegistre.getTxtNom().getText();

				desHabilitarRegistre();
				habilitarBotons();

				vistaPrincipal.getBtnDesa().setEnabled(false);
				vistaPrincipal.getBtncancela().setEnabled(false);

				if (!editar) {

					if (model.getDades().isEmpty()) {
						model.getDades().clear();
						guardaDades(dni, nom, cognom, cognom2, edatInt);
						model.setTotalReg(1);
						model.setIndex(0);
						vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());

					} else {
						guardaDades(dni, nom, cognom, cognom2, edatInt);
						model.setTotalReg(model.getTotalReg() + 1);
						model.setIndex(model.getTotalReg() - 1);
						vistaPrincipal.setLblEstat(model.getIndex(), model.getTotalReg());
					}

				} else {
					this.editar = false;
					actualitza(dni, nom, cognom, cognom2, edatInt);

				}

			}

			else {
				JOptionPane.showMessageDialog(vistaPrincipal, "L'edat introduïda és incorrecte");
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vistaPrincipal, "L'edat introduïda ha de ser un número");
		}

	}

	public void deshabilitarBotons() {
		vistaPrincipal.getBtnNou().setEnabled(false);
		vistaPrincipal.getBtnAnterior().setEnabled(false);
		vistaPrincipal.getBtncancela().setEnabled(false);
		vistaPrincipal.getBtnDarrer().setEnabled(false);
		vistaPrincipal.getBtnDesa().setEnabled(false);
		vistaPrincipal.getBtnEdita().setEnabled(false);
		vistaPrincipal.getBtnEsborra().setEnabled(false);
		vistaPrincipal.getBtnPrimer().setEnabled(false);
		vistaPrincipal.getBtnSegent().setEnabled(false);

	}

	public void habilitarBotons() {
		vistaPrincipal.getBtnNou().setEnabled(true);
		vistaPrincipal.getBtnAnterior().setEnabled(true);
		vistaPrincipal.getBtncancela().setEnabled(true);
		vistaPrincipal.getBtnDarrer().setEnabled(true);
		vistaPrincipal.getBtnDesa().setEnabled(true);
		vistaPrincipal.getBtnEdita().setEnabled(true);
		vistaPrincipal.getBtnEsborra().setEnabled(true);
		vistaPrincipal.getBtnPrimer().setEnabled(true);
		vistaPrincipal.getBtnSegent().setEnabled(true);
	}

	public void habilitarRegistre() {
		vistaRegistre.getTxtDni().setEditable(true);
		vistaRegistre.getTxtCognom().setEditable(true);
		vistaRegistre.getTxtCognom2().setEditable(true);
		vistaRegistre.getTxtEdat().setEditable(true);
		vistaRegistre.getTxtNom().setEditable(true);
	}

	public void desHabilitarRegistre() {
		vistaRegistre.getTxtDni().setEditable(false);
		vistaRegistre.getTxtCognom().setEditable(false);
		vistaRegistre.getTxtCognom2().setEditable(false);
		vistaRegistre.getTxtEdat().setEditable(false);
		vistaRegistre.getTxtNom().setEditable(false);
	}

	public void buidarRegistre() {
		vistaRegistre.getTxtDni().setText("");
		vistaRegistre.getTxtCognom().setText("");
		vistaRegistre.getTxtCognom2().setText("");
		vistaRegistre.getTxtEdat().setText("");
		vistaRegistre.getTxtNom().setText("");
	}

}
