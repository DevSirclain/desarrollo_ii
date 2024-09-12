package api.servicios.epe3.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class CursosVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String codigo;
    private String descripcion;
    private String creditos;
    
	@Override
	public String toString() {
		return "CursosVO [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", creditos=" + creditos + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getCodigo()="
				+ getCodigo() + ", getDescripcion()=" + getDescripcion() + ", getCreditos()=" + getCreditos() + "]";
	}
    
	public CursosVO(Long id, String nombre, String codigo, String descripcion, String creditos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.creditos = creditos;
	}
	public CursosVO() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCreditos() {
		return creditos;
	}
	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}


}
