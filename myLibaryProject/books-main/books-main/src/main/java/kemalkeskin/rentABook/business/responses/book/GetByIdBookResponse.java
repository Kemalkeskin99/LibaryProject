package kemalkeskin.rentABook.business.responses.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBookResponse {
	private int bookId;
	private String bookName;
	private double bookPrice;
	private String authorName;
	private int state;
}
