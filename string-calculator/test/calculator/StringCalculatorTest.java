package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @Test
    public void add_null_or_empty() {
        assertEquals(0, this.stringCalculator.add(null));
        assertEquals(0, this.stringCalculator.add(""));
    }

    @Test
    public void add_number_one() {
        assertEquals(1, this.stringCalculator.add("1"));
    }

    @Test
    public void add_comma_delimiter() {
        assertEquals(3, this.stringCalculator.add("1,2"));
    }

    @Test
    public void add_comma_or_colon_delimiter() throws Exception {
        assertEquals(6, this.stringCalculator.add("1,2:3"));
    }

    @Test
    public void add_custom_delimiter() throws Exception {
        assertEquals(6, this.stringCalculator.add("//;\n1;2;3"));
    }

    @Test
    public void add_negative() throws Exception {
        assertThrows(RuntimeException.class, () -> {
            this.stringCalculator.add("-1,-2,3");
        });
    }
}
