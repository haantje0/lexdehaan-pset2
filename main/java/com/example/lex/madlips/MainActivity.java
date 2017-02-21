package com.example.lex.madlips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
    }

    public void GoToWords(View view){
        if (option == 0){
            Toast.makeText(this, "Chose your story!", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, words.class);
            intent.putExtra("option", option);
            startActivity(intent);
        }
    }

    public void RadioClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.option_simple:
                if (checked)
                    option = 1;
                    break;
            case R.id.option_tarzan:
                if (checked)
                    option = 2;
                    break;
            case R.id.option_university:
                if (checked)
                    option = 3;
                    break;
            case R.id.option_clothes:
                if (checked)
                    option = 4;
                    break;
            case R.id.option_dance:
                if (checked)
                    option = 5;
                    break;
        }
    }
}
