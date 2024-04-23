package com.example.todov1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.todov1app.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addNewButton.setOnClickListener(view -> {
            String name = binding.taskNameEditText.getText().toString();
            String desc = binding.taskDescEditText.getText().toString();
            TaskPriority priority;
            switch (binding.activityMainRadioGroupTaskPriority.getCheckedRadioButtonId()) {
                case R.id.activity_main_radio_button_medium_priority_task:
                    priority = TaskPriority.medium;
                    break;
                case R.id.activity_main_radio_button_high_priority_task:
                    priority = TaskPriority.high;
                    break;
                case R.id.activity_main_radio_button_low_priority_task:
                default:
                    priority = TaskPriority.low;
            }

            Task task = new Task(name, desc, priority);
            Intent i = new Intent();
            i.putExtra("taskAdded", task);
            setResult(RESULT_OK, i);
            AddTaskActivity.this.finish();
        });
    }
}