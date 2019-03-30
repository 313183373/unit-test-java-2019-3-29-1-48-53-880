package tw.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test
    public void should_return_a_answer_when_create_a_answer_with_string() {
        //given
        String answerString = "1 2 3 4";
        Answer answer = Answer.createAnswer(answerString);
        //when
        //then
        assertEquals(answerString, answer.toString());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_a_exception_when_input_a_duplicated_number() throws OutOfRangeAnswerException {
        //given
        String answerString = "1 2 3 3";
        Answer answer = Answer.createAnswer(answerString);
        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        //when
        //then
        answer.validate();
    }

    @Test
    public void should_throw_a_exception_when_input_a_out_of_range_number() throws OutOfRangeAnswerException {
        //given
        String answerString = "1 2 3 10";
        Answer answer = Answer.createAnswer(answerString);
        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        //when
        //then
        answer.validate();
    }

    @Test
    public void should_throw_a_exception_when_input_is_not_number() throws OutOfRangeAnswerException {
        //given
        String answerString = "1 2 3 a";
        Answer answer = Answer.createAnswer(answerString);
        thrown.expect(NumberFormatException.class);
        //when
        //then
        answer.validate();
    }
}