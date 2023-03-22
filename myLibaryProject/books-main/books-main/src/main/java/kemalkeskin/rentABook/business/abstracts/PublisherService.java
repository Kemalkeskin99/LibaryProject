package kemalkeskin.rentABook.business.abstracts;

import java.util.List;

import kemalkeskin.rentABook.business.requests.publisher.CreatePublisherRequest;
import kemalkeskin.rentABook.business.requests.publisher.UpdatePublisherRequest;
import kemalkeskin.rentABook.business.responses.publisher.GetAllPublisherResponse;
import kemalkeskin.rentABook.business.responses.publisher.GetByIdPublisherResponse;

public interface PublisherService {

	List<GetAllPublisherResponse>getAll();
	
	GetByIdPublisherResponse getById(int id);
	
	void add(CreatePublisherRequest createPublisherRequest);
	
	void update(int id,UpdatePublisherRequest updatePublisherRequest);
	
	void delete(int id);
}
