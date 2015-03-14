package ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
	
	public enum TipoDDBB {MySQL, Oracle, Postgre};
	
	private List<String[]> datos;
	private String[] cabeceras;
	
	private String error;
	
	private Connection conexion = null;
	private Statement lanzadorDeSentencias = null;
	
	private boolean estadoDeLaConexi�n = false;
	
	// Par�metros de conexi�n
		private String fuente;
		private String puerto;
		private TipoDDBB tipo;
		private String database;
		private String user;
		private String pass;
		
	
	/**
	 * Constructor. Requiere de los siguientes par�metros:
	 * @param host - Es la direcci�n del host de la base de datos.
	 * @param tipo - Es el tipo de la base de datos.
	 * @param database - Es el nombre de la base de datos.
	 * @param user - Es el usuario de la base de datos.
	 * @param pass - Es la contrase�a de la base de datos.
	 * @param puerto - Es el puerto de escucha del host por el que acceder a la base de datos.
	 */
	public Conexion(TipoDDBB tipo, String host, String database, String user,
			String pass) {
		this.fuente = host;
		this.tipo = tipo;
		this.database = database;
		this.user = user;
		this.pass = pass;
		this.puerto = ":3306";
		conectar();
	}

	private void conectar() {
		try {
			if (tipo == TipoDDBB.MySQL){
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://"+fuente+puerto+"/"+database, user, pass);
			}else if (tipo == TipoDDBB.Oracle){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+fuente+puerto+"/"+database, user, pass);
			}else{
				Class.forName("org.postgresql.Driver");
				conexion = DriverManager.getConnection("jdbc:postgresql://"+fuente+puerto+"/"+database, user, pass);
			}
			lanzadorDeSentencias = conexion.createStatement();
			estadoDeLaConexi�n = true;
			System.out.println("gestor OK");
		} catch (ClassNotFoundException e) {
			error = "Error CNF [Conexion.conectar()]: " + e.toString();
			estadoDeLaConexi�n = false;
			System.out.println("Petaras por aqui");
		} catch (SQLException e) {
			error = "Error SQL [Conexion.conectar()]: " + e.toString();
			estadoDeLaConexi�n = false;
			System.out.println("petaras por alla");
		}
	}
	
	/**
	 * Devuelve el �ltimo mensaje de error que se haya generado.
	 * @return
	 */
	public String getERROR() {
		return error;
	}
	
	/**
	 * Devuelte true si hay conexi�n establecida o false si no es as�.
	 * @return
	 */
	public boolean estadoConexion() {
		return estadoDeLaConexi�n;
	}
	
	/**
	 * Realiza una consulta sobre la base de datos, y devuelve false si
	 * se han producido errores, o true si todo ha ido bien. Adem�s, si
	 * ha funcionado, guarda el resultado de la consulta en los campos
	 * datos y cabeceras, y si ha fallado, guarda el mensaje de error en
	 * el campo error.
	 * @param query
	 * @return
	 */
	public boolean consulta(String query) {
		datos = new ArrayList<String[]>();
		cabeceras = new String[0];
		try {
			ResultSet res = lanzadorDeSentencias.executeQuery(query);
			
			ResultSetMetaData meta = res.getMetaData();
			int columnas = meta.getColumnCount();
			cabeceras = new String[columnas];
			for (int i=1; i<=columnas; i++) cabeceras[i-1] = meta.getColumnName(i);
			
			while(res.next()){
				String[] row = new String[columnas];
				for (int i=1; i<=columnas; i++) row[i-1] = res.getString(i);
				datos.add(row);
			}
			
			return true;
		} catch (SQLException e) {
			error = "Error SQL [Conexion.consulta()]: " + e.toString();
			return false;
		}
	}
	
	/**
	 * Devuelve los datos generados tras la �ltima instrucci�n.
	 * @return
	 */
	public String[][] getDatos() {
		int n = datos.size();
		String[][] respuesta = new String[n][cabeceras.length];
		for (int i=0; i<n; i++) respuesta[i]=datos.get(i);
		return respuesta;
	}
	
	/**
	 * Devuelve las cabeceras de los datos generados tras la �ltima instrucci�n.
	 * @return
	 */
	public String[] getCabeceras() {
		return cabeceras;
	}
	
	/**
	 * Realiza una consulta sobre la base de datos, y devuelve false si
	 * se han producido errores, o true si todo ha ido bien. Adem�s, tanto
	 * si funciona como si no, resetea a cero los campos datos y cabeceras,
	 * y si ha fallado, guarda el mensaje de error en el campo error.
	 * @param instruccion
	 * @return
	 */
	public boolean modifica(String instruccion) {
		datos = new ArrayList<String[]>();
		cabeceras = new String[0];
		try {
			lanzadorDeSentencias.executeUpdate(instruccion);
			datos = new ArrayList<String[]>();
			return true;
		} catch (SQLException e) {
			error = "Error SQL [Conexion.modifica()]: " + e.toString();
			return false;
		}
	}
	
	/**
	 * Desconecta de la base de datos, si es que hay conexi�n establecida.
	 */
	public void desconectar() {
		try {
			if (lanzadorDeSentencias!=null) lanzadorDeSentencias.close();
			if (conexion!=null) conexion.close();
			estadoDeLaConexi�n = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getString() {
		return datos.get(0)[0];
	}

	public String[] getDatosColumna(int n) {
		int size = datos.size();
		String[] respuesta = new String[size];
		for (int i=0; i<size; i++){
			respuesta[i] = datos.get(i)[n];
		}
		return respuesta;
	}
	
	public String[] getDatosPrimeraFila() {
		return datos.get(0);
	}
}
