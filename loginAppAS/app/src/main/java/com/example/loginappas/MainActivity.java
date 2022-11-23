package com.example.loginappas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email_editText = findViewById(R.id.editTextTextEmail);
        EditText password_1_editText = findViewById(R.id.editTextTextPassword);
        EditText password_2_editText = findViewById(R.id.editTextTextPassword2);
        Button submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView info = findViewById(R.id.info);

                String email = String.valueOf(email_editText.getText());
                String password_1 = String.valueOf(password_1_editText.getText());
                String password_2 = String.valueOf(password_2_editText.getText());

                System.out.println(password_1);
                System.out.println(password_2);

                info.setText("Witaj " + email);

                if(!checkIsEmailValid(email)) {
                    info.setText("Nieprawidłowy adres e-mail");
                }

                if(!arePasswordsTheSame(password_1, password_2)) {
                    info.setText("Hasła są różne");
                }

                if((!checkIsEmailValid(email)) && (!arePasswordsTheSame(password_1, password_2))) {
                    info.setText("Nieprawidłowy adres e-mail oraz hasła sa różne");
                }
            }
        });


    }

    private boolean checkIsEmailValid(String email) {

        for(int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@') {
                return true;
            }
        }

        return false;
    }

    private boolean arePasswordsTheSame(String password1, String password2) {

        if(password1.equals(password2)){
            return true;
        }

        return false;
    }
}