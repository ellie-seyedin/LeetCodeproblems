package ArraysQ;

import org.junit.Test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalRelayInterview {

    public boolean isAnagram(final String value, final Set<String> stringSet) {
        boolean isAnagram = false;
        StringBuilder stringBuilder = new StringBuilder();
        //reverse value
        for (int i = value.length() - 1; i >= 0; i--) {
            stringBuilder.append(value.charAt(i));
        }
        String s = stringBuilder.toString();
        for (String st : stringSet)
            if (st.length()!= s.length())
                return false;
            else {
                isAnagram = st.contentEquals(s);
            }

        return isAnagram;
    }


        @Test
        public void testIsAnagramShouldReturnTrue () {
            String actual = "dog";
            Set<String> set = new HashSet<>();
            set.add("god");
            set.add("odg");
            boolean expected = true;
            assertEquals(expected, isAnagram(actual, set));
        }

    @Test
    public void testIsAnagramShouldReturnFalse () {
        String actual = "dog";
        Set<String> set = new HashSet<>();
        set.add("god");
        set.add("odttg");
        set.add("odg");
        boolean expected = true;
        assertEquals(expected, isAnagram(actual, set));
    }
    }
