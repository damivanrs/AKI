package p020101Pagos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





import p02MenuSorteos.ControladorMenuSorteos;
import utiles.AKIButton;
import utiles.AKIPanel;
import marco.ControladorMarco;

public class PantallaPagos extends utiles.PanelPantalla implements MouseListener {
	private ControladorPagos c;
	protected AKIButton bValidar = new AKIButton("Validar", AKIButton.TipoBoton.BotonSimple);
	private JTextField textFieldNumTarjeta;
	private JTextField textFieldNumSecreto;
	private JTextField textFieldPayPal;
	
	public PantallaPagos(ControladorMarco controladorMarco){
		super(controladorMarco);
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Pagos Sorteos";
		}else{
			sms1="Pantalla";
			sms2="Pagos Sorteos";
		}
		
		bSalir="Volver Atras";
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 355);
		add(pSuperior);
		pSuperior.setLayout(null);
		
		AKIPanel panel = new AKIPanel();
		panel.setBounds(12, 13, 343, 74);
		pSuperior.add(panel);
		panel.setLayout(null);
		
		JLabel lblPatrocinioDelSorteo = new JLabel("Patrocinio del Sorteo");
		lblPatrocinioDelSorteo.setBounds(12, 10, 128, 16);
		panel.add(lblPatrocinioDelSorteo);
		
		JLabel lblCoste = new JLabel("Coste:");
		lblCoste.setBounds(12, 41, 45, 16);
		panel.add(lblCoste);
		
		JLabel lbl€ = new JLabel("\u20AC");
		lbl€.setBounds(107, 41, 18, 16);
		panel.add(lbl€);
		
		JLabel lblValorCoste = new JLabel("100");
		lblValorCoste.setBounds(63, 41, 34, 16);
		panel.add(lblValorCoste);
		
		JLabel lblOBien = new JLabel("o bien:");
		lblOBien.setBounds(138, 41, 56, 16);
		panel.add(lblOBien);
		
		JLabel lblValorBono = new JLabel("4");
		lblValorBono.setBounds(196, 41, 34, 16);
		panel.add(lblValorBono);
		
		JLabel lblBonos = new JLabel("Bonos");
		lblBonos.setBounds(232, 41, 56, 16);
		panel.add(lblBonos);
		
		JLabel lblIdsorteo = new JLabel("IdSorteo");
		lblIdsorteo.setBounds(138, 10, 193, 16);
		panel.add(lblIdsorteo);
		
		AKIPanel panel_1 = new AKIPanel();
		panel_1.setBounds(12, 100, 343, 242);
		pSuperior.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago:");
		lblFormaDePago.setBounds(12, 13, 100, 16);
		panel_1.add(lblFormaDePago);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.white);
		comboBox.addItem("Selecciona una Forma de Pago");
		comboBox.setBounds(113, 10, 218, 22);
		panel_1.add(comboBox);
		
		JLabel lblVisa = new JLabel("VISA");
		lblVisa.setBounds(12, 53, 56, 16);
		panel_1.add(lblVisa);
		
		textFieldNumTarjeta = new JTextField();
		textFieldNumTarjeta.setBounds(12, 89, 203, 22);
		panel_1.add(textFieldNumTarjeta);
		textFieldNumTarjeta.setColumns(10);
		
		textFieldNumSecreto = new JTextField();
		textFieldNumSecreto.setBounds(233, 89, 56, 22);
		panel_1.add(textFieldNumSecreto);
		textFieldNumSecreto.setColumns(10);
		
		JLabel lblNmeroTarjeta = new JLabel("N\u00FAmero Tarjeta:");
		lblNmeroTarjeta.setBounds(12, 70, 100, 16);
		panel_1.add(lblNmeroTarjeta);
		
		JLabel lblNmeroSecreto = new JLabel("N\u00FAmero Secreto:");
		lblNmeroSecreto.setBounds(231, 70, 100, 16);
		panel_1.add(lblNmeroSecreto);
		
		JLabel lblPaypal = new JLabel("PayPal");
		lblPaypal.setBounds(12, 124, 56, 16);
		panel_1.add(lblPaypal);
		
		textFieldPayPal = new JTextField();
		textFieldPayPal.setBounds(12, 144, 203, 22);
		panel_1.add(textFieldPayPal);
		textFieldPayPal.setColumns(10);
		
		JLabel lblBonos_1 = new JLabel("Bonos");
		lblBonos_1.setBounds(12, 179, 56, 16);
		panel_1.add(lblBonos_1);
		
		JLabel lblNumBonos = new JLabel("4");
		lblNumBonos.setBounds(113, 208, 34, 16);
		panel_1.add(lblNumBonos);
		
		JLabel lblBonosAPagar = new JLabel("Bonos a Pagar:");
		lblBonosAPagar.setBounds(12, 208, 87, 16);
		panel_1.add(lblBonosAPagar);
		
		JLabel lblBonosDisponibles = new JLabel("Bonos Disponibles:");
		lblBonosDisponibles.setBounds(159, 208, 113, 16);
		panel_1.add(lblBonosDisponibles);
		
		JLabel lblNumBonosDisponibles = new JLabel("50");
		lblNumBonosDisponibles.setBounds(275, 208, 23, 16);
		panel_1.add(lblNumBonosDisponibles);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 379, 367, 60);
		add(pInferior);
		pInferior.setBackground(Color.white);
		pInferior.setLayout(null);
		
		
		JPanel pCompraBonos = new JPanel();
		pCompraBonos.setBounds(8, 10, 350, 47);
		pCompraBonos.setBackground(Color.white);
		pInferior.add(pCompraBonos);
		pCompraBonos.add(bValidar);
		
		c = new ControladorPagos(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
