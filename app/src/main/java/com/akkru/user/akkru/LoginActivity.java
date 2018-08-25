package com.akkru.user.akkru;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    ProgressDialog progressDialog;
    private EditText loginusername , loginpassword;
    private Button btnlogin;
    private Button btnlinkSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginusername = (EditText) findViewById(R.id.login_input_username);
        loginpassword = (EditText) findViewById(R.id.login_input_password);
        btnlogin = (Button) findViewById(R.id.btn_login);
        btnlinkSignUp = (Button) findViewById(R.id.btnLinkSignUp);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(loginusername.getText().toString(),loginpassword.getText().toString());
            }
        });

        btnlinkSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    private void loginUser(final String username , final String password){
        String cancel_reg_tag = "login";
        progressDialog.setMessage("Login . . .");
        showDialog();

        if (username.equals("halo")  && password.equals("manja") ){

            Intent intent = new Intent(getApplicationContext(), DummyActivity.class);
            startActivity(intent);
        } else {
            System.out.println("ERROR");
            hideDialog();
        }

    }

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
