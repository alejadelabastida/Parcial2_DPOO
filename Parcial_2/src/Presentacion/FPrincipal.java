package Presentacion;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Logica.Parcial;

public class FPrincipal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tA, tB, tC;
	private JLabel lResultado;
	private JButton bCalcular;
	private Parcial parcial;

	public FPrincipal() {
		this.parcial = new Parcial();
		this.setLayout(new GridLayout(4, 2, 10, 10));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Examen Alejandra de la Bastida");
		this.setBounds((int) pantalla.getWidth() / 2 - 200, (int) pantalla.getHeight() / 2 - 150, 400, 300);

		this.tA = new JTextField();
		this.tB = new JTextField();
		this.tC = new JTextField();
		this.lResultado = new JLabel();
		this.bCalcular = new JButton("Calcular");
		this.bCalcular.addActionListener(this);

		this.add(new JLabel("a:", SwingConstants.RIGHT));
		this.add(this.tA);
		this.add(new JLabel("b:", SwingConstants.RIGHT));
		this.add(this.tB);
		this.add(new JLabel("c:", SwingConstants.RIGHT));
		this.add(this.tC);
		this.add(this.bCalcular);
		this.add(this.lResultado);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.bCalcular) {
			try {
				double a = Double.parseDouble(this.tA.getText());
				double b = Double.parseDouble(this.tB.getText());
				double c = Double.parseDouble(this.tC.getText());
				this.lResultado.setText(this.parcial.calcularRaices(a, b, c));
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}