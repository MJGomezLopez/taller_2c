package es.ubu.gii.sd.labmetric.model;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "vista_resultados")
public class VistaResultado {
    @Id
    @Column(name = "id_muestra")
    private Long idMuestra;

    private String analista;
    private String telefono;
    private Date fecha;

    @Column(name = "punto_muestreo")
    private String puntoMuestreo;

    private String ruta;

    @Column(name = "tecnico_campo")
    private String tecnicoCampo;

    private Double r_dbo_dqo;
    private Double prct_bio;
    private Double imnb;
    private Double im;
    private Double ch;
    private Double ini;
    private Double r_po4_no3;
    private Double dt;
    private Double cht;
    private Double ics;
    
    // como es una vista no le creo constructor (es solo para consultar)
    
	public Long getIdMuestra() {
		return idMuestra;
	}
	public void setIdMuestra(Long idMuestra) {
		this.idMuestra = idMuestra;
	}
	public String getAnalista() {
		return analista;
	}
	public void setAnalista(String analista) {
		this.analista = analista;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getPuntoMuestreo() {
		return puntoMuestreo;
	}
	public void setPuntoMuestreo(String puntoMuestreo) {
		this.puntoMuestreo = puntoMuestreo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getTecnicoCampo() {
		return tecnicoCampo;
	}
	public void setTecnicoCampo(String tecnicoCampo) {
		this.tecnicoCampo = tecnicoCampo;
	}
	public Double getR_dbo_dqo() {
		return r_dbo_dqo;
	}
	public void setR_dbo_dqo(Double r_dbo_dqo) {
		this.r_dbo_dqo = r_dbo_dqo;
	}
	public Double getPrct_bio() {
		return prct_bio;
	}
	public void setPrct_bio(Double prct_bio) {
		this.prct_bio = prct_bio;
	}
	public Double getImnb() {
		return imnb;
	}
	public void setImnb(Double imnb) {
		this.imnb = imnb;
	}
	public Double getIm() {
		return im;
	}
	public void setIm(Double im) {
		this.im = im;
	}
	public Double getCh() {
		return ch;
	}
	public void setCh(Double ch) {
		this.ch = ch;
	}
	public Double getIni() {
		return ini;
	}
	public void setIni(Double ini) {
		this.ini = ini;
	}
	public Double getR_po4_no3() {
		return r_po4_no3;
	}
	public void setR_po4_no3(Double r_po4_no3) {
		this.r_po4_no3 = r_po4_no3;
	}
	public Double getDt() {
		return dt;
	}
	public void setDt(Double dt) {
		this.dt = dt;
	}
	public Double getCht() {
		return cht;
	}
	public void setCht(Double cht) {
		this.cht = cht;
	}
	public Double getIcs() {
		return ics;
	}
	public void setIcs(Double ics) {
		this.ics = ics;
	}
    
}
