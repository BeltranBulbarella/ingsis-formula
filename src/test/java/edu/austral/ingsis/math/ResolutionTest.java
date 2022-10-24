package edu.austral.ingsis.math;

import org.junit.Test;
import edu.austral.ingsis.math.composite.operators.*;
import edu.austral.ingsis.math.composite.operators.Number;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function f = new Sum(new Number(1.0), new Number(6.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function f = new Div(new Number(12.0), new Number(2.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function f = new Div(new Number(9.0), new Number(2.0));
        Function f2 = new Mul(f, new Number(3.0));
        final Double result = f2.calculate(Map.of());

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function f = new Div(new Number(27.0), new Number(6.0));
        Function f2 = new Pow(f, new Number(2.0));
        final Double result = f2.calculate(Map.of());

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function f = new Div(new Number(1.0), new Number(2.0));
        Function f2 = new Pow(new Number(36.0), f);
        final Double result = f2.calculate(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function f = new Abs(new Number(136.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function f = new Abs(new Number(-136.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function f = new Subt(new Number(5.0), new Number(5.0));
        Function f2 = new Mul(new Number(8.0), f);
        final Double result = f2.calculate(Map.of());

        assertThat(result, equalTo(0d));
    }
}
