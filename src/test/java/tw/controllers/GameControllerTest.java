package tw.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void should_print_a_welcome_message_when_start_game() {
        try {
            new GameController(new Game(new AnswerGenerator(new RandomIntGenerator())), new GameView()).beginGame();
            assertEquals("------Guess Number Game, You have 6 chances to guess!  ------\n", outContent.toString());
        } catch (IOException | OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }
}