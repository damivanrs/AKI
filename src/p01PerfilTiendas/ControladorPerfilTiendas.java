package p01PerfilTiendas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import objetos.Patrocinador;
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

	public void cargarDatos() {
		// TODO Auto-generated method stub
		Patrocinador p= marco.getPatrocinador(marco.getUsuario());
		mostrarPatrocinador(p);
		pantalla.textFieldNombreComercial.setEnabled(false);
	}

	private void mostrarPatrocinador(Patrocinador p) {
		pantalla.textFieldPwd.setText(p.getPwd());
		pantalla.textFieldTelefono.setText(p.getTelfContacto());
		pantalla.textFieldEmail.setText(p.getEmailContacto());
		pantalla.textFieldDireccion.setText(p.getDireccionContacto());
		pantalla.textFieldContacto.setText(p.getNombreContacto());
		pantalla.textFieldRazonSocial.setText(p.getRazonSocial());
		pantalla.textFieldNombreComercial.setText(p.getNombre());
		
		String[] actividades = p.getTipoComercio();
		String temporal="";
		for (int i=0; i<actividades.length; i++){
			if (i==0){
				temporal=actividades[i];
			}else{
				temporal=temporal+", "+actividades[i];
			}					
		}
		pantalla.textFieldActividadNegocio.setText(temporal);
		pantalla.lblNumeroBonos.setText(p.getBonos());
		pantalla.lblNewLabel.setText(p.getEstado());
		pantalla.lblNombreUsuario.setText(p.getNombre());
		try {
			pantalla.pimgLocal.setImagen(new URL (p.getImagen()));
		} catch (MalformedURLException e) {
			
		}
		pantalla.textFieldNombreComercial.setText(p.getNombre());
	}

	public void conectar() {
		// TODO Auto-generated method stub
		if (opcionConectar()){
			ejecutarConexion();
		}else if (opcionRegistrar()){
			registrarUsuario();
		}else if (opcionActualizar()){
			actualizarDatos();
		}else {
			marco.dialogMensaje("No se ha realizado la acción. Revisa los campos y prueba de nuevo.");
		}
		
	}

	private void actualizarDatos() {
		Patrocinador pat = cargarDatosPatrocinadorDesdePantalla();
		if(!marco.actualizarPatrocinador(pat)){marco.dialogMensaje("No se han actualizado los datos del Usuario.");}		
	}

	private void registrarUsuario() {
		Patrocinador pat=cargarDatosPatrocinadorDesdePantalla();
		if(marco.anadirPatrocinador(pat)){
			confirmarConexion();
		}else{
			marco.dialogMensaje("El usuario no ha sido registrado por problemas de conectividad.");
		}
	}

	private Patrocinador cargarDatosPatrocinadorDesdePantalla() {
		Patrocinador pat = new Patrocinador();
		pat.setNombre(pantalla.textFieldNombreComercial.getText());
		pat.setPwd(pantalla.textFieldPwd.getText());
		pat.setRazonSocial(pantalla.textFieldRazonSocial.getText());
		pat.setNombreContacto(pantalla.textFieldContacto.getText());
		pat.setDireccionContacto(pantalla.textFieldDireccion.getText());
		pat.setEmailContacto(pantalla.textFieldEmail.getText());
		pat.setTelfContacto(pantalla.textFieldTelefono.getText());
		String contenedor = pantalla.textFieldActividadNegocio.getText();
		
		ArrayList<String> actividades = new ArrayList<String>();
		String temporal="";
		for(int i=0;i<contenedor.length();i++){
			if(contenedor.charAt(i)==','){
				actividades.add(temporal);	
				temporal="";
				i++;
			}else{				
				temporal=temporal+contenedor.charAt(i);
			}
		}
		actividades.add(temporal);
		String[] activ=new String[actividades.size()];
		for (int i=0;i<actividades.size();i++){
			activ[i]=actividades.get(i);
		}
		pat.setTipoComercio(activ);
		return pat;
	}

	private void confirmarConexion() {
		pantalla.cambiaSMS1(pantalla.textFieldNombreComercial.getText());
		pantalla.textFieldNombreComercial.setEnabled(false);
		marco.setUsuario(pantalla.textFieldNombreComercial.getText());
		marco.reload();
	}

	private void ejecutarConexion() {
		String nombre = pantalla.textFieldNombreComercial.getText();
		String pwd = pantalla.textFieldPwd.getText();
		Patrocinador pat = marco.getPatrocinador(nombre, pwd);
		if(pat==null){
			marco.dialogMensaje("Revisa tu usuario o contraseña y prueba de nuevo.");
		}else{
			mostrarPatrocinador(pat);
			confirmarConexion();
		}
	}

	private boolean opcionActualizar() {
		boolean ok = true;
		if (pantalla.textFieldRazonSocial.getText().equals("")){ok=false;}
		else if (pantalla.textFieldContacto.getText().equals("")){ok=false;}
		else if (pantalla.textFieldDireccion.getText().equals("")){ok=false;}
		else if (pantalla.textFieldEmail.getText().equals("")){ok=false;}
		else if (pantalla.textFieldTelefono.getText().equals("")){ok=false;}
		else if (pantalla.textFieldActividadNegocio.getText().equals("")){ok=false;}
		else if (pantalla.textFieldNombreComercial.getText().equals("")){ok=false;}
		else if (pantalla.textFieldPwd.getText().equals("")){ok=false;}
		else if (!marco.isConectado()){ok=false;}
		return ok;
	}

	private boolean opcionRegistrar() {
		boolean ok = true;
		if (pantalla.textFieldRazonSocial.getText().equals("")){ok=false;}
		else if (pantalla.textFieldContacto.getText().equals("")){ok=false;}
		else if (pantalla.textFieldDireccion.getText().equals("")){ok=false;}
		else if (pantalla.textFieldEmail.getText().equals("")){ok=false;}
		else if (pantalla.textFieldTelefono.getText().equals("")){ok=false;}
		else if (pantalla.textFieldActividadNegocio.getText().equals("")){ok=false;}
		else if (pantalla.textFieldNombreComercial.getText().equals("")){ok=false;}
		else if (pantalla.textFieldPwd.getText().equals("")){ok=false;}
		else if (marco.isConectado()){ok=false;}
		return ok;
	}

	private boolean opcionConectar() {
		boolean ok = true;
		if (!pantalla.textFieldRazonSocial.getText().equals("")){ok=false;}
		else if (!pantalla.textFieldContacto.getText().equals("")){ok=false;}
		else if (!pantalla.textFieldDireccion.getText().equals("")){ok=false;}
		else if (!pantalla.textFieldEmail.getText().equals("")){ok=false;}
		else if (!pantalla.textFieldTelefono.getText().equals("")){ok=false;}
		else if (!pantalla.textFieldActividadNegocio.getText().equals("")){ok=false;}
		else if (pantalla.textFieldNombreComercial.getText().equals("")){ok=false;}
		else if (pantalla.textFieldPwd.getText().equals("")){ok=false;}
		return ok;
	}

}
