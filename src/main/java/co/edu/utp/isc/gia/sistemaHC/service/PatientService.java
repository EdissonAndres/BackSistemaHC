package co.edu.utp.isc.gia.sistemaHC.service;

import co.edu.utp.isc.gia.sistemaHC.dto.PatientDTO;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);

    PatientDTO readPatient(Long id);

    PatientDTO updatePatient(PatientDTO patientDTO);

    PatientDTO deletePatient(Long id);
}
