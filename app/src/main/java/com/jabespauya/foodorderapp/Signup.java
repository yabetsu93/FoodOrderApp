package com.jabespauya.foodorderapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jabespauya.foodorderapp.FirebaseHelper.FirebaseHelpers;
import com.jabespauya.foodorderapp.UserHelper.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Signup extends AppCompatActivity {

    //BindView
    private EditText edtPhoneNo;
    private EditText edtName;
    private EditText edtPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPhoneNo = (EditText) findViewById(R.id.edtPhoneNo);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check all the field must have value
                if (edtPhoneNo.length() > 0 && edtPassword.length() > 0 && edtName.length() > 0) {
                    final ProgressDialog mProgressDialog = new ProgressDialog(Signup.this);
                    mProgressDialog.setMessage("Please wait...");
                    mProgressDialog.show();

                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final DatabaseReference reference = database.getReference("User");

                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child(edtPhoneNo.getText().toString()).exists()) {
                                mProgressDialog.dismiss();
                                Toast.makeText(Signup.this, "Phone already exist", Toast.LENGTH_SHORT).show();
                            } else {
                                mProgressDialog.dismiss();
                                User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
                                reference.child(edtPhoneNo.getText().toString()).setValue(user);
                                Toast.makeText(Signup.this, "Successful sign up", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(Signup.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(Signup.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
