package score;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {
    @Test
    void testCreatingMatch() {
        Match match = new Match(new Team("Poland"), new Team("Portugal"));

        assertEquals("Poland 0 - Portugal 0", match.toString());
    }

    @Test
    void testComparingMatches() {
        Match match1 = new Match(new Team("Poland"), new Team("Portugal"));
        Match match2 = new Match(new Team("France"), new Team("Scotland"));

        match1.updateScore(1, 4);
        assertEquals(-1, match1.compareTo(match2));

        match2.updateScore(5, 4);
        assertEquals(1, match1.compareTo(match2));

        match1.updateScore(5, 4);
        assertEquals(1, match1.compareTo(match2));
    }
}
