package models;

public class Match {

    private Integer matchID;

    private Integer season;

    private String city;

    private String date;

    private Integer team1;

    private Integer team2;

    private Integer tossWinner;

    private String tossDecision;

    private String result;

    private Integer winner;

    public Integer getMatchID() {
        return matchID;
    }

    public void setMatchID(Integer matchID) {
        this.matchID = matchID;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTeam1() {
        return team1;
    }

    public void setTeam1(Integer team1) {
        this.team1 = team1;
    }

    public Integer getTeam2() {
        return team2;
    }

    public void setTeam2(Integer team2) {
        this.team2 = team2;
    }

    public Integer getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(Integer tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

}
