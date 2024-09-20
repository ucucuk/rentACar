package kodlama.io.rentACar.core.utilities.mappers;

import org.mapstruct.Mapper;

import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.BrandDto;

@Mapper(componentModel = "spring", uses = ModelMapper.class)

public interface BrandMapper {

	Brand map(BrandDto brandDto);

	BrandDto map(Brand brand);

}
