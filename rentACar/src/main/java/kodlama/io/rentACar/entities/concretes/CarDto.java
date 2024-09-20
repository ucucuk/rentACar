package kodlama.io.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

	private int id;

	private String plate;

	private double dailyPrice;

	private int modelYear;

	private int state; // 1-Available 2-Rented 3-Maintenance

	private ModelDto model; 

}
