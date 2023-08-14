package telran.fin_tech.parsing.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockQuoteDtoOnce {
  String date;
  String open;
  String low;
  String high;
  String close;
  String volume;
}
