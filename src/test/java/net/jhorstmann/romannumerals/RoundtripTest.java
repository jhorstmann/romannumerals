package net.jhorstmann.romannumerals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RoundtripTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return IntStream.range(0, 5000).mapToObj(i -> new Object[]{i}).collect(Collectors.toList());
    }

    private final int number;

    public RoundtripTest(int number) {
        this.number = number;
    }

    @Test
    public void roundtripFromNumber() {
        assertEquals(number, RomanNumeral.toInt(RomanNumeral.toString(number)));
    }

}
