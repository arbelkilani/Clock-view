package edu.arbelkilani.eduarbelkilaniclock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arbelkilani.clock.model.StopwatchSavedItem;

import java.util.List;

public class StopWatchAdapter extends RecyclerView.Adapter<StopWatchHolder> {

    List<StopwatchSavedItem> savedItemList;

    public StopWatchAdapter(List<StopwatchSavedItem> savedItemList) {
        this.savedItemList = savedItemList;
    }

    @NonNull
    @Override
    public StopWatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_stopwatch, parent, false);
        return new StopWatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StopWatchHolder holder, int position) {
        StopwatchSavedItem stopwatchSavedItem = savedItemList.get(position);
        holder.populate(stopwatchSavedItem);
    }

    @Override
    public int getItemCount() {
        return savedItemList.size();
    }
}
