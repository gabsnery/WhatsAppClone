package whatsappclone.cursoandroid.com.whatsappclone.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class configuracaoFirebase { //uma casse Final significa que ela não pode ser extendida
    //unicamento para setar as configurações do firebase

    private static DatabaseReference referenciaFirebase; //static é o atributo que tera o mesmo valor independente das instancias;

    public static DatabaseReference getFirebase(){
        if (referenciaFirebase == null){
            referenciaFirebase =  FirebaseDatabase.getInstance().getReference();
        }

        return referenciaFirebase;
    }

}
