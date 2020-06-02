package Unidade1.PreProva2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class ArquivoBase<Reader, Writer> {

    private final FileSystem fileSystem;
    private Path diretorio;

    public ArquivoBase() {
        this.fileSystem = FileSystems.getDefault();
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        if (diretorio != null) {
            this.diretorio = fileSystem.getPath(diretorio);
        } else {
            throw new IllegalArgumentException("O diretório não pode ser nulo");
        }
    }

    public Path obterDiretorioComArquivo(String nomeArquivo) {
        if (!nomeArquivo.isEmpty()) {
            return fileSystem.getPath(diretorio + "\\" + nomeArquivo);
        } else {
            throw new NullPointerException("Nome de arquivo inválido");
        }
    }

    public boolean arquivoExiste(Path path) {
        return Files.exists(path);
    }

    public Path criarArquivo(Path arquivo) {
        try {
            if (arquivo != null) {
                return Files.createFile(arquivo);
            } else {
                throw new NullPointerException("O arquivo não pode ser nulo");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao criar arquivo. " + ex.getMessage());
        }
    }

    public Path criarDiretorio(Path diretorio) {
        try {
            if (diretorio != null) {
                return Files.createDirectories(diretorio);
            } else {
                throw new NullPointerException("O diretório não pode ser nulo");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao criar diretório. " + ex.getMessage());
        }
    }

    public void criarDiretorioEArquivo(Path path, Path dirArquivo) {
        if (!this.arquivoExiste(path)) {
            this.criarDiretorio(path);
        }
        if (!this.arquivoExiste(dirArquivo)) {
            this.criarArquivo(dirArquivo);
        }
    }

    public void moverArquivo(Path origem, Path destino) {
        try {
            if (!Files.exists(destino)) {
                Files.move(origem, destino);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao mover arquivo. " + ex.getMessage());
        }
    }

    public abstract Reader lerArquivo(Path dirArquivo);

    public abstract Writer escreverNoArquivo(Path dirArquivo, boolean agregar);
}
