package com.example.autoservice.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoservice.R;
import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.viewModels.HomeViewModel;
import com.example.autoservice.mvvm.viewModels.ProfileViewModel;

import java.util.ArrayList;

public class DisplayCarWorkAdapter extends RecyclerView.Adapter<DisplayCarWorkAdapter.DisplayCarWorkViewHolder> {
    private ProfileViewModel viewModel;
    private ArrayList<Recording> recordingsList;
    Context context;

    public DisplayCarWorkAdapter(ArrayList<Recording> data, Context context, ProfileViewModel viewModel) {
        this.recordingsList = data;
        this.context = context;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public DisplayCarWorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.car_info_fragment, parent, false);

        return new DisplayCarWorkAdapter.DisplayCarWorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayCarWorkViewHolder holder, int position) {
        final Recording tempRecording = recordingsList.get(position);

        holder.carName.setText(tempRecording.getCar().getName());
        holder.carYear.setText(tempRecording.getCar().getYear());
        holder.carLicensePlate.setText(tempRecording.getCar().getLicensePlateNum());
        holder.doneWork.setText(tempRecording.getDoneWork());
    }

    @Override
    public int getItemCount() {
        return recordingsList.size();
    }

    public static class DisplayCarWorkViewHolder extends RecyclerView.ViewHolder {
        TextView carName, carYear, carLicensePlate, doneWork;

        public DisplayCarWorkViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_tile_name);
            carYear = itemView.findViewById(R.id.car_tile_year);
            carLicensePlate = itemView.findViewById(R.id.car_tile_license_plate);
            doneWork = itemView.findViewById(R.id.car_tile_work_done);
        }
    }
}
