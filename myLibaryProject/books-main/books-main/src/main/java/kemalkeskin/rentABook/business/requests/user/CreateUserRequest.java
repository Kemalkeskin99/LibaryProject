package kemalkeskin.rentABook.business.requests.user;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	@JsonIgnore
	private int id;

	private String firstName;

	private String lastName;


	private String nationalId;

	@Min(0)
	private int birthOfYear;

}
