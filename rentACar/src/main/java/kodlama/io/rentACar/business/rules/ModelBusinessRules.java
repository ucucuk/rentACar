package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
	private ModelRepository modelRepository;
	private BrandRepository brandRepository;

	public void checkIfModelNameExist(String modelName) {
		if (this.modelRepository.existsByNameIgnoreCase(modelName)) {
			throw new BusinessException("This model already exists.");
		}
	}

	public void checkIfModelNameAndBrandNameExist(String modelName, String brandName) {
		if (this.modelRepository.existsByNameIgnoreCaseAndBrandNameIgnoreCase(modelName, brandName)) {
			throw new BusinessException("This Model already exists in this Brand.");
		}
	}

	public void checkIfBrandNameNoExists(String name) {
		if (!this.brandRepository.existsByNameIgnoreCase(name)) {
			throw new BusinessException("Brand NO exists.");
		}
	}
}
