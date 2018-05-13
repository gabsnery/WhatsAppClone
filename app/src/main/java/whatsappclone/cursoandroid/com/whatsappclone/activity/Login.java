package whatsappclone.cursoandroid.com.whatsappclone.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;
import java.util.Random;

import whatsappclone.cursoandroid.com.whatsappclone.Manifest;
import whatsappclone.cursoandroid.com.whatsappclone.R;
import whatsappclone.cursoandroid.com.whatsappclone.helper.Permission;
import whatsappclone.cursoandroid.com.whatsappclone.helper.Preferences;

public class Login extends Activity {

    private EditText editTextPhone;
    private EditText editTextDDD;
    private EditText editTextCodigoPais;
    private EditText editTextName;
    private Button cadastrar;

    private String[] permissionNeeded = new String[]{
            android.Manifest.permission.SEND_SMS,
            android.Manifest.permission.INTERNET

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Permission.validatePermission(1,this,permissionNeeded);

        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextDDD = (EditText) findViewById(R.id.editTextDDD);
        editTextCodigoPais = (EditText) findViewById(R.id.editTextCodPais);
        editTextName = (EditText) findViewById(R.id.editTextName);

        cadastrar = (Button) findViewById(R.id.buttonCadastrar);

        SimpleMaskFormatter simpleMaskPhone = new SimpleMaskFormatter("NNNNN-NNNN");
        MaskTextWatcher maskPhone = new MaskTextWatcher(editTextPhone, simpleMaskPhone);
        editTextPhone.addTextChangedListener(maskPhone);

        SimpleMaskFormatter simpleMaskDDD = new SimpleMaskFormatter("NN");
        MaskTextWatcher maskDDD = new MaskTextWatcher(editTextDDD, simpleMaskDDD);
        editTextDDD.addTextChangedListener(maskDDD);

        SimpleMaskFormatter simpleMaskCodPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskCodPais = new MaskTextWatcher(editTextCodigoPais, simpleMaskCodPais);
        editTextCodigoPais.addTextChangedListener(maskCodPais);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = editTextName.getText().toString();

                String phone =
                        editTextCodigoPais.getText().toString() +
                        editTextDDD.getText().toString() +
                        editTextPhone.getText().toString();
                phone = phone.replace("+","");
                phone = phone.replace("(","");
                phone = phone.replace(")","");
                phone = phone.replace("-","");

                Log.i("Phone",phone);
                // O IDEAL É GERAR O TOKEN EM UM SERVIDOR
                //TOKEN GERADO PELO SERVIDOR
                //ENVIADO DO SERVIDOR PARA CELULAR
                //APP ENVIA TOKEN DIGITADO
                //SERVIDOR RESPONDE SE É VALIDO OU NÃO
                //PODE SER FEITO COM PHP POR EXEMPLO
                //Gera token
                Random random = new Random();
                int numeroValidador = random.nextInt(9999 - 1000) + 1000;
                String token = String.valueOf(numeroValidador);
                Log.i("Token",token);


                //Salvar dados para validação
                Preferences preferences = new Preferences(Login.this);
                preferences.saveUserPreferences(userName,phone,token);


                //Envio SMS
                boolean sended = sendSMS("+"+phone,"WhatsApp code validation:  "+token);

                if (sended){
                    Intent intent = new Intent( Login.this,ValidadorActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this,"Problema ao enviar SMS, tente novamente!",Toast.LENGTH_LONG).show();
                }
  /*


                HashMap<String,String> usuario = preferences.getDataUser();
                Log.i("token","T:"+usuario.get("token"));*/
            }
        });
    }
    private boolean sendSMS(String phone,String message){
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,message,null,null);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
            for(int resultado : grantResults){
                if (resultado == PackageManager.PERMISSION_DENIED){
                    alertValidPermission();
                }
            }
        }
    }

    private void alertValidPermission(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões negadas");
        builder.setMessage("Para utilizar esse app, é necessário aceitar as permissões");

        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
