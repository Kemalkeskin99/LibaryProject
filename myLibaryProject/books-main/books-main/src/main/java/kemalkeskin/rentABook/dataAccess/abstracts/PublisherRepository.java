package kemalkeskin.rentABook.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rentABook.entitities.concretes.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

}
