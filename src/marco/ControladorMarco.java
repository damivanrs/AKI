package marco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import objetos.Patrocinador;
import ddbb.GestorDDBB;
import principal.PantallaPrincipal;
import utiles.PanelPantalla;

public class ControladorMarco {
	
	private Marco vista;
	private ArrayList<PanelPantalla> pantallas;
	private GestorDDBB db;
	
	
	private String usuario = null;
	
	public ControladorMarco(Marco marco){
		vista = marco;
		pantallas = new ArrayList<PanelPantalla>();
		db = new GestorDDBB();
		cargarInicio();
	}
	
	public void setUsuario(String text) {
		usuario=text;
	}
	
	private void cargarInicio() {
		PanelPantalla inicio = new PantallaPrincipal(this);
		anadirPantalla(inicio);
	}

	public void anadirPantalla(PanelPantalla pantalla) {
		pantallas.add(pantalla);
		cargar();
	}

	public void salir(){
		if (pantallas.size() <= 1){
			db.desconectar();
			System.exit(0);
		} else {
			//Pantalla p = pantallas.get(pantallas.size()-1);
			//p.liberar();
			pantallas.remove(pantallas.size()-1);
			cargar();
		}
	}

	private void cargar() {
		PanelPantalla carga = pantallas.get(pantallas.size()-1);
		vista.setSMS1(carga.getSMS1());
		vista.setSMS2(carga.getSMS2());
		vista.setCentro(carga);
		vista.setbSalir(carga.getbSALIR());
	}

	public boolean isConectado() {
		return usuario!=null;
	}

	public String getUsuario() {
		return usuario;
	}

	public boolean conecta(String user, String pass) {
		boolean conectado = db.conecta(user, pass);
		if (conectado){
			usuario = user;
		}
		return conectado;
	}

	public void reload() {
		cargar();
	}

	public String[] getDatosCortosUsuario() {
		return db.getDatosCortosUsuario(usuario);
	}

	public String[] getProvincias() {
		return db.getProvincias();
	}

	public String[] getLocalidades(String provincia) {
		return db.getLocalidades(provincia);
	}

	public boolean existeUsuario(String user) {
		return db.existeUsuario(user);
	}

	public boolean existeMail(String mail) {
		return db.existeMail(mail);
	}

	public void registrarUsuario(String alias, String pass, String mail, String poblacion,
			String nombre, String apellidos, String direccion, String cp) {
		db.registrarUsuario(alias, pass, mail, poblacion, nombre, apellidos, direccion, cp);
	}

	public void enviarMensaje(String asunto, String mensaje, String correo) {
		if (usuario==null){
			db.enviarMensajeAnonimo(asunto, mensaje, correo);
		} else {
			db.enviarMensaje(usuario, asunto, mensaje, correo);
		}
	}

	public void notificaciones() {
		this.anadirPantalla(new p00Notificaciones.PantallaNotificaciones(this));
	}

	public Patrocinador getPatrocinador(String usuario) {
		return db.getPatrocinador(usuario);
	}

	public Patrocinador getPatrocinador(String nombre, String pwd) {
		return db.getPatrocinador(nombre, pwd);
	}

	public boolean anadirPatrocinador(Patrocinador pat) {
		return db.anadirPatrocinador(pat);
	}

	public void dialogMensaje(String string) {
		JOptionPane.showMessageDialog(vista,  string);
	}

	public boolean actualizarPatrocinador(Patrocinador pat) {
		return db.actualizarPatrocinador(pat);
	}

	
}
