package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Abs implements Function, Visitable {

    final private Function f1;

    public Abs(Function f1) {
        this.f1 = f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitAbs(this);
    }

    public Function getF1() {
        return f1;
    }

}
