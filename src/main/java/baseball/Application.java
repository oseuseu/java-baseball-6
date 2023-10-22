package baseball;

import baseball.model.BaseballModel;
import baseball.model.Score;
import baseball.view.BaseballView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballModel model = new BaseballModel();
        BaseballView view = new BaseballView();
        while (true) {
            model.generateAnswer();
            view.printStartMessage();

            Score score;
            do {
                String guessInput = view.getPlayerGuess();
                if (!model.isValidGuess(guessInput)) {
                    throw new IllegalArgumentException("유효하지 않은 값 입력");
                }
                List<Integer> playerGuess = model.parseStringToIntegerList(guessInput);
                score = model.calculateScore(playerGuess);
                view.printGameResult(score);
            } while (score.getStrike() != 3);

            view.printEndMessage();

            String choiceInput = view.getPlayerChoice();
            if (!model.isValidChoice(choiceInput)) {
                throw new IllegalArgumentException("유효하지 않은 값 입력");
            }
            if (choiceInput.equals("2")) {
                break;
            }
        }
    }
}
