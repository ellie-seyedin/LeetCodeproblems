package Practice;

public class MyString {

    private static String reverse(String str) {
        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("elaheh"));
    }
}