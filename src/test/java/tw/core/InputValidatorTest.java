package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.validator.InputValidator;

import static org.junit.Assert.assertFalse;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @Before
    public void initInputValidator() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_false_when_input_not_enough_number() {
        String inputString = "1 2 3";
        assertFalse(inputValidator.validate(inputString));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_throw_a_exception_when_input_is_not_number() {
        String inputString = "1 2 3 A";
        expectedException.expect(NumberFormatException.class);
        inputValidator.validate(inputString);
    }

    @Test
    public void should_return_false_when_input_number_out_of_range() {
        String inputString = "1 2 3 10";
        assertFalse(inputValidator.validate(inputString));
    }

    @Test
    public void should_return_false_when_input_too_much_number() {
        String inputString = "1 2 3 4 5";
        assertFalse(inputValidator.validate(inputString));
    }

    @Test
    public void should_return_false_when_input_duplicated_number() {
        String inputString = "1 2 3 3";
        assertFalse(inputValidator.validate(inputString));
    }
}
