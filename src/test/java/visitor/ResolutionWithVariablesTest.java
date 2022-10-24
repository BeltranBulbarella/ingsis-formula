package visitor;

import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;
import edu.austral.ingsis.math.visitor.visit.CalculateVisitor;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Function function = new Sum(
                new Number(1.0),
                new Variable("x")
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("x",3.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Function function = new Div(
                new Number(12.0),
                new Variable("div")
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("div",4.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Function function = new Mul(
                new Div(
                        new Number(9.0),
                        new Variable("x")
                ),
                new Variable("y")
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("x",3.0, "y", 4.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Function function = new Pow(
                new Div(
                        new Number(27.0),
                        new Variable("a")
                ),
                new Variable("b")
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("a",9.0, "b",3.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Function function = new Pow(
                new Variable("z"),
                new Number(0.5)
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("z",36.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Function function = new Subt(
                new Abs(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("value",8.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Function function = new Subt(
                new Abs(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("value",8.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Function function = new Mul(
                new Subt(
                        new Number(5.0),
                        new Variable("i")
                ),
                new Number(8.0)
        );
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("i",2.0));
        final Double result = function.accept(visitor);

        assertThat(result, equalTo(24d));
    }
}
