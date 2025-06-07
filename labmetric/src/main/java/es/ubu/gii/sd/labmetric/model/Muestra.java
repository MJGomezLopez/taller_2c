package es.ubu.gii.sd.labmetric.model;

import jakarta.persistence.*;

/**
 * Clase para manejar a las muestras
 */
@Entity
@Table(name="muestra")
public class Muestra {
	
	//Variables de la clase
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
    private Double ph; 		//pH
	
	@Column
    private Double dbo; 	//Demanda bioquimica de oxigeno
	
	@Column
    private Double dqo; 	//Demanda quimica de oxigeno
	
	@Column
    private Double st; 		//Solidos totales
	
	@Column
    private Double ce; 		//Conductividad electrica
	
	@Column
    private Double no3; 	//Nitratos
	
	@Column
    private Double nh4;		//Amonio
	
	@Column
    private Double po4;		//Fosfatos
	
	@Column
    private Double alca;	//Alcalinidad
	
	@Column
    private Double cl;		//Cloruros
	
	@Column
    private Double fe;		//Hierro
	
	@Column
    private Double so4;		//Sulfatos
	
	@Column
    private Double od;		//Oxigeno disuelto
	
	@Column
    private Double cot;		//Carbono organico total
	
	//FK Tabla
    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "control_id", nullable = false, unique = true)
    private ListaControl control;
    
	@ManyToOne(optional = true)
	@JoinColumn(name = "analista_id", nullable = false)
	private Analista analista;
    
    //Constructor
    //--con parametros
	public Muestra(Double ph, Double dbo, Double dqo, Double st, Double ce, Double no3, Double nh4, Double po4, Double alca, Double cl, Double fe, Double so4, Double od, Double cot, ListaControl control, Analista analista) {
		this.ph = ph;
		this.dbo = dbo;
		this.dqo = dqo;
		this.st = st;
		this.ce = ce;
		this.no3 = no3;
		this.nh4 = nh4;
		this.po4 = po4;
		this.alca = alca;
		this.cl = cl;
		this.fe = fe;
		this.so4 = so4;
		this.od = od;
		this.cot = cot;
		this.control = control;
		this.analista = analista;
	}
	//--sin parametros
	public Muestra() {
	}
	
	
	//Getters y Setters
	public Double getPh() {
		return ph;
	}

	public void setPh(Double ph) {
		this.ph = ph;
	}

	public Double getDbo() {
		return dbo;
	}

	public void setDbo(Double dbo) {
		this.dbo = dbo;
	}

	public Double getDqo() {
		return dqo;
	}

	public void setDqo(Double dqo) {
		this.dqo = dqo;
	}

	public Double getSt() {
		return st;
	}

	public void setSt(Double st) {
		this.st = st;
	}

	public Double getCe() {
		return ce;
	}

	public void setCe(Double ce) {
		this.ce = ce;
	}

	public Double getNo3() {
		return no3;
	}

	public void setNo3(Double no3) {
		this.no3 = no3;
	}

	public Double getNh4() {
		return nh4;
	}

	public void setNh4(Double nh4) {
		this.nh4 = nh4;
	}

	public Double getPo4() {
		return po4;
	}

	public void setPo4(Double po4) {
		this.po4 = po4;
	}

	public Double getAlca() {
		return alca;
	}

	public void setAlca(Double alca) {
		this.alca = alca;
	}

	public Double getCl() {
		return cl;
	}

	public void setCl(Double cl) {
		this.cl = cl;
	}

	public Double getFe() {
		return fe;
	}

	public void setFe(Double fe) {
		this.fe = fe;
	}

	public Double getSo4() {
		return so4;
	}

	public void setSo4(Double so4) {
		this.so4 = so4;
	}

	public Double getOd() {
		return od;
	}

	public void setOd(Double od) {
		this.od = od;
	}

	public Double getCot() {
		return cot;
	}

	public void setCot(Double cot) {
		this.cot = cot;
	}

	public Long getId() {
		return id;
	}
	
	public ListaControl getControl() {
		return control;
	}
	
	public void setControl(ListaControl control) {
		this.control = control;
	}
	
	public Analista getAnalista() {
		return analista;
	}
	
	public void setAnalista(Analista analista) {
		this.analista = analista;
	}
	
}
