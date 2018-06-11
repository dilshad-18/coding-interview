package basicAlgo;

/**
 * Created by psi143 on 11/14/2016.
 */
public class StringUtil {
    /**
     * Permutation of string
     *
     * @param str
     */
    public static void permutation(String str) {
        permutation("", str);
    }

    public static void removeDuplicates(char[] strArray) {

        if (strArray == null)
            return;
        int len = strArray.length;
        if (len < 2)
            return;
        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int k;
            for (k = 0; k < tail; ++k) {
                if (strArray[k] == strArray[i])
                    break;
            }
            if (k == tail) {
                strArray[tail] = strArray[i];
                ++tail;
            }
        }
        strArray[tail] = 0;
      /*  System.out.println(strArray.length);
        for (char c :
                strArray) {
            System.out.println(c);
        }*/


    }


    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[256];
        int num_unique_chars = 0;
        int num_completed_t = 0;
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            if (letters[c] == 0) ++num_unique_chars;
            ++letters[c];
        }
        for (int i = 0; i < t.length(); ++i) {
            int c = (int) t.charAt(i);
            if (letters[c] == 0) { // Found more of char c in t than in s.
                return false;
            }
            --letters[c];
            if (letters[c] == 0) {
                ++num_completed_t;
                if (num_completed_t == num_unique_chars) {
                    // it’s a match if t has been processed completely
                    return i == t.length() - 1;
                }
            }
        }
        return false;
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

}
