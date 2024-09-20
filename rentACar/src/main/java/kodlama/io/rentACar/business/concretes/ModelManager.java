package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelsResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapper;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.entities.concretes.ModelDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private BrandRepository brandRepository;
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;
	private ModelMapper modelMapper;

	@Override
	public List<ModelDto> getAll() {

		List<Model> models = modelRepository.findAll();
//		List<GetAllModelsResponse> modelsResponse = models.stream()
//				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
//				.collect(Collectors.toList());
		List<ModelDto> modelsResponse = models.stream().map(model -> modelMapper.map(model))
				.collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		this.modelBusinessRules.checkIfBrandNameNoExists(createModelRequest.getBrandName());
		this.modelBusinessRules.checkIfModelNameExist(createModelRequest.getName());
		this.modelBusinessRules.checkIfModelNameAndBrandNameExist(createModelRequest.getName(),
				createModelRequest.getBrandName());
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		List<Brand> brand = brandRepository.findByNameIgnoreCase(createModelRequest.getBrandName());
		for (Brand brand2 : brand) {
			model.setBrand(brand2);
		}
		modelRepository.save(model);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.modelRepository.deleteById(id);
	}

}
