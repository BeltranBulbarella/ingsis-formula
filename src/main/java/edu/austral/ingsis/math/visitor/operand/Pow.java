package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Pow implements Visitable {

    final private Visitable f1;
    final private Visitable f2;

    public Pow(Visitable f1, Visitable f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitPow(this);
    }

    public Visitable getF1() {
        return f1;
    }

    public Visitable getF2() {
        return f2;
    }

}