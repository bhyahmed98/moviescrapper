package com.example.demo.services;

import java.io.IOException;

import org.hibernate.validator.internal.util.logging.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CommonName {
	
	private String commonName;
	private String scrappedUrl;
	
	public static void main(String[] args) {
		findCommonName("just in time","url");
	}
	
	public static void findCommonName(String name,String url) {
		String url1="https://www.rottentomatoes.com/search?search="+name.replace(" ","%20");
		
		
		


		
		
		
		try {
			final Document doc = Jsoup.connect(url1).get();
			
			

			
			for (Element e : doc.select("div.search__container layout")) {
				System.out.println(e.text());
			}
			
			
		
		
		
		
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
