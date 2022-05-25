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

import java.util.ArrayList;

public class DisplayRecordingsAdapter extends RecyclerView.Adapter<DisplayRecordingsAdapter.DisplayRecordingsViewHolder> {
    private HomeViewModel viewModel;
    private ArrayList<Recording> recordingsList;
    Context context;

    public DisplayRecordingsAdapter(ArrayList<Recording> data, Context context, HomeViewModel viewModel) {
        this.recordingsList = data;
        this.context = context;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public DisplayRecordingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recording_fragment, parent, false);

        return new DisplayRecordingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayRecordingsViewHolder holder, int position) {
        final Recording tempRecording = recordingsList.get(position);

        holder.carName.setText(tempRecording.getCar().getName());
        holder.status.setText(tempRecording.getStatus().toString());
        holder.description.setText(tempRecording.getReason());
    }

    @Override
    public int getItemCount() {
        return recordingsList.size();
    }


    public static class DisplayRecordingsViewHolder extends RecyclerView.ViewHolder {
        TextView carName, status, description;

        public DisplayRecordingsViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_tile_name);
            status = itemView.findViewById(R.id.car_tile_year);
            description = itemView.findViewById(R.id.recording_tile_reason);
        }
    }
}
