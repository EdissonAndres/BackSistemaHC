package co.edu.utp.isc.gia.sistemaHC.service.impl;

import co.edu.utp.isc.gia.sistemaHC.dto.PatientDTO;
import co.edu.utp.isc.gia.sistemaHC.entities.PatientEntity;
import co.edu.utp.isc.gia.sistemaHC.exception.BadRequestException;
import co.edu.utp.isc.gia.sistemaHC.repository.PatientRepository;
import co.edu.utp.isc.gia.sistemaHC.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PatientDTO createPatient (PatientDTO patientDTO) {
        if (!patientDTO.equals(null) && patientDTO != null) {
            Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(patientDTO.getIdentificacion());
            if(!optionalPatientEntity.isPresent()){
                PatientEntity patientEntity = modelMapper.map(patientDTO, PatientEntity.class);
                return modelMapper.map(patientRepository.save(patientEntity), PatientDTO.class);
            }
            else {
                throw new BadRequestException("ya existe registro");

            }
        }
        else {
            throw new BadRequestException("datos vacios");
        }
    }

    public PatientDTO readPatient (Long id) {
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(id);
        if(optionalPatientEntity.isPresent()) {
            PatientEntity patientEntity = optionalPatientEntity.get();
            return modelMapper.map(patientEntity, PatientDTO.class);
        }
        else {
            throw new BadRequestException("no existe registro");
        }
    }

    public PatientDTO updatePatient (PatientDTO patientDTO) {
        if (!patientDTO.equals(null) && patientDTO != null) {
            Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(patientDTO.getIdentificacion());
            if (optionalPatientEntity.isPresent()) {
                PatientEntity patientEntity = modelMapper.map(patientDTO, PatientEntity.class);
                return modelMapper.map(patientRepository.save(patientEntity), PatientDTO.class);
            } else {
                throw new BadRequestException("no existe registro");
            }
        }
        else {
            throw new BadRequestException("datos vacios");
        }
    }

    public PatientDTO deletePatient (Long id) {
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(id);
        if(optionalPatientEntity.isPresent()) {
            patientRepository.deleteById(id);
            PatientEntity patientEntity = optionalPatientEntity.get();
            return modelMapper.map(patientEntity, PatientDTO.class);
        }
        else {
            throw new BadRequestException("no existe registro");
        }
    }
}
