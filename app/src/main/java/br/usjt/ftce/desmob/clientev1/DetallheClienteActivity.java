package br.usjt.ftce.desmob.clientev1;

/**
 * Created by Marcelo Morales RA: 201517112 on 05/05/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetallheClienteActivity extends Activity {
    TextView textViewNome, textViewEmail, textViewFone;
    ImageView imagemCliente;
    ClienteRequester clienteRequester;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallhe_cliente);
        textViewNome = (TextView) findViewById(R.id.txt_cliente_nome);
        textViewFone = (TextView) findViewById(R.id.txt_cliente_fone);
        textViewEmail = (TextView) findViewById(R.id.txt_cliente_email);
        imagemCliente = (ImageView) findViewById(R.id.cliente_image_view);
        Intent intent = getIntent();
        cliente = (Cliente) intent.getSerializableExtra(ListarClientesActivity.CLIENTE);

        textViewNome.setText(cliente.getNomePais());
        textViewFone.setText(cliente.getCapital());
        textViewEmail.setText(cliente.getArea());
        textViewEmail.setText(cliente.getPopulação());
        textViewEmail.setText(cliente.getMoeda());

        clienteRequester = new ClienteRequester();

        new DownloadImage().execute(MainActivity.SERVIDOR
                + MainActivity.APPSTRING
                + "/img/" + cliente.getImagem()+".jpg");

    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return clienteRequester.getImage(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Bitmap result) {
            imagemCliente.setImageBitmap(result);
        }
    }
}
