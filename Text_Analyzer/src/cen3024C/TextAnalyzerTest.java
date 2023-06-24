package cen3024C;

import org.junit.Test;
import org.junit.*;
import java.io.*;
import java.util.*;

public class TextAnalyzerTest {
	File file = new File("raven.txt");
	Map<String, Integer> wordFrequency;
	
	@Test
	public void testUsableWords() throws IOException {
		wordFrequency = TextAnalyzer.usableWords(file);
		
		Assert.assertEquals(11, (int) wordFrequency.get("chamber"));
		Assert.assertEquals(9, (int) wordFrequency.get("nevermore"));
		Assert.assertEquals(10, (int) wordFrequency.get("raven"));
		Assert.assertEquals(1, (int) wordFrequency.get("front"));
		Assert.assertEquals(56, (int) wordFrequency.get("the"));
	}
	
	@Test
	public void testTopFrequentWords() throws IOException {
		wordFrequency = TextAnalyzer.usableWords(file);
		
		int n = 443;
		List<Map.Entry<String, Integer>> sortedList = TextAnalyzer.topFrequentWords(wordFrequency, n);
		
		Assert.assertEquals(442, sortedList.size());
		Assert.assertEquals("the", sortedList.get(0).getKey());
		Assert.assertEquals(56, (int) sortedList.get(0).getValue());
		Assert.assertEquals("silence", sortedList.get(165).getKey());
		Assert.assertEquals(1, (int) sortedList.get(165).getValue());
		Assert.assertEquals("friends", sortedList.get(267).getKey());
		Assert.assertEquals(1, (int) sortedList.get(267).getValue());
		Assert.assertEquals("front", sortedList.get(441).getKey());
		Assert.assertEquals(1, (int) sortedList.get(441).getValue());
	}

}
