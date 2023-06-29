package ar.edu.unlam.tallerweb1.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    //@Column(nullable = false)
    private String nombre;
    // @Column(nullable = false)
    private String apellido;
    // @Column(nullable = false)
    private String localidad;
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false)
    private String clave;

    @Column(nullable=true)
    private Boolean isAdmin=false;

    @Column(nullable=true)
    @OneToMany(fetch = FetchType.EAGER) //analizar por qué no se guarda en la tabla de usuario_entrada y sí en entrada
   private List<Entrada> entradas = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name = "id_categoria",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categoria> categoriasPreferidas = new ArrayList<>();


    public Usuario() {

    }


    public Usuario(String nombre, String apellido, String localidad, String correo, String clave) {
        setNombre(nombre);
        setApellido(apellido);
        setLocalidad(localidad);
        setCorreo(correo);
        setClave(clave);

    }

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;


    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void isAdmin(Boolean b) {
        isAdmin=b;
    }

    public Boolean getIsAdmin (){
        return isAdmin;
    }
    
    


	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public List<Categoria> getCategoriasPreferidas() {
		return categoriasPreferidas;
	}


	public void setCategoriasPreferidas(List<Categoria> categoriasPreferidas) {
		this.categoriasPreferidas = categoriasPreferidas;
	}


    public void asignarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }


    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }
}


