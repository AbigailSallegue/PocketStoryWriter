package com.example.pocketstorywriter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewStoriesMenu extends AppCompatActivity {

    // UI components
    private Button btnReturn;
    private ListView listViewStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_stories_menu);

        // Apply system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.view_stories_menu), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        btnReturn = findViewById(R.id.button6);
        listViewStories = findViewById(R.id.listViewStories);

        // Return to previous screen
        btnReturn.setOnClickListener(v -> finish());

        // Placeholder: display sample story toast on item click
        listViewStories.setOnItemClickListener((parent, view, position, id) -> {
            String selectedStory = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, "Selected: " + selectedStory, Toast.LENGTH_SHORT).show();
        });

        // You can load stories into the list with a custom adapter here
    }
}