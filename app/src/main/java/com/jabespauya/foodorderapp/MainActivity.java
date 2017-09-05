package com.jabespauya.foodorderapp;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSignup:
                startSignUpActivity();
                break;
            case R.id.btnSignInLink:
                startSignInActivity();
                break;
        }
    }



    public void startSignUpActivity(){
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }

    public void startSignInActivity(){
        Intent intent = new Intent(MainActivity.this, Signin.class);
        startActivity(intent);
    }
}
