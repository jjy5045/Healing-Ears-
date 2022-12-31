package com.project.healingEars.activity.ui.station;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.databinding.FragmentStationBinding;
import com.example.app.databinding.FragmentStationInfoBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;


public class StationInfoFragment extends Fragment {

    FragmentStationInfoBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);
        StationViewModel stationViewModel = new ViewModelProvider(this).get(StationViewModel.class);

        binding = FragmentStationInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 스테이션 번호를 받아옴
        int stnId = StationInfoFragmentArgs.fromBundle(getArguments()).getStnId();

        stationViewModel.getProDetailByStnId(stnId);

        // 전달값 확인완료 ! Layout 짜면됌, 레이아웃 리스트 뷰로

        Toast.makeText(requireContext(), stnId +"\n" +" 앙", Toast.LENGTH_SHORT).show();
        //Toast.makeText(requireContext(), stnId +"\n" +" 앙", Toast.LENGTH_LONG).show();




        return root;
    }
}