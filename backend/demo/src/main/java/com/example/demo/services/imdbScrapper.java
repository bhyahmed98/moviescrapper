package com.example.demo.services;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class imdbScrapper {

	// private static String Annees="";
	// private static String Annees="";

	public static void main(String[] args) {
		scrap("the prison","");
	}

	final String url = "https://www.rottentomatoes.com/m/the_prison";

	// System.out.println(url.substring(33,url.length()-1).replace("-", " "));

	final static void scrap(String name, String url2) {
		
		String url = "https://www.rottentomatoes.com/m/"+name.replace(" ", "_");
		System.out.println(url);
		url="https://www.imdb.com/title/tt1520211/?ref_=hm_hp_cap_pri_1";
		
		try {
			final Document doc = Jsoup.connect(url).get();
			if (doc != null) {
				String Rating = "", Langues = "", Director = "", Date = "", Runtime = "", Realisateur = "";
				String[] Category, Producer, Writer, Production_co;

				for (Element e : doc.select("a.title-cast-item__actor")) {
					//if ((e.text().contains("Rating:")) && (e.text().contains(" Rating: ") == false))
					System.out.println(e.text());
					/*
					if (e.text().contains("Genre:"))
						System.out.println(e.text());
					if (e.text().contains("Original Language:"))
						System.out.println(e.text());
					if (e.text().contains("Director:"))
						System.out.println(e.text());
					if (e.text().contains("Producer:"))
						System.out.println(e.text());
					if (e.text().contains("Writer:"))
						System.out.println(e.text());
					if (e.text().contains("Release Date (Theaters):"))
						System.out.println(e.text());
					if (e.text().contains("Runtime:"))
						System.out.println(e.text());
					if (e.text().contains("Production Co:"))
						System.out.println(e.text());
					
					*/
					
					
					/*
					 * if (e.text().contains("Années")) Annee =
					 * e.text().substring("Années:".length()).trim(); if
					 * (e.text().contains("Langues")) Langues =
					 * e.text().substring("Langues:".length()).trim(); if
					 * (e.text().contains("Qualités")) SD =
					 * e.text().substring("Qualités:".length()).trim(); if
					 * (e.text().contains("Pays:")) Pays =
					 * e.text().substring("Pays:".length()).trim(); if (e.text().contains("Genre"))
					 * Genre = e.text().substring("Genre:".length()).trim(); if
					 * (e.text().contains("Acteurs")) acteurs =
					 * e.text().substring("Acteurs:".length()).split(","); if
					 * (e.text().contains("Realisateur")) Realisateur =
					 * e.text().substring("Realisateur:".length()).trim();
					 * 
					 */

				
				}
				

				System.out.println("Actors:");
				for (Element e : doc.select("div.media-body")) {
					String[] l = e.text().split(" ");
					if (l.length <= 5)
						System.out.println(l[0] + " " + l[1]);
				}
				

				/*
				 * System.out.println(Annee); System.out.println(Langues);
				 * System.out.println(SD); System.out.println(Pays); System.out.println(Genre);
				 * System.out.println(Realisateur);
				 */
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	
	}
	

}
	
