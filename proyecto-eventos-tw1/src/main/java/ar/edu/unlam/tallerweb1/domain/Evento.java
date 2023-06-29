package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.DatosEvento;
import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Evento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long Id;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private String localidad;
    private String URLImagen;
    private Boolean eventoActivo;

    private Integer disponibilidad;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "evento")
    private List<Entrada> entradas = new ArrayList<>();

    public Evento (){
    }
    
    public Evento(DatosEvento datosEvento, Categoria categoria) {
    	setNombre(datosEvento.getNombre());
    	setLocalidad(datosEvento.getLocalidad());
    	setCategoria(categoria);
    	setEventoActivo(true);
        setDisponibilidad(50);
    }
    
    public Evento(DatosEvento datosEvento) {
    	setNombre(datosEvento.getNombre());
    	setLocalidad(datosEvento.getLocalidad());
    	setEventoActivo(true);
        setDisponibilidad(50);
    }
    
    public Evento(String nombre, LocalDate fecha, String lugar, String localidad) {
    	setNombre(nombre);
    	setFecha(fecha);
    	setLugar(lugar);
    	setLocalidad(localidad);
    	setEventoActivo(true);
        setDisponibilidad(50);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public String getURLImagen() {
        return URLImagen;
    }

    public void setURLImagen(String URLImagen) {
        this.URLImagen = URLImagen;
    }

	

	public Boolean getEventoActivo() {
		return eventoActivo;
	}

	public void setEventoActivo(Boolean eventoActivo) {
		this.eventoActivo = eventoActivo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

    public Integer getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void agregarEntrada(Entrada entrada){
        entradas.add(entrada);
        disponibilidad--;
    }

	@Override
	public String toString() {
		return "Evento [categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, categoria, disponibilidad, eventoActivo, fecha, localidad, lugar, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(disponibilidad, other.disponibilidad)
				&& Objects.equals(eventoActivo, other.eventoActivo) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(localidad, other.localidad) && Objects.equals(lugar, other.lugar)
				&& Objects.equals(nombre, other.nombre);
	}

}
