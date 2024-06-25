// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:15


package rs.ac.bg.etf.pp1.ast;

public class VariableDeclaration extends VarDecl {

    private Type Type;
    private VarName VarName;
    private VarDeclRepeat VarDeclRepeat;

    public VariableDeclaration (Type Type, VarName VarName, VarDeclRepeat VarDeclRepeat) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
        this.VarDeclRepeat=VarDeclRepeat;
        if(VarDeclRepeat!=null) VarDeclRepeat.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public VarDeclRepeat getVarDeclRepeat() {
        return VarDeclRepeat;
    }

    public void setVarDeclRepeat(VarDeclRepeat VarDeclRepeat) {
        this.VarDeclRepeat=VarDeclRepeat;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarName!=null) VarName.accept(visitor);
        if(VarDeclRepeat!=null) VarDeclRepeat.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
        if(VarDeclRepeat!=null) VarDeclRepeat.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        if(VarDeclRepeat!=null) VarDeclRepeat.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclRepeat!=null)
            buffer.append(VarDeclRepeat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDeclaration]");
        return buffer.toString();
    }
}
