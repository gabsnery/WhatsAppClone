package whatsappclone.cursoandroid.com.whatsappclone.activity;
import android.os.Bundle;
import whatsappclone.cursoandroid.com.whatsappclone.R;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastroUsuarioActivity extends AppCompatActivity {
    
    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        nome = (EditText) findViewById(R.id.edit_cadastro_usuario);
        email = (EditText) findViewById(R.id.edit_cadastro_senha);
        senha = (EditText) findViewById(R.id.edit_cadastro_senha);
        botaoCadastrar = (Button) findViewById(R.id.buttonCadastrar);
    }
}
