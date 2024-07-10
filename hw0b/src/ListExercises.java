import java.util.*;

public class ListExercises {

    /**
     * Returns the total sum in a list of integers
     */
    public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        return L.stream().mapToInt(i -> i).sum();
    }

    /**
     * Returns a list containing the even numbers of the given list
     */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        return L.stream().filter(i -> i % 2 == 0).toList();
    }

    /**
     * Returns a list containing the common item of the two given lists
     */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        Set<Integer> s = new HashSet<>(L1);
        List<Integer> ans = new ArrayList<>();
        for (Integer i : L2) {
            if (s.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static int countCharsInString(String s, char c) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Returns the number of occurrences of the given character in a list of strings.
     */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        return words.stream().mapToInt(w -> countCharsInString(w, c)).sum();
    }
}
