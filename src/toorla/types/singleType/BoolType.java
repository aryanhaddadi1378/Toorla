package toorla.types.singleType;


import toorla.types.Type;
import toorla.types.Undefined;

public class BoolType extends SingleType {
    @Override
    public String toString() {
        return "bool";
    }

    @Override
    public boolean equals(Type type) {
        return type instanceof BoolType || type instanceof Undefined;
    }
}
