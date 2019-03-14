package jaumebalmes.net.jobadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class TrobarEmpresa extends Activity {

    EditText nomEmpresaTxt;
    EditText poblacioEmpresaTxt;
    EditText sectorEmpresaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trobar_empresa);

        nomEmpresaTxt = (EditText) findViewById(R.id.txtNomEmpresa);
        poblacioEmpresaTxt = (EditText) findViewById(R.id.txtPoblacioEmpresa);
        sectorEmpresaTxt = (EditText) findViewById(R.id.txtSectorEmpresa);
    }

    public void busquedaEmpresa(View view) {
        Intent i = new Intent(TrobarEmpresa.this, ResultatsEmpreses.class);
        Bundle b = new Bundle();
        b.putString("nomEmpresa",nomEmpresaTxt.getText().toString());
        i.putExtras(b);
        startActivity(i);
    }

}
