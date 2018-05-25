package whatsappclone.cursoandroid.com.whatsappclone.activity;

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
import whatsappclone.cursoandroid.com.whatsappclone.R;
import whatsappclone.cursoandroid.com.whatsappclone.config.ConfiguracaoFirebase;

public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // referenciaFirebase.child("pontos").setValue("100");
    }
}
