package es.ubu.gii.sd.labmetric.model;

import java.util.List;

import jakarta.persistence.*;

/**
 * Clase para manejar a los tecnico de campo
 */
@Entity
@Table(name="analista")
public class Analista {
	
	//Variables de clase
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido;
	
	@Column
	private String telefono;
	
	@OneToMany(mappedBy = "analista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Muestra> muestras;

	//Constructor
	//--con parametros
	public Analista(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	//--sin parametros	
	public Analista() {}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getId() {
		return id;
	}
	public List<Muestra> getMuestras() {
		return muestras;
	}
	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
}
