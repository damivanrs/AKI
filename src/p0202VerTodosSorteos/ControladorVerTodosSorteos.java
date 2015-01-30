package p0202VerTodosSorteos;

import marco.ControladorMarco;

public class ControladorVerTodosSorteos {
	private PantallaVerTodosSorteos pantalla;
	private ControladorMarco marco;
	
	public ControladorVerTodosSorteos(PantallaVerTodosSorteos pantallaVerTodosSorteos){
		pantalla=pantallaVerTodosSorteos;
		marco=pantallaVerTodosSorteos.getMarco();
	}

	public void unirmeASorteo() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p020201UnirmeASorteo.PantallaUnirmeASorteo(marco));
	}

}
