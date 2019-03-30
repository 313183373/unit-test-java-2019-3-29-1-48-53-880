package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    @Test
    public void should_return_a_answer_result_after_input_a_answer() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        String answerString = "1 2 3 4";
        String guessString = "3 5 4 1";
        try {
            when(answerGenerator.generate()).thenReturn(Answer.createAnswer(answerString));
            Game game = new Game(answerGenerator);
            GuessResult guessResult = game.guess(Answer.createAnswer(guessString));
            assertEquals("0A3B", guessResult.getResult());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }
}
