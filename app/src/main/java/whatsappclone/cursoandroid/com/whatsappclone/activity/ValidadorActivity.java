package whatsappclone.cursoandroid.com.whatsappclone.activity;
import whatsappclone.cursoandroid.com.whatsappclone.R;
import whatsappclone.cursoandroid.com.whatsappclone.helper.Preferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;

public class ValidadorActivity extends AppCompatActivity {
    private EditText editTextCodigoValidador;
    private Button validar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        editTextCodigoValidador = (EditText) findViewById(R.id.editTextValidar);
        validar = (Button) findViewById(R.id.buttonValidar);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("NNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(editTextCodigoValidador, simpleMaskTelefone);
        editTextCodigoValidador.addTextChangedListener(maskTelefone);

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recuperar dados das preferencias do usuario
                Preferences preferencias = new Preferences(ValidadorActivity.this);
                HashMap<String,String> usuario = preferencias.getDataUser();

                String tokenGenerated = usuario.get("token");
                String tokenText = editTextCodigoValidador.getText().toString();

                if (tokenText.equals(tokenGenerated)){
                    Toast.makeText(ValidadorActivity.this,"Token VALIDADO",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ValidadorActivity.this,"Token não VALIDADO",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
