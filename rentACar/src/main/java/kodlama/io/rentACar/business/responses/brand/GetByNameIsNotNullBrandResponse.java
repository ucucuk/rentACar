package kodlama.io.rentACar.business.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNameIsNotNullBrandResponse {
	private int id;
	private String name;
}
