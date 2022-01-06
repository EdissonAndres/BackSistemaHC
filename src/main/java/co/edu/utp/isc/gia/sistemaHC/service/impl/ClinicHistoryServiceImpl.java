package co.edu.utp.isc.gia.sistemaHC.service.impl;

import co.edu.utp.isc.gia.sistemaHC.dto.ClinicHistoryDTO;
import co.edu.utp.isc.gia.sistemaHC.entities.ClinicHistoryEntity;
import co.edu.utp.isc.gia.sistemaHC.entities.DoctorEntity;
import co.edu.utp.isc.gia.sistemaHC.entities.PatientEntity;
import co.edu.utp.isc.gia.sistemaHC.exception.BadRequestException;
import co.edu.utp.isc.gia.sistemaHC.repository.ClinicHistoryRepository;
import co.edu.utp.isc.gia.sistemaHC.service.ClinicHistoryService;
import co.edu.utp.isc.gia.sistemaHC.service.DoctorService;
import co.edu.utp.isc.gia.sistemaHC.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicHistoryServiceImpl implements ClinicHistoryService {

    @Autowired
    private ClinicHistoryRepository clinicHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    public ClinicHistoryDTO createClinicHistory(ClinicHistoryDTO clinicHistoryDTO) {
        if (!clinicHistoryDTO.equals(null) && clinicHistoryDTO != null) {
            PatientEntity patientEntity = modelMapper.map(patientService.readPatient(clinicHistoryDTO.getPacienteId()),
                    PatientEntity.class);
            DoctorEntity doctorEntity = modelMapper.map(doctorService.readDoctor(clinicHistoryDTO.getDoctorId()),
                    DoctorEntity.class);
            ClinicHistoryEntity clinicHistoryEntity = modelMapper.map(clinicHistoryDTO, ClinicHistoryEntity.class);
            clinicHistoryEntity.setPatientEntity(patientEntity);
            clinicHistoryEntity.setDoctorEntity(doctorEntity);
            return modelMapper.map(clinicHistoryRepository.save(clinicHistoryEntity), ClinicHistoryDTO.class);
        }
        else {
            throw new BadRequestException("datos vacios");
        }
    }

    public ClinicHistoryDTO readClinicHistory(Long id){
        Optional<ClinicHistoryEntity> optionalClinicHistoryEntity = clinicHistoryRepository.findById(id);
        if(optionalClinicHistoryEntity.isPresent()) {
            ClinicHistoryEntity clinicHistoryEntity = optionalClinicHistoryEntity.get();
            return modelMapper.map(clinicHistoryEntity, ClinicHistoryDTO.class);
        }
        else {
            throw new BadRequestException("no existe registro");
        }
    }

    public ClinicHistoryDTO updateClinicHistory(ClinicHistoryDTO clinicHistoryDTO){
        if (!clinicHistoryDTO.equals(null) && clinicHistoryDTO != null) {
            Optional<ClinicHistoryEntity> optionalClinicHistoryEntity = clinicHistoryRepository
                    .findById(clinicHistoryDTO.getId());
            if (optionalClinicHistoryEntity.isPresent()) {
                PatientEntity patientEntity = modelMapper.map(patientService.readPatient(clinicHistoryDTO.getPacienteId()),
                        PatientEntity.class);
                DoctorEntity doctorEntity = modelMapper.map(doctorService.readDoctor(clinicHistoryDTO.getDoctorId()),
                        DoctorEntity.class);
                ClinicHistoryEntity clinicHistoryEntity = modelMapper.map(clinicHistoryDTO, ClinicHistoryEntity.class);
                clinicHistoryEntity.setPatientEntity(patientEntity);
                clinicHistoryEntity.setDoctorEntity(doctorEntity);
                return modelMapper.map(clinicHistoryRepository.save(clinicHistoryEntity), ClinicHistoryDTO.class);
            } else {
                throw new BadRequestException("no existe registro");
            }
        }
        else {
            throw new BadRequestException("datos vacios");
        }
    }

    public ClinicHistoryDTO deleteClinicHistory(Long id){
        Optional<ClinicHistoryEntity> optionalClinicHistoryEntity = clinicHistoryRepository.findById(id);
        if(optionalClinicHistoryEntity.isPresent()) {
            clinicHistoryRepository.deleteById(id);
            ClinicHistoryEntity clinicHistoryEntity = optionalClinicHistoryEntity.get();
            return modelMapper.map(clinicHistoryEntity, ClinicHistoryDTO.class);
        }
        else {
            throw new BadRequestException("no existe registro");
        }
    }

}
