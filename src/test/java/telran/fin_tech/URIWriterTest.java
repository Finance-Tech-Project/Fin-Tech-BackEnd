package telran.fin_tech;

import telran.fin_tech.parsing.URLWriter;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class URIWriterTest {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URLWriter urlWriter = new URLWriter("%5EGSPC","1690934400","1691712000","1d");
        assert(urlWriter.getURLHistoryByPeriod().toString().equals("https://finance.yahoo.com/quote/%5EGSPC/history?period1=1690934400&period2=1691712000&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true"));
        System.out.println( urlWriter.getURLHistoryByPeriod().toString().equals("https://finance.yahoo.com/quote/%5EGSPC/history?period1=1690934400&period2=1691712000&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true"));

    }
}
