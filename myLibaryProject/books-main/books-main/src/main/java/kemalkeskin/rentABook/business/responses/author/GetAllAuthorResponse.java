package kemalkeskin.rentABook.business.responses.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAuthorResponse {
	
	private int id;
	private String authorName;
	//private List<Book>books;

}
