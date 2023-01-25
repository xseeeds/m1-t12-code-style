import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LongestNameTest {
    @Test
    public void shouldLongestNameIsAlexOrMax() {
        var longestName = LongestName
                .longestName(List.of(Optional.empty(), Optional.of("Max"), Optional.of("Alex")))
                .get();
        assertEquals(longestName, "Alex");
    }
    @Test
    public void shouldLongestNameIsEmpty() {
        var longestName = LongestName
                .longestName(List.of(Optional.empty(), Optional.empty()))
                .flatMap(String::describeConstable);
        assertTrue(longestName.isEmpty());
    }
    @Test
    public void shouldLongestListIsEmpty() {
        var longestName = LongestName
                .longestName(new ArrayList<>());
        assertTrue(longestName.isEmpty());
    }
    /*@Test
    public void shouldLongestNameIsNull() {
        var longestName = LongestName
                .longestName(List.of(Optional.empty(), null))
                .flatMap(String::describeConstable);
        assertTrue(longestName.isEmpty());
    }*/
}
