package ua.blowball_soft.labsinspector.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ua.blowball_soft.labsinspector.R;
import ua.blowball_soft.labsinspector.dto.LabsInspDTO;

public class LabsInspListAdapter extends RecyclerView.Adapter<LabsInspListAdapter.LabsInspViewHolder> {

    private List <LabsInspDTO> data;
    private Context mContext;
    public LabsInspListAdapter(List<LabsInspDTO> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public LabsInspViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent,false);
        return new LabsInspViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LabsInspViewHolder holder, final int position) {
        final LabsInspDTO item =data.get(position);
        holder.title.setText(item.getTitle());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display option menu
                PopupMenu popupMenu = new PopupMenu(mContext, holder.imageButton);
                popupMenu.inflate(R.menu.option_subject_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuitem) {

                        switch (menuitem.getItemId()) {
                            case R.id.menu_item_edit:
                                Toast.makeText(mContext, "Edit", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.menu_item_delete:
                                //Delete item
                                data.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(mContext, "Deleted", Toast.LENGTH_LONG).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class  LabsInspViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title;
        ImageButton imageButton;
        public LabsInspViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.subject_CardView);
            title = itemView.findViewById(R.id.subject_title_name);
            imageButton =itemView.findViewById(R.id.txtOptionDigit);
        }
    }
}
