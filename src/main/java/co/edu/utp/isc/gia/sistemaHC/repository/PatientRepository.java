package co.edu.utp.isc.gia.sistemaHC.repository;

import co.edu.utp.isc.gia.sistemaHC.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientEntity, Long> {
}
