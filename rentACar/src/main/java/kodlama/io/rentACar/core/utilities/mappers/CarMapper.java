package kodlama.io.rentACar.core.utilities.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.concretes.CarDto;

@Mapper(componentModel = "spring", uses = ModelMapper.class)
public interface CarMapper {

	Car map(CarDto carDto);

	CarDto map(Car car);

	List<CarDto> listMap(List<Car> listCar);
}
