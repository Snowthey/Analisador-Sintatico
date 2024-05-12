public class ClassificacaoLexica {
    public String Lexema;
    public int Token;
    public int Linha;

    public ClassificacaoLexica(String Lexema, int token, int linha){
        this.Lexema = Lexema;
        this.Token = token;
        this.Linha = linha;
    }
}
