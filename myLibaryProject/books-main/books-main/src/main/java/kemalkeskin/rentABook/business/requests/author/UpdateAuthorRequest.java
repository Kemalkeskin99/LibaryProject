package kemalkeskin.rentABook.business.requests.author;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthorRequest {
	@JsonIgnore
	private int id;
	private String authorName;
}
