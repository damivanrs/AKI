package p01Contactar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import marco.ControladorMarco;

public class PantallaContactar extends utiles.PanelPantalla implements MouseListener {
	
	protected AKIButton bEnviar = new AKIButton("Enviar Mensaje", AKIButton.TipoBoton.BotonSimple);
	protected JTextField tCorreo;
	protected JTextField tAsunto;
	protected JEditorPane tTexto;
	
	private ControladorContactar c;
	
	public PantallaContactar(ControladorMarco marco){
		super(marco);
		
		this.bSalir = "Volver";
		this.sms1 = this.getMarco().getUsuario();
		if (this.sms1==null) this.sms1 = "Sin identificar";
		this.sms2 = "Contacta con nosotros";
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 343);
		add(pSuperior);
		pSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pSur = new JPanelFondo();
		pSuperior.add(pSur, BorderLayout.SOUTH);
		bEnviar.addMouseListener(this);
		pSur.add(bEnviar);
		
		JPanelFondo pNorte = new JPanelFondo();
		pSuperior.add(pNorte, BorderLayout.NORTH);
		
		JLabel lAsunto = new JLabel("Asunto:");
		lAsunto.setBackground(Color.WHITE);
		lAsunto.setHorizontalAlignment(SwingConstants.LEFT);
		pNorte.add(lAsunto);
		
		tAsunto = new JTextField();
		pNorte.add(tAsunto);
		tAsunto.setColumns(25);
		
		JPanelFondo pCentro = new JPanelFondo();
		pSuperior.add(pCentro, BorderLayout.CENTER);
		pCentro.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Mensaje:");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pCentro.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanelFondo pC_Sur = new JPanelFondo();
		pCentro.add(pC_Sur, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Facilita un e-mail:");
		lblNewLabel_1.setBackground(Color.WHITE);
		pC_Sur.add(lblNewLabel_1);
		
		tCorreo = new JTextField();
		pC_Sur.add(tCorreo);
		tCorreo.setColumns(20);
		
		AKIPanel pC_Centro = new AKIPanel();
		pC_Centro.setLayout(null);
		pCentro.add(pC_Centro, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 320, 200);
		scrollPane.setBorder(null);
		pC_Centro.add(scrollPane);
		
		tTexto = new JEditorPane();
		scrollPane.setViewportView(tTexto);
		
		JPanelFondo pC_Este = new JPanelFondo();
		pCentro.add(pC_Este, BorderLayout.EAST);
		
		JPanelFondo pC_Oeste = new JPanelFondo();
		pCentro.add(pC_Oeste, BorderLayout.WEST);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 365, 367, 76);
		add(pInferior);
		pInferior.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Otras formas de contactar con nosotros (solo si falla la aplicaci\u00F3n):");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 15, 347, 14);
		pInferior.add(lblNewLabel_2);
		
		JLabel lblEnvianosUnCorreo = new JLabel("Envianos un correo electr\u00F3nico a:");
		lblEnvianosUnCorreo.setBackground(Color.WHITE);
		lblEnvianosUnCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnvianosUnCorreo.setBounds(10, 40, 192, 14);
		pInferior.add(lblEnvianosUnCorreo);
		
		JLabel lblNewLabel_3 = new JLabel("dakidam@hotmail.com");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(212, 40, 145, 14);
		pInferior.add(lblNewLabel_3);
		
		c = new ControladorContactar(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bEnviar)){
			c.enviar();
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
