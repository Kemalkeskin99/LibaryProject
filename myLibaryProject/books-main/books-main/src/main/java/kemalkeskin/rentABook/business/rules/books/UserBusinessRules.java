package kemalkeskin.rentABook.business.rules.books;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kemalkeskin.rentABook.core.exception.BusinessException;
import kemalkeskin.rentABook.dataAccess.abstracts.UserRepository;
import kemalkeskin.rentABook.entitities.concretes.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserBusinessRules {

	private UserRepository userRepository;
	
	public void isExistsId(int id) {
		
		Optional<User> user=this.userRepository.findById(id);
			if(!user.isPresent()) {
				throw new BusinessException("Don't exists Id");
			}	
	}
	
	
	public void isSuitableNationalId(String nationalId){
		
			List<User>users=this.userRepository.findAll();
			for (User user : users) {
					if(user.getNationalId().equals(nationalId)) {
						throw new BusinessException("Please enter valid National Id,this national ıd  system is also avaliable");
					}else{
							if(nationalId.length()!=11) {
								throw new BusinessException("National Id is maximum and minimum length 11");
							}
					}
			}	
	}
	
	public void isLengthFirstNameandLastName(String firstName,String lastName) {
		if(firstName.length()<=1) {
			throw new BusinessException("firstnames is mimumum length 2 ");
		}
			
	}
}
