import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager
{
    public void classeFile()
    {
        /*
        java.io.File
        A classe File representa um arquivo ou diretório no sistema operacional.
        Importante saber que apenas REPRESENTA, não significa que o arquivo ou
        diretório realmente exista.
        */
        
        //Para instanciar um objeto do tipo File:
        File arquivo = new File( "/home/xyz/Desktop/cursoJava/projetos_deitel/manipulacao_arquivos/arquivo_teste.txt");
        
        //verifica se o arquivo ou diretório existe
        boolean existe = arquivo.exists();
        
        try {
            //cria um arquivo (vazio)
            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //cria um diretório
        arquivo.mkdir();
        
        
        //caso seja um diretório, é possível listar seus arquivos e diretórios
        File [] arquivos = arquivo.listFiles();
        
        //exclui o arquivo ou diretório
        arquivo.delete();
    }
    
    public void classeFileWriter_BufferedWriter() throws IOException
    {
        File arquivo;
        /*
        java.io.FileWriter e java.io.BufferedWriter
        As classes FileWriter e BufferedWriter servem para escrever em arquivos de texto.
        A classe FileWriter serve para escrever diretamente no arquivo, enquanto a classe
        BufferedWriter, além de ter um desempenho melhor, possui alguns métodos que
        são independentes de sistema operacional, como quebra de linhas.
        */
        arquivo = new File( "/home/xyz/Desktop/cursoJava/projetos_deitel/manipulacao_arquivos/arquivo_teste.txt");
        
        //construtor que recebe o objeto do tipo arquivo
        FileWriter fw = new FileWriter( arquivo );
        //construtor que recebe também como argumento se o conteúdo será acrescentado
        //ao invés de ser substituído (append)
        FileWriter fw2 = new FileWriter( arquivo, true );

        //construtor recebe como argumento o objeto do tipo FileWriter
        BufferedWriter bw = new BufferedWriter( fw );

        //escreve o conteúdo no arquivo
        bw.write( "Texto a ser escrito no txt" );

        //quebra de linha
        bw.newLine();

        //fecha os recursos
        bw.close();
        fw.close();

    }
    
    public void FileReader_BufferedReader()
    {
        /*
        As classes FileReader e BufferedReader servem para ler arquivos em formato texto.
        */
        File arquivo = new File( "/home/xyz/Desktop/cursoJava/projetos_deitel/manipulacao_arquivos/arquivo_teste.txt");
        
        try {
            //construtor que recebe o objeto do tipo arquivo
            FileReader fr = new FileReader( arquivo );
            
            //construtor que recebe o objeto do tipo FileReader
            BufferedReader br = new BufferedReader( fr );
            
            //enquanto houver mais linhas
            while( br.ready() ){
                //lê a proxima linha
                String linha = br.readLine();
                 //faz algo com a linha
            }
            
            br.close();
            fr.close(); 
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        File arquivo = new File("/home/xyz/Desktop/cursoJava/projetos_deitel/manipulacao_arquivos/arquivo_teste.txt");
        try {
            if (!arquivo.exists()) {
            //cria um arquivo (vazio)
            arquivo.createNewFile();
            }
            //caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Texto a ser escrito no txt");
            bw.newLine();
            bw.close();
            fw.close(); 
            
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            //enquanto houver mais linhas
            while (br.ready()) {
                //lê a proxima linha
                String linha = br.readLine();
                //faz algo com a linha
                System.out.println(linha);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
        }
    }
    
}