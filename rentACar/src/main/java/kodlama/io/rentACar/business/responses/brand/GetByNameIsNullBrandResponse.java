package kodlama.io.rentACar.business.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNameIsNullBrandResponse {
	private int id;
	private String name;
}
