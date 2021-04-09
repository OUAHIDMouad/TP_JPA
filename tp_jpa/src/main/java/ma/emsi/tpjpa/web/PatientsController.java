package ma.emsi.tpjpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.tpjpa.entities.Patient;
import ma.emsi.tpjpa.repositories.PatientRepository;

@RestController
public class PatientsController {
	@Autowired
	private PatientRepository pr;
	@GetMapping("/patients")
	public List<Patient> Patients(){
		return pr.findAll();
	}
	@GetMapping("/patients/{id}")
	public Patient Patient(@PathVariable Long id) {
		return pr.findById(id).get();
	}
}
