package kemalkeskin.rentABook.business.requests.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
	@JsonIgnore
	private int id;
	
	private String firstName;
	private String lastName;
	private String nationalId;
	private int birthOfYear;

}
