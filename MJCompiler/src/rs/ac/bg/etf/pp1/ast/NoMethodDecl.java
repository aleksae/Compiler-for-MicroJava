// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class NoMethodDecl extends MethodDecl {

    public NoMethodDecl () {
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
        buffer.append("NoMethodDecl(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodDecl]");
        return buffer.toString();
    }
}
