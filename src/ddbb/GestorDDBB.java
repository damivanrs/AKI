package ddbb;

public class GestorDDBB implements Runnable {
	
	private Conexion db;
	
	private final String dbHost = "d791cb50-1163-484d-9954-a41c017ec13a.mysql.sequelizer.com";
	private final String dbName = "dbd791cb501163484d9954a41c017ec13a";
	private final String dbUser = "shzplpupurazfjjc";
	private final String dbPass = "a4tCx5f3edcbDc8w7wUNjZwJjfvtokPGKyZirhJasqKmnsVyknr7QApiFSssGUN3";
	
	public GestorDDBB(){
		new Thread(this, "GestorDDBB").start();
	}

	public void desconectar() {
		db.desconectar();
	}

	public boolean conecta(String user, String pass) {
		String consulta = "select count(*) from usuarios where alias='"+user+"' and pass='"+pass+"'";
		boolean hayRespuesta = db.consulta(consulta);
		if (hayRespuesta){
			String respuesta = db.getString();
			if (respuesta.equals("1")) return true;
		}
		return false;
	}

	public String[] getDatosCortosUsuario(String usuario) {
		String consulta = "select alias, email, p.poblacion, CONCAT(nombre, ' ', apellidos), direccion "
							+ "from usuarios u, poblaciones p "
							+ "where alias='"+usuario+"' and u.poblacion=p.id";
		if (db.consulta(consulta)) return db.getDatosPrimeraFila();
		return null;
	}

	public void run() {
		db = new Conexion(Conexion.TipoDDBB.MySQL, dbHost, dbName, dbUser, dbPass);
	}

	public String[] getProvincias() {
		String consulta = "select provincia from provincias order by provincia";
		if (db.consulta(consulta)) return db.getDatosColumna(0);
		return null;
	}

	public String[] getLocalidades(String provincia) {
		String consulta = "select poblacion from poblaciones po, provincias pr "
				+ "where po.provincia=pr.id and pr.provincia='"+provincia+"' order by poblacion";
		if (db.consulta(consulta)) return db.getDatosColumna(0);
		return null;
	}

	public boolean existeUsuario(String user) {
		String consulta = "select count(*) from usuarios where alias='"+user+"'";
		if (db.consulta(consulta)){
			if (db.getString().equals("1")) return true;
		}
		return false;
	}

	public boolean existeMail(String mail) {
		String consulta = "select count(*) from usuarios where email='"+mail+"'";
		if (db.consulta(consulta)){
			if (db.getString().equals("1")) return true;
		}
		return false;
	}

	public void registrarUsuario(String alias, String pass, String mail, String poblacion,
			String nombre, String apellidos, String direccion, String cp) {
		String orden = "insert into usuarios(alias, pass, email, direccion, cp, poblacion, nombre, apellidos) "
				+ "values('"+alias+"', '"+pass+"', '"+mail+"', '"+direccion+"',"
						+ " '"+cp+"', (select id from poblaciones where poblacion='"+poblacion+"'), '"+nombre+"', '"+apellidos+"')";
		db.modifica(orden);
	}

	public void enviarMensajeAnonimo(String asunto, String mensaje, String correo) {
		String orden = "insert into mensajes_usuarios(asunto, mensaje, mail) "
				+ "values('"+asunto+"', '"+mensaje+"', '"+correo+"')";
		db.modifica(orden);
	}

	public void enviarMensaje(String usuario, String asunto, String mensaje, String correo) {
		String idUsuario = "select id from usuarios where alias = '"+usuario+"'";
		String orden = "insert into mensajes_usuarios(usuario, asunto, mensaje, mail) "
				+ "values(("+idUsuario+"), '"+asunto+"', '"+mensaje+"', '"+correo+"')";
		db.modifica(orden);
	}
}
