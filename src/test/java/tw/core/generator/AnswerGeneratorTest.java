package tw.core.generator;

import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test
    public void should_return_a_standard_answer() {
        //given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        String expected = "1 2 3 4";
        //when
        when(randomIntGenerator.generateNums(9, 4)).thenReturn(expected);
        //then
        try {
            Answer answer = answerGenerator.generate();
            assertEquals(expected, answer.toString());
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
        }
    }

}

