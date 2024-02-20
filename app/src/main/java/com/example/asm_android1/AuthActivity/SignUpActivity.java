package com.example.asm_android1.AuthActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm_android1.R;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignUp_re;
    EditText edtUser,editPass,edtCom_Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp_re = findViewById(R.id.btnSignUp);

        editPass = findViewById(R.id.edtPass_SignUp);
        edtUser = findViewById(R.id.edtUsername_SignUp);
        edtCom_Pass = findViewById(R.id.edtConPass_SignUp);

        btnSignUp_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pass = editPass.getText().toString().trim();
                String com_pass = edtCom_Pass.getText().toString().trim();

                if (!user.equals("")&& !pass.equals("") && !com_pass.equals("")){
                    if (pass.equals(com_pass)){
                        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username",user);
                        bundle.putString("password",pass);
                        intent.putExtras(bundle);
                        Toast.makeText(getApplicationContext(),"Đăng ký thành công",Toast.LENGTH_LONG).show();
                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(),"Password và ComfrimPassword phải giống nhau",Toast.LENGTH_LONG).show();
                    }


                }else {Toast.makeText(getApplicationContext(),"Hãy điền hết các thông tin",Toast.LENGTH_LONG).show();}

            }
        });
    }
}