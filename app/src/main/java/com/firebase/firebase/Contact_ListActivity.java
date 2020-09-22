package com.firebase.firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class Contact_ListActivity extends AppCompatActivity {
FirebaseDatabase firebaseDatabase;
ArrayList<String> arrayList;
ListView listView;
    Add a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__list);
        listView= findViewById(R.id.list);
        DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference("Add");


        final ArrayAdapter<String> details= new ArrayAdapter<>(this, R.layout.activity_contact__list);

        listView.setAdapter(details);
databaseReference.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        try {


            if (snapshot.exists()) {
                a = snapshot.getValue(Add.class);
                if (a.toString() != null) {
                    arrayList.add(a.toString());
                } else


                    details.notifyDataSetChanged();
            } else {
                Toast.makeText(Contact_ListActivity.this, "NO DATA", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            e.getStackTrace();
        }


     }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});

    }
}