package score;

public final class Team {
    private final String name;
    private Integer score;

    public Team(String name) {
        this.name = name;
        this.score = 0;
    }

    public void setScore(Integer score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score must be greater than or equal to zero");
        }
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public String toString() {
        return name + " " + score;
    }
}
