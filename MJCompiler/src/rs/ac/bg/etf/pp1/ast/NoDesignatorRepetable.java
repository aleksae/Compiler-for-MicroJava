// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class NoDesignatorRepetable extends Designator {

    private DesignatorInner DesignatorInner;

    public NoDesignatorRepetable (DesignatorInner DesignatorInner) {
        this.DesignatorInner=DesignatorInner;
        if(DesignatorInner!=null) DesignatorInner.setParent(this);
    }

    public DesignatorInner getDesignatorInner() {
        return DesignatorInner;
    }

    public void setDesignatorInner(DesignatorInner DesignatorInner) {
        this.DesignatorInner=DesignatorInner;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorInner!=null) DesignatorInner.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorInner!=null) DesignatorInner.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorInner!=null) DesignatorInner.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoDesignatorRepetable(\n");

        if(DesignatorInner!=null)
            buffer.append(DesignatorInner.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoDesignatorRepetable]");
        return buffer.toString();
    }
}
