package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarBusinessRules {

	private CarRepository carRepository;
	private ModelRepository modelRepository;

	public void checkIfCarPlateExists(String plate) {
		if (this.carRepository.existsByPlateIgnoreCase(plate)) {
			throw new BusinessException("This plate already exists.");
		}
	}
	public void checkIfCarPlateNoExists(String plate) {
		if (!this.carRepository.existsByPlateIgnoreCase(plate)) {
			throw new BusinessException("This plate no exists.");
		}
	}
	public void checkIfModelNoExists(String modelName) {
		if (!this.modelRepository.existsByNameIgnoreCase(modelName)) {
			throw new BusinessException("This model no exists.");
		}
	}
}
