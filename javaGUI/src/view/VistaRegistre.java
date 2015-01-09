package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

public class VistaRegistre extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDni;
	private JTextField txtNom;
	private JTextField txtCognom;
	private JTextField txtCognom2;
	private JTextField txtEdat;

	/**
	 * Create the panel.
	 */
	public VistaRegistre() {
		setBackground(new Color(224, 255, 255));
		setBounds(0, 0, 380, 200);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 28, 127, 203, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 21, 30, 30, 30, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 1;
		add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		txtDni.setEditable(false);
		GridBagConstraints gbc_dni = new GridBagConstraints();
		gbc_dni.fill = GridBagConstraints.HORIZONTAL;
		gbc_dni.insets = new Insets(0, 0, 5, 0);
		gbc_dni.anchor = GridBagConstraints.NORTH;
		gbc_dni.gridx = 2;
		gbc_dni.gridy = 1;
		add(txtDni, gbc_dni);
		txtDni.setColumns(10);

		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 2;
		add(lblNom, gbc_lblNom);

		txtNom = new JTextField();
		txtNom.setEditable(false);
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.insets = new Insets(0, 0, 5, 0);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 2;
		add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);

		JLabel lblPrimerCognom = new JLabel("Primer cognom:");
		lblPrimerCognom.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrimerCognom = new GridBagConstraints();
		gbc_lblPrimerCognom.anchor = GridBagConstraints.WEST;
		gbc_lblPrimerCognom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerCognom.gridx = 1;
		gbc_lblPrimerCognom.gridy = 3;
		add(lblPrimerCognom, gbc_lblPrimerCognom);

		txtCognom = new JTextField();
		txtCognom.setEditable(false);
		GridBagConstraints gbc_txtCongnom = new GridBagConstraints();
		gbc_txtCongnom.insets = new Insets(0, 0, 5, 0);
		gbc_txtCongnom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCongnom.gridx = 2;
		gbc_txtCongnom.gridy = 3;
		add(txtCognom, gbc_txtCongnom);
		txtCognom.setColumns(10);

		JLabel lblSegonCognom = new JLabel("Segon Cognom:");
		lblSegonCognom.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSegonCognom = new GridBagConstraints();
		gbc_lblSegonCognom.anchor = GridBagConstraints.WEST;
		gbc_lblSegonCognom.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegonCognom.gridx = 1;
		gbc_lblSegonCognom.gridy = 4;
		add(lblSegonCognom, gbc_lblSegonCognom);

		txtCognom2 = new JTextField();
		txtCognom2.setEditable(false);
		GridBagConstraints gbc_txtCognom = new GridBagConstraints();
		gbc_txtCognom.insets = new Insets(0, 0, 5, 0);
		gbc_txtCognom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCognom.gridx = 2;
		gbc_txtCognom.gridy = 4;
		add(txtCognom2, gbc_txtCognom);
		txtCognom.setColumns(10);

		JLabel lblEdat = new JLabel("Edat:");
		lblEdat.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEdat = new GridBagConstraints();
		gbc_lblEdat.anchor = GridBagConstraints.WEST;
		gbc_lblEdat.insets = new Insets(0, 0, 0, 5);
		gbc_lblEdat.gridx = 1;
		gbc_lblEdat.gridy = 5;
		add(lblEdat, gbc_lblEdat);

		txtEdat = new JTextField();
		txtEdat.setEditable(false);
		GridBagConstraints gbc_txtEdat = new GridBagConstraints();
		gbc_txtEdat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEdat.gridx = 2;
		gbc_txtEdat.gridy = 5;
		add(txtEdat, gbc_txtEdat);
		txtEdat.setColumns(10);

	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public JTextField getTxtNom() {
		return txtNom;
	}

	public JTextField getTxtCognom() {
		return txtCognom;
	}

	public JTextField getTxtCognom2() {
		return txtCognom2;
	}

	public JTextField getTxtEdat() {
		return txtEdat;
	}

}
