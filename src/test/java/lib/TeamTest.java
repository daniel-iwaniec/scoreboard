package lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamTest {
    @Test
    void testCreatingTeam() {
        Team team = new Team("Poland");

        assertEquals("Poland 0", team.toString());
    }

    @Test
    void testSettingScore() {
        Team team = new Team("Poland");
        team.setScore(2);

        assertEquals(2, team.getScore());
        assertEquals("Poland 2", team.toString());
    }

    @Test
    void testSettingInvalidScore() {
        Team team = new Team("Poland");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> team.setScore(-2));

        String expectedMessage = "Score must be greater than or equal to zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
