package com.firebase.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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


public class ContactsActivity extends AppCompatActivity {

    EditText ContactName, ContactNumber, Email;
    Button Add, Back;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;
    Add a=new Add();

    private FirebaseAuth.AuthStateListener maAthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        mFirebaseAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.etEmail);
        ContactName = findViewById(R.id.etContactName);
        ContactNumber = findViewById(R.id.etContactNumber);
        Add = findViewById(R.id.btnAdd);
        Back = findViewById(R.id.Back);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=Email.getText().toString();

                String name = ContactName.getText().toString();
                String number = ContactNumber.getText().toString();
                a.setEmail(email);
                a.setName(name);
                a.setContact(number);
                if (email.isEmpty()) {
                    Email.setError("Please Enter Valid Email Id");
                    Email.requestFocus();
                } else if (name.isEmpty()) {
                    ContactName.setError("Please enter the Name");
                    ContactName.requestFocus();
                } else if (number.isEmpty()) {
                    ContactNumber.setError("Please enter the 10 Digits Number");
                    ContactNumber.requestFocus();
                } else if (email.isEmpty() && name.isEmpty() && number.isEmpty()) {
                    Toast.makeText(ContactsActivity.this, "Fields are empty!", Toast.LENGTH_SHORT).show();

                }


                        else {
                           firebaseDatabase.getInstance().getReference("Add").child(ContactNumber.getText().toString()).setValue(a);
                            startActivity(new Intent(ContactsActivity.this,Contact_ListActivity.class));

                }

            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsActivity.this, HomeActivity.class);
            }
        });
    }
}