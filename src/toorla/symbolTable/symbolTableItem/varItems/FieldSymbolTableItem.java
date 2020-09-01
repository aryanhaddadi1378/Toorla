package toorla.symbolTable.symbolTableItem.varItems;

import toorla.ast.declaration.classDecs.classMembersDecs.AccessModifier;
import toorla.types.Type;

public class FieldSymbolTableItem extends VarSymbolTableItem {

    private AccessModifier accessModifier;

    public FieldSymbolTableItem(String name, AccessModifier accessModifier, Type type) {
        this.name = name;
        this.accessModifier = accessModifier;
        this.type = type;
    }

    public FieldSymbolTableItem(String name, Type type) {
        this.name = name;
        this.accessModifier = AccessModifier.ACCESS_MODIFIER_PRIVATE;
        this.type = type;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public Type getFieldType() {
        return type;
    }

    public void setFieldType(Type fieldType) {
        this.type = fieldType;
    }
}
