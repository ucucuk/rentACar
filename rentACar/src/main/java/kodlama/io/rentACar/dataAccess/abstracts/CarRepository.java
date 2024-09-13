package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.rentACar.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	boolean existsByPlateIgnoreCase(String name); // spring jpa keywords


	Car findByPlateIgnoreCase(String plate);

	@Query("SELECT c FROM Car c WHERE c.modelYear=:modelyear")
	List<Car> findByModelYearJPQL(@Param("modelyear") int modelYear); 

//	List<Car> findByModelYear(int modelYear);

//	@Query("SELECT c FROM Car c ORDER BY modelYear")
//	@Query("SELECT c FROM Car c Where c.modelYear= ?1 ORDER BY dailyPrice DESC")
//	@Query("SELECT c FROM Car c JOIN c.model m WHERE c.modelYear= ?1 and c.dailyPrice=1000 and m.id=21")
//  @Query("SELECT c FROM Car c INNER JOIN c.model m WHERE c.modelYear=:modelyear and c.dailyPrice=2000 or m.name='i10'")
//  List<Car> findByModelYearJPQL(@Param("modelyear") int modelYear);

//	List<Car> findByYearLessThan(int modelYear);
//
//	List<Car> findByYearLessThanEqual(int modelYear);
//
//	List<Car> findByYearGreaterThan(int modelYear);
//
//	List<Car> findByYearGreaterThanEqual(int modelYear);
//
//	List<Car> findByYearBetween(int startYear, int endYear);
}
