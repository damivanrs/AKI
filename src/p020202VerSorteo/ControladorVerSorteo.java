package p020202VerSorteo;

import marco.ControladorMarco;


public class ControladorVerSorteo {
	private PantallaVerSorteo pantalla;
	private ControladorMarco marco;
	
	public ControladorVerSorteo(PantallaVerSorteo pantallaVerSorteo){
		pantalla=pantallaVerSorteo;
		marco=pantallaVerSorteo.getMarco();
	}

}
