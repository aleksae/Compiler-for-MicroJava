// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:15


package rs.ac.bg.etf.pp1.ast;

public class VarDeclRepeatArr extends VarDeclRepeat {

    private VarDeclRepeat VarDeclRepeat;
    private VarName VarName;

    public VarDeclRepeatArr (VarDeclRepeat VarDeclRepeat, VarName VarName) {
        this.VarDeclRepeat=VarDeclRepeat;
        if(VarDeclRepeat!=null) VarDeclRepeat.setParent(this);
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
    }

    public VarDeclRepeat getVarDeclRepeat() {
        return VarDeclRepeat;
    }

    public void setVarDeclRepeat(VarDeclRepeat VarDeclRepeat) {
        this.VarDeclRepeat=VarDeclRepeat;
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclRepeat!=null) VarDeclRepeat.accept(visitor);
        if(VarName!=null) VarName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclRepeat!=null) VarDeclRepeat.traverseTopDown(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclRepeat!=null) VarDeclRepeat.traverseBottomUp(visitor);
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclRepeatArr(\n");

        if(VarDeclRepeat!=null)
            buffer.append(VarDeclRepeat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclRepeatArr]");
        return buffer.toString();
    }
}
