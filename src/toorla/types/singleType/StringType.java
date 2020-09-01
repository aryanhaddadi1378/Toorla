package toorla.types.singleType;


import toorla.types.Type;
import toorla.types.Undefined;

public class StringType extends SingleType {
    @Override
    public String toString() {
        return "string";
    }

    @Override
    public boolean equals(Type type) {
        return type instanceof StringType || type instanceof Undefined;
    }
}
