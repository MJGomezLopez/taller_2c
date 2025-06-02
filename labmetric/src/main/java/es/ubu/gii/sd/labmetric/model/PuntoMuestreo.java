package es.ubu.gii.sd.labmetric.model;

import java.util.List;

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
	
	@OneToMany(mappedBy = "punto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ListaControl> listaControles;
	
	//FK tablas
	@ManyToOne(optional = false)
	@JoinColumn(name = "ruta_id", nullable = false)
	private Ruta ruta;
	
	//Constructores
	
	//--sin parametros
	public PuntoMuestreo() {}
	
	//--con parametros
	public PuntoMuestreo(String nombre, String descripcion, Ruta ruta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ruta = ruta;
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
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public List<ListaControl> getListaControles() {
		return listaControles;
	}

	public void setListaControles(List<ListaControl> listaControles) {
		this.listaControles = listaControles;
	}
	
}
