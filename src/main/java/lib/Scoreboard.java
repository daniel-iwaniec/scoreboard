package lib;

import java.util.*;

public final class Scoreboard {
    private final HashMap<UUID, Match> matches;

    public Scoreboard() {
        this.matches = new HashMap<>();
    }

    public UUID startMatch(Match match) {
        UUID uuid = UUID.randomUUID();
        this.matches.put(uuid, match);

        return uuid;
    }

    public void updateScore(UUID matchId, int homeTeamScore, int awayTeamScore) {
        this.matches.get(matchId).updateScore(homeTeamScore, awayTeamScore);
    }

    public void finishMatch(UUID matchId) {
        this.matches.remove(matchId);
    }

    public String getSummary() {
        ArrayList<Match> sortedMatches = new ArrayList<>(matches.values());
        sortedMatches.sort(Match::compareTo);

        String summary = "";
        for (Match match : sortedMatches) {
            summary = summary.concat(match + "\n");
        }

        return summary.replaceAll("\\n+$", "");
    }
}
