import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {

        String CaminhoArquivoAnalisado = "";
        String TextoArquivoAnalisado;
        Lexer objetoAnalisadorLexico = new Lexer();

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION){
            File selectedFile =  fileChooser.getSelectedFile();
            System.out.println("\n ====> Arquivo Selecionado: " + selectedFile.getAbsolutePath());
            boolean resultado = objetoAnalisadorLexico.AnalisadorLexico(selectedFile);

            if(!resultado){
                System.out.println("\n ### Erro na ANALISE LEXICA ###");
            } else {
                System.out.println("\n\n ******** ANALISE SINTATICA ******** \n\n");
                AnalisadorSintatico objSintatico = new AnalisadorSintatico();
                objSintatico.AnaliseSintatica();
            }
        } else {
            System.out.println("Nenhum arquivo selecionado");
        }
    }
}
