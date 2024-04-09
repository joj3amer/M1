// Generated from D:/Cours/M1/M1_GL/HAI705/ANTLR/Hello.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#programme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramme(HelloParser.ProgrammeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#type_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_variable(HelloParser.Type_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstante(HelloParser.ConstanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#definir_fonction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinir_fonction(HelloParser.Definir_fonctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#procedure_programme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_programme(HelloParser.Procedure_programmeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#nouveau_tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNouveau_tab(HelloParser.Nouveau_tabContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#get_tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet_tab(HelloParser.Get_tabContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#set_tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_tab(HelloParser.Set_tabContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#allocExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocExpr(HelloParser.AllocExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#creation_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreation_var(HelloParser.Creation_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#assignation_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignation_val(HelloParser.Assignation_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(HelloParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(HelloParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#procedure_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_exp(HelloParser.Procedure_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(HelloParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#nom_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNom_variable(HelloParser.Nom_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#calle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalle(HelloParser.CalleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#genere_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenere_instruction(HelloParser.Genere_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#gen_exp_unaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_exp_unaire(HelloParser.Gen_exp_unaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#gen_exp_binaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_exp_binaire(HelloParser.Gen_exp_binaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#gen_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_exp(HelloParser.Gen_expContext ctx);
}