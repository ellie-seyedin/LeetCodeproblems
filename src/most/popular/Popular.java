package most.popular;

import java.util.HashMap;
import java.util.Map;

public class Popular {

    private static void reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append(str);
        System.out.println(append.reverse());
    }

    private static String reverseWithoutUsingInbuiltFunction(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + " , b =" + b);
    }


    private static void swapWithoutThirdValue(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " | " + " b " + b);
    }

    private static void countWordsInText(String text) {
        String[] words = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word))
                map.put(word, 1);
            else {
                map.put(word, map.get(word) + 1);
            }
        }
        System.out.println(map);
    }

    private static void iterateThroughHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("AM", 2);
        map.put("READY", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static boolean isPrime(int number) {
        boolean prime = true;
        for (int i = 2; i <number/ 2; i++)
            if (number % i == 0) {
                prime = false;
                break;
            }
        return prime;
    }


    public static void main(String[] args) {
        String name = "elaheh";
//        reverse(name);
//        System.out.println(reverseWithoutUsingInbuiltFunction(name));
        swap(10, 20);
        swapWithoutThirdValue(45, 67);
        countWordsInText("THIS THIS IS DONE BY ELAHEH!");
        iterateThroughHashMap();
        System.out.println(isPrime(17));
    }

}
