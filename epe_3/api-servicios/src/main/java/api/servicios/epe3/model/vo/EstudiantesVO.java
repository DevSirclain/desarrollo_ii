package api.servicios.epe3.model.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class EstudiantesVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String rut;
    private String email;
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String matricula;
    
    
	@Override
	public String toString() {
		return "EstudiantesVO [id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", email=" + email
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", matricula=" + matricula + "]";
	}
	public EstudiantesVO(Long id, String nombre, String rut, String email, String fecha_nacimiento, String direccion,
			String telefono, String matricula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rut = rut;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.matricula = matricula;
	}
	public EstudiantesVO() {
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
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
    
    
    
}
