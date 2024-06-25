// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class StatementCurlyStatement extends Statement {

    private StatementRepeat StatementRepeat;

    public StatementCurlyStatement (StatementRepeat StatementRepeat) {
        this.StatementRepeat=StatementRepeat;
        if(StatementRepeat!=null) StatementRepeat.setParent(this);
    }

    public StatementRepeat getStatementRepeat() {
        return StatementRepeat;
    }

    public void setStatementRepeat(StatementRepeat StatementRepeat) {
        this.StatementRepeat=StatementRepeat;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementRepeat!=null) StatementRepeat.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementRepeat!=null) StatementRepeat.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementRepeat!=null) StatementRepeat.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementCurlyStatement(\n");

        if(StatementRepeat!=null)
            buffer.append(StatementRepeat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementCurlyStatement]");
        return buffer.toString();
    }
}
