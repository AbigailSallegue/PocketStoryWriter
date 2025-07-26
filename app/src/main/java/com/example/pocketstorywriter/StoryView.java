package com.example.pocketstorywriter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoryView extends AppCompatActivity {

    // UI components
    private TextView tvTitle, tvCharacters, tvWorldSetting, tvStoryContent;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story_view);

        // Apply system window insets for immersive experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        tvTitle = findViewById(R.id.textView);
        tvCharacters = findViewById(R.id.textView2);
        tvWorldSetting = findViewById(R.id.textView3);
        tvStoryContent = findViewById(R.id.textView4);
        btnReturn = findViewById(R.id.button7);

        // Return button functionality
        btnReturn.setOnClickListener(v -> finish());

        // Placeholder: You can replace this with real story data passed via Intent
        tvTitle.setText("The Last Ember");
        tvCharacters.setText("Ember, Orion, Selene");
        tvWorldSetting.setText("Post-apocalyptic floating archipelago");
        tvStoryContent.setText("In a world scorched by firestorms, Ember discovers ancient tech that could reignite hope or plunge humanity into silence…");
    }
}