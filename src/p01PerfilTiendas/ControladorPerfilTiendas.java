package p01PerfilTiendas;

import p0101Bonos.PantallaBonos;
import marco.ControladorMarco;

public class ControladorPerfilTiendas {
	
	private PantallaPerfilTiendas pantalla;
	private ControladorMarco marco;
	
	public ControladorPerfilTiendas(PantallaPerfilTiendas pantallaPerfilTiendas){
		pantalla=pantallaPerfilTiendas;
		marco=pantalla.getMarco();
	}
	
	public void bonos(){
		marco.anadirPantalla(new p0101Bonos.PantallaBonos(marco));
	}

}
