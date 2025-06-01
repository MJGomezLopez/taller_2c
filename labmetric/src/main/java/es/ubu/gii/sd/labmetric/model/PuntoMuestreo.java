package es.ubu.gii.sd.labmetric.model;

import jakarta.persistence.*;

/**
 * Clase para manejar a los puntos de muestreo
 */
@Entity
@Table(name="punto_muestreo")
public class PuntoMuestreo {
	
	//Variables de clase
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column
	private String descripcion;
	
	//Constructores
	
	//--sin parametros
	public PuntoMuestreo() {}
	
	//--con parametros
	public PuntoMuestreo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getId() {
		return id;
	}
	
}
