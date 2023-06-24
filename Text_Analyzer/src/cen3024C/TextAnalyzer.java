package cen3024C;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TextAnalyzer {
	
	public static Map<String, Integer> usableWords(File file) throws IOException {
		Map<String, Integer> wordFrequency = new HashMap<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				if (!line.trim().equals("")) {
					String[] words = line.toLowerCase().split(" ");

					for (String word : words) {
						if (word != null && !word.trim().equals("")) {
							String str = word.replaceAll("[^a-z]", "");
							wordFrequency.put(str, wordFrequency.getOrDefault(str, 0)+1);
						}
					}
				}
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wordFrequency;
	}
	
	public static List<Entry<String, Integer>> topFrequentWords(Map<String, Integer> wordFrequency, int n) {
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());
		sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		if(n < 1) {
			System.out.println("Enter a number larger than 0");
		}
		int count = 0;
		for(int i = 0; i < n && i < sortedList.size(); i++) {
			Entry<String, Integer> finalList = sortedList.get(i);
			System.out.println(count+1+") "+finalList.getKey() + " = " + finalList.getValue());
			count++;
		}
		if(n > sortedList.size()) {
			System.out.println("There is a maximum of 442 top frequented words");
		}
		return sortedList;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("raven.txt");
		Map<String, Integer> wordFrequency = usableWords(file);
		int n = 5;
		topFrequentWords(wordFrequency, n);
	}
}