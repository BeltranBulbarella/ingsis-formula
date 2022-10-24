package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;


public class Par implements Function, Visitable {

    private final Function f1;

    public Par(Function f1) {
        this.f1 = f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitPar(this);
    }

    public Function getF1() {
        return f1;
    }

}
