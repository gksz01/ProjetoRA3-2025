package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoData {
    private static final String FILE_NAME = "/DadosAlunos.txt"; // Caminho dentro do classpath
    private static final String TEMP_FILE = "temp_DadosAlunos.txt"; // Arquivo temporário salvo no disco

    public static void salvarAlunos(List<Aluno> alunos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TEMP_FILE))) {
            outputStream.writeObject(alunos);
            System.out.println("Arquivo temporário salvo em: " + new File(TEMP_FILE).getAbsolutePath());
            // Copiar manualmente o conteúdo para o classpath se necessário
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo de alunos: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar os dados dos alunos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Aluno> carregarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        try (InputStream inputStream = AlunoData.class.getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                System.out.println("Arquivo " + FILE_NAME + " não encontrado no classpath.");
                return alunos; // Retorna lista vazia se o arquivo não existir
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                Object obj = objectInputStream.readObject();
                if (obj instanceof List<?>) {
                    alunos = (List<Aluno>) obj;
                } else {
                    System.out.println("Objeto lido não é uma List: " + obj);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O ao carregar alunos: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados dos alunos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe não encontrada ao desserializar alunos: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados dos alunos: " + e.getMessage());
        }
        return alunos;
    }
}
