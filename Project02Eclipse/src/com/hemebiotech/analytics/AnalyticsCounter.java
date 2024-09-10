package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class AnalyticsCounter {

	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	// Déclaration des attributs de classe
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;

	// 1. Créez le constructeur
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	// 2. Créez une méthode getSymptoms qui récupère la liste des entrées
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	// 3. Créez une méthode countSymptoms qui compte les occurrences de
	public static Map<String, Integer> countSymptoms(List<String> symptoms) {

		// Map pour stocker le résultat (clé = symptôme, valeur = nombre d'occurrences)
		Map<String, Integer> result = new HashMap<String, Integer>();

		// Parcours de la liste des symptômes
		for (String symptom : symptoms) {
			// Si le symptôme est déjà présent dans la Map, on incrémente son compteur
			result.put(symptom, result.getOrDefault(symptom, 0) + 1);
		}

		return result; // Retourne la carte avec les occurrences de chaque symptôme
	}


	// 4. Créez une méthode sortSymptoms qui trie la liste de symptômes
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		// Convertir la Map en une liste
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(symptoms.entrySet());

		// Trie la liste par les valeurs (nombre d'occurrences) dans l'ordre croissant
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		// Ajoute les entrées triées dans la nouvelle Map
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	// 5. Créez une méthode writeSymptoms qui écrit le résultat dans le fichier
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}


	// main
	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader (
				new FileReader("/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;

		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();

	}
}
