package ArraysQ;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8ArrayProblems {

    private static void fetchSecondSmallestElement(int[] array){
        int secondSmallest = Arrays.stream(array).distinct()
                                    .sorted()
                                    .skip(1).findFirst()
                                    .orElseThrow(()-> new IllegalArgumentException("Array doesn't have a second smallest element"));
        System.out.println("The second smallest element in a given array is: " + secondSmallest);
    }

    private static void fetchCommonElements(int[] array1, int[] array2){
        List<Integer> common = Arrays.stream(array1).filter(number-> Arrays.stream(array2).anyMatch(number2-> number2==number)).boxed().collect(Collectors.toList());
        System.out.println(common);
    }

    private static void reverseArrayInPlace(int[] array){
        IntStream.range(0, array.length/2).forEach(i->{
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
            });
        System.out.println("Reversed array : " + Arrays.toString(array));
    }

    private static void iterateArrayWithForEach(int[] array){
       Arrays.stream(array).forEach(System.out::print);
    }


    public static void main(String[] args) {
        int[] numbers = {2,4,1,1,1,5,6,4};
        fetchSecondSmallestElement(numbers);

        int[] array1 = {1,2,3,4,5};
        int[] array2 = {4,5,6,7,8};
        fetchCommonElements(array1,array2);

        int[] arr = {4,5,6,7,8};
        reverseArrayInPlace(arr);

        iterateArrayWithForEach(arr);
    }


}


