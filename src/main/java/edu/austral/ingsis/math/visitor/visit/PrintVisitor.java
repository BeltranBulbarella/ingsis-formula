package edu.austral.ingsis.math.visitor.visit;


import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;

public class PrintVisitor implements Visitor<String> {

    @Override
    public String visitSum(Sum operand) {
        return operand.getF1().accept(this) + " + " + operand.getF2().accept(this);
    }

    @Override
    public String visitSubt(Subt operand) {
        return operand.getF1().accept(this) + " - " + operand.getF2().accept(this);
    }

    @Override
    public String visitAbs(Abs operand) {
        return "|" + operand.getF1().accept(this) + "|";
    }

    @Override
    public String visitMul(Mul operand) {
        return operand.getF1().accept(this) + " * " + operand.getF2().accept(this);
    }

    @Override
    public String visitDiv(Div operand) {
        return operand.getF1().accept(this) + " / " + operand.getF2().accept(this);
    }

    @Override
    public String visitPow(Pow operand) {
        return operand.getF1().accept(this) + " ^ " + operand.getF2().accept(this);
    }

    @Override
    public String visitPar(Par operand) {
        return "(" + operand.getF1().accept(this) + ")";
    }

    @Override
    public String visitNumber(Number operand) {
        if (operand.getNumber() == Math.floor(operand.getNumber())) {
            return String.format("%d", operand.getNumber().intValue());
        } else {
            return String.format("%s", operand.getNumber());
        }
    }

    @Override
    public String visitVariable(Variable operand) {
        return operand.getVariable();
    }

}