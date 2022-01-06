package co.edu.utp.isc.gia.sistemaHC.service;

import co.edu.utp.isc.gia.sistemaHC.dto.DoctorDTO;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    DoctorDTO readDoctor(Long id);

    DoctorDTO updateDoctor(DoctorDTO doctorDTO);

    DoctorDTO deleteDoctor(Long id);
}
