/*
Api no qual se comunica com o servidor por meio de port, onde ele realiza o post do salvarChamado no link "chamados".
* */

package br.senac.es.helpdeskrennan.API;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("chamados")
    Call<ResponseBody> salvarChamado(@Body RequestBody body);
}
