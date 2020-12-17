package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class register extends AppCompatActivity {
    EditText emailId, password,passwordc,phone;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference reference;
    String email,pwd,pwdc,phn;
    String currentUserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        if(mFirebaseAuth.getCurrentUser()!=null)
        {//getApplicationContext()
            startActivity(new Intent(register.this, MainActivity.class));//MainActivity
            finish();
        }
     else {
            emailId = findViewById(R.id.useremail);
            password = findViewById(R.id.userpassword);
            phone = findViewById(R.id.userphone);
            btnSignUp = findViewById(R.id.registerBtn);
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    email = emailId.getText().toString();
                    pwd = password.getText().toString();
                    //  pwdc = passwordc.getText().toString();
                /*
                email = "asteett@gmail.com";//extras.getString("EXTRA_EMAIL");
                pwd = "astro123";//extras.getString("EXTRA_PASSWORD");
                pwdc = "astro123";//extras.getString("EXTRA_PASSWORDC");*/
                    if (email.isEmpty()) {
                        emailId.setError("Please enter email id");
                        emailId.requestFocus();
                    } else if (pwd.isEmpty()) {
                        password.setError("Please enter your password");
                        password.requestFocus();
                    }
                    // else if(!pwd.equals(pwdc)){ Toast.makeText(register.this,"Password Does not Match!",Toast.LENGTH_SHORT).show();  }

                    else if (email.isEmpty() && pwd.isEmpty()) {
                        Toast.makeText(register.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                    } else if (!(email.isEmpty() && pwd.isEmpty())) {

                        mFirebaseAuth.createUserWithEmailAndPassword(email, pwd)
                                .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(register.this, "SignUp Unsuccessful, Please Try Again" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        } else {
                                            currentUserId = mFirebaseAuth.getCurrentUser().getUid();
                                            reference = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(currentUserId);
                                            reference.setValue(true);

                                            Intent intent = new Intent(register.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                                });
                        /////////////////
                    } else {
                        Toast.makeText(register.this, "Error Occurred!", Toast.LENGTH_SHORT).show();

                    }
                }
            });
//**********************************************************************************************************************************
        }
    }

}


/*

 private void RegisterCustomer(String email, String password) {
        //**********************************************************************************************************************************
        RegisterCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = CustomerEmail.getText().toString();
                String password = CustomerPassword.getText().toString();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(register.this, "Please write your Email...", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(register.this, "Please write your Password...", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    loadingBar.show();

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isSuccessful())
                            {
                                currentUserId = mAuth.getCurrentUser().getUid();
                                customersDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(currentUserId);
                                customersDatabaseRef.setValue(true);

                                Intent intent = new Intent(register.this, MainActivity.class);
                                startActivity(intent);

                                loadingBar.dismiss();
                            }
                            else
                            {
                                Toast.makeText(register.this, "Please Try Again. Error Occurred, while registering... ", Toast.LENGTH_SHORT).show();

                                loadingBar.dismiss();
                            }
                        }
                    });
                }
            }
        });
//**********************************************************************************************************************************

    }
 */