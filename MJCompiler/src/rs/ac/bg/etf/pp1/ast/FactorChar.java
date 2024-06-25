// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class FactorChar extends Factor {

    private String valC;

    public FactorChar (String valC) {
        this.valC=valC;
    }

    public String getValC() {
        return valC;
    }

    public void setValC(String valC) {
        this.valC=valC;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorChar(\n");

        buffer.append(" "+tab+valC);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorChar]");
        return buffer.toString();
    }
}
