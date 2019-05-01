package models;

public class Deliveries {

   
    private Match match;
    
    private Integer inning;

    private Integer battingTeam;
    
    private Integer bowlingTeam;

    private Integer over;

    private Integer ball;
    
    private String batsman;

    private String bowler;
    
    private Integer wideRuns;
   
    private Integer byeRuns;
    
    private Integer legByeRuns;
    
    private Integer noBallRuns;
    
    private Integer penaltyRuns;
    
    private Integer batsmanRuns;
  
    private Integer extraRuns;
    
    private Integer totalRuns;

    public Match getMatch() {
        return match;
    }

    
    public void setMatch(Match match) {
        this.match = match;
    }

    
    public Integer getInning() {
        return inning;
    }

    public void setInning(Integer inning) {
        this.inning = inning;
    }

    public Integer getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Integer battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Integer getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Integer bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public Integer getOver() {
        return over;
    }

    public void setOver(Integer over) {
        this.over = over;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

 
    public String getBowler() {
        return bowler;
    }

  
    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

  
    public Integer getWideRuns() {
        return wideRuns;
    }


    public void setWideRuns(Integer wideRuns) {
        this.wideRuns = wideRuns;
    }

 
    public Integer getByeRuns() {
        return byeRuns;
    }

   
    public void setByeRuns(Integer byeRuns) {
        this.byeRuns = byeRuns;
    }

  
    public Integer getLegByeRuns() {
        return legByeRuns;
    }


    public void setLegByeRuns(Integer legByeRuns) {
        this.legByeRuns = legByeRuns;
    }

 
    public Integer getNoBallRuns() {
        return noBallRuns;
    }

    public void setNoBallRuns(Integer noBallRuns) {
        this.noBallRuns = noBallRuns;
    }

 
    public Integer getPenaltyRuns() {
        return penaltyRuns;
    }


    public void setPenaltyRuns(Integer penaltyRuns) {
        this.penaltyRuns = penaltyRuns;
    }

    public Integer getBatsmanRuns() {
        return batsmanRuns;
    }

  
    public void setBatsmanRuns(Integer batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }

 
    public Integer getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(Integer extraRuns) {
        this.extraRuns = extraRuns;
    }

 
    public Integer getTotalRuns() {
        return totalRuns;
    }
    
    public void setTotalRuns(Integer totalRuns) {
        this.totalRuns = totalRuns;
    }


}
