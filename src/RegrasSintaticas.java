import java.util.ArrayList;

public class RegrasSintaticas {

    boolean INICIO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        int Tamanho = VetorAnaliseLexica.size();

        if((VetorAnaliseLexica.get(0).Token == Token.VOID) && (VetorAnaliseLexica.get(1).Token == Token.MAIN) &&
                (VetorAnaliseLexica.get(2).Token == Token.ABRE_PARENTESES) && (VetorAnaliseLexica.get(3).Token == Token.FECHA_PARENTESES) &&
                (VetorAnaliseLexica.get(4).Token == Token.ABRE_CHAVE) && (VetorAnaliseLexica.get(5).Token == Token.FECHA_CHAVE)){

            return true;
        } else return false;

    }

    boolean DECLARACAO_VARIAVEL(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if((VetorAnaliseLexica.get(0).Token == Token.INT) || (VetorAnaliseLexica.get(0).Token == Token.FLOAT) &&
                (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(2).Token == Token.PONTO_VIRGULA)){
            return true;
        }

        int tamanho = VetorAnaliseLexica.size();
        if(tamanho < 5)
            return false;

        if((VetorAnaliseLexica.get(0).Token == Token.INT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) &&
                (VetorAnaliseLexica.get(2).Token == Token.VIRGULA) && (VetorAnaliseLexica.get(3).Token == Token.VARIAVEL) &&
                (VetorAnaliseLexica.get(4).Token == Token.PONTO_VIRGULA)){
            return true;
        } else
            return false;
    }

    boolean COMANDO_ATRIBUICAO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        int tamanho = VetorAnaliseLexica.size();

        if(tamanho < 4)
            return false;

        if((VetorAnaliseLexica.get(0).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(1).Token == Token.ATRIBUICAO) &&
                (VetorAnaliseLexica.get(2).Token == Token.NUMERO_INTEIRO) && (VetorAnaliseLexica.get(3).Token == Token.PONTO_VIRGULA)){
            return true;
        }

        if(tamanho < 6)
            return false;

        if((VetorAnaliseLexica.get(0).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(1).Token == Token.ATRIBUICAO) &&
                (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(3).Token == Token.ADICAO) &&
                (VetorAnaliseLexica.get(4).Token == Token.NUMERO_INTEIRO) && (VetorAnaliseLexica.get(5).Token == Token.PONTO_VIRGULA)){
            return true;
        } else
            return false;
    }

    boolean COMANDO_ESPECIFICO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        int tamanho = VetorAnaliseLexica.size();
        if(tamanho < 5)
            return false;

        if ((VetorAnaliseLexica.get(0).Token == Token.PRINTLN) && (VetorAnaliseLexica.get(1).Token == Token.ABRE_PARENTESES) &&
                (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(3).Token == Token.FECHA_PARENTESES) &&
                (VetorAnaliseLexica.get(4).Token == Token.PONTO_VIRGULA)){
            return true;
        } else
            return false;
    }

    boolean PROGRAMA(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if(DECLARACAO_VARIAVEL(VetorAnaliseLexica) == true){
            System.out.print("DECLARACAO_VARIAVEL - ");
            return true;
        }
        if(COMANDO_ATRIBUICAO(VetorAnaliseLexica) == true){
            System.out.print("COMANDO_ATRIBUICAO - ");
            return true;
        }
        if(COMANDO_ESPECIFICO(VetorAnaliseLexica) == true){
            System.out.print("COMANDO_PRINT - ");
            return true;
        }
        else return false;
    }
}
