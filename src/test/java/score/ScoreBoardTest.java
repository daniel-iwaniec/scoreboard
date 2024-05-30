package score;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    @Test
    void testCreatingScoreboard() {
        Scoreboard scoreboard = new Scoreboard();

        assertEquals("", scoreboard.getSummary());
    }

    @Test
    void testShowingScoreboard() {
        Scoreboard scoreboard = new Scoreboard();

        UUID match1 = scoreboard.startMatch(new Match(new Team("Mexico"), new Team("Canada")));
        UUID match2 = scoreboard.startMatch(new Match(new Team("Spain"), new Team("Brazil")));
        UUID match3 = scoreboard.startMatch(new Match(new Team("Germany"), new Team("France")));
        UUID match4 = scoreboard.startMatch(new Match(new Team("Uruguay"), new Team("Italy")));
        UUID match5 = scoreboard.startMatch(new Match(new Team("Argentina"), new Team("Australia")));

        scoreboard.updateScore(match1, 0, 5);
        scoreboard.updateScore(match2, 10, 2);
        scoreboard.updateScore(match3, 2, 2);
        scoreboard.updateScore(match4, 6, 6);
        scoreboard.updateScore(match5, 3, 1);

        assertEquals(
                "Uruguay 6 - Italy 6\n" +
                "Spain 10 - Brazil 2\n" +
                "Mexico 0 - Canada 5\n" +
                "Argentina 3 - Australia 1\n" +
                "Germany 2 - France 2",
                scoreboard.getSummary()
        );
    }

    @Test
    void testShowingScoreboardWithEquals() {
        Scoreboard scoreboard = new Scoreboard();

        UUID match1 = scoreboard.startMatch(new Match(new Team("Mexico"), new Team("Canada")));
        UUID match2 = scoreboard.startMatch(new Match(new Team("Spain"), new Team("Brazil")));
        UUID match3 = scoreboard.startMatch(new Match(new Team("Germany"), new Team("France")));
        UUID match4 = scoreboard.startMatch(new Match(new Team("Uruguay"), new Team("Italy")));
        UUID match5 = scoreboard.startMatch(new Match(new Team("Argentina"), new Team("Australia")));

        scoreboard.updateScore(match1, 0, 5);
        scoreboard.updateScore(match2, 10, 2);
        scoreboard.updateScore(match3, 2, 2);
        scoreboard.updateScore(match4, 6, 6);
        scoreboard.updateScore(match5, 6, 6);

        assertEquals(
                "Argentina 6 - Australia 6\n" +
                        "Uruguay 6 - Italy 6\n" +
                        "Spain 10 - Brazil 2\n" +
                        "Mexico 0 - Canada 5\n" +
                        "Germany 2 - France 2",
                scoreboard.getSummary()
        );
    }

    @Test
    void testShowingScoreboardWithoutFinishedMatches() {
        Scoreboard scoreboard = new Scoreboard();

        UUID match1 = scoreboard.startMatch(new Match(new Team("Mexico"), new Team("Canada")));
        UUID match2 = scoreboard.startMatch(new Match(new Team("Spain"), new Team("Brazil")));
        UUID match3 = scoreboard.startMatch(new Match(new Team("Germany"), new Team("France")));
        UUID match4 = scoreboard.startMatch(new Match(new Team("Uruguay"), new Team("Italy")));
        UUID match5 = scoreboard.startMatch(new Match(new Team("Argentina"), new Team("Australia")));

        scoreboard.updateScore(match1, 0, 5);
        scoreboard.updateScore(match2, 10, 2);
        scoreboard.updateScore(match3, 2, 2);
        scoreboard.updateScore(match4, 6, 6);
        scoreboard.updateScore(match5, 3, 1);

        scoreboard.finishMatch(match1);

        assertEquals(
                "Uruguay 6 - Italy 6\n" +
                        "Spain 10 - Brazil 2\n" +
                        "Argentina 3 - Australia 1\n" +
                        "Germany 2 - France 2",
                scoreboard.getSummary()
        );
    }
}
