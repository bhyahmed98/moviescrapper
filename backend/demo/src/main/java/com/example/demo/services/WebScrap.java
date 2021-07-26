package com.example.demo.services;

import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScrap {
	private static String[] category;
<<<<<<< HEAD
	private static String director;
	private static ArrayList<String> actors = new ArrayList<String>();
	private static ArrayList<String> languages = new ArrayList<String>();
=======
	private static String originalLanguage;
	private static String director;
	private static ArrayList<String> actors = new ArrayList<String>();
	private static String rating;
>>>>>>> 9f2d7eafedc172aea8819eb6d54dafb902f52644

	private static String imdbRating;

	public static void main(String[] args) {
<<<<<<< HEAD
		ScrapeImdb("https://www.imdb.com/title/tt3554046/?ref_=adv_li_tt", "");

	}

	public static void ScrapeImdb(String movieurl, String url) {
		try {
			languages = new ArrayList<String>();
=======
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
>>>>>>> 9f2d7eafedc172aea8819eb6d54dafb902f52644
			final Document doc = Jsoup.connect(movieurl).get();
			if (doc != null) {
				String s = doc.select("li.ipc-inline-list__item").text();
				boolean t = false;
				try {
					t = s.substring(0, Math.min(s.length() - 1, s.indexOf("Cast"))).contains("min");

<<<<<<< HEAD
				} catch (Exception e) {
					return;
				}
				if (!t) {
					return;
				}

				int i = 0;
				for (Element e : doc.select("div.StyledComponents__CastItemSummary-y9ygcu-9.fBAofn a")) {
					i += 1;
					if ((i % 2) == 1) {

						actors.add(e.text());
						System.out.println(e.text());
					}

				}
				category = doc.select("a.GenresAndPlot__GenreChip-cum89p-3.fzmeux.ipc-chip.ipc-chip--on-baseAlt").text()
						.split(" ");
				director = doc.select(
						"a.ipc-metadata-list-item__list-content-item.ipc-metadata-list-item__list-content-item--link")
						.first().text();
				String type;
				type = doc.select("li.ipc-inline-list__item").first().text();
				// System.out.println(type);
				// System.out.println(doc.select("li.ipc-inline-list__item").text());

				try {
					imdbRating = doc.select("span.AggregateRatingButton__RatingScore-sc-1ll29m0-1.iTLWoV").first()
							.text();
				} catch (Exception e) {
					imdbRating = "-";
				}
				String[] str = {};
				for (Element e : doc.select("div")) {
					if (e.attr("data-testid").equals("title-details-section")) {

						str = e.text().split(" ");

					}
				}
				// for (String ch: str) {System.out.println(ch);}
				int k = 0;
				boolean test = false;

				while (k < str.length) {
					k += 1;
					if (str[k].contains("Language")) {
						test = true;
					} else if (str[k].contains("Also")) {
						break;
					} else if (str[k].contains("Filming")) {
						break;
					} else if (str[k].contains("Production")) {
						break;
					} else if (str[k].contains("See")) {
						break;
					} else if (test == true) {
						languages.add(str[k]);
					}
					// else {System.out.println("no languages");}

				}

				for (String j : category) {
					System.out.println(j);
				}
				System.out.println(director);
				System.out.println(imdbRating);
				for (String j : languages) {
					System.out.println(j);
				}

=======
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

>>>>>>> 9f2d7eafedc172aea8819eb6d54dafb902f52644
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
<<<<<<< HEAD
}
=======

}
>>>>>>> 9f2d7eafedc172aea8819eb6d54dafb902f52644
