package toorla.types.singleType;


import toorla.types.Type;
import toorla.types.Undefined;

public class IntType extends SingleType {
    @Override
    public String toString() {
        return "int";
    }

    @Override
    public boolean equals(Type type) {
        return type instanceof IntType || type instanceof Undefined;
    }
}
