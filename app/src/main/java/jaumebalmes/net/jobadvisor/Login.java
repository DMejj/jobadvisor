package jaumebalmes.net.jobadvisor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (EditText) findViewById(R.id.txtNomEmpresa);
        editTextPassword = (EditText) findViewById(R.id.txtPassword);
    }


    public void doLogin(View view) {
        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if(!email.isEmpty() && !pass.isEmpty()) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.API_BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JobAdvisorAPI apiService = retrofit.create(JobAdvisorAPI.class);

            Call<Usuari> peticionLogin = apiService.dologin(email,pass);

            peticionLogin.enqueue(new Callback<Usuari>() {

                @Override
                public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                    if(response.code()== HttpURLConnection.HTTP_OK) {

                        String nomRespuesta = response.body().getNickname();
                        String emailRespuesta = response.body().getEmail();

                        // Guardar los datos del login
                        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_jobadvisor_file),Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.preferencias_mail), emailRespuesta);
                        editor.putString(getString(R.string.preferencias_nombre), nomRespuesta);
                        editor.commit();

                        Intent i = new Intent(Login.this, BuscarOpinions.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Login.this, "Usuari i/o contrasenya incorrectes", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Usuari> call, Throwable t) {
                    Toast.makeText(Login.this, "Error al trucar al servidor", Toast.LENGTH_SHORT).show();
                }
            });



        } else {
            Toast.makeText(this, "Usuari i/o contrasenya incorrectes", Toast.LENGTH_SHORT).show();
        }

    }
}
