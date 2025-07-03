package util;

import javafx.scene.image.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileLoader {

    private static final Path BASE_DIR = Paths.get(System.getProperty("user.dir"));

    public static String carregarTexto(String nomeArquivo) throws IOException {
        Path caminho = BASE_DIR.resolve(nomeArquivo);
        return Files.readString(caminho);
    }

    public static List<String> listarImagens(String subpasta) throws IOException {
        Path caminho = BASE_DIR.resolve(subpasta);
        if (!Files.exists(caminho)) {
            throw new IOException("Diretório de imagens não encontrado: " + caminho.toString());
        }
        return Files.list(caminho)
                .filter(Files::isRegularFile)
                .sorted(Comparator.comparing(p -> p.getFileName().toString().toLowerCase()))
                .map(p -> p.toAbsolutePath().toString())
                .collect(Collectors.toList());
    }

    public static Image carregarImagem(String caminhoCompleto) {
        return new Image(Paths.get(caminhoCompleto).toUri().toString());
    }
}