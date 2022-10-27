package visitor;

import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;
import edu.austral.ingsis.math.visitor.visit.PrintVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    final private static Visitor<String> visitor = new PrintVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = visitor.visitSum(new Sum(new Number(1.0), new Number(6.0)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String result = visitor.visitDiv(new Div(new Number(12.0), new Number(2.0)));
        final String expected = "12 / 2";

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = visitor.visitMul(new Mul(new Par(new Div(new Number(9.0), new Number(2.0))), new Number(3.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = visitor.visitPow(new Pow(new Par(new Div(new Number(27.0), new Number(6.0))), new Number(2.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = visitor.visitSubt(new Subt(new Abs(new Variable("value")), new Number(8.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = visitor.visitSubt(new Subt(new Abs(new Variable("value")), new Number(8.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = visitor.visitMul(new Mul(new Par(new Subt(new Number(5.0), new Variable("i"))), new Number(8.0)));

        assertThat(result, equalTo(expected));
    }
}
