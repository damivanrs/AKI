package p03Ayuda;

import java.awt.Color;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorAyuda {
	private PantallaAyuda pantalla;
	private ControladorMarco marco;

	public ControladorAyuda(PantallaAyuda pantallaAyuda) {
		// TODO Auto-generated constructor stub
		pantalla=pantallaAyuda;
		marco=pantalla.getMarco();
	}

	public void registrar() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p01Registrar.PantallaRegistrar(marco));
	}
	
	

}
