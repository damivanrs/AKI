package p0203MisSorteos;


import marco.ControladorMarco;


public class ControladorMisSorteos {
	private PantallaMisSorteos pantalla;
	private ControladorMarco marco;
	
	public ControladorMisSorteos(PantallaMisSorteos pantallaMisSorteos){
		pantalla=pantallaMisSorteos;
		marco=pantallaMisSorteos.getMarco();
	}

	public void verSorteo() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p020202VerSorteo.PantallaVerSorteo(marco));
	}

}
