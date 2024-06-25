// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:16


package rs.ac.bg.etf.pp1.ast;

public class FactorNum extends Factor {

    private Integer valN;

    public FactorNum (Integer valN) {
        this.valN=valN;
    }

    public Integer getValN() {
        return valN;
    }

    public void setValN(Integer valN) {
        this.valN=valN;
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
        buffer.append("FactorNum(\n");

        buffer.append(" "+tab+valN);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNum]");
        return buffer.toString();
    }
}
