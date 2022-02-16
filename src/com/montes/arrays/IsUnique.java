package com.montes.arrays;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) {
        String wordRepeated = "kjdasdasdasdasd";
        String wordUnique = "qpwoieurytalksdjhfgzmxcbv";

        System.out.println("---using distinct method---");
        boolean distinctMethod = isUnique3(wordUnique);
        System.out.println("word: " + wordUnique + ", res= " + distinctMethod);
        distinctMethod = isUnique3(wordRepeated);
        System.out.println("word: " + wordRepeated + ", res= " + distinctMethod);

    }

    public static boolean isUnique(String word) {
        long numberUniqueChars =  word.chars().distinct().count();
        return word.length() == numberUniqueChars;
    }

    public static boolean isUnique2(String word) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        word.chars().forEach( c -> {
            Integer charInMap =  hm.get(c);
            if (charInMap != null)
                hm.put(c, ++charInMap);
            else {
                hm.put(c, 1);
            }
        });

        return hm.values().stream().allMatch(v -> v == 1);
    }

    public static boolean isUnique3(String word) {
        boolean res = true;

        for(int i = 0; i < word.length(); i++) {
            for(int j = i + 1; j < word.length(); j++) {
                if(word.charAt(i) == word.charAt(j)) {
                    res = false;
                    break;
                }
            }
        }

        return res;
    }
}
