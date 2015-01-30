package p01Registrar;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorRegistrar {
	
	private PantallaRegistrar pantalla;
	private ControladorMarco marco;
	private String fallos = "";
	
	public ControladorRegistrar(PantallaRegistrar pantallaRegistrar){
		pantalla = pantallaRegistrar;
		marco = pantalla.getMarco();
		
		String[] provincias = marco.getProvincias();
		String[] poblaciones = marco.getLocalidades(provincias[0]);
		for(int i=0; i<provincias.length; i++){
			pantalla.cProvincia.addItem(provincias[i]);
		}
		for (int i=0; i<poblaciones.length; i++){
			pantalla.cPoblacion.addItem(poblaciones[i]);
		}
	}

	public void provinciaCambiada() {
		System.out.println("Recargando poblaciones");
		String provincia = (String)pantalla.cProvincia.getSelectedItem();
		String[] poblaciones = marco.getLocalidades(provincia);
		pantalla.cPoblacion.removeAllItems();
		for (int i=0; i<poblaciones.length; i++){
			pantalla.cPoblacion.addItem(poblaciones[i]);
		}
	}

	public void enviarDatos() {
		if(datosOK()){
			registrarUsuario();
		} else {
			JOptionPane.showMessageDialog(pantalla,
					   "Se han producido los siguientes fallos:"
					   +fallos);
			fallos = "";
		}
		
	}

	private void registrarUsuario() {
		marco.registrarUsuario(pantalla.tAlias.getText(), new String(pantalla.tPass.getPassword()),
				pantalla.tMail.getText(), (String)pantalla.cPoblacion.getSelectedItem(), pantalla.tNombre.getText(),
				pantalla.tApellido.getText(), pantalla.tDireccion.getText(), pantalla.tCP.getText());
		JOptionPane.showMessageDialog(pantalla,
				   "Usuario registrado con exito.\nVuelve a la pantalla anterior y conectate.");
	}

	private boolean datosOK() {
		boolean ok = true;
		if (pantalla.tAlias.getText().equals("")){
			ok = false;
			addFallo("Introduce un 'Alias'.");
		} else if (marco.existeUsuario(pantalla.tAlias.getText())){
			ok = false;
			addFallo("El 'Alias' ya existe.");
		}
		if ((new String(pantalla.tPass.getPassword())).equals("")){
			ok = false;
			addFallo("Introduce una 'Contraseña'.");
		}
		if (pantalla.tMail.getText().equals("")){
			ok = false;
			addFallo("Introduce un 'e-mail'.");
		} else if (!pantalla.tConfirmacionMail.getText().equals(pantalla.tMail.getText())){
			ok = false;
			addFallo("El 'e-mail' no coincide con su confirmación.");
		} else if (marco.existeMail(pantalla.tMail.getText())){
			ok = false;
			addFallo("El 'e-mail' ya está registrado");
		}
		if (pantalla.tNombre.getText().equals("")){
			ok = false;
			addFallo("Introduce un 'Nombre'.");
		}
		if (pantalla.tApellido.getText().equals("")){
			ok = false;
			addFallo("Al menos un 'Apellido'.");
		}
		if (pantalla.tDireccion.getText().equals("")){
			ok = false;
			addFallo("Introduce una 'Direccion'.");
		}
		if (pantalla.tCP.getText().length()!=5 && !esCP(pantalla.tCP.getText())){
			ok = false;
			addFallo("Introduce un 'Código Postal' ('C.P.').");
		}
		if (!pantalla.check.isSelected()){
			ok = false;
			addFallo("No has aceptado las condiciones.");
		}
		return ok;
	}

	private void addFallo(String fallo) {
		fallos = fallos + "\n" + fallo;
		
	}

	private boolean esCP(String numero) {
		try{
			Integer.parseInt(numero);
			return true;
		} catch(Exception e){
			return false;
		}
		
	}

	public void verCondiciones() {
		JOptionPane.showMessageDialog(pantalla,
				   "Condiciones:\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n");
	}
	
}
