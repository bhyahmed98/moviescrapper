package com.example.demo.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Translation {
	private static String detectedLanguage;
	private static String translatedText;

	public static void main(String[] args) {
		String text = "Le Dernier Tango à Paris";
		translate(text);
		System.out.println(translatedText);
		System.out.println(getDetectedLanguage());

	}

	public static void translate(String text) {
		final String url = "https://www.google.com/search?q=";
		String trtext = "";
		try {
			final Document document = Jsoup.connect(url + text.replace(" ", "+") + "+google+translate+to+english")
					.get();
			int i = 0;
			for (Element e : document.select("span.Y2IQFc")) {
				i += 1;

				if (i == 3) {
					trtext = (e.text());
					translatedText = trtext;
					break;
				}
			}
			Element e;
			String language = document.select("span.source-language").text();
			if (language.contains("الفرنسية")) {
				setDetectedLanguage("French");
			} else {
				setDetectedLanguage("English");
			}
		} catch (Exception ex) {
			System.out.println("that error");
		}

	}

	public static String getDetectedLanguage() {
		return detectedLanguage;
	}

	public static void setDetectedLanguage(String detectedLanguage) {
		Translation.detectedLanguage = detectedLanguage;
	}

	public static String getTranslatedText() {
		return translatedText;
	}

	public static void setTranslatedText(String translatedText) {
		Translation.translatedText = translatedText;
	}

}