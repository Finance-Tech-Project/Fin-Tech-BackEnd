package telran.fin_tech.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import telran.fin_tech.parsing.dto.StockQuoteDto;
import telran.fin_tech.parsing.dto.StockQuoteDtoOnce;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class HTMLParser {
    public String ticker;
    public LocalDate dateFrom;
    public LocalDate dateTo;
    public String interval;
    public String filter;
    public String frequency;
    public String includeAdjustedClose;

    public HTMLParser(String ticker, LocalDate dateFrom, LocalDate dateTo, String interval) {
        this.ticker = ticker;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.interval = interval;
        this.filter = "history";
        this.frequency = this.interval;
        this.includeAdjustedClose = "true";
    }


    public List<StockQuoteDtoOnce> parseTable() throws URISyntaxException, IOException {
        final ModelMapper mapper = new ModelMapper();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.ENGLISH);

        Document doc = Jsoup.connect(new URLWriter(this.ticker, this.dateFrom, this.dateTo, this.interval).getURLHistoryByPeriod().toString()).get();
        Element table = doc.select("table").first(); //находим первую таблицу в документе, если надо вторую, третью или т.д. используем .get(номер)
        Elements rows = null;
        if (table != null) {
            rows = table.select("tr");
        }

        List<StockQuoteDtoOnce> data = new ArrayList<>();
        if (rows != null) {
            for (int i = 1; i < rows.size()-1 ; i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                List<String> quote = (cols.stream()
                        .map(col -> col.text().replace(",",""))
                        .map(col -> col.replace(".",","))

                        .collect(Collectors.toList()));
                StockQuoteDtoOnce stockQuoteDtoOnce = new StockQuoteDtoOnce(LocalDate.parse(quote.get(0), formatter), quote.get(1), quote.get(2), quote.get(3), quote.get(4), quote.get(6));

                data.add(stockQuoteDtoOnce);
            }
        }
        System.out.println(data);
        String json=mapper.map(new StockQuoteDto(data),StockQuoteDto.class).toString();
        System.out.println(json);
        return data;
    }
}





