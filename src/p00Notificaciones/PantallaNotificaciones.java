package p00Notificaciones;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;





import utiles.AKIButton;
import utiles.AKIPanel;
import marco.ControladorMarco;

public class PantallaNotificaciones extends utiles.PanelPantalla implements MouseListener {
	private ControladorNotificaciones c;

	protected AKIButton bBorrar = new AKIButton("Borrar Mensaje", AKIButton.TipoBoton.BotonSimple);
	protected AKIButton bResponder = new AKIButton("Responder Mensaje", AKIButton.TipoBoton.BotonSimple);

	public PantallaNotificaciones(ControladorMarco controladorMarco) {
		super(controladorMarco);
		// TODO Auto-generated constructor stub
		
		bSalir = "Volver Atras";
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Notificaciones";
		}else{
			sms1="Pantalla";
			sms2="Notificaciones";
		}
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 387, 452);
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panelNotificaciones = new JPanel();
		panelNotificaciones.setBounds(12, 13, 363, 369);
		panelPrincipal.add(panelNotificaciones);
		
		AKIPanel panelConfirmacion = new AKIPanel();
		//panelConfirmacion.setBackground(Color.white);
		panelConfirmacion.setBounds(12, 390, 363, 49);
		panelPrincipal.add(panelConfirmacion);
		panelConfirmacion.setLayout(null);
		
		JPanel panelResponder = new JPanel();
		panelResponder.setBackground(Color.white);
		//panelResponder.setBounds(0, 2, 180, 45);
		panelResponder.setBounds(8, 2, 175, 45);
		panelConfirmacion.add(panelResponder);
		panelResponder.add(bResponder);
		
		JPanel panelBorrar = new JPanel();
		panelBorrar.setBackground(Color.white);
		//panelBorrar.setBounds(183, 2, 180, 45);
		panelBorrar.setBounds(180, 2, 175, 45);
		panelConfirmacion.add(panelBorrar);
		panelBorrar.add(bBorrar);
		
		c = new ControladorNotificaciones(this); 
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
