import java.util.HashMap;

public class TabelaDeSimbolos {

    private HashMap<Integer, String> tabela;

    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    public void adcionarSimbolo(int token, String simbolo) {
        tabela.put(token, simbolo);
    }

    public String buscarValor(Integer token) {
        return tabela.get(token);
    }

    public boolean contemToken(Integer token) {
        return tabela.containsKey(token);
    }

    public boolean contemSimbolo(String simbolo) {
        return tabela.containsKey(simbolo);
    }

}
