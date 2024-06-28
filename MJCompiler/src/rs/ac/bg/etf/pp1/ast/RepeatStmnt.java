// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class RepeatStmnt extends RepeatStatement {

    private RepeatStatement RepeatStatement;
    private Statement Statement;

    public RepeatStmnt (RepeatStatement RepeatStatement, Statement Statement) {
        this.RepeatStatement=RepeatStatement;
        if(RepeatStatement!=null) RepeatStatement.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public RepeatStatement getRepeatStatement() {
        return RepeatStatement;
    }

    public void setRepeatStatement(RepeatStatement RepeatStatement) {
        this.RepeatStatement=RepeatStatement;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RepeatStatement!=null) RepeatStatement.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RepeatStatement!=null) RepeatStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RepeatStatement!=null) RepeatStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RepeatStmnt(\n");

        if(RepeatStatement!=null)
            buffer.append(RepeatStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RepeatStmnt]");
        return buffer.toString();
    }
}
