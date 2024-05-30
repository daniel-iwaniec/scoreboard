package org.scoreboard;

import lib.Match;
import lib.Scoreboard;
import lib.Team;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(scoreboard.getSummary());
    }
}
