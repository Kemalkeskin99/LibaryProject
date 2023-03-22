package kemalkeskin.rentABook.business.abstracts;

import java.util.List;

import kemalkeskin.rentABook.business.requests.user.CreateUserRequest;
import kemalkeskin.rentABook.business.requests.user.UpdateUserRequest;
import kemalkeskin.rentABook.business.responses.user.GetAllUserBetweenBirthOfYear;
import kemalkeskin.rentABook.business.responses.user.GetAllUserLastName;
import kemalkeskin.rentABook.business.responses.user.GetAllUserResponse;
import kemalkeskin.rentABook.business.responses.user.GetByIdUserResponse;

public interface UserService {
	
	List<GetAllUserResponse>getAll();
	GetByIdUserResponse getById(int id);
	void add(CreateUserRequest createUserRequest);
	void update(int id,UpdateUserRequest updateUserRequest);
	void delete(int id);
	List<GetAllUserLastName> getByUserLastName(String lastName);
	List<GetAllUserBetweenBirthOfYear>findByBirthOfYearBetween(Integer startbirthOfYear, Integer ebirthOfYear);

}
