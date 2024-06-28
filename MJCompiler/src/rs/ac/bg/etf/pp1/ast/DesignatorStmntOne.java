// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmntOne extends DesignatorStatement {

    private Designator Designator;
    private DesignatorStatementPartOne DesignatorStatementPartOne;

    public DesignatorStmntOne (Designator Designator, DesignatorStatementPartOne DesignatorStatementPartOne) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorStatementPartOne=DesignatorStatementPartOne;
        if(DesignatorStatementPartOne!=null) DesignatorStatementPartOne.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorStatementPartOne getDesignatorStatementPartOne() {
        return DesignatorStatementPartOne;
    }

    public void setDesignatorStatementPartOne(DesignatorStatementPartOne DesignatorStatementPartOne) {
        this.DesignatorStatementPartOne=DesignatorStatementPartOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorStatementPartOne!=null) DesignatorStatementPartOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorStatementPartOne!=null) DesignatorStatementPartOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorStatementPartOne!=null) DesignatorStatementPartOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmntOne(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementPartOne!=null)
            buffer.append(DesignatorStatementPartOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmntOne]");
        return buffer.toString();
    }
}
