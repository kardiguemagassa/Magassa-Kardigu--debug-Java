package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

	private IsymptomReader iSymptomReader;
	private IsymptomWriter iSymptomWriter;

	public AnalyticsCounter(IsymptomReader iSymptomReader, IsymptomWriter iSymptomWriter) {
		this.iSymptomReader = iSymptomReader;
		this.iSymptomWriter = iSymptomWriter;
	}

	public List<String> getSymptoms() {
		return iSymptomReader.getSymptoms();
	}

	public static Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> result = new HashMap<>();

		for (String symptom : symptoms) {
			result.put(symptom, result.getOrDefault(symptom, 0) + 1);
		}
		System.out.println(result);
		System.out.println();

		return result;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		iSymptomWriter.writeSymptoms(symptoms);
	}

}
