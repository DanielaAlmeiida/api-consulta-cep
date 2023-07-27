import br.com.alura.cep.model.Endereco;
import br.com.alura.cep.services.ConsultaCEP;
import br.com.alura.cep.services.GenerateJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaCEP consultaCEP = new ConsultaCEP();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número de um CEP: ");
        var cep = sc.nextLine();

        try {
            Endereco novoEndereco = consultaCEP.buscaEndereco(cep);
            System.out.println(novoEndereco);

            GenerateJson converterJSON = new GenerateJson();
            converterJSON.saveJson(novoEndereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
