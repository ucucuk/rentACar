package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByModelYearJPQLCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByPlateCarResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController // annotation
@RequestMapping("/api/cars")
public class CarController {
	private CarService carService;

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}

	@GetMapping
	public List<GetAllCarsResponse> getAll() {
		return this.carService.getAll();
	}

	@PutMapping
	public void update(@RequestBody @Valid() UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}

	@GetMapping("findbyplate")
	public GetByPlateCarResponse findByPlate(String plate) {
		return this.carService.findByPlate(plate);
	}

	@GetMapping("findbymodelyear")
	public List<GetByModelYearJPQLCarsResponse> findByModelYear(int modelYear) {
		return this.carService.findByModelYearJPQL(modelYear);
	}
}
