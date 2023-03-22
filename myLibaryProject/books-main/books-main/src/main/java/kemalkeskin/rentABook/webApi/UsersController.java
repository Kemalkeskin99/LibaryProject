package kemalkeskin.rentABook.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kemalkeskin.rentABook.business.abstracts.UserService;
import kemalkeskin.rentABook.business.requests.user.CreateUserRequest;
import kemalkeskin.rentABook.business.requests.user.UpdateUserRequest;
import kemalkeskin.rentABook.business.responses.user.GetAllUserBetweenBirthOfYear;
import kemalkeskin.rentABook.business.responses.user.GetAllUserLastName;
import kemalkeskin.rentABook.business.responses.user.GetAllUserResponse;
import kemalkeskin.rentABook.business.responses.user.GetByIdUserResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

	private UserService userService;
	
	 @GetMapping("/getall")
	 public List<GetAllUserResponse> getAll(){
		 return userService.getAll();
	 }
	 
	 @GetMapping("/{id}")
	 public GetByIdUserResponse getById(@PathVariable int id) {
		return this.userService.getById(id);
	 }
	 
	 @PostMapping
	 @ResponseStatus(code = HttpStatus.CREATED)
	 public void add(@RequestBody @Valid CreateUserRequest createUserRequest) {
		 this.userService.add(createUserRequest);
	 }
	 
	 @PutMapping
	 public void update(int id, UpdateUserRequest updateUserRequest) {
		 this.userService.update(id, updateUserRequest);
	 }
	 
	 @DeleteMapping
	 public void delete( int id) {
		 this.userService.delete(id);
	 }
	 
	 @GetMapping("/getalluserlastname")
	 public List<GetAllUserLastName> getByUserLastName(@RequestParam String lastName){
		 return userService.getByUserLastName(lastName);
	 }
	 
	 @GetMapping("/getallusersbetweenbirthofyear")
	 public List<GetAllUserBetweenBirthOfYear> findByBirthOfYearBetween(@RequestParam Integer startbirthOfYear, @RequestParam Integer endbirthOfYear){
		return userService.findByBirthOfYearBetween(startbirthOfYear, endbirthOfYear);
	 }
	 
}
