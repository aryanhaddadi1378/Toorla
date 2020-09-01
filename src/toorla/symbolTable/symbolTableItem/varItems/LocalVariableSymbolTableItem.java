package toorla.symbolTable.symbolTableItem.varItems;

import toorla.types.AnonymousType;
import toorla.types.Type;

public class LocalVariableSymbolTableItem extends VarSymbolTableItem {

    private int index;

    public LocalVariableSymbolTableItem(String name, int index) {
        this.name = name;
        this.type = new AnonymousType();
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Type getVarType() {
        return type;
    }

    public void setVarType(Type varType) {
        this.type = varType;
    }
    @Override
    public boolean mustBeUsedAfterDef()
    {
        return true;
    }
    @Override
    public int getDefinitionNumber()
    {
        return index;
    }
}
