package telran.fin_tech;

import telran.fin_tech.parsing.HTMLParser;

// Convert string to `Date` in Java using DateTimeFormatter
class HTMLParserTestClass {
	static HTMLParser parser = new HTMLParser("%5EGSPC","1690934400","1691712000","1d");
	public static void main (String args []) throws Exception {
	String url1 = "http://www.theserverside.com/video/IBM-Watson-Content-Hub-has-problems-before-you-even-start";
	//	    WebClient webClient = new WebClient();
	//	    webClient.getOptions().setUseInsecureSSL(true);
	//	    webClient.getOptions().setCssEnabled(false);
	//	    webClient.getOptions().setJavaScriptEnabled(false);
	//
	//	    HtmlPage htmlPage = webClient.getPage(url1);
	//	    System.out.println(htmlPage.getTitleText ( ));

		String url2 = "https://finance.yahoo.com/quote/%5EGSPC/history?period1=1690934400&period2=1691712000&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true";

		System.out.println(parser.parseTable(parser.getTicker(), parser.getDateFrom(), parser.getDateTo(), parser.getInterval()));
	}

}
