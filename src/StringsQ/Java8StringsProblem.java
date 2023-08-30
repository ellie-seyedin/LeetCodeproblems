package StringsQ;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java8StringsProblem {
    private static String reverseString(String name) {
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    private static StringBuilder reverseString1(String name) {
        StringBuilder reversed = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; i--) {
            reversed.append(name.charAt(i));
        }
        return reversed;
    }

    private static String reverseString2(String name) {
        char[] chars = name.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        return reversed.toString();
    }

    //worstcase
    private static Set<Character> findDuplicate(String name) {
        Set<Character> duplicate = new LinkedHashSet<>();
        for (int i = 0; i < name.length(); i++) {
            for (int j = i + 1; j < name.length(); j++) {
                if (name.charAt(i) == name.charAt(j))
                    duplicate.add(name.charAt(i));
            }
        }
        return duplicate;
    }

    //O(n)
    private static Set<Character> findDuplicateUsingArray(String name) {
        Set<Character> duplicate = new LinkedHashSet<>();
        int[] arrayForChar = new int[256];

        for (int i = 0; i < name.length(); i++) {
            arrayForChar[name.charAt(i)] = arrayForChar[name.charAt(i)] + 1;
        }
        for (int i = 0; i < arrayForChar.length; i++) {
            if (arrayForChar[i] > 1)
                duplicate.add((char) i);
        }

        return duplicate;
    }

    private static Set<Character> findDuplicateUsingHashMap(String name) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        Set<Character> duplicate = new HashSet<>();
        for (int i = 0; i < name.length(); i++) {
            if (countMap.containsKey(name.charAt(i))) {
                countMap.put(name.charAt(i), countMap.get(name.charAt(i)) + 1);
            } else {
                countMap.put(name.charAt(i), 1);
            }

            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > 1) {
                    duplicate.add(entry.getKey());
                }
            }
        }
        return duplicate;
    }

    //    private static String remove(String name){
//        StringBuilder stringBuilder = new StringBuilder();
//        char remove;
//        for (int i = 0; i <name.length()-1 ; i++) {
//            if (name.charAt(i) == remove)
//
//        }
//    }
    private static String removeDuplicateByJava8(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        name.chars().distinct().forEach(c -> stringBuilder.append((char) c));
        return stringBuilder.toString();
    }

    private static Set<Character> removeDuplicateBySet(String name) {
        Set<Character> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < name.length(); i++) {
            hashSet.add(name.charAt(i));
        }
        return hashSet;
    }

    private static String removeDuplicate2(String name) {
        Set<Character> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < name.length(); i++) {
            hashSet.add(name.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : hashSet) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private static Map<Character, Integer> findOccurrenceOfEachCharacter(String txt) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        //hello
        char[] chars = txt.toCharArray();
        for (char c : chars) {
            if (!countMap.containsKey(c))
                countMap.put(c, 1);
            else
                countMap.put(c, countMap.get(c) + 1);
        }
            return countMap;
    }

    public static void main(String[] args) {
        String name = "elaheh";
        String name1 = new String("elaheh");
        System.out.println(name == name1);
        System.out.println(name.equals(name1));

        //add string from heap to string pool
        String name3 = name1.intern();
        System.out.println(name3 == name);


        System.out.println(reverseString(name));
        System.out.println(reverseString1(name));

        //It proves String is immutable, because instead of change the content of s1, create new String.
        String s1 = "qqq";
        System.out.println(s1.hashCode());
        s1 = s1 + "yyy";
        System.out.println(s1.hashCode());

        System.out.println(findDuplicate(name));
        System.out.println(findDuplicateUsingArray(name));
        System.out.println(findDuplicateUsingHashMap(name));
        HashMap<Character, Integer> countMap = new HashMap<>();
        countMap.put('k', 0);
        countMap.put('r', 1);
        countMap.put('f', 2);
        System.out.println("*********************************************************");
        Integer value = countMap.get('k');
        String duplication = "elaheh";
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        removeDuplicateBySet(duplication);
        String dup = "SIIINA";
        System.out.println(removeDuplicateByJava8(dup));
    }


    @Test
    public void testReverseString() {
        //Test with String that has even length
        String evenString = "abcd";
        String reversedEevenString = "dcba";
        StringBuilder reversedEvenStringBuilder = new StringBuilder("dcba");
        assertEquals(reversedEevenString, Java8StringsProblem.reverseString(evenString));
        assertEquals(reversedEvenStringBuilder.toString(), Java8StringsProblem.reverseString1(evenString).toString());
        assertEquals(reversedEevenString, Java8StringsProblem.reverseString2(evenString));

        //Test with String that has odd length
        String oddString = "abcde";
        String reversedOddString = "edcba";
        StringBuilder reversedOddStringBuilder = new StringBuilder("edcba");
        assertEquals(reversedOddString, Java8StringsProblem.reverseString(oddString));
        assertEquals(reversedOddStringBuilder.toString(), Java8StringsProblem.reverseString1(oddString).toString());
        assertEquals(reversedOddStringBuilder.toString(), Java8StringsProblem.reverseString2(oddString));

        //Test with empty String
        String empty = "";
        String reversedEmpty = "";
        StringBuilder reversedEmptyBuilder = new StringBuilder("");
        assertEquals(reversedEmpty, Java8StringsProblem.reverseString(empty));
        assertEquals(reversedEmptyBuilder.toString(), Java8StringsProblem.reverseString1(empty).toString());
        assertEquals(reversedEmpty, Java8StringsProblem.reverseString2(empty));

        //Test with Single Character
        String single = "x";
        String reversedSingle = "x";
        StringBuilder reversedSingleBuilder = new StringBuilder("x");
        assertEquals(reversedSingle, Java8StringsProblem.reverseString(single));
        assertEquals(reversedSingleBuilder.toString(), Java8StringsProblem.reverseString1(single).toString());
        assertEquals(reversedSingle, Java8StringsProblem.reverseString2(single));
    }

    @Test
    public void testFindDuplicateUsingHashMap() {
        // Test with a string containing duplicate characters
        String input1 = "hello";
        Set<Character> expected1 = new HashSet<>();
        expected1.add('l');
        expected1.add('o');
        assertEquals(expected1, Java8StringsProblem.findDuplicateUsingHashMap(input1));

        // Test with a string containing no duplicate characters
        String input2 = "world";
        Set<Character> expected2 = new HashSet<>();
        assertEquals(expected2, Java8StringsProblem.findDuplicateUsingHashMap(input2));

        // Test with an empty string
        String input3 = "";
        Set<Character> expected3 = new HashSet<>();
        assertEquals(expected3, Java8StringsProblem.findDuplicateUsingHashMap(input3));

        // Test with a string containing spaces
        String input4 = "hello world";
        Set<Character> expected4 = new HashSet<>();
        expected4.add('l');
        expected4.add('o');
        expected4.add(' ');
        assertEquals(expected4, Java8StringsProblem.findDuplicateUsingHashMap(input4));
    }

    @Test
    public void testRemoveDuplicate() {
        String actual = "elaheh";
        Set<Character> expected = new HashSet<>();
        expected.add('e');
        expected.add('l');
        expected.add('a');
        expected.add('h');
        assertEquals(expected, Java8StringsProblem.removeDuplicateBySet(actual));
    }
    @Test
    public void testRemoveDuplicate1() {
        String actual = "necessary";
        String expected = "necsary";
        assertEquals(expected, Java8StringsProblem.removeDuplicate2(actual));
    }

    @Test
    public void testCountMap(){
        String actual = "occurrence";
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('o',1);
        map.put('c',3);
        map.put('u',1);
        map.put('r',2);
        map.put('e',2);
        map.put('n',1);
        assertEquals(map, Java8StringsProblem.findOccurrenceOfEachCharacter(actual));
    }
}
