//CHENINI Ayoub
//RABIA Anas
//Laguerre Thomas

grammar PP;

programme returns [PPProg e] :
    global = allocExpr
    (rul = procedure_programme)
    inst = genere_instruction {$e = new PPProg($global.var,$rul.valeur,$inst.instr);};

type_variable returns [Type t] :
    'integer' {$t = new Int();}
    | 'boolean' {$t = new Bool();}
    | 'array of' tab = type_variable {$t = new Array($tab.t);} ;

constante returns [PPExpr co] :
    n = Number {$co = new PPCte(Integer.valueOf($n.text));}
    | False {$co = new PPFalse();}
    | True {$co = new PPTrue();} ;


definir_fonction returns [PPDef r] :
    nom_fonction = nom_variable
    '('(arg = argument)*')'
    (':' type = type_variable {$r = new PPFun($r.name,$r.args,$r.locals,$r.code,$type.t);} )?
    (local = allocExpr)?
    instr = genere_instruction {$r = new PPProc($nom_fonction.text,$arg.args,$local.var,$instr.instr);};

procedure_programme returns [ArrayList<PPDef> valeur] @init{$valeur = new ArrayList<PPDef>();}:
    (
        def = definir_fonction {$valeur.add($def.r);}
    )*;

/*
funcExpr returns [PPFun f] :
    var = nom_variable {$f.var = $var.text;}
    '(' (arg = argument)*  ')'
    (':' type = typeVar {$f = new PPFun($var.text,$arg.args,null,$r.code,$type.t);} )?;
*/
nouveau_tab : 'new' type_variable '[' gen_exp ']';

get_tab : nom_variable '[' gen_exp ']';

set_tab returns [PPArraySet set_tab_var] :
    expr1 = gen_exp
    '[' expr2 = gen_exp ']'
    ':=' expr3 = gen_exp {$set_tab_var = new PPArraySet($expr1.expr,$expr2.expr,$expr3.expr);};

allocExpr returns [ArrayList<creation_var<String,Type>> var] @init{$var = new ArrayList<creation_var<String,Type>>();} : ('var' (v = creation_var {$var.add($v.p);})+);

creation_var returns [creation_var<String,Type> p] : string = nom_variable
                                                    ':' type = type_variable {$p = new creation_var($string.var.name,$type.t);};

assignation_val returns [PPAssign ass] : var = nom_variable
                                        ':=' exp = gen_exp {$ass = new PPAssign($var.var.name,$exp.expr);} ;

condition returns [PPCond condition_p] :
    'if' expr = gen_exp_binaire
    'then' instr1 = genere_instruction
    'else' instr2 = genere_instruction {$condition_p = new PPCond($expr.expr,$instr1.instr,$instr2.instr);};

while returns [PPWhile while_p] :
    'while' exp = gen_exp_binaire
    'do' inst = genere_instruction {$while_p = new PPWhile($exp.expr,$inst.instr);};

procedure_exp returns [PPProcCall pr] @init{ArrayList<PPExpr> al = new ArrayList<PPExpr>();}:
    cal = calle
    '(' (exp = gen_exp {al.add($exp.expr);}
    (',' exps = gen_exp {al.add($exps.expr);} )*)? ')' {$pr = new PPProcCall($cal.cal,al);};


argument returns [ArrayList<creation_var<String,Type>> args] @init{$args = new ArrayList<creation_var<String,Type>>();}:
    (string = nom_variable
    ':' type = type_variable {$args.add(new creation_var($string.var.name,$type.t));});

nom_variable returns [PPVar var] :
    name = Var {$var = new PPVar($name.text);};

calle returns [Callee cal] : Read {$cal = new Read();}
                            | Write {$cal = new Write();}
                            | vn = nom_variable {$cal = new User($vn.text);};

genere_instruction returns [PPInst instr]  : assign = assignation_val {$instr = $assign.ass;}
                                        |   setarr = set_tab {$instr = $setarr.set_tab_var;}
                                        |   cond = condition {$instr = $cond.condition_p;}
                                        |   loop = while {$instr = $loop.while_p;}
                                        |   proc = procedure_exp {$instr = $proc.pr;}
                                        |   instr1 = genere_instruction ';' instr2 = genere_instruction {$instr = new PPSeq($instr2.instr, $instr1.instr);}
                                        |   skip = Skip {$instr = new PPSkip();} ;

gen_exp_unaire returns [PPExpr expr] : cons = constante {$expr = $cons.co;}
                                   |   var = Var {$expr = new PPVar($var.text);}
                                   |   '-' exp = gen_exp_unaire {$expr = new PPInv($exp.expr);}
                                   |   'not' exp = gen_exp_unaire {$expr = new PPNot($exp.expr);};

gen_exp_binaire returns [PPExpr expr] : cons = constante {$expr = $cons.co;}
                                    |   var = Var {$expr = new PPVar($var.text);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '-' exp2 =  gen_exp_binaire {$expr = new PPSub($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '+' exp2 =  gen_exp_binaire {$expr = new PPAdd($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '*' exp2 =  gen_exp_binaire {$expr = new PPMul($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '/' exp2 =  gen_exp_binaire {$expr = new PPDiv($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '<' exp2 =  gen_exp_binaire {$expr = new PPLt($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '<=' exp2 =  gen_exp_binaire {$expr = new PPLe($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '>' exp2 =  gen_exp_binaire {$expr = new PPGt($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '>=' exp2 =  gen_exp_binaire {$expr = new PPGe($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '=' exp2 =  gen_exp_binaire {$expr = new PPEq($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} '!=' exp2 =  gen_exp_binaire {$expr = new PPNe($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} 'and' exp2 =  gen_exp_binaire {$expr = new PPAnd($expr, $exp2.expr);}
                                    |   exp1 = gen_exp_binaire {$expr = $exp1.expr;} 'or' exp2 =  gen_exp_binaire {$expr = new PPOr($expr, $exp2.expr);}
                                    |   nouveau_tab
                                    |   get_tab;

gen_exp returns [PPExpr expr] : gen_exp_binaire | gen_exp_unaire;

Skip : 'skip';
Number : ('0'..'9')+ ;
fragment Char : [a-zA-Z_];
Read : 'read';
Write : 'write';
True : 'true';
False : 'false';
Var : Char (Char | Number)* ;
WS : [ \t\r\n]+ -> skip ;