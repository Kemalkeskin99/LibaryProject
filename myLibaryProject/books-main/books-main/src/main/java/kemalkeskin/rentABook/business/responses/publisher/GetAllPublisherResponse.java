package kemalkeskin.rentABook.business.responses.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPublisherResponse {

	private int id;
	private String name;
}
