package kemalkeskin.rentABook.business.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserLastName {

	private int id;
	private String firstName;
	private String nationalId;
	private int birthOfYear;
}
