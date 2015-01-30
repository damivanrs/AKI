package p020201UnirmeASorteo;

import marco.ControladorMarco;

public class ControladorUnirmeASorteo {
	private PantallaUnirmeASorteo pantalla;
	private ControladorMarco marco;
	
	public ControladorUnirmeASorteo(PantallaUnirmeASorteo pantallaUnirmeASorteo){
		pantalla=pantallaUnirmeASorteo;
		marco=pantallaUnirmeASorteo.getMarco();
	}

}
