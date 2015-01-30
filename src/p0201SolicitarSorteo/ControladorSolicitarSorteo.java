package p0201SolicitarSorteo;

import p020101Pagos.PantallaPagos;
import marco.ControladorMarco;

public class ControladorSolicitarSorteo {
	private PantallaSolicitarSorteo pantalla;
	private ControladorMarco marco;
	
	public ControladorSolicitarSorteo(PantallaSolicitarSorteo pantallaSolicitarSorteo){
		pantalla=pantallaSolicitarSorteo;
		marco=pantallaSolicitarSorteo.getMarco();
	}
	
	public void pagos(){
		marco.anadirPantalla(new p020101Pagos.PantallaPagos(marco));
	}

}
