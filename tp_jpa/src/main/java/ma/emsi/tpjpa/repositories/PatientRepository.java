package ma.emsi.tpjpa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.tpjpa.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	public Page<Patient> findByNomContains(String name,Pageable pageable);
	public List<Patient> findByMalade(boolean malade);
	public List<Patient> findByNomContainsAndMalade(String name,boolean malade);
}
