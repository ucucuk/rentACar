package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	boolean existsByNameIgnoreCase(String name); // spring jpa keywords

	boolean existsByNameIgnoreCaseAndBrandNameIgnoreCase(String modelName, String brandName); // spring jpa keywords

	Model findByNameIgnoreCase(String modelName);
}
