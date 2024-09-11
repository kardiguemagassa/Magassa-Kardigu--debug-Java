package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements IsymptomReader {

	private String filePath;

	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}

	@Override
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filePath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
					System.out.println(line);
				}
				System.out.println();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid file path.");
		}
		
		return result;
	}

}
