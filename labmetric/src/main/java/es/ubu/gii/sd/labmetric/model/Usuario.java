package es.ubu.gii.sd.labmetric.model;

import jakarta.persistence.*;

/**
 * Clase para manejar a los usuarios de la aplicación
 */
@Entity
@Table(name="usuario")
public class Usuario {
	
	//Variables de clase
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true, nullable=false)
	private String nombreUsuario;
	
	@Column(nullable=false)
	private String clave;
	
	//Constructores
	
	//--Con parametros
	public Usuario(String nombreUsuario, String clave) {
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	//--Sin parametros
	public Usuario() {}
	
	//Getters y Setters
	public Long getId() {
		return id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
