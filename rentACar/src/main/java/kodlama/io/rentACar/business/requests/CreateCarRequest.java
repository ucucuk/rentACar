package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	@NotNull
	@NotBlank
	@Size(min = 3, max = 20)
	private String plate;

	@NotNull
	private double dailyPrice;

	@NotNull
	@Min(value = 2000, message = "Too low.")
	@Max(value = 2024, message = "Too high.")
	private int modelYear;

	@NotNull
	@Min(value = 1, message = "Too low.")
	@Max(value = 3, message = "Too high.")
	private int state; // 1-Available 2-Rented 3-Maintenance

	@NotNull
	@NotBlank
	@Size(min = 3, max = 20)
	private String modelName;
}
