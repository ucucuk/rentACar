package kodlama.io.rentACar.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByModelYearJPQLCarsResponse {

	private int id;

	private String plate;

	private double dailyPrice;

	private int modelYear;

	private int state; // 1-Available 2-Rented 3-Maintenance

	private String modelName;

}
