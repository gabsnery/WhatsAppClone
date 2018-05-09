package whatsappclone.cursoandroid.com.whatsappclone.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Preferences {

    private Context contexto;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "curso_android_whats.preferencias";
    private final int MODE = 0;
    private SharedPreferences.Editor editor;
    private final String key_Name = "name";
    private final String key_Phone = "phone";
    private final String key_Token = "token";



    public Preferences(Context contextoParametro) {

        contexto = contextoParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO,MODE);
        editor = preferences.edit();

    }

    public  void saveUserPreferences(String name, String phone, String token){
        editor.putString(key_Name,name);
        editor.putString(key_Phone,phone);
        editor.putString(key_Token,token);
        editor.commit();
    }

    public HashMap<String,String> getDataUser(){
        HashMap<String,String> dataUser = new HashMap<>();

        dataUser.put(key_Name, preferences.getString(key_Name,null));
        dataUser.put(key_Phone, preferences.getString(key_Phone,null));
        dataUser.put(key_Token, preferences.getString(key_Token,null));

        return dataUser;
    }
}
