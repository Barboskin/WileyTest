package rules;

import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by Женя on 24.06.2017.
 */

//Здесь можно реализовать отправку результатов в тестов в Test Management Tools (например, TestRail)
public class WatcherRule extends TestWatcher {

    @Override
    protected void succeeded(Description description) {
        System.out.println("!!!! Тест закончился успешно");
    }

    @Override
    protected void failed(Throwable e, Description description) {
        System.err.println("!!!! Тест закончился провалом");
    }

    @Override
    protected void skipped(org.junit.AssumptionViolatedException e, Description description) {
        this.skipped((AssumptionViolatedException)e, description);
    }
}
