package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoData {
    private static final String FILE_NAME = "/DadosCursos.txt"; // Caminho no classpath para leitura
    private static final String TEMP_FILE = "temp_DadosCursos.txt"; // Arquivo temporário

    public static void salvarCursos(List<Curso> cursos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TEMP_FILE))) {
            outputStream.writeObject(cursos);
            System.out.println("Arquivo temporário salvo em: " + new File(TEMP_FILE).getAbsolutePath());
            // Copiar para resources manualmente ou via script após salvar
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar os dados do curso: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Curso> carregarCursos() {
        List<Curso> cursos = new ArrayList<>();
        try (InputStream inputStream = CursoData.class.getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                System.out.println("Arquivo " + FILE_NAME + " não encontrado no classpath.");
                return cursos; // Retorna lista vazia se o arquivo não existir
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                Object obj = objectInputStream.readObject();
                if (obj instanceof List) {
                    cursos = (List<Curso>) obj;
                } else {
                    System.out.println("Objeto lido não é uma List: " + obj);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O ao carregar o arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados do curso: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe não encontrada durante desserialização: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados do curso: " + e.getMessage());
        }
        return cursos;
    }
}