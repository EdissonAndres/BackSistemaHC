package co.edu.utp.isc.gia.sistemaHC.controller;

import co.edu.utp.isc.gia.sistemaHC.dto.DoctorDTO;
import co.edu.utp.isc.gia.sistemaHC.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("createDoctor")
    public DoctorDTO createDoctor (@RequestBody DoctorDTO doctorDTO) {
        return doctorService.createDoctor(doctorDTO);
    }

    @GetMapping("readDoctor")
    public DoctorDTO readDoctor (@RequestBody Long id) {
        return doctorService.readDoctor(id);
    }

    @PutMapping("updateDoctor")
    public DoctorDTO updateDoctor (@RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctor(doctorDTO);
    }

    @DeleteMapping("deleteDoctor")
    public DoctorDTO deleteDoctor (@RequestBody Long id) {
        return doctorService.deleteDoctor(id);
    }

}
