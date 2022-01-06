package co.edu.utp.isc.gia.sistemaHC.controller;

import co.edu.utp.isc.gia.sistemaHC.dto.ClinicHistoryDTO;
import co.edu.utp.isc.gia.sistemaHC.service.ClinicHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("clinicHistory")
public class ClinicHistoryController {

    @Autowired
    private ClinicHistoryService clinicHistoryService;

    @PostMapping("createClinicHistory")
    public ClinicHistoryDTO createClinicHistory (@RequestBody ClinicHistoryDTO clinicHistoryDTO) {
        return clinicHistoryService.createClinicHistory(clinicHistoryDTO);
    }

    @GetMapping("readClinicHistory")
    public ClinicHistoryDTO readClinicHistory (@RequestBody Long id) {
        return clinicHistoryService.readClinicHistory(id);
    }

    @PutMapping("updateClinicHistory")
    public ClinicHistoryDTO updateClinicHistory (@RequestBody ClinicHistoryDTO clinicHistoryDTO) {
        return clinicHistoryService.updateClinicHistory(clinicHistoryDTO);
    }

    @DeleteMapping("deleteClinicHistory")
    public ClinicHistoryDTO deleteClinicHistory (@RequestBody Long id) {
        return clinicHistoryService.deleteClinicHistory(id);
    }
}
