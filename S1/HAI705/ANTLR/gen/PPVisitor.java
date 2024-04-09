// Generated from D:/Cours/M1/M1_GL/HAI705/ANTLR/PP.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PPParser#programme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramme(PPParser.ProgrammeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#type_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_variable(PPParser.Type_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstante(PPParser.ConstanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#definir_fonction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinir_fonction(PPParser.Definir_fonctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#procedure_programme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_programme(PPParser.Procedure_programmeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#nouveau_tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNouveau_tab(PPParser.Nouveau_tabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#get_tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet_tab(PPParser.Get_tabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#set_tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_tab(PPParser.Set_tabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#allocExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocExpr(PPParser.AllocExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#creation_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreation_var(PPParser.Creation_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#assignation_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignation_val(PPParser.Assignation_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PPParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(PPParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#procedure_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_exp(PPParser.Procedure_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(PPParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#nom_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNom_variable(PPParser.Nom_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#calle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalle(PPParser.CalleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#genere_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenere_instruction(PPParser.Genere_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#gen_exp_unaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_exp_unaire(PPParser.Gen_exp_unaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#gen_exp_binaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_exp_binaire(PPParser.Gen_exp_binaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPParser#gen_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_exp(PPParser.Gen_expContext ctx);
}