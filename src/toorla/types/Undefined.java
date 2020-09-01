package toorla.types;

public class Undefined extends Type {
    @Override
    public String toString() {
        return "$Undefined";
    }
    @Override
    public boolean equals(Type type)
    {
        return true;
    }
}
