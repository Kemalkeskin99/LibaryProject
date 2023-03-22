package kemalkeskin.rentABook.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rentABook.entitities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User>getByLastName(String lastName);
	
	List<User>findByBirthOfYearBetween(Integer startbirthOfYear, Integer endbirthOfYear);
	
	User getByNationalId(String nationalId);

}
