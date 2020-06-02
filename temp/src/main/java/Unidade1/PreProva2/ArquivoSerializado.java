package Unidade1.PreProva2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public interface ArquivoSerializado {
    FileSystem getFileSystem();
    Path getDiretorio();
    void setDiretorio(String diretorio);
    Path obterDiretorioComArquivo(String nomeArquivo);
    boolean arquivoExiste(Path path);
    Path criarArquivo(Path diretorio);
    Path criarDiretorio(Path diretorio);
    void criarDiretorioEArquivo(Path path, Path dirArquivo);
    void moverArquivo(Path origem, Path destino);
    ObjectInputStream lerArquivo(Path dirArquivo);
    ObjectOutputStream escreverNoArquivo(Path dirArquivo, boolean agregar);
}
