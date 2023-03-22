package kemalkeskin.rentABook.business.rules.books;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kemalkeskin.rentABook.core.exception.BusinessException;
import kemalkeskin.rentABook.dataAccess.abstracts.PublisherRepository;
import kemalkeskin.rentABook.entitities.concretes.Publisher;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherBusinessRules {

	private PublisherRepository publisherRepository;
	
	public void isExistsId(int id) {
		Optional<Publisher> publisher=this.publisherRepository.findById(id);
		if(!publisher.isPresent()) {
			throw new BusinessException("don't exists Id");
		}
	}
	
	
	public void isRepeatName(String name) {
		List<Publisher>publishers=publisherRepository.findAll();
		for (Publisher publisher : publishers) {
			if(publisher.getName().equals(name)) {
				throw new BusinessException("name is  avaliable. enter a new  name please!! ");
			}
		}
		
	}
}
