package es.ubu.gii.sd.labmetric.model;

import jakarta.persistence.*;

/**
 * Clase para manejar a las rutas
 */
@Entity
@Table(name="ruta")
public class Ruta {
	
	//Variables de clase
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	//Constructor
	
	//--con parametros
	public Ruta(String nombre) {
		this.nombre = nombre;
	}
	
	//--sin parametros
	public Ruta() {}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
}
