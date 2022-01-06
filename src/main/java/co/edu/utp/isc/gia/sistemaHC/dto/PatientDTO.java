package co.edu.utp.isc.gia.sistemaHC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO implements Serializable {
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
