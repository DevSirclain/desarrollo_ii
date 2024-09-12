package api.servicios.epe3.model.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class ProfesoresVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String departamento;
    
    
	@Override
	public String toString() {
		return "ProfesoresVO [id=" + id + ", nombre=" + nombre + ", email=" + email + ", departamento=" + departamento
				+ "]";
	}


	public ProfesoresVO(Long id, String nombre, String email, String departamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.departamento = departamento;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public ProfesoresVO() {
		super();
		// TODO Auto-generated constructor stub
	}
    }
