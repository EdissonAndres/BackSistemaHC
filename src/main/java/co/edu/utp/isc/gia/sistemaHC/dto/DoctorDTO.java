package co.edu.utp.isc.gia.sistemaHC.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO implements Serializable {
    private Long identificacion;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String telefono;
    private String email;
}
