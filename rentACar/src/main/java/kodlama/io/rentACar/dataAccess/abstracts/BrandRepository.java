package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByNameIgnoreCase(String name); // spring jpa keywords

	List<Brand> findByNameIgnoreCase(String name);

	List<Brand> findByNameIsIgnoreCase(String name);

	List<Brand> findByNameEqualsIgnoreCase(String name);

	List<Brand> findByNameIsNull();

	List<Brand> findByNameIsNotNull();

	List<Brand> findByNameStartingWithIgnoreCase(String prefix);
}
