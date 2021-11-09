package com.example.androidusecase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    EditText login_id;
    EditText password;

    void checkFieldsForEmptyValues(){


        String s1 = login_id.getText().toString();
        String s2 = password.getText().toString();

        if(s1.equals("")|| s2.equals("")){
            loginbtn.setEnabled(false);
        } else {
            loginbtn.setEnabled(true);
        }

//        temp = (s1.equals("")||s2.equals(""))? loginbtn.setEnabled(false) : loginbtn.setEnabled(true);
    }






    private TextWatcher mTextWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Button loginbtn = findViewById(R.id.loginbtn);
            loginbtn.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            checkFieldsForEmptyValues();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         login_id =  findViewById(R.id.login_IDET);
         password =  findViewById(R.id.passwordET);
         loginbtn = findViewById(R.id.loginbtn);




        login_id.addTextChangedListener(mTextWatcher);
        password.addTextChangedListener(mTextWatcher);


//        loginbtn.setEnabled(false);
//
//        password.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int before, int count) {
//                if (s.toString().trim().length() == 0) {
//                    loginbtn.setEnabled(false);
//                } else {
//                    loginbtn.setEnabled(true);
//
//                }
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });







        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                startActivity(intent);
            }
        });

    }
}

//    private TextWatcher loginTextWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            String loginInput = login_id.getText().toString().trim();
//            String passwordInput = password.getText().toString().trim();
//
//            loginbtn.setEnabled(!loginInput.isEmpty() && !passwordInput.isEmpty());
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//
//        }
//    };
    //        public void ShowHidePass(View view){
//
//            if(view.getId()==R.id.show_pass_btn){
//
//                if(password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
//                    ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);
//
//                    //Show Password
//                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                }
//                else{
//                    ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);
//
//                    //Hide Password
//                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
//
//                }
//            }
//        }


//        login_id.addTextChangedListener(loginTextWatcher);
//        password.addTextChangedListener(loginTextWatcher);

