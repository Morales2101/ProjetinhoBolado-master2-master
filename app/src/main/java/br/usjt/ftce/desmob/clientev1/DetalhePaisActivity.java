package br.usjt.ftce.desmob.clientev1;
/**
 * Created by Marcelo Morales RA: 201517112 on 05/05/2017.
 */


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetalhePaisActivity extends Activity {
    TextView textViewNomePais, textViewCapital, textViewArea, textViewPopulacao, textViewMoeda;
    ImageView imagemPais;
    PaisRequester paisRequester;
    Pais pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        textViewNomePais = (TextView) findViewById(R.id.txt_cliente_nome);
        textViewFone = (TextView) findViewById(R.id.txt_cliente_fone);
        textViewEmail = (TextView) findViewById(R.id.txt_cliente_email);
        imagemPais = (ImageView) findViewById(R.id.cliente_image_view);
        Intent intent = getIntent();
        pais = (Pais)intent.getSerializableExtra(ListarPaisActivity.PAIS);
        textViewNome.setText(pais.getNome());
        textViewEmail.setText(pais.getEmail());
        textViewFone.setText(pais.getFone());

        paisRequester = new PaisRequester();
        new DownloadImage().execute(MainActivity.SERVIDOR+
                MainActivity.APLICACAO+"/img/"+pais.getImagem()+".jpg");

    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return PaisRequester.getImage(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Bitmap result){
            imagemCliente.setImageBitmap(result);
        }
    }
}

