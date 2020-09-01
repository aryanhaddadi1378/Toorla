import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;


//main toorla runner

public class Toorla {
    public static void main(String[] args) throws IOException {
        CharStream textStream = CharStreams.fromFileName(args[0]);
        ToorlaCompiler compiler = new ToorlaCompiler();
        compiler.compile(textStream);
    }
}
