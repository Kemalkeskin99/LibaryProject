package kemalkeskin.rentABook.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.rentABook.business.abstracts.AuthorService;
import kemalkeskin.rentABook.business.requests.author.CreateAuthorRequest;
import kemalkeskin.rentABook.business.requests.author.UpdateAuthorRequest;
import kemalkeskin.rentABook.business.responses.author.GetAllAuthorResponse;
import kemalkeskin.rentABook.business.responses.author.GetByIdAuthorResponse;
import kemalkeskin.rentABook.business.rules.books.AuthorBusinessRules;
import kemalkeskin.rentABook.core.mapper.ModelMapperService;
import kemalkeskin.rentABook.dataAccess.abstracts.AuthorRepository;
import kemalkeskin.rentABook.entitities.concretes.Author;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService {

	private AuthorRepository authorRepository;
	private ModelMapperService modelMapperService;
	private AuthorBusinessRules authorBusinessRules;

	@Override
	public List<GetAllAuthorResponse> getAll() {
		List<Author> authors = authorRepository.findAll();
		List<GetAllAuthorResponse> getAllAuthorResponses = authors.stream()
				.map(author -> this.modelMapperService.forResponse().map(author, GetAllAuthorResponse.class))
				.collect(Collectors.toList());
		return getAllAuthorResponses;

	}
	
	@Override
	public GetByIdAuthorResponse getById(int id) {
		this.authorBusinessRules.isExistsId(id);
		Author author=authorRepository.findById(id).orElseThrow();
		GetByIdAuthorResponse getByIdAuthorResponse=modelMapperService.forResponse().map(author, GetByIdAuthorResponse.class);
		return getByIdAuthorResponse;
	}
	
	

	@Override
	public void add(CreateAuthorRequest createAuthorRequest) {
		this.authorBusinessRules.isRepeatAuthorName(createAuthorRequest.getAuthorName());
		Author author = this.modelMapperService.forRequest().map(createAuthorRequest, Author.class);
		this.authorRepository.save(author);

	}

	@Override
	public void update(int id, UpdateAuthorRequest updateAuthorRequest) {
		this.authorBusinessRules.isExistsId(id);
		Author author=modelMapperService.forRequest().map(updateAuthorRequest, Author.class);
		this.authorRepository.save(author);
		
	}

	@Override
	public void delete(int id) {
	this.authorBusinessRules.isExistsId(id);
	this.authorRepository.deleteById(id);
	
		
	}

	


	

}
