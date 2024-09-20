package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetByModelYearJPQLCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByPlateCarResponse;
import kodlama.io.rentACar.entities.concretes.CarDto;

public interface CarService {
	List<CarDto> getAll();

	void add(CreateCarRequest createCarRequest);

	void update(UpdateCarRequest updateCarRequest);

	GetByPlateCarResponse findByPlate(String plate);

	List<GetByModelYearJPQLCarsResponse> findByModelYearJPQL(int modelYear);

	List<CarDto> getCarfindByBrand(String brand);
}
