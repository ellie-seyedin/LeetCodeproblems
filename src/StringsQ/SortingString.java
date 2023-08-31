package StringsQ;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingString {

    private static void sortingAlphabetically(String name) {
        char[] chars = name.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }

    public static String findLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0; // Length of the longest substring
        int maxStart = 0; // Start index of the longest substring
        int start = 0; // Start index of the current substring
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the current character has been seen before and its index is after the start of the current substring
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update the index of the current character
            charIndexMap.put(currentChar, i);
            //character -->key
            //index --> value

            // Calculate the length of the current substring
            int currentLength = i - start + 1;

            // If the current substring is longer than the longest seen so far, update maxLength and maxStart
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }

    //Java Program To Replace Character With It's Occurrence | Java | Ashok IT
    //hello -> replace l with position -> he12o
    private static String replaceCharacterWithOccurrence(String txt, char replacement) {
        if (txt.indexOf(replacement) == -1)
            System.out.println("This character doesn't exist.");
        int count = 1;
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (c == replacement) {
                txt = txt.replaceFirst(String.valueOf(c), String.valueOf(count));
                count++;
            }
        }
        return txt;

    }


    public static void main(String[] args) {
        String input = "abcabcbb";
        char replacement = 'b';
        String longestSubstring = findLongestSubstring(input);
        System.out.println("Longest substring without repeating characters: " + longestSubstring);
        replaceCharacterWithOccurrence(input, replacement);
    }

    @Test
    public void test() {
        String txt = "occurrence";
        char replace = 'r';
        String expected = "occu12ence";
        assertEquals(expected, SortingString.replaceCharacterWithOccurrence(txt, replace));
    }
}


