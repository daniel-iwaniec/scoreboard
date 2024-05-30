package lib;

import java.time.LocalTime;

public final class Match {
    private final Team homeTeam;
    private final Team awayTeam;
    private final LocalTime startTime;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = LocalTime.now();
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        homeTeam.setScore(homeTeamScore);
        awayTeam.setScore(awayTeamScore);
    }

    public Integer compareTo(Match match) {
        int comparison = match.getTotalScore().compareTo(this.getTotalScore());
        if (comparison == 0) {
            return match.startTime.compareTo(this.startTime);
        }

        return comparison;
    }

    public String toString() {
        return homeTeam + " - " + awayTeam;
    }

    private Integer getTotalScore() {
        return homeTeam.getScore() + awayTeam.getScore();
    }
}
