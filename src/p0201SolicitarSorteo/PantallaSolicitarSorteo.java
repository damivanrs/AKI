package p0201SolicitarSorteo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




import p02MenuSorteos.ControladorMenuSorteos;
import utiles.AKIButton;
import utiles.AKIPanel;
import marco.ControladorMarco;

public class PantallaSolicitarSorteo extends utiles.PanelPantalla implements MouseListener {
	private ControladorSolicitarSorteo c;
	protected AKIButton bSolicitarSorteo = new AKIButton("Solicitar Sorteo", AKIButton.TipoBoton.BotonSimple);
	private JTextField textFieldCaracteristicasPremio;

	public PantallaSolicitarSorteo(ControladorMarco controladorMarco) {
		super(controladorMarco);
		// TODO Auto-generated constructor stub
		bSalir = "Volver Atras";
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Solicitar Sorteos";
		}else{
			sms1="Pantalla";
			sms2="Solicitar Sorteos";
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
		lblSorteo.setBounds(12, 5, 56, 16);
		pCaracteristicasSorteo.add(lblSorteo);
		
		JLabel lblIdSorteo = new JLabel("IdSorteo");
		lblIdSorteo.setBounds(68, 5, 65, 16);
		pCaracteristicasSorteo.add(lblIdSorteo);
		
		JLabel lblLmitePatrocinadores = new JLabel("L\u00EDmite Patrocinadores:");
		lblLmitePatrocinadores.setBounds(145, 5, 136, 16);
		pCaracteristicasSorteo.add(lblLmitePatrocinadores);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(284, 2, 47, 22);
		pCaracteristicasSorteo.add(comboBox);
		
		JLabel lblExclusividad = new JLabel("Exclusividad:");
		lblExclusividad.setBounds(12, 33, 82, 16);
		pCaracteristicasSorteo.add(lblExclusividad);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBackground(Color.white);
		rdbtnSi.setBounds(95, 30, 47, 25);
		pCaracteristicasSorteo.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.white);
		rdbtnNo.setBounds(155, 30, 56, 25);
		pCaracteristicasSorteo.add(rdbtnNo);
		
		JLabel lblCaractersticasDelPremio = new JLabel("Caracter\u00EDsticas del Premio:");
		lblCaractersticasDelPremio.setBounds(12, 57, 163, 16);
		pCaracteristicasSorteo.add(lblCaractersticasDelPremio);
		
		textFieldCaracteristicasPremio = new JTextField();
		textFieldCaracteristicasPremio.setBounds(17, 81, 314, 86);
		pCaracteristicasSorteo.add(textFieldCaracteristicasPremio);
		textFieldCaracteristicasPremio.setColumns(10);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 379, 367, 60);
		add(pInferior);
		pInferior.setBackground(Color.white);
		pInferior.setLayout(null);
		
		
		JPanel pSolicitarSorteo = new JPanel();
		pSolicitarSorteo.setBounds(2, 10, 360, 40);
		pSolicitarSorteo.setBackground(Color.white);
		pInferior.add(pSolicitarSorteo);
		pSolicitarSorteo.add(bSolicitarSorteo);
		
		bSolicitarSorteo.addMouseListener(this);
		
		c = new ControladorSolicitarSorteo(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(bSolicitarSorteo)){
			c.pagos();
		}
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
