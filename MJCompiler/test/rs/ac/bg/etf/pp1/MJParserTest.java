package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class MJParserTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static Struct boolType;
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTest.class);
		
		Reader br = null;
		try {
			File sourceCode = new File("test/program"
					+ ".mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
	        Tab.init();
	        /*dodavanje bool*/
	        boolType = new Struct(Struct.Bool);
	        Tab.chainLocalSymbols(new Obj(Obj.Type, "bool", boolType));
	        
	        //Tab.addToLocals(new Obj(Obj.Type, "int", intType));
	        /*kraj bool*/
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			/*RuleVisitor v = new RuleVisitor();
			prog.traverseBottomUp(v); 
	      
			log.info(" Print count calls = " + v.printCallCount);

			log.info(" Namespaces declared = " + v.nmspcCount);
			log.info("Array varibale decl = " + v.vrbArrCount);
			log.info("Array repeat varibale decl = " + v.vrbArrayRepeatCount);*/
			
			
			SemanticPass v = new SemanticPass();
			prog.traverseBottomUp(v); 
	      
			log.info(" Print count calls = " + v.printCallCount);

			log.info(" Deklarisanih promenljivih ima = " + v.varDeclCount);
			
			log.info("===================================");
			Tab.dump();
			//Obj cnt = new Obj(Obj.Var, "pomocniBrojac", Tab.intType, 0,0);
			Tab.insert(Obj.Var, "mojPomocniBrojacAleksa", Tab.intType);
			if(v.passed() && v.mainExists()){
				File objFile = new File("test/program.obj");
				if(objFile.exists()) objFile.delete();
				
				CodeGenerator codeGenerator = new CodeGenerator();
				prog.traverseBottomUp(codeGenerator);
				Code.dataSize = v.nVars;
				Code.mainPc = codeGenerator.getMainPc();
				Code.write(new FileOutputStream(objFile));
				log.info("Parsiranje uspesno zavrseno!");
				
			}else{
				log.error("Parsiranje NIJE uspesno zavrseno!");
			}
			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
