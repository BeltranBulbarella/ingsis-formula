package edu.austral.ingsis.math.visitor.interfaces;


public interface Visitable {
    <T> T accept(Visitor<T> visitor);
}
