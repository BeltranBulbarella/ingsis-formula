package edu.austral.ingsis.math.visitor.utils;


import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Variable implements Function, Visitable {

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariable(this);
    }

    public String getVariable() {
        return this.variable;
    }
}