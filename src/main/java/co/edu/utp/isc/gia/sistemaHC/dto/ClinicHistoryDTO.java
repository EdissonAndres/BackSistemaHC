package co.edu.utp.isc.gia.sistemaHC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicHistoryDTO implements Serializable {
    private Long id;
    private Long pacienteId;
    private Long doctorId;
    private Date fecha;
    private String motivoConsulta;
    private String revisionSistemas;
    private String antecedentes;
    private String examenFisico;
    private String aspectoGeneral;
    private String diagnostico;
    private String conducta;
    private String medicamentosSuministros;
    private String ayudasDiagnosticas;
}
