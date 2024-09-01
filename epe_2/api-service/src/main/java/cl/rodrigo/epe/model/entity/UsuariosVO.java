package cl.rodrigo.epe.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class UsuariosVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    // Constructor vacío
    public UsuariosVO() {
    }

    // Constructor con parámetros
    public UsuariosVO(Long usuarioId, String nombre, String correoElectronico, Date fechaCreacion) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
