package kemalkeskin.rentABook.business.requests.publisher;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePublisherRequest {

	@JsonIgnore
	private int id;
	private String publisherName;
}
