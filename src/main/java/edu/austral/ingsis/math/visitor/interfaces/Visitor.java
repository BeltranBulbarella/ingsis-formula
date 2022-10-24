package edu.austral.ingsis.math.visitor.interfaces;


import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;

public interface Visitor<T> {
    T visitSum(Sum operand);
    T visitSubt(Subt operand);
    T visitMul(Mul operand);
    T visitDiv(Div operand);
    T visitPow(Pow operand);

    //no sqrt in tests

    T visitAbs(Abs operand);
    T visitPar(Par operand);
    T visitNumber(Number operand);
    T visitVariable(Variable operand);
}
