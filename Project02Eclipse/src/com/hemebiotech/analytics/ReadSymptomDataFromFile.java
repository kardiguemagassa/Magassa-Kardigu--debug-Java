package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La classe ReadSymptomDataFromFile pour lecture des symptômes à partir d'un fichier donné.
 * Elle implémente l'interface IsymptomReader et renvoie une liste de symptômes.
 * Chaque ligne du fichier représente un symptôme.
 */
public class ReadSymptomDataFromFile implements IsymptomReader {

	private String filePath;

	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}

	@Override
	public List<String> getSymptoms() {

		List<String> result = new ArrayList<>();

		if (filePath != null) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

				// Iteration avec le Stream
				result = bufferedReader.lines().collect(Collectors.toList());
				System.out.println("liste de Symptoms : " + result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid file path.");
		}

		return result;
	}


}
