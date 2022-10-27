package visitor;


import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.visit.CalculateVisitor;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {
    private final static Visitor<Double> visitor = new CalculateVisitor();
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = visitor.visitSum(new Sum(new Number(1.0), new Number(6.0)));
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = visitor.visitDiv(new Div(new Number(12.0), new Number(2.0)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double result = visitor.visitMul(new Mul(new Par(new Div(new Number(9.0), new Number(2.0))), new Number(3.0)));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double result = visitor.visitPow(new Pow(new Par(new Div(new Number(27.0), new Number(6.0))), new Number(2.0)));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = visitor.visitPow(new Pow(new Number(36.0), new Par( new Div(new Number(1.0), new Number(2.0)))));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = visitor.visitAbs(new Abs(new Number(136.0)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = visitor.visitAbs(new Abs(new Number(-136.0)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double result = visitor.visitMul(new Mul(new Par(new Subt(new Number(5.0), new Number(5.0))), new Number(8.0)));

        assertThat(result, equalTo(0d));
    }
}
