// Generated from D:/Cours/M1/M1_GL/HAI705/ANTLR/PP.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PPParser}.
 */
public interface PPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PPParser#programme}.
	 * @param ctx the parse tree
	 */
	void enterProgramme(PPParser.ProgrammeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#programme}.
	 * @param ctx the parse tree
	 */
	void exitProgramme(PPParser.ProgrammeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#type_variable}.
	 * @param ctx the parse tree
	 */
	void enterType_variable(PPParser.Type_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#type_variable}.
	 * @param ctx the parse tree
	 */
	void exitType_variable(PPParser.Type_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterConstante(PPParser.ConstanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitConstante(PPParser.ConstanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#definir_fonction}.
	 * @param ctx the parse tree
	 */
	void enterDefinir_fonction(PPParser.Definir_fonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#definir_fonction}.
	 * @param ctx the parse tree
	 */
	void exitDefinir_fonction(PPParser.Definir_fonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#procedure_programme}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_programme(PPParser.Procedure_programmeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#procedure_programme}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_programme(PPParser.Procedure_programmeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#nouveau_tab}.
	 * @param ctx the parse tree
	 */
	void enterNouveau_tab(PPParser.Nouveau_tabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#nouveau_tab}.
	 * @param ctx the parse tree
	 */
	void exitNouveau_tab(PPParser.Nouveau_tabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#get_tab}.
	 * @param ctx the parse tree
	 */
	void enterGet_tab(PPParser.Get_tabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#get_tab}.
	 * @param ctx the parse tree
	 */
	void exitGet_tab(PPParser.Get_tabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#set_tab}.
	 * @param ctx the parse tree
	 */
	void enterSet_tab(PPParser.Set_tabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#set_tab}.
	 * @param ctx the parse tree
	 */
	void exitSet_tab(PPParser.Set_tabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#allocExpr}.
	 * @param ctx the parse tree
	 */
	void enterAllocExpr(PPParser.AllocExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#allocExpr}.
	 * @param ctx the parse tree
	 */
	void exitAllocExpr(PPParser.AllocExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#creation_var}.
	 * @param ctx the parse tree
	 */
	void enterCreation_var(PPParser.Creation_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#creation_var}.
	 * @param ctx the parse tree
	 */
	void exitCreation_var(PPParser.Creation_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#assignation_val}.
	 * @param ctx the parse tree
	 */
	void enterAssignation_val(PPParser.Assignation_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#assignation_val}.
	 * @param ctx the parse tree
	 */
	void exitAssignation_val(PPParser.Assignation_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PPParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PPParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(PPParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(PPParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#procedure_exp}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_exp(PPParser.Procedure_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#procedure_exp}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_exp(PPParser.Procedure_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(PPParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(PPParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#nom_variable}.
	 * @param ctx the parse tree
	 */
	void enterNom_variable(PPParser.Nom_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#nom_variable}.
	 * @param ctx the parse tree
	 */
	void exitNom_variable(PPParser.Nom_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#calle}.
	 * @param ctx the parse tree
	 */
	void enterCalle(PPParser.CalleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#calle}.
	 * @param ctx the parse tree
	 */
	void exitCalle(PPParser.CalleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#genere_instruction}.
	 * @param ctx the parse tree
	 */
	void enterGenere_instruction(PPParser.Genere_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#genere_instruction}.
	 * @param ctx the parse tree
	 */
	void exitGenere_instruction(PPParser.Genere_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#gen_exp_unaire}.
	 * @param ctx the parse tree
	 */
	void enterGen_exp_unaire(PPParser.Gen_exp_unaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#gen_exp_unaire}.
	 * @param ctx the parse tree
	 */
	void exitGen_exp_unaire(PPParser.Gen_exp_unaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#gen_exp_binaire}.
	 * @param ctx the parse tree
	 */
	void enterGen_exp_binaire(PPParser.Gen_exp_binaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#gen_exp_binaire}.
	 * @param ctx the parse tree
	 */
	void exitGen_exp_binaire(PPParser.Gen_exp_binaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link PPParser#gen_exp}.
	 * @param ctx the parse tree
	 */
	void enterGen_exp(PPParser.Gen_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link PPParser#gen_exp}.
	 * @param ctx the parse tree
	 */
	void exitGen_exp(PPParser.Gen_expContext ctx);
}