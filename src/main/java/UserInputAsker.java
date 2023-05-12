import java.util.List;
import java.util.Scanner;

public class UserInputAsker {
    private final Scanner scanner;

    public UserInputAsker(){
        scanner = new Scanner(System.in);
    }

    public Integer askUserPositiveInteger(String wrongAnswerMessage, int maxArea) {
        Integer userAnswer = Integer.MIN_VALUE;
        do {
            String introducedAnswer = scanner.nextLine();
            try {
                userAnswer = Integer.parseInt(introducedAnswer);
            } catch (NumberFormatException e) {
                System.out.println(wrongAnswerMessage);
                continue;
            }
            if (userAnswer < 1 || userAnswer > maxArea) {
                System.out.println(wrongAnswerMessage);
            }
        } while (userAnswer < 1 && userAnswer > maxArea);
        return userAnswer;
    }
}
