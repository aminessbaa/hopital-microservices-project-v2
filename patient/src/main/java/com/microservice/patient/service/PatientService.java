package com.microservice.patient.service;

import com.microservice.patient.model.dto.AddPatientDTO;

import com.microservice.patient.model.dto.PatientDTO;
import com.microservice.patient.model.dto.UpdatePatientDTO;
import com.microservice.patient.model.entity.Patient;

import com.microservice.patient.reposetory.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class PatientService {
    private List<String> names= Arrays.asList("Abd","khaled","benkida");

    public String getName(String name){
        return names.stream().filter(n->n.equals(name)).findAny().orElse("no patient found");
    }

    @Autowired
    private PatientRepo patientRepo;



    public AddPatientDTO savePatient(AddPatientDTO addPatientDTO) {
       Patient entity=Patient.builder()
                .patientName(addPatientDTO.getPatientName())
                .patientAge(addPatientDTO.getPatientAge())
                .build();
        Patient patient=this.patientRepo.save(entity);

        return AddPatientDTO.builder()
                .patientName(patient.getPatientName())
                .patientAge(patient.getPatientAge())
                .build();
    }
    public PatientDTO updatePatient(UpdatePatientDTO updatePatientDTO) {

        Patient updateEntity=Patient.builder().
                id(updatePatientDTO.getId())
                .patientName(updatePatientDTO.getPatientName())
                .patientAge(updatePatientDTO.getPatientAge())
                .build();

        Patient patient=this.patientRepo.save(updateEntity);
        return PatientDTO.builder()
                .id(patient.getId())
                .patientName(patient.getPatientName())
                .patientAge(patient.getPatientAge())
                .build();

    }
    public void deletePatient(Long id) {
        Patient patient=this.patientRepo.findById(id).orElse(null);
         this.patientRepo.deleteById(id);
    }


    public PatientDTO getPatient(Long id) {
        Optional<Patient> patient=this.patientRepo.findById(id);

       return PatientDTO.builder()
               .id(patient.get().getId())
               .patientName(patient.get().getPatientName())
               .patientAge(patient.get().getPatientAge())
               .build();


    }


}
