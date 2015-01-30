package p020202VerSorteo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utiles.AKIButton;
import utiles.AKIPanel;
import marco.ControladorMarco;

public class PantallaVerSorteo extends utiles.PanelPantalla implements MouseListener{
	private ControladorVerSorteo c;
	protected AKIButton bVerPatrocinador = new AKIButton("Ver Patrocinadores del Sorteo", AKIButton.TipoBoton.BotonSimple);
	private JTextField textFieldCaracteristicasPremio;

	public PantallaVerSorteo(ControladorMarco controladorMarco) {
		super(controladorMarco);
		// TODO Auto-generated constructor stub
		bSalir = "Volver Atras";
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Sorteo";
		}else{
			sms1="Pantalla";
			sms2="Sorteo";
		}
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 355);
		add(pSuperior);
		//pSuperior.setBackground(Color.white);
		pSuperior.setLayout(null);
		
		AKIPanel pImgSorteo = new AKIPanel();
		pImgSorteo.setBackground(Color.white);
		pImgSorteo.setBounds(12, 13, 343, 149);
		pSuperior.add(pImgSorteo);
		pImgSorteo.setLayout(null);
		
		JPanel pCaracteristicasSorteo = new JPanel();
		pCaracteristicasSorteo.setBackground(Color.white);
		pCaracteristicasSorteo.setBounds(12, 175, 343, 167);
		pSuperior.add(pCaracteristicasSorteo);
		pCaracteristicasSorteo.setLayout(null);
		
		JLabel lblSorteo = new JLabel("Sorteo:");
		lblSorteo.setBounds(12, 0, 56, 16);
		pCaracteristicasSorteo.add(lblSorteo);
		
		JLabel lblIdSorteo = new JLabel("IdSorteo");
		lblIdSorteo.setBounds(68, 0, 65, 16);
		pCaracteristicasSorteo.add(lblIdSorteo);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(136, 0, 77, 16);
		pCaracteristicasSorteo.add(lblFechaFin);
		
		JLabel lblNumFecha = new JLabel("99/99/9999");
		lblNumFecha.setBounds(219, 0, 97, 16);
		pCaracteristicasSorteo.add(lblNumFecha);
		
		JLabel lblCaractersticasDelPremio = new JLabel("Caracter\u00EDsticas del Premio:");
		lblCaractersticasDelPremio.setBounds(12, 18, 319, 39);
		pCaracteristicasSorteo.add(lblCaractersticasDelPremio);
		
		textFieldCaracteristicasPremio = new JTextField();
		textFieldCaracteristicasPremio.setBounds(17, 50, 314, 115);
		pCaracteristicasSorteo.add(textFieldCaracteristicasPremio);
		textFieldCaracteristicasPremio.setColumns(10);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 379, 367, 60);
		add(pInferior);
		pInferior.setBackground(Color.white);
		pInferior.setLayout(null);
		
		//Al pulsar el AKIButton debe abrir un dialog con los patrocinadores de ese evento.
		JPanel pUnirmeASorteo = new JPanel();
		pUnirmeASorteo.setBounds(2, 10, 360, 40);
		pUnirmeASorteo.setBackground(Color.white);
		pInferior.add(pUnirmeASorteo);
		pUnirmeASorteo.add(bVerPatrocinador);
				
		c = new ControladorVerSorteo(this);
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
