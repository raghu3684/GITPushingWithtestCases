package DataStructures.PatternSearch;

/**
 * Created by ggorantla on 12/15/2014.
 *  Thanks to saurabh for a good explanation https://www.youtube.com/watch?v=UsmvbZGKdlM
 *  GeeksForGeeks Implementation
 */

/*
       ->  LPS stores the prefix and suffix till the ith index.(Compute LPS)
       ->  Implement the search based on the LPS
*/


public class KMP {
    public void kmpPatternSearching(String txt, String pattern) {
        int[] LPS = computeLps(pattern);
        int patternIndex = 0, txtIndex = 0;
        int patternLength = pattern.length(), txtLength = txt.length();
        System.out.println(">>> Flag");
        while (txtIndex < txtLength) {
            if (pattern.charAt(patternIndex) == txt.charAt(txtIndex)) {
                patternIndex++;
                txtIndex++;
            }
            if (patternIndex == patternLength) {
                System.out.println(txtIndex - patternIndex);
                patternIndex = LPS[patternLength - 1];
            } else if (txtIndex < txtLength && pattern.charAt(patternIndex) != txt.charAt(txtIndex)) {
                if (patternIndex != 0) {
                    patternIndex = LPS[patternIndex - 1];
                } else {
                    txtIndex = txtIndex + 1;
                }
            }
        }
        return;
    }

    private int[] computeLps(String pattern) {
        int Lpattern = pattern.length();
        int[] lps = new int[Lpattern];

        lps[0] = 0;
        int index = 1, len = 0;
        while (index < Lpattern) {
            if (pattern.charAt(index) == pattern.charAt(len)) {
                len++;
                lps[index] = len;
                index++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[index] = 0;
                    index++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        KMP obj = new KMP();
        int[] result = obj.computeLps("AABAACAABAA");
        result = obj.computeLps("ABCDE");
        //for (int i = 0; i < result.length; i++)
        //    System.out.print(result[i]);

        obj.kmpPatternSearching("ABABDABACDABABCABAB", "ABABCABAB");

        obj.kmpPatternSearching("raghu", "gh");
    }



}
