package com.example.sudungfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    StorageReference store;
    FirebaseStorage fireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");
        String userId = myRef.push().getKey();
        fireStore=FirebaseStorage.getInstance("gs://classicfirebase.appspot.com");
        store=fireStore.getReference();
        StorageReference store2=store.child("Image");

        Log.d("BBB",store.getPath());


// creating user object
        //  User user = new User("Phung Tuan Anh", "phungtuananhxy@gmail.com");

// pushing user to \'users\' node using the userId
        /*myRef.child(userId).setValue(user);*/

        //doc du lieu

        myRef.child("-LygJeDtxfFuJu_bdvwz").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Log.d("AAA", user.email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
