package jaumebalmes.net.jobadvisor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultatsOpinions extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listviewOpinions;
    Activity a;
    Context context;
    JSONArray empresas;
    static ArrayList<Opinio> listaOpinions;
    Integer idEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_opinions);
        Intent intent = getIntent();
        idEmpresa = intent.getIntExtra("idEmpresa",-1);
        listaOpinions = new ArrayList<Opinio>();
        a=this;
        context=getApplicationContext();
        listviewOpinions = (ListView) findViewById(R.id.listOpinions);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JobAdvisorAPI apiService = retrofit.create(JobAdvisorAPI.class);

        Call<List<Opinio>> peticionOpinions = apiService.getOpinioEmpresa(idEmpresa);

        peticionOpinions.enqueue(new Callback<List<Opinio>>() {

            @Override
            public void onResponse(Call<List<Opinio>> call, Response<List<Opinio>> response) {
                if(response.code()== HttpURLConnection.HTTP_OK) {
                    listaOpinions.addAll(response.body());

                    ArrayAdapter<Opinio> adaptador = new ArrayAdapter<Opinio>(context,android.R.layout.simple_list_item_1,listaOpinions);

                    listviewOpinions.setAdapter(adaptador);

                    listviewOpinions.setOnItemClickListener(ResultatsOpinions.this);

                } else {
                    Toast.makeText(ResultatsOpinions.this, "Opinions no trobades", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Opinio>> call, Throwable t) {
                Toast.makeText(ResultatsOpinions.this, "Error al trucar al servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Integer idOpinio = listaOpinions.get(position).getId();
        Intent intent = new Intent(this, SeleccioOpinio.class);
        Bundle b = new Bundle();
        b.putInt("idOpinio",idOpinio);
        intent.putExtras(b);
        startActivity(intent);

    }
}
