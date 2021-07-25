package com.example.demo.services;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TranslateMovie {
	private static String translatedMovie;
	private static String movieLink;
	private static String movieYear;
  
	public static void main(String[] args) {
		String text = "un flic a la maternelle 2";
		movieTranslation(text);
		System.out.println(translatedMovie);
		System.out.println(movieYear);
				
	}

	public static void movieTranslation(String text) {
		final String url = "https://www.imdb.com/find?q=";
		String trtext = "";
		String link="";
		String year="";
		try {
			final Document document = Jsoup.connect(url + text.replace(" ", "+") + "&ref_=nv_sr_sm")
					.get();
			int i = 0;
			for (Element e : document.select("td.result_text a")) {
				i += 1;
			    link = e.absUrl("href");
			    movieLink=link;
			    
				if (i == 1) {
					trtext = (e.text());
					translatedMovie=trtext;
					break;
				}	
			}}
			catch (Exception ex) {
			System.out.println("error");
		}
		try 
		{   
			final Document document = Jsoup.connect(movieLink).get();
			int i = 0;
			for (Element e : document.select("span.TitleBlockMetaData__ListItemText-sc-12ein40-2.jedhex")) {
				i+=1;
				if(i == 1) {
					year=e.text();
					movieYear=year;
					break;}
			}
		}
		catch (Exception ex) {
			System.out.println("error");

			
		}

	}
}
