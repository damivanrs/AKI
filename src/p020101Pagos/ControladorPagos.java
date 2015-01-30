package p020101Pagos;

import marco.ControladorMarco;

public class ControladorPagos {
	private PantallaPagos pantalla;
	private ControladorMarco marco;
	
	public ControladorPagos(PantallaPagos pantallaPagos){
		pantalla=pantallaPagos;
		marco=pantalla.getMarco();		
	}


}
