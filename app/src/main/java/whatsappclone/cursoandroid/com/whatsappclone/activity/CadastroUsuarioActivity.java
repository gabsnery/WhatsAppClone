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


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }
}
