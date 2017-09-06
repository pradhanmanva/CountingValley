import java.util.Scanner;

import static java.lang.System.*;

public class CountingValley {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(in);
        int steps = 0;
        int track = 0;
        int valley = 0;

        //input
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        //processing Input
        try {
            steps = Integer.parseInt(line1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        char hikes[] = line2.toCharArray();

        //checking Constraints
        boolean status = checkConstraints(steps, hikes);
        if (!status) {
            exit(10);
        }
        //start solving
        //System.out.println(line1);
        //System.out.println(line2);
        for (char hike : hikes) {
            if (hike == 'U') {
                track++;
            }
            if (hike == 'D') {
                if (track == 0) {
                    valley++;
                }
                track--;
            }
        }
        System.out.println(valley);
    }

    private static boolean checkConstraints(int steps, char[] hikes) {
        boolean result = true;

        if (steps < 2 || steps > 1000000) {
            result = false;
        }
        if (steps != hikes.length) {
            result = false;
        }
        for (char hike : hikes) {
            if (hike != 'U' && hike != 'D') {
                result = false;
            }
        }
        return result;
    }
}
