package p0101Bonos;

import marco.ControladorMarco;

public class ControladorBonos {
	private PantallaBonos pantalla;
	private ControladorMarco marco;

	
	public ControladorBonos(PantallaBonos pantallaBonos){
		pantalla=pantallaBonos;
		marco=pantalla.getMarco();
	}

}
