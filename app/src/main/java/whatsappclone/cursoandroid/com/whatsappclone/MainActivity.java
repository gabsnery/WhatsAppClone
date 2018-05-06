package whatsappclone.cursoandroid.com.whatsappclone;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Snapshot;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import whatsappclone.cursoandroid.com.whatsappclone.POJO.Produto;
import whatsappclone.cursoandroid.com.whatsappclone.POJO.Usuario;

public class MainActivity extends Activity {
  /* 
    private DatabaseReference ReferenciaDataBase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioRef = ReferenciaDataBase.child("usuarios");
    private DatabaseReference produtoRef = ReferenciaDataBase.child("produtos");*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    Usuario usuario = new Usuario();
        usuario.setNome("Ana Helena");
        usuario.setSobrenome("Silva");
        usuario.setSexo("Feminino");
        usuario.setIdade(22);

        Produto produto = new Produto();
        produto.setDescricao("celular");
        produto.setCor("rosa");
        produto.setFabricante("Samsung");

        produtoRef.child("001").setValue(produto);

        produtoRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i("FIREBASE",dataSnapshot.toString().toString());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        usuarioRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i("FIREBASE_USU",dataSnapshot.toString().toString());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

    }
}
