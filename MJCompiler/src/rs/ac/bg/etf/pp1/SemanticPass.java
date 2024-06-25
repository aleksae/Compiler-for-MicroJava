package rs.ac.bg.etf.pp1;

import java.awt.font.NumericShaper.Range;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	Type currType = null;
	Struct currVariableType = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	boolean hasMain=false;
	
	public boolean mainExists() {
		return hasMain;
	}
	ArrayList<String> currLocalSymbols = new ArrayList<>();
	int nVars;
	
	Logger log = Logger.getLogger(getClass());

	public String kind_to_str(int kind) {
		switch(kind) {
		case 0:
			return "None";
		case 1:
			return "Integer";
		case 2:
			return "Char";
		case 3:
			return "Array";
		case 4:
			return "Class";
		case 5:
			return "Bool";
		case 6:
			return "Enum";
		case 7:
			return "Interface";
		default:
			return null;
		}
	}
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	/*public void visit(VarDecl varDecl){
		varDeclCount++;
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
	}*/
	
   /* public void visit(PrintStmt print) {
		printCallCount++;
	}*/
    
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    	report_info("Pronadjen je program sa imenom "+progName.getProgName(), progName);
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    	report_info("Zavrsen je program ", program);
    }
    
    public void visit (MethodName mn) {
    	this.currentMethod = Tab.insert(Obj.Meth, mn.getName(), mn.getTypeOrVoid().struct);
    	mn.obj = this.currentMethod;
    	mn.obj.setLevel(0);
    	Tab.openScope();
    	if("main".equalsIgnoreCase(mn.getName())) hasMain = true;
    	report_info("Detektovana je metoda "+mn.getName()+" uz povratni tip "+mn.obj.getType(), mn);
    	
    }
    public void visit(FormName fn) {
    	Obj temp = Tab.insert(Obj.Var, fn.getName(), this.currVariableType);
    	fn.obj = temp;
    	/*jer je level za metode br paramterara*/
    	this.currentMethod.setLevel(this.currentMethod.getLevel()+1);
    	this.currLocalSymbols.add(fn.getName());
    	report_info("Param metode detektovan. Zove se "+fn.getName(), fn);
    }
    public void visit (MethodDeclaration md) {
    	if(!returnFound && currentMethod.getType() != Tab.noType){
			report_error("Semanticka greska na liniji " + md.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
			return;
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	this.currLocalSymbols.clear();
    	this.currentMethod = null;
    	report_info("Kraj tekuce metode", md);
    }
    
    boolean RangeDetected=false;
	public void visit(FactorRange r) {
		if(r.getExpr().obj.getType().getKind()==3) {
			if(!r.getExpr().obj.getType().getElemType().equals(Tab.intType)) {
				r.obj = Tab.noObj;
				report_error("Greska, range prima samo int",r);
				return;
			}
		}else if(!r.getExpr().obj.getType().equals(Tab.intType)) {
			r.obj = Tab.noObj;
			report_error("Greska, range prima samo int",r);
			return;
		}
		r.obj = r.getExpr().obj;
		RangeDetected = true;
		
	}
	
	
    public void visit(TypeHasType tt) {
    	Obj typeNode = Tab.find(tt.getTypeName());
    	if(tt.getTypeName().equals("bool")) {
    		tt.struct = MJParserTest.boolType;
    		return;
    	}
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + tt.getTypeName() + " u tabeli simbola! ", null);
    		tt.struct = Tab.noType;
    		return;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			tt.struct = typeNode.getType();
    			report_info("Ima povratni tip "+tt.getTypeName(), tt);
    		}else{
    			report_error("Greska: Ime " + tt.getTypeName() + " ne predstavlja tip!", tt);
    			tt.struct = Tab.noType;
    		}
    	}
    	
    	
    }
   
    public void visit(TypeVoid tv) {
    	tv.struct = Tab.noType;
    	report_info("Povratni tip void", tv);
    	
    }
    
    public void visit(ReturnEmptyStatement rs) {
    	this.returnFound = true;
    	rs.obj = Tab.noObj;
    	if(currentMethod.getType().getKind()!=rs.obj.getType().getKind()) {
    		report_error("Povratni tip se ne slaze za metodu "+currentMethod.getName()+", ocekivan je "+kind_to_str(currentMethod.getType().getKind()),rs);
    	}
    }
    public void visit(ReturnStatement rs) {
    	this.returnFound = true;
    	rs.obj = rs.getExpr().obj;
    	
    	if(currentMethod.getType().getKind()!=rs.obj.getType().getKind()) {
    		report_error("Povratni tip se ne slaze za metodu "+currentMethod.getName()+", ocekivan je "+kind_to_str(currentMethod.getType().getKind()),rs);
    	}
    }
    
    
    /*variables*/
    public void visit(VariableName vn) {
    	if(this.currentMethod!=null && this.currLocalSymbols.contains(vn.getName())) {
    		report_error("Ime "+vn.getName()+" u upotrebi", vn);
    		return;
    	}
    	boolean isVariableArray = vn.getParent() instanceof VariableDeclarationArray || vn.getParent() instanceof VarDeclRepeatArr;
    	
    	Obj temp = null;
    	if(isVariableArray) {
    		temp = Tab.insert(Obj.Var, vn.getName(), new Struct(Struct.Array, currVariableType));

    	}else {
    		
    		temp = Tab.insert(Obj.Var, vn.getName(), currVariableType);
    	}
    	vn.obj = temp;
    	if(this.currentMethod != null) {
    		this.currLocalSymbols.add(vn.getName());
    	}
    	report_info("Detektovana promenljiva "+vn.getName(), vn);
    }

    public void visit(TypeNoColon tt) {
    	Obj typeNode = Tab.find(tt.getTypeName());
    	if(tt.getTypeName().equals("bool")) {
    		tt.struct = MJParserTest.boolType;
    		this.currVariableType = tt.struct;
    		report_info("Tekuci tip promenljive je bool", tt);
    		return;
    	}
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + tt.getTypeName() + " u tabeli simbola! ", null);
    		tt.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			tt.struct = typeNode.getType();
    			report_info("Tekuci tip promenljive "+tt.getTypeName(), tt);
    		}else{
    			report_error("Greska: Ime " + tt.getTypeName() + " ne predstavlja tip!", tt);
    			tt.struct = Tab.noType;
    		}
    	}
    	this.currVariableType = tt.struct;
    	
    }
    
    public void visit(StatementIfElse st) {
    	/*if(!st.getCondition().struct.equals(MJParserTest.boolType)) {
    		report_error("Uslov mora biti boolean", st);
    	}*/
    	st.obj = st.getStatement().obj;
    }
    public void visit(StatementIfNoElse st) {
    	/*if(!st.getCondition().struct.equals(MJParserTest.boolType)) {
    		report_error("Uslov mora biti boolean", st);
    	}*/
    	st.obj = st.getStatement().obj;
    }
    
    public void visit(ConstName cn) {
    	Obj temp = Tab.find(cn.getName());
    	if(temp != Tab.noObj) {
    		report_error("Ime "+cn.getName()+" u upotrebi -- "+temp.getName(), cn);
    		return;
    	}
    	//boolean isVariableArray = cn.getParent() instanceof VariableDeclarationArray;
    	
    	temp = Tab.insert(Obj.Con, cn.getName(), currVariableType);
    	
    	cn.obj = temp;
    	
    	report_info("Detektovana konstanta "+cn.getName(), cn);
    }
    
    public void visit(CharConst cc) {
    	cc.struct = Tab.charType;
    }
    public void visit(NumConst cc) {
    	cc.struct = Tab.intType;
    }
    public void visit(BoolConst cc) {
    	
    	cc.struct = MJParserTest.boolType;
    	/*TODO
    	 * dodaj kad uvede bool tip
    	 * */
    }
    public void visit(FactorChar cc) {
    	cc.obj = Tab.insert(Obj.Con, cc.getValC(), Tab.charType);
    }
    public void visit(FactorNum cc) {
    	cc.obj = Tab.insert(Obj.Con, cc.getValN().toString(), Tab.intType);
    	report_info("Cc num je sada objekat sa imenom "+cc.obj.getName(), cc);
    	
    }
    public void visit(FactorBool cc) {
    	cc.obj = Tab.insert(Obj.Con, cc.getValB(),MJParserTest.boolType);
    	 
    	report_info("Cc bool je sada objekat sa imenom "+cc.obj.getName(), cc);
    	//Integer val = cc.getValB().equals("true")?1:0;
    	//cc.obj = Tab.insert(Obj.Con, val.toString(), MJParserTest.boolType);
    	/*TODO
    	 * dodaj kad uvede bool tip
    	 * */
    }
    
    public void visit(StatementDesign sd) {
    	sd.obj = sd.getDesignatorStatement().obj;
    }

    public void visit(DesignatorRegular d) {
    	Obj o = Tab.find(d.getName());
    	if(o == Tab.noObj) {
    		report_error("Promenljiva "+d.getName()+" je nedeklarisana", d);
    	}else {
    		d.obj = o;
    		report_info("Objekat dodat desigantoru "+d.getName(), d);
    	}
    }
    
    public void visit(NoDesignatorRepetable des) {
    	des.obj = des.getDesignatorInner().obj;
    }
    
    public void visit(FactorDesignator fd) {
    	//Tab.
    	//fd.struct = fd.getDesignator().obj.
    	fd.obj = fd.getDesignator().obj;
    }
    
    
    public int brackCounter = 0;
    
    public void visit(ConstDeclaration cd) {
    	if(!cd.getType().struct.equals(cd.getConstElem().struct)) {
    		report_error("Dodeljena ne-int vrednost konstantni tipa int", cd);
    	}
    }
    
    public void visit(DesignatorStmntOne des) {
    	try {
    		Struct left = des.getDesignator().obj.getType();
    		if(des.getDesignatorStatementPartOne() instanceof DesignatorStatementAssign){
    			funcCallDetected=false;
    		}
	    	if(funcCallDetected) {
	    	
	    		if(des.getDesignator().obj.getKind()!=Obj.Meth) {
	    			report_error("Greska, pozvana fja nije fja ", des);
	    		}
	    		ArrayList<Obj> arguments = new ArrayList<>();
	    		try{
	    			DesignatorStatementParen paren = (DesignatorStatementParen) des.getDesignatorStatementPartOne();
	    			arguments.add(paren.obj);
		    		ActParse a = paren.getActParse();
		        	if(a.getRepetableActParse() instanceof RepetableActParseFull) {
		        		RepetableActParseFull ff = (RepetableActParseFull) a.getRepetableActParse();
		        		arguments.add(ff.getExpr().obj);
		        		while(ff.getRepetableActParse() instanceof RepetableActParseFull) {
		            		arguments.add(ff.getRepetableActParse().obj);
		            		ff=(RepetableActParseFull) ff.getRepetableActParse(); 		
		            	}
		        	}
	    		}catch(Exception e) {
	    			report_info("Metoda je pozvana bez agrumenata ", des);
	    		}
	    		
	    		funcCallDetected = false;
	    		int realNumOfAgrs = des.getDesignator().obj.getLevel();
	    		int givenNumOfArgs = arguments.size();
	    		//boolean isLen = "len".equalsIgnoreCase(des.getDesignator().obj.getName());
	    		if(realNumOfAgrs != givenNumOfArgs) {
	    			report_error("Neispravan broj argumenata. Ocekivano "+realNumOfAgrs+" a prosledjeno "+givenNumOfArgs, des);
	    			return;
	    		}
	    		Collection<Obj> params = des.getDesignator().obj.getLocalSymbols();
	    		int i=0;
	    		for (Obj param : params) {
	    			if(i>=realNumOfAgrs) break;
	    			if(!param.getType().equals(arguments.get(i).getType())) {
	    				if(arguments.get(i).getType().getKind()==3) {
	    					
	    					if(brackCounter==0 && !"len".equalsIgnoreCase(des.getDesignator().obj.getName())) {
	    						report_error("Ne moze se proslediti niz ako argument, greska na argumentu broj "+i, des);
	    					} 
	    					if(!param.getType().equals(arguments.get(i).getType().getElemType())) {
	    						if("len".equalsIgnoreCase(des.getDesignator().obj.getName())) {
	    							
	    						}
	    						else report_error("Ocekivan argument "+i+" je "+kind_to_str(param.getType().getKind())+" a prosledjeno je "+kind_to_str(arguments.get(i).getType().getKind()), des);
	    					}
	    					report_info("Brack cnt je stavljen na 0",des);
	    					brackCounter=0;
	    					assignedArrayInPrevious=false;
	    				}else {
	    					report_error("Ocekivan argument "+i+" je "+kind_to_str(param.getType().getKind())+" a prosledjeno je "+kind_to_str(arguments.get(i).getType().getKind()), des);
	    				}
	    				
	    			}
	    			i++;
	    		}
	    		
	    		return;
	    	}
	    	if(des.getDesignatorStatementPartOne().obj == Tab.noObj || des.getDesignatorStatementPartOne().obj == null) {
	    		if (des.getDesignatorStatementPartOne() instanceof DesignatorStatementInc || des.getDesignatorStatementPartOne() instanceof DesignatorStatementDec) {
	    			if(!left.equals(Tab.intType) && left.getKind()!=3){
	    				report_error("Ne moze se inc/dec nesto sto nije int", des);
	    			}else if(left.getKind()==3) {
	    				if(left.getElemType().getKind()!=1) {
	    					report_error("Niz, Ne moze se inc/dec nesto sto nije int", des);
	    				}
	    			}
	    		}
	    		return;
	    	}
	    	Struct right = des.getDesignatorStatementPartOne().obj.getType();
	    	if(right.getKind()==3) {
	    		if(brackCounter==0 && !assignedArrayInPrevious) {
	    			report_error("Desna strana je niz, a ne element niza", des);
	    			return;
	    		}
	    		if(!assignedArrayInPrevious) brackCounter--;
	    		right = right.getElemType();
	    	}
	    	if(left.getKind()==3) {
	    		if(brackCounter<=0 && !RangeDetected) {
	    			report_error("Leva strana je niz, a ne element niza", des);
	    			return;
	    		}else if(RangeDetected && brackCounter>0) {
	    			report_error("Leva strana mora biti niz", des);
	    			return;
	    		}
	    		if(RangeDetected) RangeDetected = false;
	    		brackCounter--;
	    		left = left.getElemType();
	    	}
	
	    	if(!left.assignableTo(right)) {
	    		report_error("Tipovi nisu kompatibilni, left je "+kind_to_str(left.getKind()) + " a right je "+kind_to_str(right.getKind()), des);
	    		return;
	    	}
	    	brackCounter=0;
	    	assignedArrayInPrevious=false;
	    	report_info("Brack cnt je stavljen na 0",des);
    	}catch(Exception e) {
    		report_error("Desstmntne neko djubre "+e.getMessage(),des);
    	}
    }
    
    public void visit(ReadStatement r) {
    	//rs.getDesignator().obj.getType().equals(Obj.)
    	r.obj = r.getDesignator().obj;
    	report_info("read stmnt sem pass",r);
    }
    public void visit(FactorDesignatorBrace des) {
    	funcCallDetected = true;
    	des.obj = des.getDesignator().obj;
    }
    public void visit(FactorDesignatorEmptyBrace des) {
    	funcCallDetected = true;
    	des.obj = des.getDesignator().obj;
    }
    public void visit(ActParse a) {
    	a.obj = a.getExpr().obj;
    	
    	
    }
    
    public void visit(RepetableActParseFull re) {
    	re.obj = re.getExpr().obj;
    }


    public void visit(DesignatorIdentBrackets des) {
    	report_info("-------------------Usao u ident brack curr je "+brackCounter,des);
    	if(!des.getExpr().obj.getType().equals(Tab.intType)) {
    		if(des.getExpr().obj.getType().getKind()==3) {
    			if(des.getExpr().obj.getType().getElemType().equals(Tab.intType)) {
    				des.obj = des.getDesignator().obj;
    		    	brackCounter++;
    		    	report_info("-------------------Curr brack cnt je "+brackCounter,des);
    		    	return;
    			}else {
    				report_error("Expr nije int za indeksiranje niza",des);
    				des.obj = Tab.noObj;
    				return;
    			}
    		}
    		report_error("Expr nije int za indeksiranje niza",des);
    		des.obj = Tab.noObj;
    		return;
    	}
    	if(des.getDesignator().obj.getType().getKind()!=3) {
    		report_error("Indeksira se nesto sto nije niz!",des);
    		des.obj = Tab.noObj;
    		return;
    	}
    	des.obj = des.getDesignator().obj;
    	brackCounter++;
    	report_info("-------------------Curr brack cnt je "+brackCounter,des);
    	
    	
    }
    
    public void visit(FactorArrHasE f) {
    	if(!f.getExpr().obj.getType().equals(Tab.intType)) {
    		if(f.getExpr().obj.getType().getKind()==3) {
    			if(!f.getExpr().obj.getType().getElemType().equals(Tab.intType)) {
    				report_error("Indeks mora biti tipa int", f);
    				f.obj = Tab.noObj;
    				return;
    			}else {
    				f.obj = f.getExpr().obj;
    			}
    		}
    		report_error("Indeks mora biti tipa int", f);
			f.obj = Tab.noObj;
    	}else {
    		f.obj = f.getExpr().obj;
    	}
    }
    
    boolean funcCallDetected = false;
    public void visit(DesignatorStatementParen des) {
    	funcCallDetected = true;
    	des.obj = des.getActParse().obj;
    }
    public void visit(DesignatorStatementEmptyParen des) {
    	funcCallDetected = true;
    }
    
    public void visit(DesignatorStatementAssign des) {
    	des.obj = des.getExpr().obj;
    }
    
    
    boolean assignedArrayInPrevious = false;
    public void visit(Term e) {
    	if(e.getRepetableTerm() instanceof NoRepTerm) {
    		e.obj = e.getFactor().obj;
    		return;
    	}
    	Struct left = e.getFactor().obj.getType().getKind()==3 ? e.getFactor().obj.getType().getElemType() : e.getFactor().obj.getType();
    	Struct right = e.getRepetableTerm().obj.getType().getKind()==3 ? e.getRepetableTerm().obj.getType().getElemType() : e.getRepetableTerm().obj.getType();

    	if(e.getFactor().obj.getType().getKind()==3 && brackCounter>0) {brackCounter--;}
    	else if(e.getFactor().obj.getType().getKind()==3 ){
    		report_error("Term: Term levo je arr, ne valja"+e.getFactor().obj.getName(), e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if((e.getRepetableTerm().obj.getType().getKind()==3 && brackCounter>0) || 
    			(e.getRepetableTerm().obj.getType().getKind()==3 && assignedArrayInPrevious)) {if(brackCounter>0 && !assignedArrayInPrevious) brackCounter--; assignedArrayInPrevious = false;}
    	else if(e.getRepetableTerm().obj.getType().getKind()==3){
    		report_error("Desno nesto ne valja",e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if(!left.equals(right)) {
    		report_error("Tterm mora biti int sa obe strane", e);
    		e.obj=Tab.noObj;
    	}else {
    		
    		e.obj = e.getFactor().obj;
    		if(e.obj.getType().getKind()==3) assignedArrayInPrevious = true;
    	}
    }
    
    public void visit(RepetableTerminal e) {
    	if(e.getRepetableTerm() instanceof NoRepTerm) {
    		e.obj = e.getFactor().obj;
    		return;
    	}
    	Struct left = e.getFactor().obj.getType().getKind()==3 ? e.getFactor().obj.getType().getElemType() : e.getFactor().obj.getType();
    	Struct right = e.getRepetableTerm().obj.getType().getKind()==3 ? e.getRepetableTerm().obj.getType().getElemType() : e.getRepetableTerm().obj.getType();
    	if(e.getFactor().obj.getType().getKind()==3 && brackCounter>0) {brackCounter--;}
    	else if(e.getFactor().obj.getType().getKind()==3 ){
    		report_error("RepTerm: Term levo je arr, ne valja"+e.getFactor().obj.getName()+" brackCnt "+brackCounter, e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if((e.getRepetableTerm().obj.getType().getKind()==3 && brackCounter>0) || 
    			(e.getRepetableTerm().obj.getType().getKind()==3 && assignedArrayInPrevious)) {if(brackCounter>0 && !assignedArrayInPrevious) brackCounter--; assignedArrayInPrevious = false;}
    	else if(e.getRepetableTerm().obj.getType().getKind()==3){
    		report_error("Desno nesto ne valja",e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if(!left.equals(right)) {
    		report_error("Tterm mora biti int sa obe strane", e);
    		e.obj=Tab.noObj;
    	}else {
    		e.obj = e.getFactor().obj;
    		if(e.getFactor().obj.getType().getKind()==3) assignedArrayInPrevious = true;
    	}
    }
    
    
    
    
    public void visit(Expression e) {
    	if(e.getExprRepetable() instanceof NoExpressionRepetable) {
    		e.obj = e.getTerm().obj;
    		return;
    	}
    	Struct left = e.getTerm().obj.getType().getKind()==3 ? e.getTerm().obj.getType().getElemType() : e.getTerm().obj.getType();
    	Struct right = e.getExprRepetable().obj.getType().getKind()==3 ? e.getExprRepetable().obj.getType().getElemType() : e.getExprRepetable().obj.getType();

    	if(e.getTerm().obj.getType().getKind()==3 && brackCounter>0) {brackCounter--;}
    	else if(e.getTerm().obj.getType().getKind()==3 ){
    		report_error("Expression: Term levo je arr, ne valja"+e.getTerm().obj.getName(), e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if((e.getExprRepetable().obj.getType().getKind()==3 && brackCounter>0) || 
    			(e.getExprRepetable().obj.getType().getKind()==3 && assignedArrayInPrevious)) {if(brackCounter>0 && !assignedArrayInPrevious) brackCounter--; assignedArrayInPrevious = false;}
    	else if(e.getExprRepetable().obj.getType().getKind()==3){
    		report_error("Desno nesto ne valja expression "+e.getExprRepetable().obj.getName(),e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if(!left.equals(right)) {
    		report_error("Tterm mora biti int sa obe strane", e);
    		e.obj=Tab.noObj;
    	}else {
    		e.obj = e.getTerm().obj;
    		if(e.obj.getType().getKind()==3) assignedArrayInPrevious = true;
    	}
    	
    }
    
    public void visit(ExpressionRepetable e) {
    	if(e.getExprRepetable() instanceof NoExpressionRepetable) {
    		e.obj = e.getTerm().obj;
    		return;
    	}
    	Struct left = e.getTerm().obj.getType().getKind()==3 ? e.getTerm().obj.getType().getElemType() : e.getTerm().obj.getType();
    	Struct right = e.getExprRepetable().obj.getType().getKind()==3 ? e.getExprRepetable().obj.getType().getElemType() : e.getExprRepetable().obj.getType();
    	if(e.getTerm().obj.getType().getKind()==3 && brackCounter>0) {brackCounter--;}
    	else if(e.getTerm().obj.getType().getKind()==3 ){
    		report_error("Expression Repetable: Term levo je arr, ne valja"+e.getTerm().obj.getName()+" brackCnt "+brackCounter, e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if((e.getExprRepetable().obj.getType().getKind()==3 && brackCounter>0) || 
    			(e.getExprRepetable().obj.getType().getKind()==3 && assignedArrayInPrevious)) {if(brackCounter>0 && !assignedArrayInPrevious) brackCounter--; assignedArrayInPrevious = false;}
    	else if(e.getExprRepetable().obj.getType().getKind()==3){
    		report_error("Desno nesto ne valja",e);
    		e.obj = Tab.noObj;
    		return;
    	}
    	if(!left.equals(right)) {
    		report_error("Tterm mora biti int sa obe strane", e);
    		e.obj=Tab.noObj;
    	}else {
    		e.obj = e.getTerm().obj;
    		if(e.getTerm().obj.getType().getKind()==3) assignedArrayInPrevious = true;
    	}
    	
    }
    
    
    
   
    
    boolean InForLoop=false;
    
    public void visit(StatementFor sf) {
    	InForLoop = false;
    }
    public void visit(ForDect fd) {
    	InForLoop = true;
    	report_info("I'm in for loop jebem mu sve",fd);
    }
    
    public void visit(BreakStatement bs) {
    	if(!InForLoop) {
    		report_error("Break nije dozvoljen van for petlje ", bs);
    	}
    }
    
    public void visit(ContStatement bs) {
    	if(!InForLoop) {
    		report_error("Continue  nije dozvoljen van for petlje ", bs);
    	}
    }
    
    public void visit(CondFactSingle cf) {
    	/*if(!cf.getExpr().obj.getType().equals(MJParserTest.boolType)) {
    		report_error("Cf nije bool",cf);
    		cf.struct = Tab.noType;
    		return;
    	}*/
    	cf.struct = cf.getExpr().obj.getType();
    	
    }
    
    public void visit(CondFactDual cf) {
    	Struct left = cf.getExpr().obj.getType();
    	Struct right = cf.getExpr1().obj.getType();
    	if(left.getKind()==3 && right.getKind()==3 && brackCounter==0) {
    		if(cf.getRelop().getClass().getName()!="rs.ac.bg.etf.pp1.ast.RelopEq" && cf.getRelop().getClass().getName()!="rs.ac.bg.etf.pp1.ast.RelopNotEq") {
    			report_error("Nepravilno poredjenje nizova "+cf.getRelop().getClass().getName(),cf);
    			cf.struct = Tab.noType;
    			return;
    		}
    		cf.struct = MJParserTest.boolType;
    		return;
    	}
    	if(left.getKind()==3 && brackCounter>0) {
    		left = left.getElemType();
    		brackCounter--;
    	}
    	if(right.getKind()==3 && brackCounter>0) {
    		right = right.getElemType();
    		brackCounter--;
    	}
    	if(!left.equals(right)) {
    		report_error("Leva i desna strana poredjenja nisu kompatibilne", cf);
    		cf.struct = Tab.noType;
    		return;
    	}
    	cf.struct = MJParserTest.boolType;
    }
    
  
    
    public void visit(CondFactRepFull cf) {
    	/*if(!cf.getCondFact().struct.equals(MJParserTest.boolType) || !cf.getCondFactRepeater().struct.equals(MJParserTest.boolType)) {
    		report_error("Obe strane OR moraju biti bool",cf);
    		cf.struct = Tab.noType;
    		return;
    	}*/
    	cf.struct = cf.getCondFact().struct;
    }
    
    public void visit(CondTermRepFull cf) {
    	/*if(!cf.getCondTerm().struct.equals(MJParserTest.boolType) || !cf.getCondTermRepeater().struct.equals(MJParserTest.boolType)) {
    		report_error("Obe strane OR moraju biti bool",cf);
    		cf.struct = Tab.noType;
    		return;
    	}*/
    	cf.struct = cf.getCondTerm().struct;
    }
    
    public void visit(CondTerm cf) {
    	/*if(!cf.getCondFact().struct.equals(MJParserTest.boolType) || !cf.getCondFactRepeater().struct.equals(MJParserTest.boolType)) {
    		report_error("Obe strane OR moraju biti bool",cf);
    		cf.struct = Tab.noType;
    		return;
    	}*/
    	cf.struct = cf.getCondFact().struct;
    }
    
    public void visit(Condition cf) {
    	/*if(!cf.getCondTerm().struct.equals(MJParserTest.boolType) || !cf.getCondTermRepeater().struct.equals(MJParserTest.boolType)) {
    		report_error("Obe strane OR moraju biti bool",cf);
    		cf.struct = Tab.noType;
    		return;
    	}*/
    	cf.struct = cf.getCondTerm().struct;
    }
    
    public void visit(OptCondFactFor cf) {
    	/*if(!cf.getCondFact().struct.equals(MJParserTest.boolType)) {
    		report_error("Obe strane OR moraju biti bool",cf);
    		cf.struct = Tab.noType;
    		return;
    	}*/
    	cf.struct = cf.getCondFact().struct;
    }
    
    
    public void visit(NoCondFactRep nr) {
    	nr.struct = Tab.noType;
    }
    public void visit(NoCondTermRep nr) {
    	nr.struct = Tab.noType;
    }
    
    
   public void visit(LRParFactor lf) {
	   lf.obj = lf.getExpr().obj;
   }
    

  
    
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}
