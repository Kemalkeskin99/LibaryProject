package kemalkeskin.rentABook.business.abstracts;

import java.util.List;

import kemalkeskin.rentABook.business.requests.author.CreateAuthorRequest;
import kemalkeskin.rentABook.business.requests.author.UpdateAuthorRequest;
import kemalkeskin.rentABook.business.responses.author.GetAllAuthorResponse;
import kemalkeskin.rentABook.business.responses.author.GetByIdAuthorResponse;

public interface AuthorService {
	List<GetAllAuthorResponse>getAll();
	GetByIdAuthorResponse getById(int id);
	void add(CreateAuthorRequest createAuthorRequest);
	void update(int id,UpdateAuthorRequest updateAuthorRequest);
	void delete(int id);

}
