package pe.edu.estubeca.estubeca.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Profile user;
    @Column(name = "tipomoneda", length = 200)
    private String tipomoneda;
    @Column(name = "v", length = 200, nullable = false)
    private Float v;
    @Column(name = "ci", length = 200, nullable = false)
    private Float ci;
    @Column(name = "cf", length = 200, nullable = false)
    private Float cf;
    @Column(name = "frecuencia", nullable = false)
    private String frecuencia;
    @Column(name = "fechaci", length = 1200, nullable = false)
    private LocalDate fechaci;
    @Column(name="tipotasa", nullable = false)
    private String tipotasa;
    @Column(name = "periodotasa", nullable = false)
    private String periodotasa;
    @Column(name = "valortasa", length = 200, nullable = false)
    private Float valortasa;
    @Column(name = "capitalizacion", nullable = false)
    private String capitalizacion;
    @Column(name = "plazo", nullable = false)
    private String plazo;
    @Column(name = "periodogracia", nullable = false)
    private String periodogracia;
    @Column(name = "cantperiodo", nullable = false)
    private Integer cantperiodo;
    @Column(name = "tasaefectiva", length = 200, nullable = false)
    private Float tasaefectiva;

    public Solicitud(Profile user, String tipomoneda, Float v, Float ci, Float cf, String frecuencia, LocalDate fechaci, String tipotasa, String periodotasa, Float valortasa, String capitalizacion, String plazo, String periodogracia, Integer cantperiodo, Float tasaefectiva) {
        this.user = user;
        this.tipomoneda = tipomoneda;
        this.v = v;
        this.ci = ci;
        this.cf = cf;
        this.frecuencia = frecuencia;
        this.fechaci = fechaci;
        this.tipotasa = tipotasa;
        this.periodotasa = periodotasa;
        this.valortasa = valortasa;
        this.capitalizacion = capitalizacion;
        this.plazo = plazo;
        this.periodogracia = periodogracia;
        this.cantperiodo = cantperiodo;
        this.tasaefectiva = tasaefectiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getUser() {
        return user;
    }

    public void setUser(Profile user) {
        this.user = user;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public Float getV() {
        return v;
    }

    public void setV(Float v) {
        this.v = v;
    }

    public Float getCi() {
        return ci;
    }

    public void setCi(Float ci) {
        this.ci = ci;
    }

    public Float getCf() {
        return cf;
    }

    public void setCf(Float cf) {
        this.cf = cf;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public LocalDate getFechaci() {
        return fechaci;
    }

    public void setFechaci(LocalDate fechaci) {
        this.fechaci = fechaci;
    }

    public String getTipotasa() {
        return tipotasa;
    }

    public void setTipotasa(String tipotasa) {
        this.tipotasa = tipotasa;
    }

    public String getPeriodotasa() {
        return periodotasa;
    }

    public void setPeriodotasa(String periodotasa) {
        this.periodotasa = periodotasa;
    }

    public Float getValortasa() {
        return valortasa;
    }

    public void setValortasa(Float valortasa) {
        this.valortasa = valortasa;
    }

    public String getCapitalizacion() {
        return capitalizacion;
    }

    public void setCapitalizacion(String capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPeriodogracia() {
        return periodogracia;
    }

    public void setPeriodogracia(String periodogracia) {
        this.periodogracia = periodogracia;
    }

    public Integer getCantperiodo() {
        return cantperiodo;
    }

    public void setCantperiodo(Integer cantperiodo) {
        this.cantperiodo = cantperiodo;
    }

    public Float getTasaefectiva() {
        return tasaefectiva;
    }

    public void setTasaefectiva(Float tasaefectiva) {
        this.tasaefectiva = tasaefectiva;
    }
}
