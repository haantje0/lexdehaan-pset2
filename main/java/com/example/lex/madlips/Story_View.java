package com.example.lex.madlips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Story_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story__view);

        Intent intent = getIntent();
        String Story = intent.getStringExtra("story");

        TextView story_view = (TextView) findViewById(R.id.story_view);
        story_view.setText(Story);
    }
}
