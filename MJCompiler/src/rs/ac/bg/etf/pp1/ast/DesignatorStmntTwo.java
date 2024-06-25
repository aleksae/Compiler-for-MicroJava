// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmntTwo extends DesignatorStatement {

    private DesignatorStatementPartTwo DesignatorStatementPartTwo;

    public DesignatorStmntTwo (DesignatorStatementPartTwo DesignatorStatementPartTwo) {
        this.DesignatorStatementPartTwo=DesignatorStatementPartTwo;
        if(DesignatorStatementPartTwo!=null) DesignatorStatementPartTwo.setParent(this);
    }

    public DesignatorStatementPartTwo getDesignatorStatementPartTwo() {
        return DesignatorStatementPartTwo;
    }

    public void setDesignatorStatementPartTwo(DesignatorStatementPartTwo DesignatorStatementPartTwo) {
        this.DesignatorStatementPartTwo=DesignatorStatementPartTwo;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementPartTwo!=null) DesignatorStatementPartTwo.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementPartTwo!=null) DesignatorStatementPartTwo.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementPartTwo!=null) DesignatorStatementPartTwo.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmntTwo(\n");

        if(DesignatorStatementPartTwo!=null)
            buffer.append(DesignatorStatementPartTwo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmntTwo]");
        return buffer.toString();
    }
}
