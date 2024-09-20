package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.entities.concretes.ModelDto;

public interface ModelService {

	void add(CreateModelRequest createModelRequest);

	List<ModelDto> getAll();

	void delete(int id);
}
