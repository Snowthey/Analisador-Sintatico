import java.util.ArrayList;

public class AnalisadorSintatico {

    RegrasSintaticas objetoRegrasSintaticas;
    ArrayList<ClassificacaoLexica> VetorAnaliseLexica;

    public AnalisadorSintatico(){
        objetoRegrasSintaticas = new RegrasSintaticas();
        VetorAnaliseLexica = Lexer.ArrayListAnaliseLexica;
    }

    void AnaliseSintatica(){
        if(objetoRegrasSintaticas.INICIO(VetorAnaliseLexica)){
            int Tamanho = VetorAnaliseLexica.size();
            int QuantidadeTotalLinhas = VetorAnaliseLexica.get(Tamanho - 1).Linha;
            int LinhaAtual = 1;
            boolean ProgramaSemErros = true;
            int QuantidadeDeErros = 0;

            while(LinhaAtual <= QuantidadeTotalLinhas - 1){
                ArrayList<ClassificacaoLexica> VetorAnalise = new ArrayList<>();

                for(ClassificacaoLexica obj : VetorAnaliseLexica){
                    if(obj.Linha == LinhaAtual){
                        VetorAnalise.add(obj);
                    }
                }

                if(!objetoRegrasSintaticas.PROGRAMA(VetorAnaliseLexica)){
                    ProgramaSemErros = false;
                    QuantidadeDeErros++;
                    System.out.print("*** ERRO SINTATICO ");
                }


                System.out.print("Linha: " + LinhaAtual + " ");

                for(ClassificacaoLexica obj : VetorAnalise){
                    System.out.print(obj.Lexema + " ");
                }

                System.out.println(" ");
                LinhaAtual++;
            }

            if(ProgramaSemErros){
                System.out.println("\n Analise Sintatica Concluida com sucesso! Zero erros");
            } else {
                System.out.println("\n Quantidade de Erros: " + QuantidadeDeErros);
            }
        } else {
            System.out.println("Erro na linha 1 - Inicialização do programa");
        }
    }

}
