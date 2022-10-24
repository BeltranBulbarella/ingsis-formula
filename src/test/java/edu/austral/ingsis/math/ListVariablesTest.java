package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.operators.*;
import edu.austral.ingsis.math.composite.operators.Number;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function f1 = new Number(1.0);
        Function f2 = new Number(6.0);
        Function f3 = new Sum(f1, f2);
        final List<String> result = f3.listVariables(List.of());

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function f1 = new Number(12.0);
        Function f2 = new Variable("div");
        Function f3 = new Div(f1, f2);
        final List<String> result = f3.listVariables(List.of());

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function f1 = new Number(9.0);
        Function f2 = new Variable("x");
        Function f3 = new Div(f1, f2);
        Function f4 = new Variable("y");
        Function f5 = new Mul(f3, f4);
        final List<String> result = f5.listVariables(List.of());

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function f1 = new Number(27.0);
        Function f2 = new Variable("a");
        Function f3 = new Div(f1, f2);
        Function f4 = new Variable("b");
        Function f5 = new Pow(f3, f4);
        final List<String> result = f5.listVariables(List.of());

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function f1 = new Variable("z");
        Function f2 = new Number(2.0);
        Function f3 = new Number(1.0);
        Function f4 = new Div(f3, f2);
        Function f5 = new Pow(f1, f4);
        final List<String> result = f5.listVariables(List.of());

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function f1 = new Variable("value");
        Function f2 = new Number(8.0);
        Function f3 = new Abs(f1);
        Function f4 = new Subt(f3, f2);
        final List<String> result = f4.listVariables(List.of());

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function f1 = new Variable("value");
        Function f2 = new Number(8.0);
        Function f3 = new Abs(f1);
        Function f4 = new Subt(f3, f2);
        final List<String> result = f4.listVariables(List.of());

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function f1 = new Number(5.0);
        Function f2 = new Variable("i");
        Function f3 = new Subt(f1, f2);
        Function f4 = new Number(8.0);
        Function f5 = new Mul(f3, f4);
        final List<String> result = f5.listVariables(List.of());

        assertThat(result, containsInAnyOrder("i"));
    }
}
