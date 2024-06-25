// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class FactorNewFac extends Factor {

    private Type Type;
    private FactorNew FactorNew;

    public FactorNewFac (Type Type, FactorNew FactorNew) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorNew=FactorNew;
        if(FactorNew!=null) FactorNew.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorNew getFactorNew() {
        return FactorNew;
    }

    public void setFactorNew(FactorNew FactorNew) {
        this.FactorNew=FactorNew;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorNew!=null) FactorNew.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorNew!=null) FactorNew.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorNew!=null) FactorNew.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewFac(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorNew!=null)
            buffer.append(FactorNew.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewFac]");
        return buffer.toString();
    }
}
