package toorla.symbolTable.symbolTableItem;

public abstract class SymbolTableItem {

    protected String name;

    public abstract String getKey();

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
    public boolean mustBeUsedAfterDef()
    {
        return false;
    }
    public int getDefinitionNumber()
    {
        return 0;
    }
}
