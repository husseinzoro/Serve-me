package com.example.finalproject.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.MainActivity10;
import com.example.finalproject.MainActivity12;
import com.example.finalproject.databinding.ActivityDetailsBinding;
import com.example.finalproject.models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsActivity extends AppCompatActivity {


    User user = new User();
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = (User) getIntent().getSerializableExtra("user") ;

        if(user == null){
            Toast.makeText(this, "Error: user is nil", Toast.LENGTH_SHORT).show();
            setResult(AppCompatActivity.RESULT_CANCELED);
            finish();
        }

        binding.nameTV.setText(user.getName());
        binding.imageView.setImageResource(user.getUrl());
        binding.imageView14.setOnClickListener(view -> {
            Intent intent= new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+user.getPhone()));
            startActivity(intent);
        });

        binding.bookNowButton.setOnClickListener(view ->{

            FirebaseDatabase.getInstance().getReference("myApp").child("booking").push().setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(DetailsActivity.this, "success", Toast.LENGTH_SHORT).show();
                  // setResult(AppCompatActivity.RESULT_OK);
                    //finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(DetailsActivity.this, e.getMessage() +" " + e.getCause(), Toast.LENGTH_SHORT).show();

                }
            });
        });

    }


    public void next11(View view) {
        Intent intent = new Intent(this, MainActivity10.class);
        startActivity(intent);
    }

    public void next9(View view) {
        Intent intent = new Intent(this, RequestsActivity.class);
        startActivity(intent);
    }


    public void next8(View view) {
        Intent intent = new Intent(this, RequestsActivity.class);
        startActivity(intent);
    }

    public void next12(View view) {
        Intent intent = new Intent(this, MainActivity12.class);
        startActivity(intent);
    }

    public void onBookNow(View view) {


    }
}