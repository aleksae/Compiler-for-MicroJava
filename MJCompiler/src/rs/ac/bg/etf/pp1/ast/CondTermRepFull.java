// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class CondTermRepFull extends CondTermRepeater {

    private CondTerm CondTerm;
    private CondTermRepeater CondTermRepeater;

    public CondTermRepFull (CondTerm CondTerm, CondTermRepeater CondTermRepeater) {
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
        this.CondTermRepeater=CondTermRepeater;
        if(CondTermRepeater!=null) CondTermRepeater.setParent(this);
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public CondTermRepeater getCondTermRepeater() {
        return CondTermRepeater;
    }

    public void setCondTermRepeater(CondTermRepeater CondTermRepeater) {
        this.CondTermRepeater=CondTermRepeater;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTerm!=null) CondTerm.accept(visitor);
        if(CondTermRepeater!=null) CondTermRepeater.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
        if(CondTermRepeater!=null) CondTermRepeater.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        if(CondTermRepeater!=null) CondTermRepeater.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermRepFull(\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermRepeater!=null)
            buffer.append(CondTermRepeater.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermRepFull]");
        return buffer.toString();
    }
}
