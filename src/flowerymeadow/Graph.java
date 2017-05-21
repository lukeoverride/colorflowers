package flowerymeadow;

import java.util.*;

public  class Graph{

private List<Arc> arcz= new ArrayList<Arc>();
private Set<String> nodes= new HashSet<String>();
private int count= 2 ;
public  void  addNode(String id){
nodes.add(id);
}
public  void  addArc(String from,String to){
arcz.add( new Arc(from,to));
}
public Set<Colored> compute3Coloring(){
addNode( "firenze" );
addNode( "cittanova" );
addNode( "reggio" );
addNode( "catania" );
addNode( "roma" );
addNode( "genova" );
addArc( "firenze" , "cittanova" );
addArc( "firenze" , "reggio" );
addArc( "cittanova" , "reggio" );
addArc( "cittanova" , "catania" );
addArc( "reggio" , "catania" );
addArc( "catania" , "roma" );
addArc( "catania" , "genova" );
addArc( "roma" , "genova" );
Set<Colored> res= new HashSet<Colored>();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation inputProgram JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_inputProgram=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_inputProgram.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_inputProgram=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_inputProgram;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_inputProgram.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(arcz,"arc"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'arcz::arc' in module inputProgram:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(arcz,"arc"), 0));
_JDLV_PROGRAM_inputProgram.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(nodes,"node"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'nodes::node' in module inputProgram:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(nodes,"node"), 0));
_JDLV_PROGRAM_inputProgram.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(count,"conta"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'count::conta' in module inputProgram:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(count,"conta"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'res::col' in module inputProgram.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_inputProgram=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_inputProgram.addText(_JDLV_PROGRAM_BUFFER_inputProgram.toString());
_JDLV_PROGRAM_inputProgram.addText("col(X, red) v col(X, green) v col(X, blue) :- node(X)."+'\n');
_JDLV_PROGRAM_inputProgram.addText(":- col(X, C), col(Y, C), arc(X, Y)."+'\n');
_JDLV_PROGRAM_inputProgram.addText("cont(X) :- conta(X)."+'\n');
_JDLV_PROGRAM_inputProgram.getFiles().clear();
_JDLV_INVOCATION_inputProgram.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_inputProgram.append("");
_JDLV_INVOCATION_inputProgram.setInputProgram(_JDLV_PROGRAM_inputProgram);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_inputProgram=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_inputProgram);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution inputProgram program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_inputProgram.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_inputProgram.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_inputProgram.run();
while(_BUFFERED_HANDLER_inputProgram.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELinputProgram=_BUFFERED_HANDLER_inputProgram.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(res, "col",_temporary_JDLV_MODELinputProgram,Colored.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "res " + res.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(res,0));
}
if(_JDLV_INVOCATION_inputProgram.haveModel()==false){
res= null ;
System.out.print( "E' nullo" );
}
if(!_JDLV_INVOCATION_inputProgram.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_inputProgram.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_inputProgram){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_inputProgram.getMessage());
}
_JDLV_PROGRAM_inputProgram.cleanText();

	// ---- END - prepareJDLVCall ---- 
return res;
}
public static  void  main(String[] args){
System.out.println( "ciao" );
Graph graph= new Graph();
Set<Colored> risultato=graph.compute3Coloring();
Iterator<Colored> iter=risultato.iterator();
while(iter.hasNext())
{
Colored colored=iter.next();
System.out.print(colored.node+ " " );
System.out.println(colored.color);
}
}
}

