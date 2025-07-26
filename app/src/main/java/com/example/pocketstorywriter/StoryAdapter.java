package com.example.pocketstorywriter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class StoryAdapter extends ArrayAdapter<Story> {

    private Context context;
    private List<Story> stories;

    public StoryAdapter(Context context, List<Story> stories) {
        super(context, R.layout.story_item, stories);
        this.context = context;
        this.stories = stories;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Story story = stories.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.story_item, parent, false);
        }

        TextView titleView = convertView.findViewById(R.id.storyTitle);
        TextView previewView = convertView.findViewById(R.id.storyPreview);

        titleView.setText(story.title);
        previewView.setText(story.preview);

        return convertView;
    }
}