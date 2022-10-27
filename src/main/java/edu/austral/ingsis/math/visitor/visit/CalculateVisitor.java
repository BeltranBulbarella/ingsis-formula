package edu.austral.ingsis.math.visitor.visit;

import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;

import java.util.Map;

public class CalculateVisitor implements Visitor<Double> {

    private final Map<String, Double> variableValues;
    public CalculateVisitor(Map<String, Double> variableValues) {
        this.variableValues = variableValues;
    }
    public CalculateVisitor() {
        this(Map.of());
    }

    @Override
    public Double visitSum(Sum operand) {
        return operand.getF1().accept(this) + operand.getF2().accept(this);
    }

    @Override
    public Double visitSubt(Subt operand) {
        return operand.getF1().accept(this) - operand.getF2().accept(this);
    }

    @Override
    public Double visitMul(Mul operand) {
        return operand.getF1().accept(this) * operand.getF2().accept(this);
    }

    @Override
    public Double visitDiv(Div operand) {
        return operand.getF1().accept(this) / operand.getF2().accept(this);
    }

    @Override
    public Double visitPow(Pow operand) {
        return Math.pow(operand.getF1().accept(this), operand.getF2().accept(this));
    }

    @Override
    public Double visitAbs(Abs operand) {
        return Math.abs(operand.getF1().accept(this));
    }

    @Override
    public Double visitPar(Par operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public Double visitNumber(Number operand) {
        return operand.getNumber();
    }

    @Override
    public Double visitVariable(Variable operand) {
        return this.variableValues.get(operand.getVariable());
    }

}
