package com.microservice.patient.reposetory;


import com.microservice.patient.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {

}
