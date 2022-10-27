package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;


public class Par implements  Visitable {

    private final Visitable f1;

    public Par(Visitable f1) {
        this.f1 = f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitPar(this);
    }

    public Visitable getF1() {
        return f1;
    }

}
