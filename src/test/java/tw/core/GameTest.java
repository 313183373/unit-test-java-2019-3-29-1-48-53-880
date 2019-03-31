package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
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
        String guessString = "1 5 4 3";
        try {
            when(answerGenerator.generate()).thenReturn(Answer.createAnswer(answerString));
            Game game = new Game(answerGenerator);
            GuessResult guessResult = game.guess(Answer.createAnswer(guessString));
            assertEquals("1A2B", guessResult.getResult());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_a_guess_history_after_input_some_answer() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        String answerString = "1 2 3 4";
        String guessStringOne = "1 5 4 3";
        String guessStringTwo = "1 2 4 3";
        List<GuessResult> guessHistory = new ArrayList<>();
        try {
            when(answerGenerator.generate()).thenReturn(Answer.createAnswer(answerString));
            Game game = new Game(answerGenerator);
            GuessResult guessResultOne = game.guess(Answer.createAnswer(guessStringOne));
            GuessResult guessResultTwo = game.guess(Answer.createAnswer(guessStringTwo));
            guessHistory.add(guessResultOne);
            guessHistory.add(guessResultTwo);
            assertEquals(guessHistory, game.guessHistory());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void should_return_true_status_when_game_is_not_over() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        String answerString = "1 2 3 4";
        String guessStringOne = "1 5 4 3";
        String guessStringTwo = "1 2 4 3";
        try {
            when(answerGenerator.generate()).thenReturn(Answer.createAnswer(answerString));
            Game game = new Game(answerGenerator);
            game.guess(Answer.createAnswer(guessStringOne));
            game.guess(Answer.createAnswer(guessStringTwo));
            assertTrue(game.checkCoutinue());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_false_status_when_guess_time_exceed() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        String answerString = "1 2 3 4";
        String guessStringOne = "1 5 4 3";
        String guessStringTwo = "1 2 4 3";
        try {
            when(answerGenerator.generate()).thenReturn(Answer.createAnswer(answerString));
            Game game = new Game(answerGenerator);
            game.guess(Answer.createAnswer(guessStringOne));
            game.guess(Answer.createAnswer(guessStringTwo));
            game.guess(Answer.createAnswer(guessStringTwo));
            game.guess(Answer.createAnswer(guessStringTwo));
            game.guess(Answer.createAnswer(guessStringTwo));
            game.guess(Answer.createAnswer(guessStringTwo));
            assertFalse(game.checkCoutinue());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_false_status_when_guess_right() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        String answerString = "1 2 3 4";
        String guessStringOne = "1 5 4 3";
        String guessStringTwo = "1 2 4 3";
        String guessStringThree = "1 2 3 4";
        try {
            when(answerGenerator.generate()).thenReturn(Answer.createAnswer(answerString));
            Game game = new Game(answerGenerator);
            game.guess(Answer.createAnswer(guessStringOne));
            game.guess(Answer.createAnswer(guessStringTwo));
            game.guess(Answer.createAnswer(guessStringThree));
            assertFalse(game.checkCoutinue());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }
}
