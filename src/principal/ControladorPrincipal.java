package principal;

import java.awt.Color;

import marco.ControladorMarco;

public class ControladorPrincipal {
	
	private PantallaPrincipal pantalla;
	private ControladorMarco marco;
	Color sobre = new Color(0xFFBCFF);
	
	
	public ControladorPrincipal(PantallaPrincipal pantallaPrincipal) {
		pantalla = pantallaPrincipal;
		marco = pantalla.getMarco();
		relax();
	}


	public void miPerfil() {
		//marco.anadirPantalla(new p01Perfil.PantallaPerfil(marco));
		marco.anadirPantalla(new p01PerfilTiendas.PantallaPerfilTiendas(marco));
		relax();
	}


	public void buscarSorteos() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p02MenuSorteos.PantallaMenuSorteos(marco));
		relax();
		//System.out.println("Buscar Sorteos");
	}


	public void ayuda() {
		// TODO Auto-generated method stub
		//System.out.println("Mis Sorteos");
		marco.anadirPantalla(new p03Ayuda.PantallaAyuda(marco));
		relax();
	}


	public void sobreMiPerfil() {
		relax();
		pantalla.pPerfil.setBackground(sobre);
	}

	public void sobreBuscarSorteos() {
		relax();
		pantalla.pSorteos.setBackground(sobre);
	}


	public void sobreMisSorteos() {
		relax();
		pantalla.pAyuda.setBackground(sobre);
	}


	/*
	public void sobreMisTickets() {
		pantalla.lMisTickets.setBackground(Color.LIGHT_GRAY);
	}
	*/


	public void relax() {
		pantalla.pPerfil.setBackground(Color.WHITE);
		pantalla.pSorteos.setBackground(Color.WHITE);
		pantalla.pAyuda.setBackground(Color.WHITE);
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
