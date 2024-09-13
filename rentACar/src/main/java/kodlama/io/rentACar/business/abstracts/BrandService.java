package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameIsNotNullBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetByNameIsNullBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();

	GetByIdBrandResponse getById(int id);

	void add(CreateBrandRequest createBrandRequest);

	void update(UpdateBrandRequest updateBrandRequest);

	void delete(int id);

	List<GetByNameBrandResponse> getByNameBrandResponses(String name);

	List<GetByNameIsNotNullBrandResponse> getByNameIsNotNullBrandResponses();

	List<GetByNameIsNullBrandResponse> getByNameIsNullBrandResponses();
	
	List<GetByNameBrandResponse> findByNameStartingWithBrandResponse(String prefix);

}
