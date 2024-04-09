// Generated from D:/Cours/M1/M1_GL/HAI705/ANTLR/Hello.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#programme}.
	 * @param ctx the parse tree
	 */
	void enterProgramme(HelloParser.ProgrammeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#programme}.
	 * @param ctx the parse tree
	 */
	void exitProgramme(HelloParser.ProgrammeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#type_variable}.
	 * @param ctx the parse tree
	 */
	void enterType_variable(HelloParser.Type_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#type_variable}.
	 * @param ctx the parse tree
	 */
	void exitType_variable(HelloParser.Type_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterConstante(HelloParser.ConstanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitConstante(HelloParser.ConstanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#definir_fonction}.
	 * @param ctx the parse tree
	 */
	void enterDefinir_fonction(HelloParser.Definir_fonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#definir_fonction}.
	 * @param ctx the parse tree
	 */
	void exitDefinir_fonction(HelloParser.Definir_fonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#procedure_programme}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_programme(HelloParser.Procedure_programmeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#procedure_programme}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_programme(HelloParser.Procedure_programmeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#nouveau_tab}.
	 * @param ctx the parse tree
	 */
	void enterNouveau_tab(HelloParser.Nouveau_tabContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#nouveau_tab}.
	 * @param ctx the parse tree
	 */
	void exitNouveau_tab(HelloParser.Nouveau_tabContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#get_tab}.
	 * @param ctx the parse tree
	 */
	void enterGet_tab(HelloParser.Get_tabContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#get_tab}.
	 * @param ctx the parse tree
	 */
	void exitGet_tab(HelloParser.Get_tabContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#set_tab}.
	 * @param ctx the parse tree
	 */
	void enterSet_tab(HelloParser.Set_tabContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#set_tab}.
	 * @param ctx the parse tree
	 */
	void exitSet_tab(HelloParser.Set_tabContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#allocExpr}.
	 * @param ctx the parse tree
	 */
	void enterAllocExpr(HelloParser.AllocExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#allocExpr}.
	 * @param ctx the parse tree
	 */
	void exitAllocExpr(HelloParser.AllocExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#creation_var}.
	 * @param ctx the parse tree
	 */
	void enterCreation_var(HelloParser.Creation_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#creation_var}.
	 * @param ctx the parse tree
	 */
	void exitCreation_var(HelloParser.Creation_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#assignation_val}.
	 * @param ctx the parse tree
	 */
	void enterAssignation_val(HelloParser.Assignation_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#assignation_val}.
	 * @param ctx the parse tree
	 */
	void exitAssignation_val(HelloParser.Assignation_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(HelloParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(HelloParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(HelloParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(HelloParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#procedure_exp}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_exp(HelloParser.Procedure_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#procedure_exp}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_exp(HelloParser.Procedure_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(HelloParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(HelloParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#nom_variable}.
	 * @param ctx the parse tree
	 */
	void enterNom_variable(HelloParser.Nom_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#nom_variable}.
	 * @param ctx the parse tree
	 */
	void exitNom_variable(HelloParser.Nom_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#calle}.
	 * @param ctx the parse tree
	 */
	void enterCalle(HelloParser.CalleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#calle}.
	 * @param ctx the parse tree
	 */
	void exitCalle(HelloParser.CalleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#genere_instruction}.
	 * @param ctx the parse tree
	 */
	void enterGenere_instruction(HelloParser.Genere_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#genere_instruction}.
	 * @param ctx the parse tree
	 */
	void exitGenere_instruction(HelloParser.Genere_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#gen_exp_unaire}.
	 * @param ctx the parse tree
	 */
	void enterGen_exp_unaire(HelloParser.Gen_exp_unaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#gen_exp_unaire}.
	 * @param ctx the parse tree
	 */
	void exitGen_exp_unaire(HelloParser.Gen_exp_unaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#gen_exp_binaire}.
	 * @param ctx the parse tree
	 */
	void enterGen_exp_binaire(HelloParser.Gen_exp_binaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#gen_exp_binaire}.
	 * @param ctx the parse tree
	 */
	void exitGen_exp_binaire(HelloParser.Gen_exp_binaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#gen_exp}.
	 * @param ctx the parse tree
	 */
	void enterGen_exp(HelloParser.Gen_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#gen_exp}.
	 * @param ctx the parse tree
	 */
	void exitGen_exp(HelloParser.Gen_expContext ctx);
}