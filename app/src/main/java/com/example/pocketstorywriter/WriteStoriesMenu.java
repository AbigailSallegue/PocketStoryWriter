package com.example.pocketstorywriter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WriteStoriesMenu extends AppCompatActivity {

    private EditText etTitle, etCharacters, etWorldSetting, etStoryContent;
    private Button btnSave, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_write_stories_menu);

        // Apply system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.write_stories_menu), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        etTitle = findViewById(R.id.etTitle);
        etCharacters = findViewById(R.id.etCharacters);
        etWorldSetting = findViewById(R.id.etWorldSetting);
        etStoryContent = findViewById(R.id.etStoryContent);
        btnSave = findViewById(R.id.btnSave);
        btnReturn = findViewById(R.id.btnReturn);

        // Save button logic
        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString();
            String content = etStoryContent.getText().toString();

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please complete title and content.", Toast.LENGTH_SHORT).show();
            } else {
                // You could save to a database here
                Toast.makeText(this, "Story saved: " + title, Toast.LENGTH_SHORT).show();
            }
        });

        // Return button logic
        btnReturn.setOnClickListener(v -> {
            Intent intent = new Intent(WriteStoriesMenu.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}