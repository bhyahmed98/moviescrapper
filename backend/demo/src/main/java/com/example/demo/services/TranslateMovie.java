package com.example.demo.services;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TranslateMovie {
    private static String translatedMovie;
    private static String movieLink;
    private static String movieYear;
    private static WebScrap webscrap = new WebScrap();

    public static void main(String[] args) {
        String text = "un flic a la maternelle 2";
        
        System.out.println(getTranslatedMovie());
        System.out.println(movieYear);

    }

    public static void movieTranslation(String text,String url) {
    	translatedMovie="Not Found";
        final String urll = "https://www.imdb.com/find?q=";
        String trtext = "";
        String link="";
        String year="";
        try {
            final Document document = Jsoup.connect(urll + text.replace(" ", "+") + "&ref_=nv_sr_sm")
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
               
            }
            webscrap.ScrapeImdb(movieLink, url);
            
        
        }
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

	public static String getTranslatedMovie() {
		return translatedMovie;
	}

	public static void setTranslatedMovie(String translatedMovie) {
		TranslateMovie.translatedMovie = translatedMovie;
	}
}