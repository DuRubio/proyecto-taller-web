package ar.edu.unlam.tallerweb1.delivery;

import java.util.Date;

public class DatosEvento {
    private String nombre;
    private Date fecha;
    private String lugar;
    private String localidad;
    private TipoDeEvento tipo;


    public DatosEvento() {
    }

    public DatosEvento(String nombre, Date fecha, String lugar, String localidad, TipoDeEvento tipo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.localidad = localidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public TipoDeEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeEvento tipo) {
        this.tipo = tipo;
    }
}
