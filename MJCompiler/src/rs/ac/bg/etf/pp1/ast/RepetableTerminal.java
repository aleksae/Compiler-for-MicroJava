// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:15


package rs.ac.bg.etf.pp1.ast;

public class RepetableTerminal extends RepetableTerm {

    private Mulop Mulop;
    private Factor Factor;
    private RepetableTerm RepetableTerm;

    public RepetableTerminal (Mulop Mulop, Factor Factor, RepetableTerm RepetableTerm) {
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.RepetableTerm=RepetableTerm;
        if(RepetableTerm!=null) RepetableTerm.setParent(this);
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public RepetableTerm getRepetableTerm() {
        return RepetableTerm;
    }

    public void setRepetableTerm(RepetableTerm RepetableTerm) {
        this.RepetableTerm=RepetableTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Mulop!=null) Mulop.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
        if(RepetableTerm!=null) RepetableTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(RepetableTerm!=null) RepetableTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(RepetableTerm!=null) RepetableTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RepetableTerminal(\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RepetableTerm!=null)
            buffer.append(RepetableTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RepetableTerminal]");
        return buffer.toString();
    }
}
