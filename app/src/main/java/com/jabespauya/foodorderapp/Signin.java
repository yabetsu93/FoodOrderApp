package com.jabespauya.foodorderapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jabespauya.foodorderapp.Common.Helper;
import com.jabespauya.foodorderapp.UserHelper.User;


public class Signin extends AppCompatActivity {

    //Binding view
    private EditText edtPhoneNo;
    private EditText edtPassword;
    private Button btnLogin;

    private String TAG = Signin.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtPhoneNo = (EditText) findViewById(R.id.edtPhoneNo);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        final FirebaseDatabase  database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference("User");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mProgressDialog = new ProgressDialog(Signin.this);
                mProgressDialog.setMessage("Please wait...");
                mProgressDialog.show();

                reference.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (edtPassword.length() > 0 && edtPhoneNo.length() > 0) {

                            User user = dataSnapshot.child(edtPhoneNo.getText().toString()).getValue(User.class);

                           // Log.d(TAG, user.toString() + "this is a user");
                            mProgressDialog.dismiss();
                            if (dataSnapshot.child(edtPhoneNo.getText().toString()).exists()) {
                                //close the dialog


                                if (user.getPassword().equals(edtPassword.getText().toString())) {
                                    Toast.makeText(Signin.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Signin.this, Home.class);
                                    //Toast.makeText(Signin.this, ""+ user.toString(), Toast.LENGTH_SHORT).show();
                                    Helper.mCurrentUser = user;
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(Signin.this, "Sign in failed!", Toast.LENGTH_SHORT).show();
                                }//end of if statement
                            } else {
                                Toast.makeText(Signin.this, "User does not exist. Please create one!", Toast.LENGTH_SHORT).show();
                            }//end of first else statement
                        } else {
                            Toast.makeText(Signin.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        mProgressDialog.dismiss();
                        Toast.makeText(Signin.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

