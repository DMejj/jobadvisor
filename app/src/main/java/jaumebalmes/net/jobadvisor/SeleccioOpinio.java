package jaumebalmes.net.jobadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeleccioOpinio extends AppCompatActivity {

    EditText pros, cons, puntuacio, salari;
    Integer idOpinio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccio_opinio);

        idOpinio = getIntent().getIntExtra("idOpinio", -1);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JobAdvisorAPI apiService = retrofit.create(JobAdvisorAPI.class);

        Call<Opinio> peticionOpinions = apiService.getoOpinio(idOpinio);


        peticionOpinions.enqueue(new Callback<Opinio>() {
            @Override
            public void onResponse(Call<Opinio> call, Response<Opinio> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    puntuacio.setText(response.body().getPuntuacio());
                    pros.setText(response.body().getPros());
                    cons.setText(response.body().getContres());
                    salari.setText(Double.toString(response.body().getSalari()));
                } else {
                    Toast.makeText(SeleccioOpinio.this, "Opinio no trobada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Opinio> call, Throwable t) {
                Toast.makeText(SeleccioOpinio.this, "Error al trucar al servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


