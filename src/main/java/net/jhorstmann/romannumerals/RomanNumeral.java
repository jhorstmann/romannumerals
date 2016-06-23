package net.jhorstmann.romannumerals;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RomanNumeral {

    public static String toString(int number) {
        return Stream.of(Integer.toString(number))
                .flatMap(s -> IntStream.range(0, s.length())
                        .flatMap(i -> IntStream.generate(() -> (int) "IXCM".charAt(s.length() - i - 1)).limit(s.charAt(i) - '0'))
                        .mapToObj(i -> String.valueOf((char) i)))
                .collect(Collectors.joining(""))
                .replaceAll("I{9}", "IX")
                .replaceAll("I{5}", "V")
                .replaceAll("I{4}", "IV")
                .replaceAll("X{9}", "XC")
                .replaceAll("X{5}", "L")
                .replaceAll("X{4}", "XL")
                .replaceAll("C{9}", "CM")
                .replaceAll("C{5}", "D")
                .replaceAll("C{4}", "CD");
    }

    public static int toInt(String numeral) {
        return numeral.replace("CD", "CCCC")
                .replace("D", "CCCCC")
                .replace("CM", "CCCCCCCCC")
                .replace("XL", "XXXX")
                .replace("L", "XXXXX")
                .replace("XC", "XXXXXXXXX")
                .replace("IV", "IIII")
                .replace("V", "IIIII")
                .replace("IX", "IIIIIIIII")
                .codePoints()
                .map(ch -> (int)Math.pow(10, "IXCM".indexOf(ch)))
                .sum();
    }
}
