package toorla.compileErrorException.typeErrors.accessControl;

public class IllegalAccessToField extends IllegalAccessToMember {

    public IllegalAccessToField(String memberName, String className, int line, int col) {
        super(memberName, className, line, col);
    }

    @Override
    protected String memberModifierName() {
        return "Field";
    }
}
