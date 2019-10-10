/*
* Quando vamos abrir um novo chamado nós importamos essa Api para que o programa saiba qual url usar.
* */

package br.senac.es.helpdeskrennan.API;

public class ApiUtils {

    private ApiUtils(){}

    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static APIService getService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
