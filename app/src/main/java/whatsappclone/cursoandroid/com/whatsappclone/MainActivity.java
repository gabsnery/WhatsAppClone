package whatsappclone.cursoandroid.com.whatsappclone;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import whatsappclone.cursoandroid.com.whatsappclone.POJO.Produto;
import whatsappclone.cursoandroid.com.whatsappclone.POJO.Usuario;

public class MainActivity extends Activity {

    private FirebaseAuth firebaseAutenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAutenticacao = FirebaseAuth.getInstance();

        firebaseAutenticacao.signInWithEmailAndPassword("gneri94@gmail.com","novaSenha123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){//se usuario criado com sucesso
                    Log.i("login","SUCESSO"+task.getException());
                }else{//usuario nao criado com sucesso
                    Log.i("login","NÃO SUCESSO"+task.getException());
                }
            }
        });

        firebaseAutenticacao.signOut();;
        //verifica usuario logdo
        if (firebaseAutenticacao.getCurrentUser() != null){
            Log.i("VerificaUsuario",firebaseAutenticacao.getCurrentUser().toString());
        }else{
            Log.i("VerificaUsuario","Usuario não logado");
        }
        //cadastro
        /*firebaseAutenticacao.createUserWithEmailAndPassword("gneri94@gmail.com","novaSenha123")
                .addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){//se usuario criado com sucesso
                    Log.i("criacao","SUCESSO");
                }else{//usuario nao criado com sucesso
                    Log.i("criacao","NÃO SUCESSO");
                }
            }
        });*/

    }
}
