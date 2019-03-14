package jaumebalmes.net.jobadvisor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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

public class ResultatsEmpreses extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listviewEmpresas;
    Activity a;
    Context context;
    JSONArray empresas;
    static ArrayList<Empresa> listaEmpreses;
    String nombre, pobl, sector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_empreses);
        Intent intent = getIntent();
        nombre = intent.getStringExtra("nomEmpresa");
        listaEmpreses = new ArrayList<Empresa>();
        a=this;
        context=getApplicationContext();
        listviewEmpresas = (ListView) findViewById(R.id.listEmpreses);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JobAdvisorAPI apiService = retrofit.create(JobAdvisorAPI.class);

        Call<List<Empresa>> peticionEmpresa = apiService.getEmpresaNom(nombre);

        peticionEmpresa.enqueue(new Callback<List<Empresa>>() {

            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                if(response.code()== HttpURLConnection.HTTP_OK) {
                    listaEmpreses.addAll(response.body());

                    ArrayAdapter<Empresa> adaptador = new ArrayAdapter<Empresa>(context,android.R.layout.simple_list_item_1,listaEmpreses);

                    listviewEmpresas.setAdapter(adaptador);

                    listviewEmpresas.setOnItemClickListener(ResultatsEmpreses.this);

                } else {
                    Toast.makeText(ResultatsEmpreses.this, "Empreses no trobades", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Toast.makeText(ResultatsEmpreses.this, "Error al trucar al servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String nom = listaEmpreses.get(position).getNom();
        Integer idEmpresa = listaEmpreses.get(position).getId();
        Intent intent = new Intent(this, BuscarOpinions.class);
        Bundle b = new Bundle();
        b.putString("nomEmpresa",nom);
        b.putInt("idEmpresa",idEmpresa);
        intent.putExtras(b);
        startActivity(intent);

    }
}
