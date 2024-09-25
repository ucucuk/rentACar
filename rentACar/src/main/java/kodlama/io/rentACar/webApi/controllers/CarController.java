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
import kodlama.io.rentACar.business.responses.car.GetByModelYearJPQLCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByPlateCarResponse;
import kodlama.io.rentACar.entities.concretes.CarDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

//	@GetMapping
//	public List<GetAllCarsResponse> getAll() {
//		return this.carService.getAll();
//	}
	@GetMapping("findbybrand")
	public List<CarDto> getCarfindByBrand(String brand) {
		return this.carService.getCarfindByBrand(brand);
	}

	@GetMapping
	public List<CarDto> getAll() {
		log.debug("Get All Cars Controller DEBUG");
		log.info("Get All Cars Controller INFO");
		log.warn("Get All Cars Controller WARN");
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
