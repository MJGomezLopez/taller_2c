package es.ubu.gii.sd.labmetric.model;

import java.util.List;

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
	
	@OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PuntoMuestreo> puntosMuestreo;
	
	@OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ListaControl> listaControles;
	
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
	public List<PuntoMuestreo> getPuntosMuestreo() {
		return puntosMuestreo;
	}
	public void setPuntosMuestreo(List<PuntoMuestreo> puntosMuestreo) {
		this.puntosMuestreo = puntosMuestreo;
	}
	public List<ListaControl> getListaControles() {
		return listaControles;
	}
	public void setListaControles(List<ListaControl> listaControles) {
		this.listaControles = listaControles;
	}
	
}
