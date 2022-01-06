package co.edu.utp.isc.gia.sistemaHC.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "CLINIC_HISTORY")
public class ClinicHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pacienteId", foreignKey = @ForeignKey(name ="pacienteId"))
    private PatientEntity patientEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorId", foreignKey = @ForeignKey(name ="doctorId"))
    private DoctorEntity doctorEntity;
}
