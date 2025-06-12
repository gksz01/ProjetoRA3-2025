package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaData {
    private static final String FILE_NAME = "/DadosDisciplinas.txt"; // Caminho no classpath para leitura
    private static final String TEMP_FILE = "temp_DadosDisciplinas.txt"; // Arquivo temporário

    public static void salvarDisciplina(List<Disciplina> disciplinas) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TEMP_FILE))) {
            outputStream.writeObject(disciplinas);
            System.out.println("Arquivo temporário salvo em: " + new File(TEMP_FILE).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar os dados da disciplina: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Disciplina> carregarDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (InputStream inputStream = DisciplinaData.class.getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                System.out.println("Arquivo " + FILE_NAME + " não encontrado no classpath.");
                return disciplinas; // Retorna lista vazia se o arquivo não existir
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                Object obj = objectInputStream.readObject();
                if (obj instanceof List) {
                    disciplinas = (List<Disciplina>) obj;
                } else {
                    System.out.println("Objeto lido não é uma List: " + obj);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O ao carregar o arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados da disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe não encontrada durante desserialização: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados da disciplina: " + e.getMessage());
        }
        return disciplinas;
    }
}
