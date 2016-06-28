package es.esy.elvinmorales48.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    private Button botonEnviarCorreo;
    private EditText nombre, email, mensaje;

    String emailUsario;
    String nombreUsuario;
    String mensajeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSub);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContactoActivity.this,"Regresando",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        botonEnviarCorreo = (Button) findViewById(R.id.Button_enviarMensaje);
        nombre = (EditText) findViewById(R.id.EditText_nombre);
        email = (EditText) findViewById(R.id.EditText_correo);
        mensaje = (EditText) findViewById(R.id.EditText_mensaje);

        botonEnviarCorreo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nombreUsuario = nombre.getText().toString();
                emailUsario = email.getText().toString();
                mensajeUsuario = mensaje.getText().toString();

                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("plain/text");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailUsario});
                sendEmail.putExtra(Intent.EXTRA_TEXT, mensajeUsuario);
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Mensaje enviado desde APP por " + nombreUsuario);
                startActivity(Intent.createChooser(sendEmail, "Elige una aplicación: "));
            }
        });
    }
}
