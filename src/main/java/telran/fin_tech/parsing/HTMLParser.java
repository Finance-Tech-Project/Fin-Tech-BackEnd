package telran.fin_tech.parsing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import telran.fin_tech.parsing.dto.StockQuoteDto;
import telran.fin_tech.parsing.dto.StockQuoteDtoOnce;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class HTMLParser {
    public String ticker;
    public String dateFrom;
    public String dateTo;
    public String interval;
    public String filter;
    public String frequency;
    public String includeAdjustedClose;

    public HTMLParser(String ticker, String dateFrom, String dateTo, String interval) {
        this.ticker = ticker;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.interval = interval;
        this.filter = "history";
        this.frequency = this.interval;
        this.includeAdjustedClose = "true";
    }

    public StockQuoteDto parseTable(String ticker, String dateFrom, String dateTo, String interval) throws URISyntaxException, IOException {
        final ModelMapper mapper = new ModelMapper();

        Document doc = Jsoup.connect(new URLWriter(ticker, dateFrom, dateTo, interval).getURLHistoryByPeriod().toString()).get();
        Element table = doc.select("table").first(); //находим первую таблицу в документе, если надо вторую, третью или т.д. используем .get(номер)
        Elements rows = null;
        if (table != null) {
            rows = table.select("tr");
        }

        List<StockQuoteDtoOnce> data = new ArrayList<>();
        if (rows != null) {
            for (int i = 1; i < rows.size() - 1; i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                List<String> quote = (cols.stream()
                        .map(col -> col.text().replace(",",""))
                        .map(col -> col.replace(".",","))
                        .collect(Collectors.toList()));
                StockQuoteDtoOnce stockQuoteDtoOnce = new StockQuoteDtoOnce(quote.get(0), quote.get(1), quote.get(2), quote.get(3), quote.get(4), quote.get(6));
                data.add(stockQuoteDtoOnce);
            }
        }

        return mapper.map(new StockQuoteDto(data),StockQuoteDto.class);
    }
}





