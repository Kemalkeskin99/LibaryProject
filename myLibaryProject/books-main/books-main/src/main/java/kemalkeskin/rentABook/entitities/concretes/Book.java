package kemalkeskin.rentABook.entitities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String bookName;
	
	@Column(name = "price")
	private double bookPrice;
	
	@Column(name = "state")
	private int state;   // 1- rentabled // 2- cannot rented
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

}

