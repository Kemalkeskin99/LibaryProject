package kemalkeskin.rentABook.business.rules.books;

import java.util.List;

import org.springframework.stereotype.Service;

import kemalkeskin.rentABook.core.exception.BusinessException;
import kemalkeskin.rentABook.dataAccess.abstracts.BookRepository;
import kemalkeskin.rentABook.entitities.concretes.Book;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookBusinessRules {

	private BookRepository bookRepository;

	public void IdExists(int id) {

		if (!bookRepository.findById(id).isPresent()) {
			throw new BusinessException("Id don't Exists");
		}
	}

	public void repeatName(String bookName) {
		List<Book> bookList = bookRepository.findAll();
		for (Book book : bookList) {
			if (book.getBookName().equals(bookName)) {
				throw new BusinessException("book available");
			}
		}
	}
	
	

	

}
