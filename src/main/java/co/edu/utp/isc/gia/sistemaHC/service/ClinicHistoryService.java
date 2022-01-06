package co.edu.utp.isc.gia.sistemaHC.service;

import co.edu.utp.isc.gia.sistemaHC.dto.ClinicHistoryDTO;

public interface ClinicHistoryService {
    ClinicHistoryDTO createClinicHistory(ClinicHistoryDTO clinicHistoryDTO);

    ClinicHistoryDTO readClinicHistory(Long id);

    ClinicHistoryDTO updateClinicHistory(ClinicHistoryDTO clinicHistoryDTO);

    ClinicHistoryDTO deleteClinicHistory(Long id);
}
