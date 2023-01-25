import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LeapYearTest {
    @Test
    public void shouldLeapIs800Year() {
        assertTrue(LeapYear.isLeapYear(800), "Ошибка");
    }
    @Test
    public void shouldLeapIs200Year() {
        assertFalse(LeapYear.isLeapYear(200), "Ошибка");
    }
    @Test
    public void shouldLeapIs4Year() {
        assertTrue(LeapYear.isLeapYear(4), "Ошибка");
    }
}
