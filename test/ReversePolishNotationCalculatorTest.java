import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class ReversePolishNotationCalculatorTest {
    ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

    @Test
    public void shouldCalculateAddition() {
        String space = " ";
        String negative = "-";
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> {
                    calculator.calculatePolishNotation(space);
                    calculator.calculatePolishNotation(negative);
                });
        assertNull(exception.getMessage());
    }

    @Test
    public void shouldCalculateMultiply() {
        assertEquals(12, calculator.calculatePolishNotation("4 3 *"));
    }

    @Test
    public void shouldCalculatePlusAndMinus() {
        assertEquals(0, calculator.calculatePolishNotation("1 2 3 - +"));
    }
}
