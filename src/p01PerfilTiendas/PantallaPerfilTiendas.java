package p01PerfilTiendas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;









import principal.ControladorPrincipal;
import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import marco.ControladorMarco;

public class PantallaPerfilTiendas extends utiles.PanelPantalla implements MouseListener, KeyListener {
	private ControladorPerfilTiendas c;
	protected AKIButton bConectar = new AKIButton("Conectar", AKIButton.TipoBoton.BotonSimple);
	protected AKIButton bCompraBonos = new AKIButton("Comprar Bonos", AKIButton.TipoBoton.BotonSimple);
	protected AKIButton bPosicionNegocio = new AKIButton("Posición Negocio", AKIButton.TipoBoton.BotonSimple);
	protected JTextField textFieldPwd;
	protected JTextField textFieldNombreComercial;
	protected JTextField textFieldRazonSocial;
	protected JTextField textFieldContacto;
	protected JTextField textFieldDireccion;
	protected JTextField textFieldEmail;
	protected JTextField textFieldTelefono;
	protected JTextField textFieldActividadNegocio;
	protected JLabel lblNombreUsuario = new JLabel("Nombre Comercial");
	protected JLabel lblNewLabel = new JLabel("");
	protected JLabel lblNumeroBonos = new JLabel("");
	protected JPanelFondo pimgLocal = new JPanelFondo();

	public PantallaPerfilTiendas(ControladorMarco controladorMarco) {
		super(controladorMarco);
		// TODO Auto-generated constructor stub
		bSalir = "Volver Atras";
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();	
			sms2="Perfil de Usuario";
			//textFieldNombreComercial.setEnabled(false);
		}else{
			sms1="Pantalla";
			sms2="Perfil de Usuario";
		}
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 343);
		add(pSuperior);
		pSuperior.setBackground(Color.white);
		pSuperior.setLayout(null);
		
		JLabel lblNombreComercial = new JLabel("Nombre Comercial");
		lblNombreComercial.setBounds(168, 1, 131, 16);
		pSuperior.add(lblNombreComercial);
		
		textFieldNombreComercial = new JTextField();
		textFieldNombreComercial.setBounds(168, 19, 187, 22);
		pSuperior.add(textFieldNombreComercial);
		textFieldNombreComercial.setColumns(10);
		textFieldNombreComercial.addKeyListener(this);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social");
		lblRaznSocial.setBounds(168, 46, 131, 16);
		pSuperior.add(lblRaznSocial);
		
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setBounds(168, 64, 187, 22);
		pSuperior.add(textFieldRazonSocial);
		textFieldRazonSocial.setColumns(10);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(168, 88, 56, 16);
		pSuperior.add(lblContacto);
		
		textFieldContacto = new JTextField();
		textFieldContacto.setBounds(168, 107, 187, 22);
		pSuperior.add(textFieldContacto);
		textFieldContacto.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(168, 131, 56, 16);
		pSuperior.add(lblDireccin);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(168, 151, 187, 22);
		pSuperior.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(168, 177, 56, 16);
		pSuperior.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(168, 195, 187, 22);
		pSuperior.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(168, 223, 56, 16);
		pSuperior.add(lblTelfono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(168, 241, 187, 22);
		pSuperior.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		
		pimgLocal.setBounds(9, 9, 150, 150);
		pSuperior.add(pimgLocal);
		
		JLabel lblBonosDisponibles1 = new JLabel("Bonos");
		lblBonosDisponibles1.setBounds(168, 268, 102, 16);
		pSuperior.add(lblBonosDisponibles1);
		
		JLabel lblBonosDisponibles2 = new JLabel("Disponibles");
		lblBonosDisponibles2.setBounds(168, 280, 102, 16);
		pSuperior.add(lblBonosDisponibles2);
		
		
		lblNumeroBonos.setBounds(299, 268, 56, 16);
		pSuperior.add(lblNumeroBonos);
		
		JPanel pCompraBonos = new JPanel();
		pCompraBonos.setBounds(168, 295, 187, 43);
		pSuperior.add(pCompraBonos);
		pCompraBonos.setBackground(Color.white);
		pCompraBonos.add(bCompraBonos);
		
		JLabel lblActividadDeNegocio = new JLabel("Actividad de Negocio");
		lblActividadDeNegocio.setBounds(9, 166, 147, 16);
		pSuperior.add(lblActividadDeNegocio);
		
		JLabel lblConCincoPalabras = new JLabel("con cinco palabras");
		lblConCincoPalabras.setBounds(9, 183, 147, 16);
		pSuperior.add(lblConCincoPalabras);
		
		textFieldActividadNegocio = new JTextField();
		textFieldActividadNegocio.setBounds(9, 200, 150, 63);
		pSuperior.add(textFieldActividadNegocio);
		textFieldActividadNegocio.setColumns(10);
		
		JPanel pPosicionNegocio = new JPanel();
		pPosicionNegocio.setBounds(9, 295, 150, 43);
		pPosicionNegocio.setBackground(Color.white);
		pSuperior.add(pPosicionNegocio);
		pPosicionNegocio.add(bPosicionNegocio);
		
		JLabel lblCapturarPosicinNegocio1 = new JLabel("Capturar Posici\u00F3n");
		lblCapturarPosicinNegocio1.setBounds(9, 268, 150, 16);
		pSuperior.add(lblCapturarPosicinNegocio1);
		
		JLabel lblCapturarPosicinNegocio2 = new JLabel("del Negocio");
		lblCapturarPosicinNegocio2.setBounds(9, 280, 150, 16);
		pSuperior.add(lblCapturarPosicinNegocio2);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 363, 367, 76);
		add(pInferior);
		pInferior.setBackground(Color.white);
		pInferior.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 13, 56, 16);
		pInferior.add(lblUsuario);
		
		
		lblNombreUsuario.setBounds(87, 13, 100, 16);
		pInferior.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(12, 47, 73, 16);
		pInferior.add(lblContrasea);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(206, 13, 47, 16);
		pInferior.add(lblEstado);
		
		
		lblNewLabel.setBounds(264, 13, 91, 16);
		pInferior.add(lblNewLabel);
		
		textFieldPwd = new JTextField();
		textFieldPwd.setBounds(81, 42, 100, 22);
		pInferior.add(textFieldPwd);
		textFieldPwd.setColumns(10);
		
		JPanel pModificarGuardar = new JPanel();
		pModificarGuardar.setBounds(193, 30, 162, 39);
		pInferior.add(pModificarGuardar);
		pModificarGuardar.setBackground(Color.white);
		pModificarGuardar.add(bConectar);
		
		bCompraBonos.addMouseListener(this);
		bConectar.addMouseListener(this);
		
		c=new ControladorPerfilTiendas(this);
		if(this.getMarco().isConectado()){
			c.cargarDatos();
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(bCompraBonos)){
			c.bonos();
		}else if (arg0.getSource().equals(bConectar)){
			c.conectar();
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

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource().equals(textFieldNombreComercial)){
			lblNombreUsuario.setText(textFieldNombreComercial.getText());
		}
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource().equals(textFieldNombreComercial)){
			lblNombreUsuario.setText(textFieldNombreComercial.getText());
		}
	}

	public void cambiaSMS1(String text) {
		sms1=text;
	}

}
