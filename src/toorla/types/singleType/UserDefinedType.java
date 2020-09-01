package toorla.types.singleType;

import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.types.Type;
import toorla.types.Undefined;

public class UserDefinedType extends SingleType {
    private ClassDeclaration typeClass;

    public UserDefinedType(ClassDeclaration cd) {
        typeClass = cd;
    }

    public ClassDeclaration getClassDeclaration() {
        return typeClass;
    }

    public void setClassDeclaration(ClassDeclaration typeClass) {
        this.typeClass = typeClass;
    }

    @Override
    public String toString() {
        return typeClass.getName().getName();
    }

    @Override
    public boolean equals(Type type)
    {
        return ( type instanceof UserDefinedType && type.toString().equals(toString()) )
                || type instanceof Undefined;
    }
}
