package com.java.stock.yahoo.stock.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.java.stock.yahoo.stock.api.dto.StockDTO;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * Hello world!
 *
 */
public class YahooStockAPI 
{
	public StockDTO getStock(String stockName) throws IOException
	{
		Stock stock = YahooFinance.get(stockName);
		StockDTO dto = new StockDTO(stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChange(), stock.getCurrency());
		return dto;
	}
	
	public void getHistory(String stockName) throws IOException
	{
		Stock stock = YahooFinance.get(stockName);
		List<HistoricalQuote> history = stock.getHistory();
		for (HistoricalQuote quote : history) {
			System.out.println("symbol " + quote.getSymbol());
			System.out.println("date " + convertDate(quote.getDate()));
			System.out.println("closed price " + quote.getClose());
			System.out.println("high price " + quote.getHigh());
			System.out.println("low price " + quote.getLow());
			System.out.println("opened price " + quote.getOpen());
			System.out.println("==============");
		}
	}
	
	/**
	 * get stock history for the given time frame and interval
	 * @param stockName
	 * @param from
	 * @param to
	 * @param interval
	 * @throws IOException
	 */
	public void getHistory(String stockName, Calendar from, Calendar to, Interval interval) throws IOException
	{
		Stock stock = YahooFinance.get(stockName);
		List<HistoricalQuote> history = stock.getHistory(from, to, interval);
		for (HistoricalQuote quote : history) {
			System.out.println("symbol " + quote.getSymbol());
			System.out.println("date " + convertDate(quote.getDate()));
			System.out.println("closed price " + quote.getClose());
			System.out.println("high price " + quote.getHigh());
			System.out.println("low price " + quote.getLow());
			System.out.println("opened price " + quote.getOpen());
			System.out.println("==============");
		}
	}
	
	public static String convertDate(Calendar cal)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String string = format.format(cal.getTime());
		return string;
	}
	
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Stock Info:" );
        YahooStockAPI stockAPI = new YahooStockAPI();
        System.out.println(stockAPI.getStock("WIX"));
        Calendar from = Calendar.getInstance();
        from.add(Calendar.MONTH, -1);
        Calendar to = Calendar.getInstance();
        Interval interval = Interval.DAILY;
        stockAPI.getHistory("WIX", from, to, interval);
    }
}
