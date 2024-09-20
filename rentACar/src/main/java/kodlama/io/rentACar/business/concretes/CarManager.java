package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetByModelYearJPQLCarsResponse;
import kodlama.io.rentACar.business.responses.car.GetByPlateCarResponse;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.CarMapper;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.concretes.CarDto;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private CarBusinessRules carBusinessRules;
	private final CarMapper carMapper;

	@Override
	public List<CarDto> getAll() {
		// TODO Auto-generated method stub
		List<Car> cars = carRepository.findAll();
//		List<GetAllCarsResponse> allCarsResponses = new ArrayList<GetAllCarsResponse>();
//		allCarsResponses = cars.stream()
//				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
//				.collect(Collectors.toList());
		List<CarDto> allCarsResponses = new ArrayList<CarDto>();
		allCarsResponses = cars.stream().map(car -> this.carMapper.map(car)).collect(Collectors.toList());
//		allCarsResponses = cars.stream()
//				.map(car -> this.carMapper.map(car))
//				.filter(car -> car.getModel().getBrand().getName().equalsIgnoreCase("Kia"))
//				.collect(Collectors.toList());
		return allCarsResponses;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		// TODO Auto-generated method stub
		this.carBusinessRules.checkIfModelNoExists(createCarRequest.getModelName());
		this.carBusinessRules.checkIfCarPlateExists(createCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		Model model = this.modelRepository.findByNameIgnoreCase(createCarRequest.getModelName());
		car.setModel(model);
		carRepository.save(car);
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		// TODO Auto-generated method stub
		this.carBusinessRules.checkIfModelNoExists(updateCarRequest.getModelName());
		Car car = this.carRepository.findByPlateIgnoreCase(updateCarRequest.getPlate());
		car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setModel(this.modelRepository.findByNameIgnoreCase(updateCarRequest.getModelName()));
		car.setModelYear(updateCarRequest.getModelYear());
		car.setState(updateCarRequest.getState());
		carRepository.save(car);

	}

	@Override
	public GetByPlateCarResponse findByPlate(String plate) {
		this.carBusinessRules.checkIfCarPlateNoExists(plate);
		Car car = carRepository.findByPlateIgnoreCase(plate);
		GetByPlateCarResponse findByPlateCars = this.modelMapperService.forResponse().map(car,
				GetByPlateCarResponse.class);
		return findByPlateCars;
	}

	@Override
	public List<GetByModelYearJPQLCarsResponse> findByModelYearJPQL(int modelYear) {
		List<Car> cars = carRepository.findByModelYearJPQL(modelYear);
		List<GetByModelYearJPQLCarsResponse> findByModelYear = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetByModelYearJPQLCarsResponse.class))
				.collect(Collectors.toList());
		return findByModelYear;
	}

	@Override
	public List<CarDto> getCarfindByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Car> cars = carRepository.findByCarBrandNameIgnoreCaseJPQL(brand);
		List<CarDto> getCarfindByBrand = this.carMapper.listMap(cars);

		
		return getCarfindByBrand;
	}

}
