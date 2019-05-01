package ipltasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import models.Deliveries;
import models.Match;
import utilities.ProConstant;
import utilities.Utility;

public class tasks {
	
    private static Utility utili = new Utility();

    public static void main(String[] args) 
    {
        utili.loadData();

        printTop4Teams();

        printBoundariesAndTotal();

        printBestEconomyBowlers();

        printNetRunRate();
    }

   // TASK 1: Top 4 teams which elected to field first after winning toss in the year 2016 and 2017.
    
    private static void printTop4Teams() {
        Map<Integer, Integer> team16 = new HashMap<>();
        Map<Integer, Integer> team17 = new HashMap<>();
        for (Match match : utili.matches.values()) {
            if ("field".equalsIgnoreCase(match.getTossDecision())) {
                if (match.getSeason() == 2016) {
                    if (team16.get(match.getTossWinner()) != null) {
                        team16.put(match.getTossWinner(), team16.get(match.getTossWinner()) + 1);
                    } else {
                        team16.put(match.getTossWinner(), 1);
                    }
                } else if (match.getSeason() == 2017) {
                    if (team17.get(match.getTossWinner()) != null) {
                        team17.put(match.getTossWinner(), team17.get(match.getTossWinner()) + 1);
                    } else {
                        team17.put(match.getTossWinner(), 1);
                    }
                }
            }
        }

        team16 = utili.sortMapByValue(team16);
        team17 = utili.sortMapByValue(team17);

        Iterator<Map.Entry<Integer,  Integer>> iterate16 = team16.entrySet().iterator();
        Iterator<Map.Entry<Integer,  Integer>> iterate17 = team17.entrySet().iterator();

        Map.Entry<Integer, Integer> entry16 = iterate16.next();
        Map.Entry<Integer, Integer> entry17 = iterate17.next();

        System.out.println("\n\n TASK 1 : Top 4 teams which elected to field first after winning toss in the year 2016 and 2017 \n ");
        System.out.format("%10s%32s%10s", "YEAR", "TEAM", "COUNT");
        System.out.print("\n----------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println();
            if (entry16.getValue() > entry17.getValue()) {
                System.out.format("%10s%32s%10s", "2016", ProConstant.teamsByID.get(entry16.getKey()), entry16.getValue().toString());
                entry16 = iterate16.next();
            } else {
                System.out.format("%10s%32s%10s", "2017", ProConstant.teamsByID.get(entry17.getKey()), entry17.getValue().toString());
                entry17 = iterate17.next();
            }
           
        }
        System.out.print("\n----------------------------------------------------------------------------------------------------------");
    }

    // TASK 2:List total number of fours, sixes, total score with respect to team and year.
    
    public static void printBoundariesAndTotal() {
        Map<String, Integer> teamFours = new HashMap<>();
        Map<String, Integer> teamSixes = new HashMap<>();
        Map<String, Integer> teamTotalRuns = new HashMap<>();
        String teamYear = null;

        for (Deliveries delivery : utili.deliveries) {
            if (delivery.getTotalRuns() > 0) {
                teamYear = delivery.getBattingTeam() + "," + delivery.getMatch().getSeason();
                if (delivery.getTotalRuns() >= 4) {
                    if (utili.isFour(delivery)) {
                        if (teamFours.get(teamYear) != null) {
                            teamFours.put(teamYear, teamFours.get(teamYear) + 1);
                        } else {
                            teamFours.put(teamYear, 1);
                        }
                    }
                    if (utili.isSix(delivery)) {
                        if (teamSixes.get(teamYear) != null) {
                            teamSixes.put(teamYear, teamSixes.get(teamYear) + 1);
                        } else {
                            teamSixes.put(teamYear, 1);
                        }
                    }
                }
                if (teamTotalRuns.get(teamYear) != null) {
                    teamTotalRuns.put(teamYear, teamTotalRuns.get(teamYear) + delivery.getTotalRuns());
                } else {
                    teamTotalRuns.put(teamYear, delivery.getTotalRuns());
                }
            }
        }

        System.out.println("\n\n TASK 2 : Total number of fours, sixes, total score with respect to team and year \n ");
        System.out.format("%8s%32s%15s%15s%15s", "YEAR", "TEAM_NAME", "FOURS_COUNT", "SIXES_COUNT", "TOTAL_SCORE");
        System.out.print("\n---------------------------------------------------------------------------------------------");
        String[] teamYearArray;
        String team;
        String year;
        for (Map.Entry<String, Integer> teamTotal : teamTotalRuns.entrySet()) {
            System.out.println();
            teamYearArray = teamTotal.getKey().split(",");
            team = ProConstant.teamsByID.get(Integer.parseInt(teamYearArray[0]));
            year = teamYearArray[1];

            System.out.format("%8s%32s%15s%15s%15s", year, team, teamFours.get(teamTotal.getKey()), teamSixes.get(teamTotal.getKey()), teamTotal.getValue());

        }
        System.out.print("\n---------------------------------------------------------------------------------------------");
    }

 // TASK 3: Top 10 best economy rate bowler with respect to year who bowled at least 10 overs (LEGBYE_RUNS and BYE_RUNS should not be considered for Total Runs Given by a bowler)
    
    private static void printBestEconomyBowlers() {
        Map<String, Set<String>> bowlerOvers = new HashMap<>();
        Map<String, Integer> bowlerRuns = new HashMap<>();
        Map<String, Integer> bowlerEconomy = new HashMap<>();
        String bowler = null;
        String matchOver = null;
        int runsGiven = 0;

        for (Deliveries delivery : utili.deliveries) {
            bowler = delivery.getBowler() + "," + delivery.getMatch().getSeason();
            matchOver = delivery.getMatch().getMatchID() + "," + delivery.getOver();
            Set<String> over;
            if (bowlerOvers.containsKey(bowler)) {
                over = bowlerOvers.get(bowler);
            } else {
                over = new HashSet<String>();
            }
            over.add(matchOver);
            bowlerOvers.put(bowler, over);

            runsGiven = delivery.getTotalRuns() - delivery.getByeRuns() - delivery.getLegByeRuns();
            if (runsGiven > 0) {
                if (bowlerRuns.containsKey(bowler)) {
                    bowlerRuns.put(bowler, bowlerRuns.get(bowler) + runsGiven);
                } else {
                    bowlerRuns.put(bowler, runsGiven);
                }
            }
        }

        int oversBowled = 0;
        int totalRunsGiven = 0;
        int economy = 0;
        for (Map.Entry<String, Set<String>> overs : bowlerOvers.entrySet()) {
            oversBowled = overs.getValue().size();
            if (oversBowled >= 10) {
                totalRunsGiven = bowlerRuns.get(overs.getKey());
                economy = totalRunsGiven / oversBowled;
                bowlerEconomy.put(overs.getKey(), economy);
            }
        }

        bowlerEconomy = utili.sortMapByValue(bowlerEconomy);

        System.out.println("\n\n TASK 3 : Top 10 best economy rate bowler with respect to year who bowled at least 10 overs \n");
        System.out.format("%8s%30s%10s", "YEAR", "PLAYER", "ECONOMY");
        System.out.print("\n-----------------------------------------------------");
        Iterator<Map.Entry<String, Integer>> iterator = bowlerEconomy.entrySet().iterator();
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Integer> entry = iterator.next();
            String[] bowlerYear = entry.getKey().split(",");
            System.out.println();
            System.out.format("%8s%30s%10s", bowlerYear[1], bowlerYear[0], entry.getValue());
        }
        System.out.print("\n-----------------------------------------------------");
    }

   // TASK 4: Highest Net Run Rate with respect to year.
    
    private static void printNetRunRate() {
        Map<String, Integer> runsScored = new HashMap<>();
        Map<String, Set<String>> oversFaced = new HashMap<>();
        Map<String, Integer> runsConceded = new HashMap<>();
        Map<String, Set<String>> oversBowled = new HashMap<>();
        String battingTeamYear = null;
        String bowlingTeamYear = null;
        String matchOver = null;
        int totalRuns = 0;
        Set<String> overs;

        for (Deliveries delivery : utili.deliveries) {
            totalRuns = delivery.getTotalRuns();
            battingTeamYear = delivery.getBattingTeam() + "," + delivery.getMatch().getSeason();

            if (totalRuns > 0) {
                if (runsScored.containsKey(battingTeamYear)) {
                    runsScored.put(battingTeamYear, runsScored.get(battingTeamYear) + totalRuns);
                } else {
                    runsScored.put(battingTeamYear, totalRuns);
                }
            }
            matchOver = delivery.getMatch().getMatchID() + "," + delivery.getOver();
            if (oversFaced.containsKey(battingTeamYear)) {
                overs = oversFaced.get(battingTeamYear);
            } else {
                overs = new HashSet<String>();
            }
            overs.add(matchOver);
            oversFaced.put(battingTeamYear, overs);

            bowlingTeamYear = delivery.getBowlingTeam() + "," + delivery.getMatch().getSeason();
            if (totalRuns > 0) {
                if (runsConceded.containsKey(bowlingTeamYear)) {
                    runsConceded.put(bowlingTeamYear, runsConceded.get(bowlingTeamYear) + totalRuns);
                } else {
                    runsConceded.put(bowlingTeamYear, totalRuns);
                }
            }
            if (oversBowled.containsKey(bowlingTeamYear)) {
                overs = oversBowled.get(bowlingTeamYear);
            } else {
                overs = new HashSet<String>();
            }
            overs.add(matchOver);
            oversBowled.put(bowlingTeamYear, overs);

        }
        int netRunRate = 0;
        int highestNetRunRate = 0;
        int totalOversFaced = 0;
        int totalOversBowled = 0;
        int totalRunsScored = 0;
        int totalRunsConceded = 0;
        int team = 0;
        String year = null;
        for (Map.Entry<String, Set<String>> facedOver : oversFaced.entrySet()) {
            totalOversFaced = facedOver.getValue().size();
            if (oversBowled.containsKey(facedOver.getKey())) {
                totalOversBowled = oversBowled.get(facedOver.getKey()).size();
            }
            if (runsScored.containsKey(facedOver.getKey())) {
                totalRunsScored = runsScored.get(facedOver.getKey());
            }
            if (runsConceded.containsKey(facedOver.getKey())) {
                totalRunsConceded = runsConceded.get(facedOver.getKey());
            }
            netRunRate = (totalRunsScored / totalOversFaced) - (totalRunsConceded / totalOversBowled);

            if (netRunRate > highestNetRunRate) {
                highestNetRunRate = netRunRate;
                team = Integer.parseInt(facedOver.getKey().split(",")[0]);
                year = facedOver.getKey().split(",")[1];
            }

        }

        System.out.println("\n\n TASK 4 : The team name which has Highest Net Run Rate with respect to year\n");
        System.out.format("%8s%30s%15s", "YEAR", "TEAM", "NET RUN RATE");
        System.out.println("\n---------------------------------------------------------");
        System.out.format("%8s%30s%15s", year, ProConstant.teamsByID.get(team), highestNetRunRate);
        System.out.println("\n---------------------------------------------------------");
    }

}
