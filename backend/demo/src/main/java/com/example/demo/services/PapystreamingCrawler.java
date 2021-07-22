package com.example.demo.services;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.example.demo.model.Film;

public class PapystreamingCrawler {

	private static ArrayList<String> url_list = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		String url = "https://vvw.papystreaming.stream/rouge-sang/";
		//scrapping(url);
		crawl(1, url, new ArrayList<String>());
		System.out.println(url_list.size());

	}

	private static void crawl(int level, String url, ArrayList<String> visited) {
		if (level <= 15) {

			Document doc = request(url, visited);
			if (doc != null) {
				for (Element link : doc.select("a[href]")) {
					String next_link = link.absUrl("href");
					if ((visited.contains(next_link) == false) && (next_link.contains("https://vvw.papystreaming.stream"))) {
						level++;
						visited.add(next_link);
						crawl(level, next_link, visited);
					}
				}

			}
		}
	}

	private static Document request(String url, ArrayList<String> v) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			if (con.response().statusCode() == 200) {
				if (test_url(url)) {
					System.out.println("Link " + url);
					scrapping(url);
					url_list.add(url);
					System.out.println(url_list.size());
				}
				return doc;

			}
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public static boolean test_url(String url) {
		if (url.contains("/cat/"))
			return false;
		if (url.contains("/voirseries/"))
			return false;
		if (url.contains("/connection/"))
			return false;
		if (url.contains("/voirfilms/"))
			return false;
		if (url.contains("/#"))
			return false;
		if (url == "https://vvw.papystreaming.stream/")
			return false;

		return true;
	}

	
	public static void scrapping(String url) {
		
		
		
		try {
			final Document doc = Jsoup.connect(url).get();
			if (doc != null) {
				String Annee = "", Langues="", SD="", Pays="", Genre="", Realisateur = "";
				String name = url.substring(33, url.length() - 1).replace("-", " ");
				String[] acteurs;
				for (Element e : doc.select("p.infosql")) {
					//System.out.println(e.text());
					if (e.text().contains("Années"))
						Annee = e.text().substring("Années:".length()).trim();
					if (e.text().contains("Langues"))
						Langues = e.text().substring("Langues:".length()).trim();
					if (e.text().contains("Qualités"))
						SD = e.text().substring("Qualités:".length()).trim();
					if (e.text().contains("Pays:"))
						Pays = e.text().substring("Pays:".length()).trim();
					if (e.text().contains("Genre"))
						Genre = e.text().substring("Genre:".length()).trim();
					if (e.text().contains("Acteurs"))
						acteurs = e.text().substring("Acteurs:".length()).split(",");
					if (e.text().contains("Realisateur"))
						Realisateur = e.text().substring("Realisateur:".length()).trim();
				}
				
				/*
				System.out.println(Annee);
				System.out.println(Langues);
				System.out.println(SD);
				System.out.println(Pays);
				System.out.println(Genre);
				System.out.println(Realisateur);
				*/
				Film film=new Film();
				FilmService fs = new FilmService();
				film.setNameFilm(name);
				film.set
				film.setLanguage(Langues);
				fs.Add(film);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
