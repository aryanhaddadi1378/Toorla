package toorla.types;

public class AnonymousType extends Type {
    @Override
    public String toString() {
        return "Anonymous";
    }

    @Override
    public boolean equals(Type type) {
        return type instanceof AnonymousType || type instanceof Undefined;
    }
}
