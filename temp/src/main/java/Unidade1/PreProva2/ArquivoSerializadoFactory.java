package Unidade1.PreProva2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class ArquivoSerializadoFactory extends ArquivoBase<ObjectInputStream, ObjectOutputStream>
        implements ArquivoSerializado {

    @Override
    public ObjectInputStream lerArquivo(Path dirArquivo) {
        try {
            FileInputStream fr = new FileInputStream(dirArquivo.toFile());
            BufferedInputStream br = new BufferedInputStream(fr);
            return new ObjectInputStream(br);
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao ler arquivo. " + ex.getMessage());
        }
    }

    @Override
    public ObjectOutputStream escreverNoArquivo(Path dirArquivo, boolean agregar) {
        try {
            FileOutputStream fw = new FileOutputStream(dirArquivo.toFile(), agregar);
            BufferedOutputStream bw = new BufferedOutputStream(fw);
            return new ObjectOutputStream(bw);
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao escrever no arquivo. " + ex.getMessage());
        }
    }
}