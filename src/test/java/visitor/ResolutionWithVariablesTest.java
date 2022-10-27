package visitor;

import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;
import edu.austral.ingsis.math.visitor.visit.CalculateVisitor;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("x",3d));
        final Double result = visitor.visitSum(new Sum(new Number(1.0), new Variable("x")));


        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("div",4d));
        final Double result = visitor.visitDiv(new Div(new Number(12.0), new Variable("div")));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("x",3d,"y",4d));
        final Double result = visitor.visitMul(new Mul(new Par(new Div(new Number(9.0), new Variable("x"))), new Variable("y")));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("a",9d,"b",3d));
        final Double result = visitor.visitPow(new Pow(new Par(new Div(new Number(27.0), new Variable("a"))), new Variable("b")));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("z",36d));
        final Double result = visitor.visitPow(new Pow(new Variable("z"), new Div(new Number(1.0), new Number(2.0))));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("value",8d));
        final Double result = visitor.visitSubt(new Subt(new Abs(new Variable("value")), new Number(8.0)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("value",8d));
        final Double result = visitor.visitSubt(new Subt(new Abs(new Variable("value")), new Number(8.0)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Visitor<Double> visitor = new CalculateVisitor(Map.of("i",2d));
        final Double result = visitor.visitMul(new Mul(new Par(new Subt(new Number(5.0), new Variable("i"))), new Number(8.0)));

        assertThat(result, equalTo(24d));
    }
}
