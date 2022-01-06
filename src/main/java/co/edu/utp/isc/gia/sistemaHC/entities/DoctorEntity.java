package co.edu.utp.isc.gia.sistemaHC.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "DOCTOR")
public class DoctorEntity {
    @Id
    private Long identificacion;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String telefono;
    private String email;
}
