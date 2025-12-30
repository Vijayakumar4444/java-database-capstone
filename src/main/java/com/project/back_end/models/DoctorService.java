package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        doctor.setName(doctorDetails.getName());
        doctor.setSpecialty(doctorDetails.getSpecialty());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setPassword(doctorDetails.getPassword());
        doctor.setPhone(doctorDetails.getPhone());
        doctor.setAvailableTimes(doctorDetails.getAvailableTimes());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        doctorRepository.delete(doctor);
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorRepository.findAll().stream()
                .filter(d -> d.getSpecialty().equalsIgnoreCase(specialty))
                .toList();
    }

    public List<Doctor> getDoctorsByAvailableTime(String time) {
        return doctorRepository.findAll().stream()
                .filter(d -> d.getAvailableTimes().contains(time))
                .toList();
    }
}
