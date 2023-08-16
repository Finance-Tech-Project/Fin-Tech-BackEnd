package telran.fin_tech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Table(name = "history_data" )
public class StockQuote {

	@EmbeddedId
    private HistoryDataId id;
//	private LocalDate date;
//	private String ticker;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
}
