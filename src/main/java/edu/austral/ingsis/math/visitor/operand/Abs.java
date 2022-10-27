package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Abs implements Visitable {

    final private Visitable f1;

    public Abs(Visitable f1) {
        this.f1 = f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitAbs(this);
    }

    public Visitable getF1() {
        return f1;
    }

}
