package p02MenuSorteos;

import java.awt.Color;

import marco.ControladorMarco;

public class ControladorMenuSorteos {
	private PantallaMenuSorteos pantalla;
	private ControladorMarco marco;
	Color sobre = new Color(0xFFBCFF);
	
	
	public ControladorMenuSorteos(PantallaMenuSorteos pantalla) {
		this.pantalla = pantalla;
		marco = pantalla.getMarco();
		relax();
	}
	
	public void relax() {
		pantalla.pSS.setBackground(Color.WHITE);
		pantalla.pVS.setBackground(Color.WHITE);
		pantalla.pMS.setBackground(Color.WHITE);
		pantalla.pA.setBackground(Color.WHITE);
	}

	public void solicitarSorteo() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p0201SolicitarSorteo.PantallaSolicitarSorteo(marco));
		relax();		
	}

	public void verSorteos() {
		// TODO Auto-generated method stub
		//System.out.println("Pantalla Ver Sorteo");
		marco.anadirPantalla(new p0202VerTodosSorteos.PantallaVerTodosSorteos(marco));
		relax();
	}

	public void misSorteos() {
		marco.anadirPantalla(new p0203MisSorteos.PantallaMisSorteos(marco));
		relax();		
	}

	public void ayuda() {
		marco.anadirPantalla(new p03Ayuda.PantallaAyuda(marco));
		relax();
	}

	public void sobreSolicitarSorteo() {
		// TODO Auto-generated method stub
		relax();
		pantalla.pSS.setBackground(sobre);
	}

	public void sobreVerSorteo() {
		// TODO Auto-generated method stub
		relax();
		pantalla.pVS.setBackground(sobre);
	}

	public void sobreMisSorteos() {
		relax();
		pantalla.pMS.setBackground(sobre);
	}

	public void sobreAyuda() {
		relax();
		pantalla.pA.setBackground(sobre);
	}

}
