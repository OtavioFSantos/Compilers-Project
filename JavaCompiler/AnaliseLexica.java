import java.io.*;

enum TokenType{ NUM,SOMA, MULT,APar,FPar, DIV, SUB, EOF}

class Token{
  int lexema;
  TokenType token;

 Token (int l, TokenType t)
 	{ lexema=l;token = t;}	
}

class AnaliseLexica{

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception{		
	 	this.arquivo = new PushbackReader(new FileReader(a));		
	}

	Token getNextToken() throws Exception{
	
		Token token;
		int eof = -1;
		char backchar, currchar;
		int temp, currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10){	
				if (currchar >= '0' && currchar <= '9'){
					temp = Character.getNumericValue(currchar);
					while(currchar >= '0'&& currchar <= '9'){
						backchar = currchar;
						currchar = (char)arquivo.read();
						if(currchar >= '0' && currchar <= '9'){
							temp = Character.getNumericValue(currchar) + (temp * 10);
						}else{
							arquivo.unread((int)currchar);
						}
					}
					return (new Token (temp, TokenType.NUM));
				}else{
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '/':
							return (new Token (currchar,TokenType.DIV));
						case '-':
							return (new Token (currchar,TokenType.SUB));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
				}
			}
			arquivo.close();			
		return (new Token(currchar,TokenType.EOF));		
	}
}
