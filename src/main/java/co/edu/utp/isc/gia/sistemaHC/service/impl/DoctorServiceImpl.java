package co.edu.utp.isc.gia.sistemaHC.service.impl;

import co.edu.utp.isc.gia.sistemaHC.dto.DoctorDTO;
import co.edu.utp.isc.gia.sistemaHC.entities.DoctorEntity;
import co.edu.utp.isc.gia.sistemaHC.exception.BadRequestException;
import co.edu.utp.isc.gia.sistemaHC.repository.DoctorRepository;
import co.edu.utp.isc.gia.sistemaHC.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DoctorDTO createDoctor (DoctorDTO doctorDTO) {
        if (!doctorDTO.equals(null) && doctorDTO != null) {
            Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(doctorDTO.getIdentificacion());
            if(!optionalDoctorEntity.isPresent()){
                DoctorEntity doctorEntity = modelMapper.map(doctorDTO, DoctorEntity.class);
                return modelMapper.map(doctorRepository.save(doctorEntity), DoctorDTO.class);
            }
            else {
                throw new BadRequestException("ya existe registro");
            }
        }
        else {
            throw new BadRequestException("datos vacios");
        }
    }

    public DoctorDTO readDoctor (Long id) {
        Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(id);
        if(optionalDoctorEntity.isPresent()) {
            DoctorEntity doctorEntity = optionalDoctorEntity.get();
            return modelMapper.map(doctorEntity, DoctorDTO.class);
        }
        else {
            throw new BadRequestException("no existe registro");
        }
    }

    public DoctorDTO updateDoctor (DoctorDTO doctorDTO) {
        if (!doctorDTO.equals(null) && doctorDTO != null) {
            Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(doctorDTO.getIdentificacion());
            if (optionalDoctorEntity.isPresent()) {
                DoctorEntity doctorEntity = modelMapper.map(doctorDTO, DoctorEntity.class);
                return modelMapper.map(doctorRepository.save(doctorEntity), DoctorDTO.class);
            } else {
                throw new BadRequestException("no existe registro");
            }
        }
        else {
            throw new BadRequestException("datos vacios");
        }
    }

    public DoctorDTO deleteDoctor (Long id) {
        Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(id);
        if(optionalDoctorEntity.isPresent()) {
            doctorRepository.deleteById(id);
            DoctorEntity doctorEntity = optionalDoctorEntity.get();
            return modelMapper.map(doctorEntity, DoctorDTO.class);
        }
        else {
            throw new BadRequestException("no existe registro");
        }
    }
}
