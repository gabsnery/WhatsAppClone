package whatsappclone.cursoandroid.com.whatsappclone.activity;
import whatsappclone.cursoandroid.com.whatsappclone.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class ValidadorActivity extends AppCompatActivity {
    private EditText editTextCodigoValidador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        editTextCodigoValidador = (EditText) findViewById(R.id.editTextValidar);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("NNNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(editTextCodigoValidador, simpleMaskTelefone);
        editTextCodigoValidador.addTextChangedListener(maskTelefone);
    }
}
