package toorla.compileErrorException.typeErrors.accessControl;

public class IllegalAccessToMethod extends IllegalAccessToMember {
    public IllegalAccessToMethod(String memberName, String className, int line, int col) {
        super(memberName, className, line, col);
    }

    @Override
    protected String memberModifierName() {
        return "Method";
    }
}
