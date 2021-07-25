package com.example.demo.services;

import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrap {
	private static String[] category;
	private static String originalLanguage;
	private static String director;
	private static ArrayList<String> actors = new ArrayList<String>();
	private static String rating;

	// private static String Annees="";
	// private static String Annees="";

	public static void main(String[] args) {
		// String url = "https://www.rottentomatoes.com/m/the_prison";
		// movieScrape(url);
		System.out.println(check("black widow", "2019"));

		// System.out.println(url.substring(33,url.length()-1).replace("-", " "));
	}

	public static String check(String moviename, String year) {
		String url = ("https://www.rottentomatoes.com/m/" + moviename.replace(" ", "_"));

		try {
			Connection con2 = Jsoup.connect(url);
			Document doc2 = con2.get();

			if (con2.response().statusCode() == 200) {

			} else {
				url = "invalid url";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection con = Jsoup.connect(url + "_" + year);
			Document doc = con.get();
			if (con.response().statusCode() == 200) {
				url = url + "_" + year;
			} else {
				url = "invalid url";
			}
		} catch (Exception e) {

		}

		return url;
	}

	public static void movieScrape(String movieurl) {
		try {
			final Document doc = Jsoup.connect(movieurl).get();
			if (doc != null) {
				String Rating = "", Langues = "", Director = "", Date = "", Runtime = "", Realisateur = "";
				String[] Category, Producer, Writer, Production_co;

				for (Element e : doc.select("li")) {
					if ((e.text().contains("Rating:")) && (e.text().contains(" Rating: ") == false))
						rating = e.text().replace("Rating:", "");

					if (e.text().contains("Genre:")) {
						String genre = "";
						genre = e.text().replace("Genre:", "");
						genre = e.text().replace("&", ",");
						category = genre.split(",");
					}
					
					if (e.text().contains("Original Language:"))
						originalLanguage = e.text().replace("Original Language:", "");
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
					 */ }

				for (Element e : doc.select("div.media-body")) {
					String[] l = e.text().split(" ");
					if (l.length <= 5) {
						String actorName="";
						actorName= (l[0] + " " + l[1]);
						actors.add(actorName); 
						}
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
