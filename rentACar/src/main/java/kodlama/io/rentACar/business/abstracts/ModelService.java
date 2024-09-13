package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelsResponse;

public interface ModelService {

	void add(CreateModelRequest createModelRequest);

	List<GetAllModelsResponse> getAll();

	void delete(int id);
}
