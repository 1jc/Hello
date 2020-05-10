package com.example.hello;

import android.annotation.SuppressLint;
//import android.view.Menu;
import android.os.Bundle;
//import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.hello.R;
import android.widget.Button;
import android.widget.Toast;


@SuppressLint("Registered")
public class RegisterActivity extends AppCompatActivity {

    Button btn_submit, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);
       // btn_submit = (Button) findViewById(R.id.btn_submit);
       // btn_back = (Button) findViewById(R.id.btn_back);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thanks for Signing Up [username]", Toast.LENGTH_LONG).show();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Another Account", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}






