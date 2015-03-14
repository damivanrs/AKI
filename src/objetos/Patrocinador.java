package objetos;

public class Patrocinador {
	
	private String id;
	private String nombre;
	private String[] tipoComercio;
	private String nombreContacto;
	private String emailContacto;
	private String telfContacto;
	private String direccionContacto;
	private String razonSocial;
	private String imagen;
	private String bonos; 
	private String estado;
	private String pwd;
	
	
	public Patrocinador(String id, String nombre, String[] tipoComercio,
			String nombreContacto, String emailContacto, String telfContacto,
			String direccionContacto, String razonSocial, String bonos, String estado, String imagen,
			String pwd) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoComercio = tipoComercio;
		this.nombreContacto = nombreContacto;
		this.emailContacto = emailContacto;
		this.telfContacto = telfContacto;
		this.direccionContacto = direccionContacto;
		this.razonSocial = razonSocial;
		this.bonos = bonos;
		this.imagen = imagen;
		this.estado = estado;
		this.pwd = pwd;
	}
	public Patrocinador() {
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the bonos
	 */
	public String getBonos() {
		return bonos;
	}
	/**
	 * @param bonos the bonos to set
	 */
	public void setBonos(String bonos) {
		this.bonos = bonos;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tipoComercio
	 */
	public String[] getTipoComercio() {
		return tipoComercio;
	}
	/**
	 * @param tipoComercio the tipoComercio to set
	 */
	public void setTipoComercio(String[] tipoComercio) {
		this.tipoComercio = tipoComercio;
	}
	/**
	 * @return the nombreContacto
	 */
	public String getNombreContacto() {
		return nombreContacto;
	}
	/**
	 * @param nombreContacto the nombreContacto to set
	 */
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	/**
	 * @return the emailContacto
	 */
	public String getEmailContacto() {
		return emailContacto;
	}
	/**
	 * @param emailContacto the emailContacto to set
	 */
	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}
	/**
	 * @return the telfContacto
	 */
	public String getTelfContacto() {
		return telfContacto;
	}
	/**
	 * @param telfContacto the telfContacto to set
	 */
	public void setTelfContacto(String telfContacto) {
		this.telfContacto = telfContacto;
	}
	/**
	 * @return the direccionContacto
	 */
	public String getDireccionContacto() {
		return direccionContacto;
	}
	/**
	 * @param direccionContacto the direccionContacto to set
	 */
	public void setDireccionContacto(String direccionContacto) {
		this.direccionContacto = direccionContacto;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial 
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
