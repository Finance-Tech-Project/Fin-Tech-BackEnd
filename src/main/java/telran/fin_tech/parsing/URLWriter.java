package telran.fin_tech.parsing;

import lombok.ToString;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@ToString
public class URLWriter {
	public String ticker;
	public String dateFrom;
	public String dateTo;
	public String interval;
	public String  filter = "history";
	public String frequency;
	public String includeAdjustedClose = "true";

	public URLWriter(String ticker, String dateFrom, String dateTo, String interval)  {
		super();
		this.ticker = ticker;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.interval = interval;
		frequency = this.interval;
	}

	public URL getURLHistoryByPeriod() throws  MalformedURLException, URISyntaxException {
			String base ="https://finance.yahoo.com/quote/" + ticker + "/history" ;
		return new URIBuilder(base)
				.addParameter("period1", dateFrom)
				.addParameter("period2", dateTo)
				.addParameter("interval", interval)
				.addParameter("filter", filter)
				.addParameter("frequency", frequency)
				.addParameter("includeAdjustedClose",includeAdjustedClose)
				.build()
				.toURL();
	}
}
