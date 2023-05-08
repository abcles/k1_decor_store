import java.util.List;
import java.util.Scanner;

public class UserInputAsker {
    private final Scanner scanner;

    public UserInputAsker(){
        scanner = new Scanner(System.in);
    }

    public Integer askUserIntegerInput(String wrongAnswerMessage, List<Integer> goodAnswers) {
        Integer userAnswer = Integer.MIN_VALUE;
        do {
            String introducedAnswer = scanner.nextLine();
            try {
                userAnswer = Integer.parseInt(introducedAnswer);
            } catch (NumberFormatException e) {
                System.out.println(wrongAnswerMessage);
                continue;
            }
            if (!goodAnswers.contains(userAnswer)) {
                System.out.println(wrongAnswerMessage);
            }
        } while (!goodAnswers.contains(userAnswer));
        return userAnswer;
    }
}
