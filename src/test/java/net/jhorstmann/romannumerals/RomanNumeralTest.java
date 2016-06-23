package net.jhorstmann.romannumerals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RomanNumeralTest {

    public RomanNumeralTest(int number, String numeral) {
        this.number = number;
        this.numeral = numeral;
    }

    private static Object[] test(int number, String expectedString) {
        return new Object[]{number, expectedString};
    }

    @Parameterized.Parameters(name = "{0} = {1}")
    public static Collection<Object[]> parameters() {
        return asList(
                test(1, "I"),
                test(2, "II"),
                test(3, "III"),
                test(4, "IV"),
                test(5, "V"),
                test(6, "VI"),
                test(7, "VII"),
                test(8, "VIII"),
                test(9, "IX"),
                test(10, "X"),
                test(11, "XI"),
                test(12, "XII"),
                test(13, "XIII"),
                test(14, "XIV"),
                test(15, "XV"),
                test(16, "XVI"),
                test(17, "XVII"),
                test(18, "XVIII"),
                test(19, "XIX"),
                test(20, "XX"),
                test(21, "XXI"),
                test(22, "XXII"),
                test(23, "XXIII"),
                test(24, "XXIV"),
                test(25, "XXV"),
                test(29, "XXIX"),
                test(30, "XXX"),
                test(40, "XL"),
                test(41, "XLI"),
                test(45, "XLV"),
                test(49, "XLIX"),
                test(50, "L"),
                test(59, "LIX"),
                test(90, "XC"),
                test(93, "XCIII"),
                test(99, "XCIX"),
                test(100, "C"),
                test(101, "CI"),
                test(110, "CX"),
                test(501, "DI"),
                test(550, "DL"),
                test(707, "DCCVII"),
                test(890, "DCCCXC"),
                test(1800, "MDCCC"),
                test(2014, "MMXIV"),
                test(0, ""));
    }

    private final int number;
    private final String numeral;

    @Test
    public void testToString() {
        assertEquals(numeral, RomanNumeral.toString(number));
    }

    @Test
    public void testToInt() {
        assertEquals(number, RomanNumeral.toInt(numeral));
    }

}