package p02MenuSorteos;

import java.awt.Color;

import marco.ControladorMarco;

public class ControladorMenuSorteos {
	private PantallaMenuSorteos pantalla;
	private ControladorMarco marco;
	
	
	public ControladorMenuSorteos(PantallaMenuSorteos pantalla) {
		this.pantalla = pantalla;
		marco = pantalla.getMarco();
		relax();
	}
	
	public void relax() {
		pantalla.lSS.setBackground(Color.WHITE);
		pantalla.lVS.setBackground(Color.WHITE);
		pantalla.lMS.setBackground(Color.WHITE);
		pantalla.lA.setBackground(Color.WHITE);
	}

	public void solicitarSorteo() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p0201SolicitarSorteo.PantallaSolicitarSorteo(marco));
		
	}

	public void verSorteos() {
		// TODO Auto-generated method stub
		//System.out.println("Pantalla Ver Sorteo");
		marco.anadirPantalla(new p0202VerTodosSorteos.PantallaVerTodosSorteos(marco));
	}

	public void misSorteos() {
		// TODO Auto-generated method stub
		//System.out.println("Pantalla Mis Sorteos");
		marco.anadirPantalla(new p0203MisSorteos.PantallaMisSorteos(marco));
	}

	public void ayuda() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p03Ayuda.PantallaAyuda(marco));
	}

	public void sobreSolicitarSorteo() {
		// TODO Auto-generated method stub
		relax();
		pantalla.lSS.setBackground(Color.LIGHT_GRAY);
	}

	public void sobreVerSorteo() {
		// TODO Auto-generated method stub
		relax();
		pantalla.lVS.setBackground(Color.LIGHT_GRAY);
	}

	public void sobreMisSorteos() {
		// TODO Auto-generated method stub
		relax();
		pantalla.lMS.setBackground(Color.LIGHT_GRAY);
	}

	public void sobreAyuda() {
		// TODO Auto-generated method stub
		relax();
		pantalla.lA.setBackground(Color.LIGHT_GRAY);
	}

}
