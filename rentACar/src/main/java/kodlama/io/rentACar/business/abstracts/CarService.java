package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByModelYearJPQLCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByPlateCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();

	void add(CreateCarRequest createCarRequest);

	void update(UpdateCarRequest updateCarRequest);

	GetByPlateCarResponse findByPlate(String plate);

	List<GetByModelYearJPQLCarsResponse> findByModelYearJPQL(int modelYear);
}
