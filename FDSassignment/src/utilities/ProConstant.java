package utilities;

import java.util.HashMap;
import java.util.Map;

public class ProConstant {

    public static final String MATCHES_CSV = "/resources/matches.csv";

    public static final String DELIVERIES_CSV = "/resources/deliveries.csv";

    public static final String SUNRISERS_HYDERABAD = "Sunrisers Hyderabad";

    public static final String CHENNAI_SUPER_KINGS = "Chennai Super Kings";

    public static final String DECCAN_CHARGERS = "Deccan Chargers";

    public static final String DELHI_DAREDEVILS = "Delhi Daredevils";

    public static final String GUJARAT_LIONS = "Gujarat Lions";

    public static final String KINGS_XI_PUNJAB = "Kings XI Punjab";

    public static final String KOCHI_TUSKERS_KERALA = "Kochi Tuskers Kerala";

    public static final String KOLKATA_KNIGHT_RIDERS = "Kolkata Knight Riders";

    public static final String MUMBAI_INDIANS = "Mumbai Indians";

    public static final String PUNE_WARRIORS = "Pune Warriors";

    public static final String RAJASTHAN_ROYALS = "Rajasthan Royals";

    public static final String ROYAL_CHALLENGERS_BANGALORE = "Royal Challengers Bangalore";

    public static final String RISING_PUNE_SUPERGIANT = "Rising Pune Supergiant";

    public static final String RISING_PUNE_SUPERGIANTS = "Rising Pune Supergiants";

    public static final Map<String, Integer> teams = new HashMap<>();

    static {
        teams.put(SUNRISERS_HYDERABAD, 1);
        teams.put(CHENNAI_SUPER_KINGS, 2);
        teams.put(DECCAN_CHARGERS, 3);
        teams.put(DELHI_DAREDEVILS, 4);
        teams.put(GUJARAT_LIONS, 5);
        teams.put(KINGS_XI_PUNJAB, 6);
        teams.put(KOCHI_TUSKERS_KERALA, 7);
        teams.put(KOLKATA_KNIGHT_RIDERS, 8);
        teams.put(MUMBAI_INDIANS, 9);
        teams.put(PUNE_WARRIORS, 10);
        teams.put(RAJASTHAN_ROYALS, 11);
        teams.put(ROYAL_CHALLENGERS_BANGALORE, 12);
        teams.put(RISING_PUNE_SUPERGIANT, 13);
        teams.put(RISING_PUNE_SUPERGIANTS, 14);
    }

    public static final Map<Integer, String> teamsByID = new HashMap<>();

    static {
        teamsByID.put(1, SUNRISERS_HYDERABAD);
        teamsByID.put(2, CHENNAI_SUPER_KINGS);
        teamsByID.put(3, DECCAN_CHARGERS);
        teamsByID.put(4, DELHI_DAREDEVILS);
        teamsByID.put(5, GUJARAT_LIONS);
        teamsByID.put(6, KINGS_XI_PUNJAB);
        teamsByID.put(7, KOCHI_TUSKERS_KERALA);
        teamsByID.put(8, KOLKATA_KNIGHT_RIDERS);
        teamsByID.put(9, MUMBAI_INDIANS);
        teamsByID.put(10, PUNE_WARRIORS);
        teamsByID.put(11, RAJASTHAN_ROYALS);
        teamsByID.put(12, ROYAL_CHALLENGERS_BANGALORE);
        teamsByID.put(13, RISING_PUNE_SUPERGIANT);
        teamsByID.put(14, RISING_PUNE_SUPERGIANTS);
    }
}
