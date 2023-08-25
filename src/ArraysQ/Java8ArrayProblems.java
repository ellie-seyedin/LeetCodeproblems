package ArraysQ;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8ArrayProblems {

    private static void fetchSecondSmallestElement(int[] array){
        int secondSmallest = Arrays.stream(array).distinct()
                                    .sorted()
                                    .skip(1).findFirst()
                                    .orElseThrow(()-> new IllegalArgumentException("Array doesn't have a second smallest element"));
        System.out.println("The second smallest element in a given array is: " + secondSmallest);
    }

    private static void fetchCommonElements(int[] array1, int[] array2){
        List<Integer> collect = Arrays.stream(array1).filter(array1number -> Arrays.stream(array2).anyMatch(array2Number -> array2Number == array1number)).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        int[] numbers = {2,4,1,1,1,5,6,4};
        fetchSecondSmallestElement(numbers);

        int[] array1 = {1,2,3,4,5};
        int[] array2 = {4,5,6,7,8};
        fetchCommonElements(array1,array2);
    }


}


