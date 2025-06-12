package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteData {
    public static final String FILE_NAME = "/DadosEstudante.txt";
    public static final String TEMP_FILE = "temp_DadosEstudante.txt";

    public static void salvarEstudante(List<Estudante> Estudantes) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TEMP_FILE))) {
            outputStream.writeObject(Estudantes);
            System.out.println("Arquivo temporário salvo em: " + new File(TEMP_FILE).getAbsolutePath());
            // Copiar para resources manualmente ou via script após salvar
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar os dados do estudante: " + e.getMessage());
        }
    }

    public static List<Estudante> carregarEstudantes() {
        List<Estudante> estudantes = new ArrayList<>();
        try (InputStream inputStream = EstudanteData.class.getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                System.out.println("Arquivo " + FILE_NAME + " não encontrado no classpath.");
                return estudantes; // Retorna lista vazia se o arquivo não existir
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                Object obj = objectInputStream.readObject();
                if (obj instanceof List) {
                    estudantes = (List<Estudante>) obj;
                } else {
                    System.out.println("Objeto lido não é uma List: " + obj);
                }
            } } catch (IOException e) {
            System.err.println("Erro de I/O ao carregar o arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados do estudante " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe não encontrada durante desserialização: " + e.getMessage());
            throw new RuntimeException("Erro ao carregar os dados do estudante: " + e.getMessage());
        }
        return estudantes;
    }
}