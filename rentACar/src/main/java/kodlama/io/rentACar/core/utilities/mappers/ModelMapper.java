package kodlama.io.rentACar.core.utilities.mappers;

import org.mapstruct.Mapper;

import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.entities.concretes.ModelDto;

@Mapper(componentModel = "spring", uses = { BrandMapper.class, CarMapper.class })

public interface ModelMapper {

	Model map(ModelDto modelDto);

	ModelDto map(Model car);
}
