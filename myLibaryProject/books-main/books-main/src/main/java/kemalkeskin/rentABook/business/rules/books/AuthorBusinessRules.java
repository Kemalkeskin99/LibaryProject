package kemalkeskin.rentABook.business.rules.books;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kemalkeskin.rentABook.core.exception.BusinessException;
import kemalkeskin.rentABook.dataAccess.abstracts.AuthorRepository;
import kemalkeskin.rentABook.entitities.concretes.Author;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorBusinessRules {

	private AuthorRepository  authorRepository;
	
	public void isExistsId(int id) {
		Optional<Author> author=authorRepository.findById(id);
		if(!author.isPresent()) {
			throw new BusinessException("Don't exists Id");
		}
	}
	
	public void isRepeatAuthorName(String name) {
		
		List<Author>authorList=authorRepository.findAll();
		for (Author author : authorList) {
			if(author.getAuthorName().equals(name)) {
				throw new BusinessException("Author available");
			}
		}
	}
	
	
	
}
