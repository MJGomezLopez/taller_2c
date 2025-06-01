package es.ubu.gii.sd.labmetric.model;

import java.util.Date;

import jakarta.persistence.*;

/**
 * Clase para manejar a la lista de control
 */
@Entity
@Table(name="lista_control")
public class ListaControl {
	
	//Variables de clase
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Date fecha;
	
	//Constructor
	//--con parametros
	public ListaControl(Date fecha) {
		this.fecha = fecha;
	}
	//--sin parametros
	public ListaControl() {}
	
	//Getters y Setters
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}
}
