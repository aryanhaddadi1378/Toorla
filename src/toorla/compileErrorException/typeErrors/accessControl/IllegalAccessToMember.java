package toorla.compileErrorException.typeErrors.accessControl;

import toorla.compileErrorException.CompileErrorException;

public abstract class IllegalAccessToMember extends CompileErrorException {
    protected String memberName;
    protected String className;
    public IllegalAccessToMember(String memberName, String className , int line , int col )
    {
        this.memberName = memberName;
        this.atLine = line;
        this.atColumn = col;
        this.className = className;
    }
    protected abstract String memberModifierName();

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:Illegal access to %s %s of an object of Class %s;",
                atLine, memberModifierName(),  memberName, className);
    }

}
