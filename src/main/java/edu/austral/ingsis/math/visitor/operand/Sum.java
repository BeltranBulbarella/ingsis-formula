package edu.austral.ingsis.math.visitor.operand;


import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Sum implements Visitable {

    private final Visitable f1;
    private final Visitable f2;

    public Sum(Visitable f1, Visitable f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSum(this);
    }

    public Visitable getF1() {
        return f1;
    }

    public Visitable getF2() {
        return f2;
    }
}