package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

	private BrandRepository brandRepository;

	public void checkIfBrandNameExistsIgnoreCase(String name) {
		if (this.brandRepository.existsByNameIgnoreCase(name)) {
			throw new BusinessException("Brand already exists.");
		}
	}

	public void checkIfBrandNameNoExists(String name) {
		if (!this.brandRepository.existsByNameIgnoreCase(name)) {
			throw new BusinessException("Brand NO exists.");
		}
	}

}
