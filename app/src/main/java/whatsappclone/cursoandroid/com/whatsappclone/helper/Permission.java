package whatsappclone.cursoandroid.com.whatsappclone.helper;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    public static boolean validatePermission(int requestCode,Activity activity,String[] permissions){

        if (Build.VERSION.SDK_INT >= 23){

            List<String> listPermission = new ArrayList<String>();

            for(String permissao:permissions){
                Boolean checkPErmission = ContextCompat.checkSelfPermission(activity,permissao) == PackageManager.PERMISSION_GRANTED;
                if (!checkPErmission)  listPermission.add(permissao);
            }

            //verifica se tem permissoes para se dar
            if (listPermission.isEmpty()) return true;

            String[] newPermission = new String[ listPermission.size() ];
            listPermission.toArray( newPermission );

            //Solicita permissoes
            ActivityCompat.requestPermissions(activity,newPermission,requestCode);
        }
        return true;
    }
}
