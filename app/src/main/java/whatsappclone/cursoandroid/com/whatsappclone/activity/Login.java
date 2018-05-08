package whatsappclone.cursoandroid.com.whatsappclone.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Snapshot;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import whatsappclone.cursoandroid.com.whatsappclone.POJO.Produto;
import whatsappclone.cursoandroid.com.whatsappclone.POJO.Usuario;
import whatsappclone.cursoandroid.com.whatsappclone.R;

public class Login extends Activity {

    private EditText editTextTelefone;
    private EditText editTextDDD;
    private EditText editTextCodigoPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextDDD = (EditText) findViewById(R.id.editTextDDD);
        editTextCodigoPais = (EditText) findViewById(R.id.editTextCodPais);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("NNNNN-NNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(editTextTelefone, simpleMaskTelefone);
        editTextTelefone.addTextChangedListener(maskTelefone);

        SimpleMaskFormatter simpleMaskDDD = new SimpleMaskFormatter("NN");
        MaskTextWatcher maskDDD = new MaskTextWatcher(editTextDDD, simpleMaskDDD);
        editTextDDD.addTextChangedListener(maskDDD);

        SimpleMaskFormatter simpleMaskCodPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskCodPais = new MaskTextWatcher(editTextCodigoPais, simpleMaskCodPais);
        editTextCodigoPais.addTextChangedListener(maskCodPais);
    }
}
