package kemalkeskin.rentABook.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rentABook.entitities.concretes.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Book getByBookName(String bookName);
	
}
