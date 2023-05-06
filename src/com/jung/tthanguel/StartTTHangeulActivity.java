package com.jung.tthanguel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jung.tthanguel.R;
import com.jung.tthanguel.databinding.ActivityStartTthangeulBinding;

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

        // 시작하기 버튼 클릭
        binding.btnStartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "Click! ------------------------------");
                // 객체 인식 페이지로 이동
                Intent intent = new Intent(StartTTHangeulActivity.this, DetectorActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}