package flowerymeadow;

import java.util.*;

import flowerymeadow.Advice;
import flowerymeadow.Cell;
import flowerymeadow.CellForDLV;
import flowerymeadow.CoreFloweryMeadow;

public  class Intelligence{

private ArrayList<CellForDLV> allCells;
private ArrayList<CellForDLV> flowers;
private ArrayList<CellForDLV> covered;
private ArrayList<Advice> advices;
private CoreFloweryMeadow coreFloweryMeadow;
private int availableFlowers;
private int[][] matrix= new int[ 2 ][ 2 ];
public Intelligence(CoreFloweryMeadow coreFloweryMeadow){
 this .coreFloweryMeadow=coreFloweryMeadow;
}
private  void  scanMeadow(boolean probability){
 this .allCells= new ArrayList<CellForDLV>();
 this .covered= new ArrayList<CellForDLV>();
 this .advices= new ArrayList<Advice>();
if(!probability)
 this .flowers= new ArrayList<CellForDLV>();
for(int i= 0 ;i< this .coreFloweryMeadow.getHEIGHT();i++)
{
for(int j= 0 ;j< this .coreFloweryMeadow.getWIDTH();j++)
{
Cell cell= this .coreFloweryMeadow.getCells().get(i).get(j);
 this .allCells.add( new CellForDLV(i,j));
if(!probability)
{
if(cell.isBomb())
 this .flowers.add( new CellForDLV(i,j));
}
if(cell.isCover())
 this .covered.add( new CellForDLV(i,j));
if(cell.getHelp()> 0 )
 this .advices.add( new Advice(i,j,cell.getHelp()));
}
}
}
public Set<CellOutput> createInputForDLV(){
scanMeadow( false );
Set<CellOutput> free= new HashSet<CellOutput>();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation resolve JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_resolve=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_resolve.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_resolve=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_resolve;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_resolve.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(allCells,"cella"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'allCells::cella' in module resolve:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(allCells,"cella"), 0));
_JDLV_PROGRAM_resolve.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(flowers,"fiore"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'flowers::fiore' in module resolve:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(flowers,"fiore"), 0));
_JDLV_PROGRAM_resolve.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(covered,"coperta"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'covered::coperta' in module resolve:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(covered,"coperta"), 0));
_JDLV_PROGRAM_resolve.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(advices,"suggerimento"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'advices::suggerimento' in module resolve:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(advices,"suggerimento"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'free::libera' in module resolve.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_resolve=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_resolve.addText(_JDLV_PROGRAM_BUFFER_resolve.toString());
_JDLV_PROGRAM_resolve.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R + 1, C = C1."+'\n');
_JDLV_PROGRAM_resolve.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R, C1 = C + 1."+'\n');
_JDLV_PROGRAM_resolve.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R + 1, C1 = C + 1."+'\n');
_JDLV_PROGRAM_resolve.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R - 1, C1 = C + 1."+'\n');
_JDLV_PROGRAM_resolve.addText("adiacente(R, C, R1, C1) :- adiacente(R1, C1, R, C)."+'\n');
_JDLV_PROGRAM_resolve.addText("bombaSicura(R1, C1) :- suggerimento(R, C, X), contaAdiacentiCoperte(R, C, X), adiacente(R, C, R1, C1), coperta(R1, C1)."+'\n');
_JDLV_PROGRAM_resolve.addText("contaAdiacentiCoperte(R, C, X) :- cella(R, C), #count{R1,C1 : adiacente(R, C, R1, C1), coperta(R1, C1)} = X."+'\n');
_JDLV_PROGRAM_resolve.addText("libera(R, C) :- coperta(R, C), not bombaSicura(R, C), adiacente(R, C, R1, C1), suggerimento(R1, C1, X), contaAdiacentiBombeSicure(R1, C1, X)."+'\n');
_JDLV_PROGRAM_resolve.addText("contaAdiacentiBombeSicure(R, C, X) :- cella(R, C), #count{R1,C1 : adiacente(R, C, R1, C1), bombaSicura(R1, C1)} = X."+'\n');
_JDLV_PROGRAM_resolve.getFiles().clear();
_JDLV_INVOCATION_resolve.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_resolve.append("");
_JDLV_INVOCATION_resolve.setInputProgram(_JDLV_PROGRAM_resolve);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_resolve=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_resolve);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution resolve program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_resolve.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_resolve.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_resolve.run();
while(_BUFFERED_HANDLER_resolve.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELresolve=_BUFFERED_HANDLER_resolve.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(free, "libera",_temporary_JDLV_MODELresolve,CellOutput.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "free " + free.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(free,0));
}
if(_JDLV_INVOCATION_resolve.haveModel()==false){
free= null ;
return free;
}
if(!_JDLV_INVOCATION_resolve.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_resolve.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_resolve){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_resolve.getMessage());
}
_JDLV_PROGRAM_resolve.cleanText();

	// ---- END - prepareJDLVCall ---- 
return free;
}
public ArrayList<CellOutput> createCombinationsForProbability(){
availableFlowers= this .coreFloweryMeadow.getAvailableFlowers();
scanMeadow( true );
Set<CellOutput> probabilityPos= new HashSet<CellOutput>();
ArrayList<CellOutput> totalCells= new ArrayList<CellOutput>();
int nAS= 0 ;

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation probability JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_probability=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_probability.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_probability=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_probability;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_probability.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(allCells,"cella"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'allCells::cella' in module probability:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(allCells,"cella"), 0));
_JDLV_PROGRAM_probability.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(availableFlowers,"bombeTotali"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'availableFlowers::bombeTotali' in module probability:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(availableFlowers,"bombeTotali"), 0));
_JDLV_PROGRAM_probability.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(covered,"coperta"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'covered::coperta' in module probability:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(covered,"coperta"), 0));
_JDLV_PROGRAM_probability.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(advices,"suggerimento"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'advices::suggerimento' in module probability:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(advices,"suggerimento"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'probabilityPos::bomba' in module probability.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_probability=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_probability.addText(_JDLV_PROGRAM_BUFFER_probability.toString());
_JDLV_PROGRAM_probability.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R + 1, C = C1."+'\n');
_JDLV_PROGRAM_probability.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R, C1 = C + 1."+'\n');
_JDLV_PROGRAM_probability.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R + 1, C1 = C + 1."+'\n');
_JDLV_PROGRAM_probability.addText("adiacente(R, C, R1, C1) :- cella(R, C), cella(R1, C1), R1 = R - 1, C1 = C + 1."+'\n');
_JDLV_PROGRAM_probability.addText("adiacente(R, C, R1, C1) :- adiacente(R1, C1, R, C)."+'\n');
_JDLV_PROGRAM_probability.addText("bomba(X, Y) v nonBomba(X, Y) :- suggerimento(R, C, _), adiacente(X, Y, R, C), coperta(X, Y)."+'\n');
_JDLV_PROGRAM_probability.addText("number(0..11)."+'\n');
_JDLV_PROGRAM_probability.addText("contaBombeAdiacentiSuggerimenti(X, Y, N) :- suggerimento(X, Y, _), number(N), #count{R,C : adiacente(X, Y, R, C), bomba(R, C)} = N."+'\n');
_JDLV_PROGRAM_probability.addText(":- suggerimento(X, Y, N), contaBombeAdiacentiSuggerimenti(X, Y, M), not N = M."+'\n');
_JDLV_PROGRAM_probability.addText(":- bombeTotali(T), #count{X,Y : bomba(X, Y)} > T."+'\n');
_JDLV_PROGRAM_probability.getFiles().clear();
_JDLV_PROGRAM_BUFFER_probability.append("");
_JDLV_INVOCATION_probability.setInputProgram(_JDLV_PROGRAM_probability);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_probability=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_probability);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution probability program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_probability.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_probability.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_probability.run();
while(_BUFFERED_HANDLER_probability.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELprobability=_BUFFERED_HANDLER_probability.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(probabilityPos, "bomba",_temporary_JDLV_MODELprobability,CellOutput.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "probabilityPos " + probabilityPos.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(probabilityPos,0));
Iterator<CellOutput> iter=probabilityPos.iterator();
while(iter.hasNext())
{
CellOutput cell=iter.next();
totalCells.add(cell);
System.out.print(cell.getY());
System.out.println(cell.getX());
}
nAS++;
System.out.println( "A.S. number " +nAS);
System.out.println( "_________________________" );
}
if(_JDLV_INVOCATION_probability.haveModel()==false){
}
if(!_JDLV_INVOCATION_probability.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_probability.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_probability){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_probability.getMessage());
}
_JDLV_PROGRAM_probability.cleanText();

	// ---- END - prepareJDLVCall ---- 
CellOutput numberOfAS= new CellOutput();
numberOfAS.setY( "-1" );
numberOfAS.setX(Integer.toString(nAS));
totalCells.add(numberOfAS);
return totalCells;
}
public CoreFloweryMeadow getCoreFloweryMeadow(){
return coreFloweryMeadow;
}
}

