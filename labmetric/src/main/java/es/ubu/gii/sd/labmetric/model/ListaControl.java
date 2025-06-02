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
	
	//FK tablas
	@ManyToOne(optional = false)
	@JoinColumn(name = "ruta_id", nullable = false)
	private Ruta ruta;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "punto_id", nullable = false)
	private PuntoMuestreo punto;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "tecnico_id", nullable = false)
	private TecnicoCampo tecnico;
	
	//Constructor
	//--con parametros
	public ListaControl(Date fecha, Ruta ruta, PuntoMuestreo punto,TecnicoCampo tecnico) {
		this.fecha = fecha;
		this.ruta = ruta;
		this.punto = punto;
		this.tecnico = tecnico;
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
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public PuntoMuestreo getPunto() {
		return punto;
	}
	public void setPunto(PuntoMuestreo punto) {
		this.punto = punto;
	}
	public TecnicoCampo getTecnico() {
		return tecnico;
	}
	public void setTecnico(TecnicoCampo tecnico) {
		this.tecnico = tecnico;
	}
}
