package tw.core;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;
import tw.rules.RepeatRule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tw.rules.RepeatRule.Repeat;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    private RandomIntGenerator randomIntGenerator;

    @Before
    public void init() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_throw_exception_when_arguments_wrong() {
        expectedException.expect(IllegalArgumentException.class);
        randomIntGenerator.generateNums(3, 4);
    }

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 5)
    public void should_return_a_correct_random_string() {
        String answer = randomIntGenerator.generateNums(9, 4);
        String regex = "^[0-9] [0-9] [0-9] [0-9]$";
        HashSet<String> numbers = new HashSet<>(Arrays.asList(answer.split(" ")));
        assertTrue(Pattern.matches(regex, answer));
        assertEquals(4, numbers.size());
    }
}