// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class CondFactRepFull extends CondFactRepeater {

    private CondFact CondFact;
    private CondFactRepeater CondFactRepeater;

    public CondFactRepFull (CondFact CondFact, CondFactRepeater CondFactRepeater) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.CondFactRepeater=CondFactRepeater;
        if(CondFactRepeater!=null) CondFactRepeater.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public CondFactRepeater getCondFactRepeater() {
        return CondFactRepeater;
    }

    public void setCondFactRepeater(CondFactRepeater CondFactRepeater) {
        this.CondFactRepeater=CondFactRepeater;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFact!=null) CondFact.accept(visitor);
        if(CondFactRepeater!=null) CondFactRepeater.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(CondFactRepeater!=null) CondFactRepeater.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(CondFactRepeater!=null) CondFactRepeater.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactRepFull(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactRepeater!=null)
            buffer.append(CondFactRepeater.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactRepFull]");
        return buffer.toString();
    }
}
