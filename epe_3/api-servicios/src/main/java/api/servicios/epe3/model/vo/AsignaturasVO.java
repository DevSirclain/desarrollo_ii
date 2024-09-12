package api.servicios.epe3.model.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
public class AsignaturasVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long profesor_id;
    private Date fecha_asignacion;
    
    
    
    
	@Override
	public String toString() {
		return "AsignaturasVO [id=" + id + ", nombre=" + nombre + ", profesor_id=" + profesor_id + ", fecha_asignacion="
				+ fecha_asignacion + "]";
	}

	public AsignaturasVO(Long id, String nombre, Long profesor_id, Date fecha_asignacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.profesor_id = profesor_id;
		this.fecha_asignacion = fecha_asignacion;
	}

	public AsignaturasVO() {
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
	public Long getProfesor_id() {
		return profesor_id;
	}
	public void setProfesor_id(Long profesor_id) {
		this.profesor_id = profesor_id;
	}
	public Date getFecha_asignacion() {
		return fecha_asignacion;
	}
	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}
}
