/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Nara Rubia B. Balena
 */
// CEP Cadastro da LOJA
// classe para consumir a API ViaCep
public class ViaCepService {
    private static final String URL_VIACEP = "https://viacep.com.br/ws/";

    // Classe interna para armazenar os dados do endereço
   public static class Endereco {
       public String cep;
       public String logradouro;
       public String bairro;
       public String localidade;
       public  String uf;
        boolean erro; // Caso o CEP não exista

        public boolean isErro() {
            return erro;
        }
    }

    // metodo que busca o cep e retorna um objeto Endereco
    public Endereco buscarEndereco(String cep) {
        OkHttpClient client = new OkHttpClient();
        String url = URL_VIACEP + cep + "/json/";

        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;

            // Converte JSON automaticamente para o objeto Endereco
            return new Gson().fromJson(response.body().string(), Endereco.class);
        } catch (Exception e) {
            return null;
        }
    }
}



