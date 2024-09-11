package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {


        IsymptomReader iSymptomReader = new ReadSymptomDataFromFile(
                "/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/symptoms.txt");
        IsymptomWriter iSymptomWriter = new WriteSymptomDataToFile(
                "/Users/kara/Documents/dev-env/open-c/projet/Magassa-Kardigu--debug-Java/Project02Eclipse/result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);

        List<String> getSymptoms = analyticsCounter.getSymptoms();

        Map<String, Integer> countSymptoms = AnalyticsCounter.countSymptoms(getSymptoms);

        Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);

        analyticsCounter.writeSymptoms(sortSymptoms);
    }
}
