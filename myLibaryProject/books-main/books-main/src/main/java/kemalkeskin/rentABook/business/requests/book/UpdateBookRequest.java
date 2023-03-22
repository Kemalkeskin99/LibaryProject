package kemalkeskin.rentABook.business.requests.book;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {

	@JsonIgnore
	private int id;
	
	private int authorId;
	
	
	private String name;
	

	private double price;

	
	private int state;
}
