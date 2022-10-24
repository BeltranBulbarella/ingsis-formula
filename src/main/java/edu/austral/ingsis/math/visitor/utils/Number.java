package edu.austral.ingsis.math.visitor.utils;


import edu.austral.ingsis.math.visitor.interfaces.Function;
import edu.austral.ingsis.math.visitor.interfaces.Visitable;
import edu.austral.ingsis.math.visitor.interfaces.Visitor;

public class Number implements Function, Visitable {

    private final Double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitNumber(this);
    }

    public Double getNumber() {
        return this.number;
    }
}
