import java.util.Arrays;

public class FantasyAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // Established players: a long track record qualifies on experience alone
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Newer players: need to be reasonably experienced AND currently fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count] = p;
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);
        Arrays.sort(finalList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            sb.append(i + 1).append(". ").append(finalList[i].name);

            if (i < finalList.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
