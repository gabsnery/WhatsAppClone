package whatsappclone.cursoandroid.com.whatsappclone.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import whatsappclone.cursoandroid.com.whatsappclone.config.ConfiguracaoFirebase;

public class Usuario {
    private  String id;
    private  String nome;
    private  String email;
    private  String Password;


    public Usuario() {
    }


    public void Salvar(){

        DatabaseReference reference = ConfiguracaoFirebase.getFirebase();
        reference.child("usuarios").child(getId()).setValue(this);
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
