package com.jung.tthanguel.game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jung.tthanguel.databinding.ActivityLankingBinding;

public class LankingActivity extends AppCompatActivity {
    private ActivityLankingBinding binding; // viewBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // viewBinding
        binding = ActivityLankingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSkipQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}