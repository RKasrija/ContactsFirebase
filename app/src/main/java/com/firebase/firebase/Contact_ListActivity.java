package com.firebase.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Contact_ListActivity extends AppCompatActivity {
    ListView listView ;
    FirebaseAuth mFirebaseAuth;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__list);
        listView = (ListView) findViewById(R.id.list);
        mFirebaseAuth = FirebaseAuth.getInstance();



    }

}
