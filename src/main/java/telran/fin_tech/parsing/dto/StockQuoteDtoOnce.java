package telran.fin_tech.parsing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonSerialize(using = StockQuoteDtoOnceSerializer.class)
public class StockQuoteDtoOnce {
	
  LocalDate date;
  String open;
  String low;
  String high;
  String close;
  String volume;
}
