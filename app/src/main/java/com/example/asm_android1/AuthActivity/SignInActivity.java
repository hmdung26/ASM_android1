package com.example.asm_android1.AuthActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm_android1.HomeActivity.DSNhanVienActivity;
import com.example.asm_android1.R;

public class SignInActivity extends AppCompatActivity {
 TextView btnGetSignUp;
    Button btnSignIn;
    EditText edtUser,editPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnGetSignUp = findViewById(R.id.btnGetSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
        edtUser = findViewById(R.id.edtUsername);
        editPass = findViewById(R.id.edtPass);

        btnGetSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edtUser.getText().toString().trim();
                String pass = editPass.getText().toString().trim();


                if (!user.equals("") && !pass.equals("")){
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    String getUsername = bundle.getString("username");
                    String getPassword = bundle.getString("password");
                    if (user.equals(getUsername) ){
                        if (pass.equals(getPassword)){
                            Intent i = new Intent(SignInActivity.this , DSNhanVienActivity.class);
                            startActivity(i);
                            Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"Sai mật khẩu",Toast.LENGTH_LONG).show();
                        }


                    }else {
                        Toast.makeText(getApplicationContext(),"Tài khoản không tồn tại",Toast.LENGTH_LONG).show();

                    }

                }else {
                    Toast.makeText(getApplicationContext(),"Hãy điền hết các thông tin",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}