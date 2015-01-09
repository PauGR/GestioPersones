package view;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import java.awt.Color;

public class VistaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JButton nou;
	private JButton esborra;
	private JButton btnDesa;
	private JButton btncancela;
	private JLabel lblEstat;
	private JButton btnEdita;
	private JButton btnPrimer;
	private JButton btnDarrer;
	private JButton btnAnterior;
	private JButton btnSegent;
	private JPanel panel_1;
	private JToolBar toolBar_1;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setResizable(false);
		// public VistaPrincipal(JPanel panel) {
		this.setVisible(true);
		setTitle("GESTIÓ DE PERSONES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 298);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setMargin(new Insets(0, -15, 0, -5));

		toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		menuBar.add(toolBar_1);

		nou = new JButton("nou");
		toolBar_1.add(nou);

		esborra = new JButton("esborra");

		toolBar_1.add(esborra);

		btnEdita = new JButton("edita");

		toolBar_1.add(btnEdita);

		btnPrimer = new JButton("primer");

		toolBar_1.add(btnPrimer);

		btnDarrer = new JButton("darrer");

		toolBar_1.add(btnDarrer);

		btnAnterior = new JButton("anterior");

		toolBar_1.add(btnAnterior);

		btnSegent = new JButton("següent");
		toolBar_1.add(btnSegent);

		btnDesa = new JButton("desa");
		toolBar_1.add(btnDesa);

		btncancela = new JButton("cancel·la");
		toolBar_1.add(btncancela);

		lblEstat = new JLabel();
		lblEstat.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(lblEstat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}

	public void afegirComponent(Component v) {
		panel_1.add(v);
	}

	// getters i setters

	public JLabel getLblEstat() {
		return lblEstat;
	}

	public void setLblEstat(int i, int j) {
		int s = i + 1;
		this.lblEstat.setText("registre " + s + " de " + j);
	}

	public void setLblEstat(String s) {

		this.lblEstat.setText(s);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnNou() {
		return nou;
	}

	public JButton getBtnEsborra() {
		return esborra;
	}

	public JButton getBtnDesa() {
		return btnDesa;
	}

	public JButton getBtncancela() {
		return btncancela;
	}

	public JButton getBtnEdita() {
		return btnEdita;
	}

	public JButton getBtnPrimer() {
		return btnPrimer;
	}

	public JButton getBtnDarrer() {
		return btnDarrer;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public JButton getBtnSegent() {
		return btnSegent;
	}

}
