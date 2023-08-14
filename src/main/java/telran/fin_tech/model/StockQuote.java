package telran.fin_tech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//  @Table (name = ? )
public class StockQuote {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Id
	LocalDate date;
	private String name;
	private String symbol;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;

}
