package telran.fin_tech;

import telran.fin_tech.service.URLWriter;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDate;

public class URIWriterTest {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {

        URLWriter urlWriter = new URLWriter("%5EGSPC", LocalDate.parse("2023-08-02"), LocalDate.parse("2023-08-04"),"1d");
        System.out.println(urlWriter.getURLHistoryByPeriod().toString());
        assert(urlWriter.getURLHistoryByPeriod().toString().equals("https://finance.yahoo.com/quote/%5EGSPC/history?period1=1690934400&period2=1691107200&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true"));
        System.out.println( urlWriter.getURLHistoryByPeriod().toString().equals("https://finance.yahoo.com/quote/%5EGSPC/history?period1=1690934400&period2=1691107200&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true"));
    }
}


