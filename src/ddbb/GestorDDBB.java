package ddbb;

import objetos.Patrocinador;

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

	public Patrocinador getPatrocinador(String usuario) {
		String consulta = "SELECT id, razon, contacto, direccion, email, telf, bonos, (SELECT estado FROM estados_patrocinadores WHERE id=p.estado), imagen FROM patrocinadores p WHERE '"+usuario+"' = nombre ";
		if (db.consulta(consulta)){
			String[] resultado =db.getDatosPrimeraFila();
			Patrocinador pat = new Patrocinador();
			pat.setRazonSocial(resultado[1]);
			pat.setNombreContacto(resultado[2]);
			pat.setDireccionContacto(resultado[3]);	
			pat.setEmailContacto(resultado[4]);
			pat.setTelfContacto(resultado[5]);
			pat.setBonos(resultado[6]);
			pat.setEstado(resultado[7]);
			pat.setImagen(resultado[8]);
			String consultaActividad = "SELECT tipo FROM tipos_de_negocio t, tipo_de_negocio_x_patrocinador x WHERE  x.patrocinador="+resultado[0]+" AND x.negocio=t.id";
			if(db.consulta(consultaActividad)){
				String[] resultadoActividad=db.getDatosColumna(0);
				pat.setTipoComercio(resultadoActividad);
			}
			pat.setNombre(usuario);
			return pat;
		}
		return null;
	}

	public Patrocinador getPatrocinador(String nombre, String pwd) {
		// TODO Auto-generated method stub
		String consulta = "SELECT id, razon, contacto, direccion, email, telf, bonos, (SELECT estado FROM estados_patrocinadores WHERE id=p.estado), imagen FROM patrocinadores p WHERE '"+nombre+"' = nombre AND '"+pwd+"'=pwd";
		if (db.consulta(consulta)){
			String[] resultado =db.getDatosPrimeraFila();
			Patrocinador pat = new Patrocinador();
			pat.setRazonSocial(resultado[1]);
			pat.setNombreContacto(resultado[2]);
			pat.setDireccionContacto(resultado[3]);	
			pat.setEmailContacto(resultado[4]);
			pat.setTelfContacto(resultado[5]);
			pat.setBonos(resultado[6]);
			pat.setEstado(resultado[7]);
			pat.setImagen(resultado[8]);
			String consultaActividad = "SELECT tipo FROM tipos_de_negocio t, tipo_de_negocio_x_patrocinador x WHERE  x.patrocinador="+resultado[0]+" AND x.negocio=t.id";
			if(db.consulta(consultaActividad)){
				String[] resultadoActividad=db.getDatosColumna(0);
				pat.setTipoComercio(resultadoActividad);
			}
			pat.setNombre(nombre);
			return pat;
		}return null;
	}

	public boolean anadirPatrocinador(Patrocinador pat) {
		String insertar = "INSERT INTO patrocinadores (nombre, razon, contacto, email, telf, direccion, estado, bonos, pwd) VALUES ("
				+ "'"+pat.getNombre()+"', "
						+ "'"+pat.getRazonSocial()+"', "
						+ "'"+pat.getNombreContacto()+"', "
						+ "'"+pat.getEmailContacto()+"', "
						+ "'"+pat.getTelfContacto()+"', "
						+ "'"+pat.getDireccionContacto()+"', "
						+ "2, "// 2 equivale al id PENDIENTE en la BBDD
						+ "0, "// inicialmente el numero de bonos al crear el usuario es 0
						+ "'"+pat.getPwd()+"'"
						+ ") ";
		if(db.modifica(insertar)){
			insertarActividadesPatrocinador(pat);
			return true;
		}
		System.out.println(insertar);
		System.out.println(db.getERROR());
		return false;
	}

	private void insertarActividadesPatrocinador(Patrocinador pat) {
		for(int i=0;i<pat.getTipoComercio().length;i++){
			String insertarActividad = "INSERT IGNORE INTO tipos_de_negocio (tipo) VALUES ('"+pat.getTipoComercio()[i].toUpperCase()+"')";
			if(db.modifica(insertarActividad)){
				String insertarRelacion = "INSERT INTO tipo_de_negocio_x_patrocinador (patrocinador, negocio) VALUES ("
						+ "(SELECT id FROM patrocinadores WHERE nombre='"+pat.getNombre()+"'), "
						+ "(SELECT id FROM tipos_de_negocio WHERE tipo='"+pat.getTipoComercio()[i].toUpperCase()+"')"
						+ ")";
				db.modifica(insertarRelacion);
			}
		}
	}

	public boolean actualizarPatrocinador(Patrocinador pat) {
		if(controlUsuario(pat.getNombre(), pat.getPwd())){
			String actualizar = "UPDATE patrocinadores SET "
					+ "razon='"+pat.getRazonSocial()+"', "
					+ "contacto='"+pat.getNombreContacto()+"', "	
					+ "email='"+pat.getEmailContacto()+"', "	
					+ "telf='"+pat.getTelfContacto()+"', "	
					+ "direccion='"+pat.getDireccionContacto()+"' "					
					+ "WHERE nombre='"+pat.getNombre()+"' ";
			if(db.modifica(actualizar)){
				String eliminarRelacion = "DELETE FROM tipo_de_negocio_x_patrocinador WHERE "
						+ "patrocinador=(SELECT id FROM patrocinadores WHERE nombre='"+pat.getNombre()+"')";
				if(db.modifica(eliminarRelacion)){
					insertarActividadesPatrocinador(pat);
				}
				return true;
			}
		}
		return false;
	}

	private boolean controlUsuario(String nombre, String pwd) {
		String consulta = "SELECT pwd FROM patrocinadores WHERE nombre='"+nombre+"'";
		if(db.consulta(consulta)){
			if(db.getString().equals(pwd)){
				return true;
			}
		}
		return false;
	}
}
