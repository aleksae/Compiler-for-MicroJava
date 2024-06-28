// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class FactorNewDerived1 extends FactorNew {

    private ActParse ActParse;

    public FactorNewDerived1 (ActParse ActParse) {
        this.ActParse=ActParse;
        if(ActParse!=null) ActParse.setParent(this);
    }

    public ActParse getActParse() {
        return ActParse;
    }

    public void setActParse(ActParse ActParse) {
        this.ActParse=ActParse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParse!=null) ActParse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParse!=null) ActParse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParse!=null) ActParse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewDerived1(\n");

        if(ActParse!=null)
            buffer.append(ActParse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewDerived1]");
        return buffer.toString();
    }
}
