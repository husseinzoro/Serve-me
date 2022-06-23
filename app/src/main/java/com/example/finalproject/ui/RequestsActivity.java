package com.example.finalproject.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.databinding.ActivityDetailsBinding;
import com.example.finalproject.databinding.ActivityRequestsBinding;
import com.example.finalproject.models.User;
import com.example.finalproject.ui.adapters.RequestAdapter;
import java.util.ArrayList;
import com.google.firebase.database.*;


public class RequestsActivity extends AppCompatActivity implements RequestAdapter.RequestCallback {
    private ActivityRequestsBinding binding;

    private RequestAdapter adapter;
    private ArrayList<User> list = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequestsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        adapter = new RequestAdapter(list, this);


        listenForNode();


        binding.listRV.setLayoutManager(new LinearLayoutManager(this));
        binding.listRV.setAdapter(adapter);
    }

    void listenForNode(){
        FirebaseDatabase.getInstance().getReference("myApp").child("booking").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fetchData(snapshot);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RequestsActivity.this, "Error " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        list.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            User user=ds.getValue(User.class);
            list.add(user);
        }
    }
    @Override
    public void onClick(User user) {
        Toast.makeText(this, "Item is clicked", Toast.LENGTH_SHORT).show();
    }
}