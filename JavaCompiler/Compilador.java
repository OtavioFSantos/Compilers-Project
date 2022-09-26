// PARA RODAR:
// java Compilador teste -> exibe o resultado tanto do compilador quanto do interpretador
// java MaquinaPilha arquivoEntrada -> recebe a saida do compilador e retorna o resultado da exp

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			// Gera o código
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo + "\n");

			// Gera o resultado
			Interpretador interpretador = new Interpretador();
			int result = interpretador.Interpretar(arv);
			System.out.println(result);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
