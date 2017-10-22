package rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryOnFailure implements TestRule {

    private int rc;

    public RetryOnFailure(int rc){
        this.rc = rc;
    }

    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable throwable = null;
                //retryOnFailure this many times
                for(int i = 0; i < rc;i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable e) {
                        throwable = e;
                    }
                }
                System.out.println("this test failed " + rc);
                throw throwable;
            }

        };
    }
}