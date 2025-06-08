package es.ubu.gii.sd.labmetric.model;

import java.util.List;

import jakarta.persistence.*;

/**
 * Clase para manejar a los tecnico de campo
 */
@Entity
@Table(name="tecnico_campo")
public class TecnicoCampo {
	
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
	
	@OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ListaControl> listaControles;

	//Constructor
	//--con parametros
	public TecnicoCampo(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	//--sin parametros	
	public TecnicoCampo() {}
	
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
	
    public void setId(Long id) {
        this.id = id;
    }
	
	public List<ListaControl> getListaControles() {
		return listaControles;
	}
	public void setListaControles(List<ListaControl> listaControles) {
		this.listaControles = listaControles;
	}
	
}
