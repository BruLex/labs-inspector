package ua.blowball_soft.labsinspector.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.blowball_soft.labsinspector.R;
import ua.blowball_soft.labsinspector.dto.LabsInspDTO;

public class LabsInspListAdapter extends RecyclerView.Adapter<LabsInspListAdapter.LabsInspViewHolder> {

    private List <LabsInspDTO> data;

    public LabsInspListAdapter(List<LabsInspDTO> data) {
        this.data = data;
    }

    @Override
    public LabsInspViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent,false);
        return new LabsInspViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LabsInspViewHolder holder, int position) {
        LabsInspDTO item =data.get(position);
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class  LabsInspViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title;

        public LabsInspViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.subject_CardView);
            title = itemView.findViewById(R.id.subject_title_name);
        }
    }
}
