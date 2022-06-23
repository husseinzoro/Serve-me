package com.example.finalproject.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.finalproject.R;
import com.example.finalproject.databinding.ActivityMainBinding;
import com.example.finalproject.models.User;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        users.add(new User(binding.name1TV.getText().toString(),R.drawable.th10,"0113246574"));
        users.add(new User(binding.name2TV.getText().toString(),R.drawable.th11,"0128237383"));
        users.add(new User(binding.name3TV.getText().toString(),R.drawable.th12,"0112682383"));
        users.add(new User(binding.name4TV.getText().toString(),R.drawable.th13,"0112378563"));
        users.add(new User(binding.name5TV.getText().toString(),R.drawable.th14,"0123768946"));
        users.add(new User(binding.name6TV.getText().toString(),R.drawable.th15,"0112378463"));

        initListeners();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 30){
            if(resultCode == AppCompatActivity.RESULT_OK){
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void startScreen(User user){
        Intent i=new Intent(this, DetailsActivity.class);
        i.putExtra("user",user);
        startActivity(i);
    }

    void initListeners(){
        binding.user1IV.setOnClickListener(view -> {
            startScreen(users.get(0));
        });
        binding.user2IV.setOnClickListener(view -> {
            startScreen(users.get(1));

        });
        binding.user3IV.setOnClickListener(view -> {
            startScreen(users.get(2));

        });
        binding.user4IV.setOnClickListener(view -> {
            startScreen(users.get(3));

        });
        binding.user5IV.setOnClickListener(view -> {
            startScreen(users.get(4));

        });
        binding.user6IV.setOnClickListener(view -> {
            startScreen(users.get(5));

        });
        binding.requestButton.setOnClickListener(view ->{
            Intent intent = new Intent(this, RequestsActivity.class);
            startActivity(intent);
        });
    }

//    public void next(View view) {
//        Intent intent = new Intent(this, MainActivity2.class);
//        startActivity(intent);
//    }
//
//    public void next2(View view) {
//        Intent intent = new Intent(this, MainActivity3.class);
//        startActivity(intent);
//    }
//
//    public void next3(View view) {
//        Intent intent = new Intent(this, MainActivity4.class);
//        startActivity(intent);
//    }
//
//    public void next4(View view) {
//        Intent intent = new Intent(this, MainActivity5.class);
//        startActivity(intent);
//    }
//
//    public void next5(View view) {
//        Intent intent = new Intent(this, MainActivity6.class);
//        startActivity(intent);
//    }
//
//    public void next6(View view) {
//        Intent intent = new Intent(this, MainActivity7.class);
//        startActivity(intent);
//    }
//
//    public void next7(View view) {
//        Intent intent = new Intent(this, MainActivity8.class);
//        startActivity(intent);
//    }
//

//
//    public void next9(View view) {
//        Intent intent = new Intent(this, MainActivity9.class);
//        startActivity(intent);
//    }

}
