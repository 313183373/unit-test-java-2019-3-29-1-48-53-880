package tw.core;

import org.junit.Test;

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
}