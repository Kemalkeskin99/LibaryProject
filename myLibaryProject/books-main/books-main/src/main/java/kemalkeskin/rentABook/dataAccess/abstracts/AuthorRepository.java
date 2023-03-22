package kemalkeskin.rentABook.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rentABook.entitities.concretes.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
