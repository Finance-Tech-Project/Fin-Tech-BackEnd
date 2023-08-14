package telran.fin_tech.parsing.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockQuoteDto implements Serializable {

	private List<StockQuoteDtoOnce> history;

	public List<StockQuoteDtoOnce> getHistory() {
		return history;
	}
}
