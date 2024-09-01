/*--------------------------------------------------
 ------------  1ra Area: Codigo de Usuario ---------
 ---------------------------------------------------*/


//------> Paquetes,importaciones
package analizadorCJ;
import java_cup.runtime.*;
import java.util.ArrayList;
import errores.Error_;
import tokens_.Tokens_;




/*----------------------------------------------------------
  ------------  2da Area: Opciones y Declaraciones ---------
  ----------------------------------------------------------*/
%%
%{
  // ---> Codigo usuario
public  ArrayList<Tokens_> listaTokens = new ArrayList<Tokens_> ();
public ArrayList<Error_> lex_errores = new ArrayList<Error_> ();



%}

//-------> Directivas
%public
%class Lexer
%cup
%char
%column
%line


//------> Expresiones Regulares

parentesisA = "("
parentesisC = ")"

llaveA ="{"
llaveC="}"
dos_puntos = ":"
conj = "CONJ"
punto_coma = ";"

//operaciones
union = "U"
interseccion = "&"
complemento = "^"
diferencia = "-"

//Evaluar

evaluar = "EVALUAR"

letra_mayuscula =[A-Z]
letra_minuscula =[a-z]
flecha = "->"
numero = [0-9]+
guion = "~"
coma = ","
operacion = "OPERA"
identificador = [A-Za-z][A-Za-z0-9]*

comentario = (\#)[^\n]*\n
ascii = [!-~]














%%

/*------------------------------------------------
  ------------  3ra Area: Reglas Lexicas ---------
  ------------------------------------------------*/

//evaluar
{evaluar} {System.out.println("Se reconocio token  evaluar" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"EVALUAR",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.EVALUAR, yycolumn, yyline, yytext());}

{parentesisA} {System.out.println("Se reconocio token  parentesis A" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"PARENTESIS_A",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}

{parentesisC} {System.out.println("Se reconocio token  parentesis C" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"PARENTESIS_C",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}

//operaciones

{operacion} {System.out.println("Se reconocio token  opera" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"OPERA",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.OPERACION, yycolumn, yyline, yytext());}

{union} {System.out.println("Se reconocio token  union" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"UNION",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.UNION, yycolumn, yyline, yytext());}

{interseccion} {System.out.println("Se reconocio token  interseccion" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"INTERSECCION",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.INTERSECCION, yycolumn, yyline, yytext());}

{complemento} {System.out.println("Se reconocio token  complemento" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"COMPLEMENTO",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.COMPLEMENTO, yycolumn, yyline, yytext());}

{diferencia} {System.out.println("Se reconocio token  diferencia" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"DIFERENCIA",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.DIFERENCIA, yycolumn, yyline, yytext());}



{llaveA} {System.out.println("Se reconocio token  llave A" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"LLAVE A",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.LLAVEA, yycolumn, yyline, yytext());}

{llaveC} {System.out.println("Se reconocio token llave C " + " Lexema: " + yytext());listaTokens.add( new Tokens_ ( yytext(),"LLAVE C",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.LLAVEC, yycolumn, yyline, yytext()); }

{guion}  {System.out.println("Se reconocio token guion " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"GUION",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.GUION, yycolumn, yyline, yytext()); }

{coma}  {System.out.println("Se reconocio token coma " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"COMA",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.COMA, yycolumn, yyline, yytext()); }

//{numero}  {System.out.println("Se reconocio token numero " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"NUMERO",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.NUMERO, yycolumn, yyline, yytext()); }

{punto_coma} {System.out.println("Se reconocio token puntoComa " + " Lexema: " + yytext());listaTokens.add( new Tokens_ ( yytext(),"PUNTO COMO",Integer.toString(yyline),Integer.toString(yycolumn))) ;  return new Symbol(sym.PUNTO_COMA, yycolumn, yyline, yytext()); }

{dos_puntos} {System.out.println("Se reconocio token dos puntos " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"DOS PUNTOS",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext()); }

//{letra_mayuscula} {System.out.println("Se reconocio token letra mayuscula " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"MAYUSCULAS",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.LETRA_MAYUSCULA, yycolumn, yyline, yytext());}

//{letra_minuscula} {System.out.println("Se reconocio token letra minuscula " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"MINUSCULA",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.LETRA_MINUSCULA, yycolumn, yyline, yytext());}

{conj} {System.out.println("Se reconocio token conj " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"CONJ",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.CONJ, yycolumn, yyline, yytext());}



{flecha} {System.out.println("Se reconocio token  flecha " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"FLECHA",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.FLECHA, yycolumn, yyline, yytext());}


{ascii} {System.out.println("Se reconocio token  ascii" + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"ASCII",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.ASCII, yycolumn, yyline, yytext());}
{identificador} {System.out.println("Se reconocio token identificador " + " Lexema: " + yytext()); listaTokens.add( new Tokens_ ( yytext(),"ID",Integer.toString(yyline),Integer.toString(yycolumn))) ; return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());} 



[\s\t\r\n] {}

{comentario} {System.out.println("Se reconocio token comentario " + " Lexema: " + yytext());}


. {System.out.println("Error encontrado: " + yytext()); Error_ errores_ = new Error_ ( yytext(),"error lexico",Integer.toString(yyline),Integer.toString(yycolumn));  lex_errores.add(errores_) ;}
