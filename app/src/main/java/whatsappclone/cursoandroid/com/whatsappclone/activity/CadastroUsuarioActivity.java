package whatsappclone.cursoandroid.com.whatsappclone.activity;
import android.os.Bundle;
import whatsappclone.cursoandroid.com.whatsappclone.R;
import whatsappclone.cursoandroid.com.whatsappclone.model.Usuario;
import whatsappclone.cursoandroid.com.whatsappclone.config.ConfiguracaoFirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText Password;
    private Button botaoCadastrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        nome = (EditText) findViewById(R.id.edit_cadastro_usuario);
        email = (EditText) findViewById(R.id.edit_cadastro_email);
        Password = (EditText) findViewById(R.id.edit_cadastro_Password);
        botaoCadastrar = (Button) findViewById(R.id.buttonCadastrarUsu);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = new Usuario();
                usuario.setNome(nome.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setPassword(Password.getText().toString());

                cadastrarUsuario();//cadastra usuario

            }
        });
    }

    private  void cadastrarUsuario(){ //cadastra usuario

        autenticacao = ConfiguracaoFirebase.getFirebaseAutentication(); //retorna a autenticaçao do firebase
        try{
            autenticacao.createUserWithEmailAndPassword( // cria usuario de acordo com o email e senha digitado
                    usuario.getEmail(),
                    usuario.getPassword()
            ).addOnCompleteListener(CadastroUsuarioActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {  //quando o processo terminar
                    if(task.isSuccessful()){
                        Toast.makeText(CadastroUsuarioActivity.this,"SUCESSO",Toast.LENGTH_SHORT).show();

                        usuario.setId(task.getResult().getUser().getUid()); // seta no objeto Usuario o Id que foi incluido no Firebase
                        usuario.Salvar(); //salva no "banco de dados" os dados do usuario cadastrado (nome, email, Id)

                        autenticacao.signOut(); // desloga o usuario que acabou de ser criado
                        finish(); // volta para tela de login
                    }else{

                        String erroException = "";

                        try{
                            throw task.getException();  //dispara uma exceção e testa de acordo com as exceções do firebase
                        }catch (FirebaseAuthWeakPasswordException e){
                            erroException = "Digite uma Password mais forte, contendo mais caracteres e com letras e números!";
                        }catch (FirebaseAuthInvalidCredentialsException e) {
                            erroException = "Credenciais inválidas!";
                        } catch (FirebaseAuthUserCollisionException e) {
                            erroException = "Esse e-mail já está em uso no APP";
                        } catch (Exception e) {
                            erroException = "Erro ao efetuar o cadastro!";
                        }
                        Toast.makeText(CadastroUsuarioActivity.this,"Erro: "+ erroException,Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(CadastroUsuarioActivity.this,"Erro: "+ e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
