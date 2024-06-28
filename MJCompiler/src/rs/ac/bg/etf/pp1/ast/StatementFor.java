// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private ForDect ForDect;
    private OptionalDesignatorStatementFor OptionalDesignatorStatementFor;
    private OptionalCondFactFor OptionalCondFactFor;
    private OptionalDesignatorStatementFor OptionalDesignatorStatementFor1;
    private Statement Statement;

    public StatementFor (ForDect ForDect, OptionalDesignatorStatementFor OptionalDesignatorStatementFor, OptionalCondFactFor OptionalCondFactFor, OptionalDesignatorStatementFor OptionalDesignatorStatementFor1, Statement Statement) {
        this.ForDect=ForDect;
        if(ForDect!=null) ForDect.setParent(this);
        this.OptionalDesignatorStatementFor=OptionalDesignatorStatementFor;
        if(OptionalDesignatorStatementFor!=null) OptionalDesignatorStatementFor.setParent(this);
        this.OptionalCondFactFor=OptionalCondFactFor;
        if(OptionalCondFactFor!=null) OptionalCondFactFor.setParent(this);
        this.OptionalDesignatorStatementFor1=OptionalDesignatorStatementFor1;
        if(OptionalDesignatorStatementFor1!=null) OptionalDesignatorStatementFor1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForDect getForDect() {
        return ForDect;
    }

    public void setForDect(ForDect ForDect) {
        this.ForDect=ForDect;
    }

    public OptionalDesignatorStatementFor getOptionalDesignatorStatementFor() {
        return OptionalDesignatorStatementFor;
    }

    public void setOptionalDesignatorStatementFor(OptionalDesignatorStatementFor OptionalDesignatorStatementFor) {
        this.OptionalDesignatorStatementFor=OptionalDesignatorStatementFor;
    }

    public OptionalCondFactFor getOptionalCondFactFor() {
        return OptionalCondFactFor;
    }

    public void setOptionalCondFactFor(OptionalCondFactFor OptionalCondFactFor) {
        this.OptionalCondFactFor=OptionalCondFactFor;
    }

    public OptionalDesignatorStatementFor getOptionalDesignatorStatementFor1() {
        return OptionalDesignatorStatementFor1;
    }

    public void setOptionalDesignatorStatementFor1(OptionalDesignatorStatementFor OptionalDesignatorStatementFor1) {
        this.OptionalDesignatorStatementFor1=OptionalDesignatorStatementFor1;
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
        if(ForDect!=null) ForDect.accept(visitor);
        if(OptionalDesignatorStatementFor!=null) OptionalDesignatorStatementFor.accept(visitor);
        if(OptionalCondFactFor!=null) OptionalCondFactFor.accept(visitor);
        if(OptionalDesignatorStatementFor1!=null) OptionalDesignatorStatementFor1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForDect!=null) ForDect.traverseTopDown(visitor);
        if(OptionalDesignatorStatementFor!=null) OptionalDesignatorStatementFor.traverseTopDown(visitor);
        if(OptionalCondFactFor!=null) OptionalCondFactFor.traverseTopDown(visitor);
        if(OptionalDesignatorStatementFor1!=null) OptionalDesignatorStatementFor1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForDect!=null) ForDect.traverseBottomUp(visitor);
        if(OptionalDesignatorStatementFor!=null) OptionalDesignatorStatementFor.traverseBottomUp(visitor);
        if(OptionalCondFactFor!=null) OptionalCondFactFor.traverseBottomUp(visitor);
        if(OptionalDesignatorStatementFor1!=null) OptionalDesignatorStatementFor1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(ForDect!=null)
            buffer.append(ForDect.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignatorStatementFor!=null)
            buffer.append(OptionalDesignatorStatementFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalCondFactFor!=null)
            buffer.append(OptionalCondFactFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignatorStatementFor1!=null)
            buffer.append(OptionalDesignatorStatementFor1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}
