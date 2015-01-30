package p00Notificaciones;

import marco.ControladorMarco;

public class ControladorNotificaciones {
	private PantallaNotificaciones pantalla;
	private ControladorMarco marco;
	
	public ControladorNotificaciones(PantallaNotificaciones pantallaNotificaciones){
		pantalla=pantallaNotificaciones;
		marco=pantalla.getMarco();
	}

}
