import java.util.ArrayList;

public class RegrasSintaticas {

    boolean INICIO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){
        int Tamanho = VetorAnaliseLexica.size();

        if (Tamanho >= 4 &&
                VetorAnaliseLexica.get(0).Token == Token.VOID &&
                VetorAnaliseLexica.get(1).Token == Token.MAIN &&
                VetorAnaliseLexica.get(2).Token == Token.ABRE_CHAVE &&
                VetorAnaliseLexica.get(Tamanho - 1).Token == Token.FECHA_CHAVE) {
            return true;
        } else {
            return false;
        }
    }


    boolean DECLARACAO_VARIAVEL(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        int tamanho = VetorAnaliseLexica.size();

        // Verificar se o tamanho mínimo é respeitado
        if(tamanho < 3)
            return false;

        // Verificar se é uma declaração de variável válida
        if(((VetorAnaliseLexica.get(0).Token == Token.INT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL)
                && (VetorAnaliseLexica.get(3).Token == Token.VARIAVEL))){
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.CHAR) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(2).Token == Token.PONTO_VIRGULA)){
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.FLOAT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) || (VetorAnaliseLexica.get(0).Token == Token.FLOAT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL)
                && (VetorAnaliseLexica.get(2).Token == Token.ATRIBUICAO) && (VetorAnaliseLexica.get(3).Token == Token.NUMERO_DECIMAL)){
            return true;
        } else return false;


    }


    boolean COMANDO_ESPECIFICO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        int tamanho = VetorAnaliseLexica.size();
        if(tamanho < 5)
            return false;

        if ((VetorAnaliseLexica.get(0).Token == Token.COUT) && (VetorAnaliseLexica.get(1).Token == Token.OPERADOR_INSERCAO) &&
                (VetorAnaliseLexica.get(2).Token == Token.STRING) && (VetorAnaliseLexica.get(3).Token == Token.PONTO_VIRGULA)){
            return true;
        } else
            return false;
    }

    boolean COMANDO_FOR(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){
        int tamanho = VetorAnaliseLexica.size();
        if(tamanho < 19)
            return false;

        if ((VetorAnaliseLexica.get(0).Token == Token.FOR) && (VetorAnaliseLexica.get(1).Token == Token.FORLOOP) &&
                (VetorAnaliseLexica.get(2).Token == Token.FORLOOP) && (VetorAnaliseLexica.get(3).Token == Token.FORLOOP) &&
                (VetorAnaliseLexica.get(4).Token == Token.VAZIO) && (VetorAnaliseLexica.get(5).Token == Token.ABRE_CHAVE)){
            return true;
        } else
            return false;
    }


    boolean PROGRAMA(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){
        if(DECLARACAO_VARIAVEL(VetorAnaliseLexica) == true){
            System.out.print("DECLARACAO_VARIAVEL - ");
            return true;
        }

        if(COMANDO_ESPECIFICO(VetorAnaliseLexica) == true){
            System.out.print("COMANDO_ESPECIFICO - ");
            return true;
        }
        if(COMANDO_FOR(VetorAnaliseLexica) == true){
            System.out.print("COMANDO_FOR - ");
            return true;
        }
        if(INICIO(VetorAnaliseLexica) == true){
            System.out.print("INICIO - ");
            return true;
        }
        else return false;
    }



}
