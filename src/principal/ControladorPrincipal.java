package principal;

import java.awt.Color;

import marco.ControladorMarco;

public class ControladorPrincipal {
	
	private PantallaPrincipal pantalla;
	private ControladorMarco marco;
	
	
	public ControladorPrincipal(PantallaPrincipal pantallaPrincipal) {
		pantalla = pantallaPrincipal;
		marco = pantalla.getMarco();
		relax();
	}


	public void miPerfil() {
		//marco.anadirPantalla(new p01Perfil.PantallaPerfil(marco));
		marco.anadirPantalla(new p01PerfilTiendas.PantallaPerfilTiendas(marco));
	}


	public void buscarSorteos() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p02MenuSorteos.PantallaMenuSorteos(marco));
		//System.out.println("Buscar Sorteos");
	}


	public void ayuda() {
		// TODO Auto-generated method stub
		//System.out.println("Mis Sorteos");
		marco.anadirPantalla(new p03Ayuda.PantallaAyuda(marco));
	}


	public void misTickets() {
		// TODO Auto-generated method stub
		System.out.println("Mis Tickets");
	}


	public void sobreMiPerfil() {
		relax();
		pantalla.lPerfil.setBackground(Color.LIGHT_GRAY);
	}

	public void sobreBuscarSorteos() {
		relax();
		pantalla.lSorteos.setBackground(Color.LIGHT_GRAY);
	}


	public void sobreMisSorteos() {
		relax();
		pantalla.lAyuda.setBackground(Color.LIGHT_GRAY);
	}


	/*
	public void sobreMisTickets() {
		pantalla.lMisTickets.setBackground(Color.LIGHT_GRAY);
	}
	*/


	public void relax() {
		pantalla.lPerfil.setBackground(Color.WHITE);
		pantalla.lSorteos.setBackground(Color.WHITE);
		pantalla.lAyuda.setBackground(Color.WHITE);
		//pantalla.lMisTickets.setBackground(Color.WHITE);
	}


	
	
/*	private void resetOrden() {
		pantalla.removeAll();
		
		pantalla.add(pantalla.pBuscar);
		pantalla.add(pantalla.pPerfil);
		pantalla.add(pantalla.pSorteos);
		pantalla.add(pantalla.pTickets);
		
		pantalla.add(pantalla.imgBuscar);
		pantalla.add(pantalla.imgBuscar);
		pantalla.add(pantalla.imgBuscar);
		pantalla.add(pantalla.imgBuscar);
		
		pantalla.add(pantalla.lBuscar);
		pantalla.add(pantalla.lMisSorteos);
		pantalla.add(pantalla.lMisTickets);
		pantalla.add(pantalla.lPerfil);
	}
*/
}
