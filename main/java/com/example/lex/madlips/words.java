package com.example.lex.madlips;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;


public class words extends AppCompatActivity {

    Story myStory;

    int option = 0;

    int popup = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        Intent intent = getIntent();
        option = intent.getIntExtra("option", 0);

        InputStream resources = getResources().openRawResource(R.raw.madlib0_simple);
        switch (option){
            case 1:
                resources = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case 2:
                resources = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case 3:
                resources = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case 4:
                resources = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case 5:
                resources = getResources().openRawResource(R.raw.madlib4_dance);
                break;
        }
        myStory = new Story(resources);

        TextView suggestion = (TextView) findViewById(R.id.suggestion);
        suggestion.setText("fill in a(n) " + myStory.getNextPlaceholder());

        TextView words_left = (TextView) findViewById(R.id.words_left);
        words_left.setText("there are " + myStory.getPlaceholderRemainingCount() + " word(s) left");
    }

    public void NextWord(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String word = editText.getText().toString();

        if (myStory.getPlaceholderRemainingCount() == 1) {

            if (word.matches(".*[a-z].*")) {
                myStory.fillInPlaceholder(word);

                Intent intent = new Intent(this, Story_View.class);
                intent.putExtra("story", myStory.toString());
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "fill in a word!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            if (word.matches(".*[a-z].*")) {
                myStory.fillInPlaceholder(word);

                editText.setText("");

                TextView suggestion = (TextView) findViewById(R.id.suggestion);
                suggestion.setText("fill in a(n) " + myStory.getNextPlaceholder());

                TextView words_left = (TextView) findViewById(R.id.words_left);
                words_left.setText("there are " + myStory.getPlaceholderRemainingCount() + " word(s) left");

                switch (popup) {
                    case 0: {
                        Toast.makeText(this, "Great!", Toast.LENGTH_SHORT).show();
                        popup++;
                        break;
                    }
                    case 1: {
                        Toast.makeText(this, "Next word!", Toast.LENGTH_SHORT).show();
                        popup++;
                        break;
                    }
                    case 2: {
                        Toast.makeText(this, "Just " + myStory.getPlaceholderRemainingCount() + " more words!", Toast.LENGTH_SHORT).show();
                        popup = 0;
                        break;
                    }
                }
            }
            else {
                Toast.makeText(this, "fill in a word!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
