package ma.emsi.tpjpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.tpjpa.entities.Patient;
import ma.emsi.tpjpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository pr;
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*pr.save(new Patient(null,"Hassan",new Date(),2200,false));
		pr.save(new Patient(null,"Farah",new Date(),200,true));
		pr.save(new Patient(null,"Imane",new Date(),1300,false));
		pr.save(new Patient(null,"Aymane",new Date(),300,false));
		pr.save(new Patient(null,"Yassine",new Date(),2300,true));*/
		
		System.out.println("------------------------------------");
		pr.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("------------------------------------");
		//Patient patient = pr.findById(4L).get();
		//System.out.println(patient.getNom());
		System.out.println("------------------------------------");
		Page<Patient> patients = pr.findByNomContains("s",PageRequest.of(0, 2));
		patients.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("------------------------------------");
		List<Patient> patientsMalade = pr.findByMalade(true);
		patientsMalade.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("------------------------------------");
		List<Patient> patientsEtMalade = pr.findByNomContainsAndMalade("s", true);
		patientsEtMalade.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("------------------------------------");
		//pr.deleteById(5L);
		
		Page<Patient> page = pr.findAll(PageRequest.of(0, 2));
		System.out.println("Nombre de Pages :"+page.getTotalPages());
		List<Patient> list = page.getContent();
		list.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("------------------------------------");
	}

}
