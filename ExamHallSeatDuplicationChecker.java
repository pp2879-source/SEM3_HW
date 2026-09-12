public class ExamHallSeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {
        int[] reported = new int[seatNumbers.length];
        int reportedCount = 0;
        boolean foundAny = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    boolean alreadyReported = false;
                    for (int r = 0; r < reportedCount; r++) {
                        if (reported[r] == seatNumbers[i]) {
                            alreadyReported = true;
                            break;
                        }
                    }

                    if (!alreadyReported) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        reported[reportedCount] = seatNumbers[i];
                        reportedCount++;
                        foundAny = true;
                    }
                }
            }
        }

        if (!foundAny) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats1);

        int[] seats2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(seats2);
    }
}
