package whatsappclone.cursoandroid.com.whatsappclone.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DatabaseReference;

import whatsappclone.cursoandroid.com.whatsappclone.R;
import whatsappclone.cursoandroid.com.whatsappclone.config.ConfiguracaoFirebase;
import whatsappclone.cursoandroid.com.whatsappclone.model.Usuario;

public class Login extends Activity {

   // private DatabaseReference referenciaFirebase ;

    private EditText email;
    private EditText password;
    private Button botaoLogar;

    private FirebaseAuth authenti;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // referenciaFirebase = ConfiguracaoFirebase.getFirebase();

        verifyUserLog();

        botaoLogar = (Button) findViewById(R.id.buttonLogar);
        email = (EditText) findViewById(R.id.edit_signIn_email);
        password = (EditText) findViewById(R.id.edit_signIn_password);


        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = new Usuario();
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());

                authenticateLogin();
            }
        });

    }


    private void authenticateLogin(){
        authenti = ConfiguracaoFirebase.getFirebaseAutentication();
        authenti.signInWithEmailAndPassword(
                user.getEmail(),
                user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(Login.this,"SUCESSO",Toast.LENGTH_SHORT).show();
                    openPrimaryWindow();
                }else{
                    String erro = "";
                    try{
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        erro = "Usuario não encontrado!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "Senha invalida!";
                    }catch (Exception e){
                        erro = "Erro ao logar!";
                    }
                    Toast.makeText(Login.this,"Erro: "+erro,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void verifyUserLog(){
        authenti = ConfiguracaoFirebase.getFirebaseAutentication();

        if(authenti.getCurrentUser() != null){
            openPrimaryWindow();
        }

    }
    private void openPrimaryWindow(){

        Intent  intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void abrirCadastroUsuario(View view){

        Intent intent = new Intent(Login.this,CadastroUsuarioActivity.class);
        startActivity(intent);

    }
}
