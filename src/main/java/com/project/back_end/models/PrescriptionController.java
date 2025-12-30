package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable String id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@Valid @RequestBody Prescription prescription) {
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return ResponseEntity.ok(savedPrescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable String id,
                                                           @Valid @RequestBody Prescription updatedPrescription) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(id);
        if (!optionalPrescription.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Prescription prescription = optionalPrescription.get();
        prescription.setPatientName(updatedPrescription.getPatientName());
        prescription.setAppointmentId(updatedPrescription.getAppointmentId());
        prescription.setMedication(updatedPrescription.getMedication());
        prescription.setDosage(updatedPrescription.getDosage());
        prescription.setDoctorNotes(updatedPrescription.getDoctorNotes());

        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return ResponseEntity.ok(savedPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrescription(@PathVariable String id) {
        if (!prescriptionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prescriptionRepository.deleteById(id);
        return ResponseEntity.ok().body("Prescription deleted successfully.");
    }

    @GetMapping("/appointment/{appointmentId}")
    public List<Prescription> getPrescriptionsByAppointment(@PathVariable Long appointmentId) {
        return prescriptionRepository.findByAppointmentId(appointmentId);
    }

    @GetMapping("/patient/{patientName}")
    public List<Prescription> getPrescriptionsByPatient(@PathVariable String patientName) {
        return prescriptionRepository.findByPatientName(patientName);
    }
}
