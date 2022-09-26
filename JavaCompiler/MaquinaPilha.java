import java.io.*;
import java.util.*;

class MaquinaPilha{

    private Stack<Integer> pilha = new Stack<>();
    private int resultado = 0;
    private int op = 0, op1 = 0, op2 = 0;
    private BufferedReader arquivo;
    private String linha;

    public static void main(String[] args) throws IOException {
        MaquinaPilha stack = new MaquinaPilha(args[0]);
    }

    MaquinaPilha(String nomeArq) throws IOException{
        try{
            arquivo = new BufferedReader(new FileReader(nomeArq));
            Scanner leitura = new Scanner(arquivo);
            while((linha = arquivo.readLine()) != null){
                if(linha.contains("PUSH ")){
                    linha = linha.replace("PUSH ","");
                    pilha.push(Integer.valueOf(linha));
                }
                if(linha.contains("SUM")){
                    op1 = pilha.pop();
                    op2 = pilha.pop();
                    op = op2 + op1;
                    System.out.println("sum op1: " + op1);
                    System.out.println("sum op2: " + op2); 
                    pilha.push(op);
                }
                if(linha.contains("SUB")){
                    op1 = pilha.pop();
                    op2 = pilha.pop();
                    op = op2 - op1;
                    pilha.push(op);
                }
                if(linha.contains("MULT")){
                    op1 = pilha.pop();
                    op2 = pilha.pop();
                    op = op2 * op1;
                    System.out.println("mult op1: " + op1);
                    System.out.println("mult op2: " + op2);  
                    pilha.push(op);
                }
                if(linha.contains("DIV")){
                    op1 = pilha.pop();
                    op2 = pilha.pop();
                    op = op2 / op1;
                    pilha.push(op);
                }
                if(linha.contains("PRINT")){
                    System.out.println(pilha.pop());
                }
            }
            }catch(FileNotFoundException e){
                System.out.println("Arquivo não encontrado");
            }
        arquivo.close();
    }
 
}
