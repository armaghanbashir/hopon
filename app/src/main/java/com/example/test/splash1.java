package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash1 extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    FirebaseUser firebaseUser;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_splash1);
       firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

       if(firebaseUser!=null)
       {//getApplicationContext()
           startActivity(new Intent(splash1.this,MainActivity.class));
           finish();
       }
       else {
           Thread thread = new Thread() {
               @Override
               public void run() {
                   try {
                       sleep(1000);
                   } catch (Exception e) {
                       e.printStackTrace();
                   } finally {
                       Intent mainIntent = new Intent(splash1.this, splash.class);
                       startActivity(mainIntent);
                   }
               }
           };

        thread.start();
       }

    }




    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth = FirebaseAuth.getInstance();

        if(mFirebaseAuth.getCurrentUser()!=null)
        {//getApplicationContext()
            startActivity(new Intent(splash1.this,MainActivity.class));
            finish();
        }

    }

     @Override
   protected void onPause()
    {
        super.onPause();

        finish();
    }
}