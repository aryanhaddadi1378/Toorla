package toorla.nameAnalyzer;

import toorla.ast.Program;

public interface INameAnalyzingPass<T>  {
    void analyze(Program program);
    T getResult();

}