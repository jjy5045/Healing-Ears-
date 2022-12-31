package com.project.healingEars.activity.ui.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.project.healingEars.activity.ui.station.StationAdapter;
import com.project.healingEars.activity.ui.station.StationFragmentDirections;
import com.project.healingEars.http.vo.StationListVO;

import java.util.ArrayList;
import java.util.List;

public class StationAdminAdapter extends RecyclerView.Adapter<StationAdminAdapter.ViewHolder> {
    private static final String TAG = "StationAdminAdapter";

    private static List<StationListVO> LstationListVO = new ArrayList<>();

    Context context;

    public StationAdminAdapter(List<StationListVO> stationListVO) {
        this.LstationListVO = stationListVO;
    }

    //VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);



    @NonNull
    @Override
    public StationAdminAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);
        StationAdminAdapter.ViewHolder holder = new StationAdminAdapter.ViewHolder(itemView);;
        context = parent.getContext();

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StationAdminAdapter.ViewHolder holder, int position) {
        ///holder.bindItem(stationListVO.get(position));
        holder.item_name.setText(LstationListVO.get(position).stnName.toString());
        holder.item_location.setText((LstationListVO.get(position).stnSido.toString()));

    }

    public int getItemCount() {
        //return stationListVO.size();
        return (null != LstationListVO ? LstationListVO.size() : 0);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //ItemStationBinding binding;
        protected TextView item_name;
        protected TextView item_location;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_name = (TextView) itemView.findViewById(R.id.item_name);
            this.item_location = (TextView) itemView.findViewById((R.id.item_location));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 현재 클릭된 아이템의 상태를 가져욤
                    int currentPos = getAdapterPosition();
                    // 해당 아이템의 정보를 VO 객체에 담음
                    StationListVO stationListVO = LstationListVO.get(currentPos);

                    // navigation 시 변수 전달을 위해 준비
                    StationFragmentDirections.ActionNavStationToNavStationInfo action = StationFragmentDirections.actionNavStationToNavStationInfo();
                    // 이동시에 현재 클릭된 스테이션의 아이디를 값을 넘김
                    action.setStnId(stationListVO.stnId);
                    // 변수값과 함께 navigation action 실행
                    Navigation.findNavController(view).navigate(action);

                    // 변수값 전달 없이 이동
                    // Navigation.findNavController(view).navigate(R.id.action_nav_station_to_nav_station_info);

                    //Toast.makeText(view.getContext(), stationListVO.stnId +"\n" + stationListVO.stnName +" 앙", Toast.LENGTH_LONG).show();
                }
            });
            /*
            binding = ItemStationBinding.bind(itemView);
            //binding.setLifecycleOwner(this);
            binding.setVmShareModel(binding.getVmShareModel());
             */

        }

        public void bindItem(StationListVO stationListVO) {
            //binding.setVmShareModel(VmShareViewModel);

        }
    }
}
