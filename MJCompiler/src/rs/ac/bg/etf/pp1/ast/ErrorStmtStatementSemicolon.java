// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class ErrorStmtStatementSemicolon extends Statement {

    public ErrorStmtStatementSemicolon () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorStmtStatementSemicolon(\n");

        buffer.append(tab);
        buffer.append(") [ErrorStmtStatementSemicolon]");
        return buffer.toString();
    }
}
