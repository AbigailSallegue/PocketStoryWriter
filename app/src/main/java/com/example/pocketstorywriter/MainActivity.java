package com.example.pocketstorywriter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // UI Components
    private TextView tvAppTitle;
    private Button btnNewStory;
    private Button btnViewStories;
    private Button btnShareStories;
    private ImageView imgBookStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply system bar padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        tvAppTitle = findViewById(R.id.tvAppTitle);
        btnNewStory = findViewById(R.id.write_stories_menu);
        btnViewStories = findViewById(R.id.view_stories_menu);
        btnShareStories = findViewById(R.id.btnShareStories);
        imgBookStack = findViewById(R.id.imgBookStack);

        // Start WriteStoriesMenu activity
        btnNewStory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WriteStoriesMenu.class);
            startActivity(intent);
        });

        // Start ViewStoriesMenu activity
        btnViewStories.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewStoriesMenu.class);
            startActivity(intent);
        });

        // Optional: Handle sharing logic or navigation
        btnShareStories.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Check out my story on Pocket Story Writer!");
            startActivity(Intent.createChooser(intent, "Share via"));
        });
    }
}