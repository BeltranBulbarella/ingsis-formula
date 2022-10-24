package edu.austral.ingsis.math.visitor.visit;


import edu.austral.ingsis.math.visitor.interfaces.Visitor;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.utils.Number;
import edu.austral.ingsis.math.visitor.utils.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariableVisitor implements Visitor<List<String>> {

    private final List<String> variables;

    public ListVariableVisitor() {
        this.variables = new ArrayList<>();
    }

    @Override
    public List<String> visitSum(Sum operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitSubt(Subt operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitAbs(Abs operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public List<String> visitDiv(Div operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitMul(Mul operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitPar(Par operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public List<String> visitPow(Pow operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitNumber(Number operand) {
        return List.of();
    }

    @Override
    public List<String> visitVariable(Variable operand) {
        return List.of(operand.getVariable());
    }

}

