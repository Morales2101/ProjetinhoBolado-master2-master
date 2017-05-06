package br.usjt.ftce.desmob.clientev1;

/**
 * Created by Marcelo Morales RA: 201517112 on 05/05/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPaisActivity extends AppCompatActivity {
    ListView listView;
    Pais[] lista;
    public static final String PAIS = "br.usjt.ftce.desmob.clientev1.nomePais";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pais);
        listView = (ListView) findViewById(R.id.lista_de_pais);
        Intent intent = getIntent();
        //String chave = intent.getStringExtra(MainActivity.CHAVE);
        //lista = Data.buscaClientes(chave);
        ArrayList<Pais> clientes = (ArrayList<Pais>) intent.getSerializableExtra(MainActivity.LISTA);
        lista = clientes.toArray(new Pais[0]);
        BaseAdapter adapter = new PaisAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Intent intent1 = new Intent(ListarPaisActivity.this, DetallhePaisActivity.class);
                intent1.putExtra(PAIS, lista[posicao]);
                startActivity(intent1);

            }
        });
    }

}