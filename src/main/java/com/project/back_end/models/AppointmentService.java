package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import com.project.back_end.models.Doctor;
import com.project.back_end.models.Patient;
import com.project.back_end.repositories.AppointmentRepository;
import com.project.back_end.repositories.DoctorRepository;
import com.project.back_end.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) throws IllegalArgumentException {
        if (appointment.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time must be in the future");
        }

        Long doctorId = appointment.getDoctor().getId();
        Long patientId = appointment.getPatient().getId();

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStatus(0); // default status (e.g., 0 = scheduled)

        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) throws IllegalArgumentException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        if (updatedAppointment.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time must be in the future");
        }

        appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        appointment.setStatus(updatedAppointment.getStatus());

        if (updatedAppointment.getDoctor() != null) {
            Doctor doctor = doctorRepository.findById(updatedAppointment.getDoctor().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
            appointment.setDoctor(doctor);
        }

        if (updatedAppointment.getPatient() != null) {
            Patient patient = patientRepository.findById(updatedAppointment.getPatient().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
            appointment.setPatient(patient);
        }

        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) throws IllegalArgumentException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        appointmentRepository.delete(appointment);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
}
