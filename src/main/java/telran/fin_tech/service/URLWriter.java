package telran.fin_tech.service;

import lombok.ToString;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

@ToString
public class URLWriter {
	public String ticker;
	public LocalDate dateFrom;
	public LocalDate dateTo;
	public String interval;
	public String  filter = "history";
	public String frequency;
	public String includeAdjustedClose = "true";

	public URLWriter(String ticker, LocalDate dateFrom, LocalDate dateTo, String interval)  {
		super();
		this.ticker = ticker;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.interval = interval;
		frequency = this.interval;
	}

	public URL getURLHistoryByPeriod() throws  MalformedURLException, URISyntaxException {
			String base ="https://finance.yahoo.com/quote/" + ticker.replace("^", "%5E").replace("=", "%3D") + "/history" ;
		 String period1 = this.dateToSeconds(dateFrom);
		String period2 = this.dateToSeconds(dateTo);
			URL url = new URIBuilder(base)
				.addParameter("period1", period1)
				.addParameter("period2", period2)
				.addParameter("interval", interval)
				.addParameter("filter", filter)
				.addParameter("frequency", frequency)
				.addParameter("includeAdjustedClose",includeAdjustedClose)
				.build()
				.toURL();
		System.out.println(url);
		return url;
	}
	private String dateToSeconds (LocalDate date){
		Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant().plusSeconds(10800);
		long seconds = instant.getEpochSecond();
		return Long.toString(seconds);
	}
}

