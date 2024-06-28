// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class RepeatingConstDecl extends RepeatConstDecl {

    private ConstName ConstName;
    private ConstElem ConstElem;
    private RepeatConstDecl RepeatConstDecl;

    public RepeatingConstDecl (ConstName ConstName, ConstElem ConstElem, RepeatConstDecl RepeatConstDecl) {
        this.ConstName=ConstName;
        if(ConstName!=null) ConstName.setParent(this);
        this.ConstElem=ConstElem;
        if(ConstElem!=null) ConstElem.setParent(this);
        this.RepeatConstDecl=RepeatConstDecl;
        if(RepeatConstDecl!=null) RepeatConstDecl.setParent(this);
    }

    public ConstName getConstName() {
        return ConstName;
    }

    public void setConstName(ConstName ConstName) {
        this.ConstName=ConstName;
    }

    public ConstElem getConstElem() {
        return ConstElem;
    }

    public void setConstElem(ConstElem ConstElem) {
        this.ConstElem=ConstElem;
    }

    public RepeatConstDecl getRepeatConstDecl() {
        return RepeatConstDecl;
    }

    public void setRepeatConstDecl(RepeatConstDecl RepeatConstDecl) {
        this.RepeatConstDecl=RepeatConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstName!=null) ConstName.accept(visitor);
        if(ConstElem!=null) ConstElem.accept(visitor);
        if(RepeatConstDecl!=null) RepeatConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstName!=null) ConstName.traverseTopDown(visitor);
        if(ConstElem!=null) ConstElem.traverseTopDown(visitor);
        if(RepeatConstDecl!=null) RepeatConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstName!=null) ConstName.traverseBottomUp(visitor);
        if(ConstElem!=null) ConstElem.traverseBottomUp(visitor);
        if(RepeatConstDecl!=null) RepeatConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RepeatingConstDecl(\n");

        if(ConstName!=null)
            buffer.append(ConstName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstElem!=null)
            buffer.append(ConstElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RepeatConstDecl!=null)
            buffer.append(RepeatConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RepeatingConstDecl]");
        return buffer.toString();
    }
}
