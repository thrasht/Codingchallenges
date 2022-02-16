package com.montes.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
 * other. Case-sensitive. Space sensitive.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        String word = "HelloByeWelcome";
        String permutation = "WelcomeByeHello";

        System.out.println("---permutation----");
        boolean res = checkPermutation2(word, permutation);

        System.out.println("word: " + word);
        System.out.println("permutation: " + permutation);
        System.out.println("res= " + res);
    }

    public static boolean checkPermutation(String word, String permutation) {
        if(word.length() != permutation.length())
            return false;

        return sort(word).equals(sort(permutation));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);

        return new String(content);
    }

    public static boolean checkPermutation2(String word, String permutation) {
        if(word.length() != permutation.length())
            return false;

        int[] letters = new int[128];

        for(char c : word.toCharArray()) {
            letters[c]++;
        }

        for(char c : permutation.toCharArray()) {
            letters[c]--;
        }

        return Arrays.stream(letters).allMatch(value -> value == 0);
    }
}
