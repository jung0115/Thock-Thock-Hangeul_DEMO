package com.jung.tthanguel.startTTHangeul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jung.tthanguel.databinding.ActivityStartTthangeulBinding;
import com.jung.tthanguel.objectDetect.DetectorActivity;

// 앱 접속 시 첫 화면
public class StartTTHangeulActivity extends AppCompatActivity {
    private ActivityStartTthangeulBinding binding; // viewBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_start_tthangeul);

        // viewBinding
        binding = ActivityStartTthangeulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 나의 이름은 - 이름 퀴즈
        binding.btnGameName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SelectCountFragment bottomSheet = new SelectCountFragment(getApplicationContext(), "name");
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });

        // 내가 누굴까? - 특징 퀴즈
        binding.btnGameCharic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SelectCountFragment bottomSheet = new SelectCountFragment(getApplicationContext(), "charic");
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });

        // 랜덤 퀴즈
        binding.btnGameRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SelectCountFragment bottomSheet = new SelectCountFragment(getApplicationContext(), "random");
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });

        // 준비 중
        binding.btnGameClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "더 많은 게임을 준비 중이에요!",Toast.LENGTH_LONG).show();
            }
        });
    }
}