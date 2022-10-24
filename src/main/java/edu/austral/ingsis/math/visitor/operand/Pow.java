package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Pow implements Function, Visitable {

    final private Function f1;
    final private Function f2;

    public Pow(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitPow(this);
    }

    public Function getF1() {
        return f1;
    }

    public Function getF2() {
        return f2;
    }

}