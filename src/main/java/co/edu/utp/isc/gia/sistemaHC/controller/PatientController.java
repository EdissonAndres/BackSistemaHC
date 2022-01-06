package co.edu.utp.isc.gia.sistemaHC.controller;

import co.edu.utp.isc.gia.sistemaHC.dto.PatientDTO;
import co.edu.utp.isc.gia.sistemaHC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("createPatient")
    public PatientDTO createPatient (@RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    @GetMapping("readPatient")
    public PatientDTO readPatient (@RequestBody Long id) {
        return patientService.readPatient(id);
    }

    @PutMapping("uptadePatient")
    public PatientDTO updatePatient (@RequestBody PatientDTO patientDTO) {
        return patientService.updatePatient(patientDTO);
    }

    @DeleteMapping("deletePatient")
    public PatientDTO deletePatient (@RequestBody Long id) {
        return patientService.deletePatient(id);
    }
}
