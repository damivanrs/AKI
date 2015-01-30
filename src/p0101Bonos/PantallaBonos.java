package p0101Bonos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utiles.AKIButton;
import utiles.AKIPanel;
import marco.ControladorMarco;

public class PantallaBonos extends utiles.PanelPantalla implements MouseListener {
	private ControladorBonos c;
	protected AKIButton bCompraBonos = new AKIButton("Comprar Bonos", AKIButton.TipoBoton.BotonSimple);
	private JTextField textFieldBonosAAnnadir;
	private JTextField textFieldNumTarjeta;
	private JTextField textFieldNumSecreto;
	private JTextField textFieldEmailPaypal;

	public PantallaBonos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		// TODO Auto-generated constructor stub
		bSalir = "Volver Atras";
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Bonos";
		}else{
			sms1="Pantalla";
			sms2="Bonos";
		}
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 355);
		add(pSuperior);
		pSuperior.setBackground(Color.white);
		pSuperior.setLayout(null);
		
		AKIPanel pBonos = new AKIPanel();
		pBonos.setBounds(12, 13, 343, 90);
		pSuperior.add(pBonos);
		pBonos.setLayout(null);
		
		JLabel lblBonosDisponibles = new JLabel("Bonos Disponibles");
		lblBonosDisponibles.setBounds(12, 17, 114, 16);
		pBonos.add(lblBonosDisponibles);
		
		JLabel lblBonosAAdquirir = new JLabel("Bonos a Adquirir");
		lblBonosAAdquirir.setBounds(12, 52, 114, 16);
		pBonos.add(lblBonosAAdquirir);
		
		JLabel lblNumeroBonosDisponibles = new JLabel("10");
		lblNumeroBonosDisponibles.setBounds(154, 17, 56, 16);
		pBonos.add(lblNumeroBonosDisponibles);
		
		textFieldBonosAAnnadir = new JTextField();
		textFieldBonosAAnnadir.setBounds(154, 49, 177, 22);
		pBonos.add(textFieldBonosAAnnadir);
		textFieldBonosAAnnadir.setColumns(10);
		
		AKIPanel pFormasdePago = new AKIPanel();
		pFormasdePago.setBounds(12, 114, 343, 228);
		pSuperior.add(pFormasdePago);
		pFormasdePago.setLayout(null);
		
		JPanel pSeleccionPago = new JPanel();
		pSeleccionPago.setBackground(Color.white);
		pSeleccionPago.setBounds(12, 12, 319, 62);
		pFormasdePago.add(pSeleccionPago);
		pSeleccionPago.setLayout(null);
		
		JLabel lblSeleccionaFormaPago = new JLabel("Selecciona una Forma de Pago");
		lblSeleccionaFormaPago.setBounds(12, 7, 186, 16);
		pSeleccionPago.add(lblSeleccionaFormaPago);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(13, 31, 294, 22);
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("Selecciona una forma de pago");
		pSeleccionPago.add(comboBox);
		
		JPanel pVisa = new JPanel();
		pVisa.setBackground(Color.white);
		pVisa.setBounds(12, 87, 319, 62);
		pFormasdePago.add(pVisa);
		pVisa.setLayout(null);
		
		JLabel lblVisa = new JLabel("VISA");
		lblVisa.setBounds(12, 8, 56, 16);
		pVisa.add(lblVisa);
		
		textFieldNumTarjeta = new JTextField();
		textFieldNumTarjeta.setColumns(10);
		textFieldNumTarjeta.setBounds(22, 30, 234, 22);
		pVisa.add(textFieldNumTarjeta);
		
		textFieldNumSecreto = new JTextField();
		textFieldNumSecreto.setColumns(10);
		textFieldNumSecreto.setBounds(268, 30, 39, 22);
		pVisa.add(textFieldNumSecreto);
		
		JPanel pPaypal = new JPanel();
		pPaypal.setBounds(12, 162, 319, 53);
		pPaypal.setBackground(Color.white);
		pFormasdePago.add(pPaypal);
		pPaypal.setLayout(null);
		
		JLabel lblPaypal = new JLabel("Paypal");
		lblPaypal.setBounds(12, 20, 44, 16);
		pPaypal.add(lblPaypal);
		
		textFieldEmailPaypal = new JTextField();
		textFieldEmailPaypal.setColumns(10);
		textFieldEmailPaypal.setBounds(65, 17, 244, 22);
		pPaypal.add(textFieldEmailPaypal);			
	
		JPanel pInferior = new JPanel();
		pInferior.setBounds(10, 379, 367, 60);
		add(pInferior);
		pInferior.setBackground(Color.white);
		pInferior.setLayout(null);
		
		AKIPanel pCompraBonos = new AKIPanel();
		pCompraBonos.setBounds(0, 13, 367, 47);
		//(10, 11, 367, 355)
		pCompraBonos.setBackground(Color.white);
		pInferior.add(pCompraBonos);
		pCompraBonos.add(bCompraBonos);
		
		c = new ControladorBonos(this);
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
