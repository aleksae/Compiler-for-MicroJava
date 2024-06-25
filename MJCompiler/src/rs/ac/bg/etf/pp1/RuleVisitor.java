package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{

	int printCallCount = 0;
	int varDeclCount = 0;
	int nmspcCount = 0;
	int vrbArrCount = 0;
	int vrbArrayRepeatCount = 0;
	
	Logger log = Logger.getLogger(getClass());

	/*public void visit(VarDecl vardecl){
		varDeclCount++;
	}*/
	public void visit(HasNamespace nmspc) {
		nmspcCount++;
	}
	
	
	public void visit(VarDeclRepeatArr vrb) {
		vrbArrayRepeatCount++;
	}
	public void visit(VariableDeclarationArray vrb) {
		vrbArrCount++;
	}

}
