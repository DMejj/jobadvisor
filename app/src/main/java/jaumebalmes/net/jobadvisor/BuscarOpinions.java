package jaumebalmes.net.jobadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarOpinions extends AppCompatActivity {

    String nomEmpresa;
    Integer idEmpresa;
    EditText nomEmpresaTxt;
    EditText lloctxt;
    Button trobarEmpresa;
    Button buscarOpinions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_opinions);
        nomEmpresaTxt = (EditText) findViewById(R.id.editEmpresa);
        trobarEmpresa = (Button) findViewById(R.id.btnTrobarEmpresa);
        buscarOpinions = (Button) findViewById(R.id.btnBuscarOpinions);
        lloctxt = (EditText) findViewById(R.id.editLloc);

        if (getIntent().getExtras() != null){
            nomEmpresa = getIntent().getStringExtra("nomEmpresa");
            nomEmpresaTxt.setText(nomEmpresa);
            idEmpresa = getIntent().getIntExtra("idEmpresa",-1);
        }


    }

    public void busquedaEmpresa(View view) {
        Intent i = new Intent(BuscarOpinions.this, TrobarEmpresa.class);
        startActivity(i);
    }

    public void busquedaOpinions(View view){
        Intent i = new Intent(BuscarOpinions.this, ResultatsOpinions.class);
        Bundle b = new Bundle();
        b.putString("nomEmpresa",nomEmpresa);
        b.putInt("idEmpresa",idEmpresa);
        i.putExtras(b);
        startActivity(i);
    }

    public void novaOpinio(View view) {

        if (null != idEmpresa && idEmpresa != -1){

            Intent i = new Intent(BuscarOpinions.this, NovaOpinio.class);
            Bundle b = new Bundle();
            b.putInt("idEmpresa",idEmpresa);
            i.putExtras(b);
            startActivity(i);
        }else{
            Toast.makeText(this, "Trobar primer una empresa", Toast.LENGTH_SHORT).show();
        }
    }
}
