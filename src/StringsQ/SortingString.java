package StringsQ;

import java.util.Arrays;
import java.util.HashMap;

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

        public static void main(String[] args) {
            String input = "abcabcbb";
            String longestSubstring = findLongestSubstring(input);
            System.out.println("Longest substring without repeating characters: " + longestSubstring);
        }
    }


