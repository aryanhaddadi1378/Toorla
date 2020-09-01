package toorla.compileErrorException;

public class CompileErrorException extends Exception {
    protected int atLine;
    protected int atColumn;
    private String errorItem;

    public CompileErrorException(String errorItem, int atLine, int atColumn) {
        this.atLine = atLine;
        this.atColumn = atColumn;
        this.errorItem = errorItem;
    }

    public CompileErrorException() {
    }

    public void setPlace(int line, int column) {
        atLine = line;
        atColumn = column;
    }
    public String toString()
    {
        return String.format("Error:Line:%d:%s;" , atLine, errorItem);
    }

}
