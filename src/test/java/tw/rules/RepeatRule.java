package tw.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatRule implements TestRule {

    public static class MyStatement extends Statement {
        private final int times;
        private final Statement base;

        MyStatement(int times, Statement base) {
            this.times = times;
            this.base = base;
        }

        @Override
        public void evaluate() throws Throwable {
            for (int i = 0; i < times; i++) {
                base.evaluate();
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Repeat {
        public abstract int times();
    }

    @Override
    public Statement apply(Statement base, Description description) {
        Repeat repeat = description.getAnnotation(Repeat.class);
        if (repeat != null) {
            return new MyStatement(repeat.times(), base);
        }
        return base;
    }
}
