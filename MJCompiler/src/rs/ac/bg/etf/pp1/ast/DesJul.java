// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class DesJul extends DesignatorStatement {

    private DesignatorJul DesignatorJul;

    public DesJul (DesignatorJul DesignatorJul) {
        this.DesignatorJul=DesignatorJul;
        if(DesignatorJul!=null) DesignatorJul.setParent(this);
    }

    public DesignatorJul getDesignatorJul() {
        return DesignatorJul;
    }

    public void setDesignatorJul(DesignatorJul DesignatorJul) {
        this.DesignatorJul=DesignatorJul;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorJul!=null) DesignatorJul.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorJul!=null) DesignatorJul.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorJul!=null) DesignatorJul.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesJul(\n");

        if(DesignatorJul!=null)
            buffer.append(DesignatorJul.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesJul]");
        return buffer.toString();
    }
}
