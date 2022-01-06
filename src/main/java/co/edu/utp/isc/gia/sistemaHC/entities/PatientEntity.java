package co.edu.utp.isc.gia.sistemaHC.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "PATIENT")
public class PatientEntity {
    @Id
    private Long identificacion;
    private String nombres;
    private String apellidos;
    private String genero;
    private String fechaNacimiento;
    private String estadoCivil;
    private String etnia;
    private String eps;
    private String direccion;
    private String telefono;
    private String email;
}
