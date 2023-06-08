package com.jung.tthanguel.startTTHangeul;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jung.tthanguel.R;
import com.jung.tthanguel.databinding.FragmentSelectCountBinding;
import com.jung.tthanguel.objectDetect.DetectorActivity;
import com.jung.tthanguel.startTTHangeul.recycler.SelectCountAdapter;
import com.jung.tthanguel.startTTHangeul.recycler.SelectCountData;

import java.util.ArrayList;


// 물건 갯수 선택 bottomSheet
public class SelectCountFragment extends BottomSheetDialogFragment {
    Context context;
    String gameMode;
    //private FragmentSelectCountBinding binding; // viewBinding

    private RecyclerView mRecyclerView;
    private SelectCountAdapter mRecyclerAdapter;
    private ArrayList<SelectCountData> counts;

    public SelectCountFragment(Context context, String gameMode) {
        this.context = context;
        this.gameMode = gameMode;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_count,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_select_count);
        mRecyclerAdapter = new SelectCountAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 5));

        counts = new ArrayList<SelectCountData>();
        counts.add(new SelectCountData(1, true));
        for(int i = 2; i <= 10; i++){
            counts.add(new SelectCountData(i, false));
        }
        mRecyclerAdapter.setCountList(counts);

        Button startBtn = (Button) view.findViewById(R.id.btn_start_app);

        // 시작
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 객체 인식 페이지로 이동
                Intent intent = new Intent(requireActivity(), DetectorActivity.class);
                // 퀴즈 종류, 문제 갯수 넘겨주기
                intent.putExtra("game", gameMode);
                intent.putExtra("count", mRecyclerAdapter.getSelectCount());
                startActivity(intent);

                // bottomSheet 닫기
                dismiss();
            }
        });
    }
}