package kemalkeskin.rentABook.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.rentABook.business.abstracts.UserService;
import kemalkeskin.rentABook.business.requests.user.CreateUserRequest;
import kemalkeskin.rentABook.business.requests.user.UpdateUserRequest;
import kemalkeskin.rentABook.business.responses.user.GetAllUserBetweenBirthOfYear;
import kemalkeskin.rentABook.business.responses.user.GetAllUserLastName;
import kemalkeskin.rentABook.business.responses.user.GetAllUserResponse;
import kemalkeskin.rentABook.business.responses.user.GetByIdUserResponse;
import kemalkeskin.rentABook.business.rules.books.UserBusinessRules;
import kemalkeskin.rentABook.core.mapper.ModelMapperService;
import kemalkeskin.rentABook.dataAccess.abstracts.UserRepository;
import kemalkeskin.rentABook.entitities.concretes.User;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserManager implements UserService{
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	
	@Override
	public List<GetAllUserResponse> getAll() {
	
		List<User>users=userRepository.findAll();
		List<GetAllUserResponse>getAllUserResponses=users.stream().map(user->this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
		return getAllUserResponses;
	}

	@Override
	public GetByIdUserResponse getById(int id) {
		User user=this.userRepository.findById(id).orElseThrow();
		GetByIdUserResponse getByIdUserResponse=this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
		return getByIdUserResponse;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {
		this.userBusinessRules.isSuitableNationalId(createUserRequest.getNationalId());
		this.userBusinessRules.isLengthFirstNameandLastName(createUserRequest.getFirstName(), createUserRequest.getLastName());
		User user=this.modelMapperService.forRequest().map(createUserRequest, User.class);
		this.userRepository.save(user);
		
	}

	@Override
	public void update(int id, UpdateUserRequest updateUserRequest) {
		 
		Optional<User> userList=userRepository.findById(id);
		if(userList.isPresent()) {
			User user=this.modelMapperService.forRequest().map(updateUserRequest, User.class);
			this.userRepository.save(user);
		}
		
	}

	@Override
	public void delete(int id) {
		this.userBusinessRules.isExistsId(id);
		this.userRepository.deleteById(id);
	}

	@Override
	public List<GetAllUserLastName> getByUserLastName(String lastName) {
		List<User>users=this.userRepository.getByLastName(lastName);
		List<GetAllUserLastName>getAllUserLastNames=users.stream().map(user->this.modelMapperService.forResponse().map(user, GetAllUserLastName.class)).collect(Collectors.toList());
		return getAllUserLastNames;
	}

	@Override
	public List<GetAllUserBetweenBirthOfYear> findByBirthOfYearBetween(Integer startbirthOfYear, Integer endbirthOfYear) {
		
		List<User>users=this.userRepository.findByBirthOfYearBetween(startbirthOfYear, endbirthOfYear);
		List<GetAllUserBetweenBirthOfYear>getAllUserBetweenBirthOfYears=users.stream().map(user->this.modelMapperService.forResponse().map(user, GetAllUserBetweenBirthOfYear.class)).collect(Collectors.toList());
		return getAllUserBetweenBirthOfYears;
	}

}
