package telran.words.model;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static boolean isAnagram(String word, String part) {
		
        if(part == null || part.length() == 0 || 
        word == null || word.length() == 0 || 
        part.length()>word.length()) {

		return false;

	    }

    word = word.toLowerCase().trim();
    part = part.toLowerCase().trim();

    String[] wordArr = word.split("");
	String[] partArr = part.split("");
	Map<String, Integer> wordMap = new HashMap<>();
	Map<String, Integer> partMap = new HashMap<>();

    for(int i=0; i<wordArr.length; i++){
        wordMap.merge(wordArr[i], 1, (oldV, newV) -> oldV+newV);
    }

    for(int i=0; i<partArr.length; i++){
        partMap.merge(partArr[i], 1, (oldV, newV) -> oldV+newV);
    }

    for (String key : partMap.keySet()) {
        if (wordMap.get(key) == null || wordMap.get(key) < partMap.get(key)) {
            return false;
        }
    }
    return true;

}
}