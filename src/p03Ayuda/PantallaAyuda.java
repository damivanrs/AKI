package p03Ayuda;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


import p02MenuSorteos.ControladorMenuSorteos;
//import p01Perfil.ControladorPerfil;
import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.BordeRedondeado;
import marco.ControladorMarco;



public class PantallaAyuda extends utiles.PanelPantalla implements MouseListener {
	private ControladorAyuda c;
	protected AKIButton bEnviar = new AKIButton("Enviar Mensaje", AKIButton.TipoBoton.BotonSimple);

	
	public PantallaAyuda (ControladorMarco controladorMarco) {
		super(controladorMarco);
		
		bSalir = "Volver Atras";
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Ayuda";
		}else{
			sms1="Pantalla";
			sms2="Ayuda";
		}
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 343);
		add(pSuperior);
		pSuperior.setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(12, 13, 56, 16);
		pSuperior.add(lblEmpresa);
		
		if(this.getMarco().isConectado()){
			JLabel lblNombreEmpresa = new JLabel(sms1);
			lblNombreEmpresa.setBounds(93, 13, 262, 16);
			pSuperior.add(lblNombreEmpresa);
		}else{
			JLabel lblNombreEmpresa = new JLabel("Empresa");
			lblNombreEmpresa.setBounds(93, 13, 262, 16);
			pSuperior.add(lblNombreEmpresa);
		}
		
		
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(12, 45, 56, 16);
		pSuperior.add(lblAsunto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(93, 42, 262, 22);
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("Escoge un asunto");
		pSuperior.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 95, 343, 187);
		pSuperior.add(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new BordeRedondeado(new Color(0xBB00BB),1,5, new Color(0xffffff)));
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(12, 74, 56, 16);
		pSuperior.add(lblMensaje);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 287, 343, 43);
		pSuperior.add(panel);
		panel.setBackground(Color.WHITE);
		panel.add(bEnviar);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 365, 367, 76);
		add(pInferior);
		pInferior.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Otras formas de contactar con nosotros");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 347, 14);
		pInferior.add(lblNewLabel_2);
		
		JLabel lblEnvianosUnCorreo = new JLabel("Envianos un correo electr\u00F3nico a:");
		lblEnvianosUnCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnvianosUnCorreo.setBounds(10, 52, 192, 14);
		pInferior.add(lblEnvianosUnCorreo);
		
		JLabel lblNewLabel_3 = new JLabel("dakidam@hotmail.com");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(212, 52, 145, 14);
		pInferior.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("(solo si falla la aplicaci\u00F3n)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 31, 345, 16);
		pInferior.add(lblNewLabel);
		
		c = new ControladorAyuda(this);
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
