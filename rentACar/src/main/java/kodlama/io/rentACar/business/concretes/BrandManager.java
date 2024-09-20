package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameIsNotNullBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameIsNullBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.BrandMapper;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.BrandDto;
import lombok.AllArgsConstructor;

@Service // IOC
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	private BrandMapper brandMapper;

	@Override
	public List<BrandDto> getAll() {
		List<Brand> brands = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponse = brands.stream()
//				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
//				.collect(Collectors.toList());
		List<BrandDto> brandsResponse = brands.stream().map(brand -> brandMapper.map(brand))
				.collect(Collectors.toList());
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		// TODO Auto-generated method stub
		this.brandBusinessRules.checkIfBrandNameExistsIgnoreCase(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		// TODO Auto-generated method stub
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandBusinessRules.checkIfBrandNameExistsIgnoreCase(updateBrandRequest.getName());
		this.brandRepository.save(brand);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.brandRepository.deleteById(id);
	}

	@Override
	public List<GetByNameBrandResponse> getByNameBrandResponses(String name) {
		List<GetByNameBrandResponse> getByNameBrandResponses = new ArrayList<GetByNameBrandResponse>();
		getByNameBrandResponses = this.brandRepository.findByNameIgnoreCase(name).stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetByNameBrandResponse.class))
				.collect(Collectors.toList());
		return getByNameBrandResponses;
	}

	@Override
	public List<GetByNameIsNotNullBrandResponse> getByNameIsNotNullBrandResponses() {
		List<GetByNameIsNotNullBrandResponse> getByNameIsNotNullBrandResponses = new ArrayList<GetByNameIsNotNullBrandResponse>();
		getByNameIsNotNullBrandResponses = this.brandRepository.findByNameIsNotNull().stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetByNameIsNotNullBrandResponse.class))
				.collect(Collectors.toList());
		return getByNameIsNotNullBrandResponses;
	}

	@Override
	public List<GetByNameIsNullBrandResponse> getByNameIsNullBrandResponses() {
		List<GetByNameIsNullBrandResponse> getByNameIsNullBrandResponses = new ArrayList<GetByNameIsNullBrandResponse>();
		getByNameIsNullBrandResponses = this.brandRepository.findByNameIsNull().stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetByNameIsNullBrandResponse.class))
				.collect(Collectors.toList());
		return getByNameIsNullBrandResponses;
	}

	@Override
	public List<GetByNameBrandResponse> findByNameStartingWithBrandResponse(String namePrefix) {
		List<GetByNameBrandResponse> getByNameBrandResponses = new ArrayList<GetByNameBrandResponse>();
		getByNameBrandResponses = this.brandRepository.findByNameStartingWithIgnoreCase(namePrefix).stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetByNameBrandResponse.class))
				.collect(Collectors.toList());
		return getByNameBrandResponses;
	}

}
