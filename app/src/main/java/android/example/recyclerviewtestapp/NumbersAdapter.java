package android.example.recyclerviewtestapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NumbersAdapter extends  RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>{

    private static int viewHolderCount;
    private int numberItems;
    private Context parent;

    public NumbersAdapter(int numberOfItems, Context parent) {
        numberItems = numberOfItems;
        viewHolderCount = 0;

        this.parent = parent;
    }
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.viewHolderIndex.setText("ViewHolder index " + viewHolderCount);

        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;
        TextView viewHolderIndex;
        public NumberViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.tv_number_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int positionIndex = getAbsoluteAdapterPosition();

                    Toast toast = Toast.makeText(parent, "Element " + positionIndex
                    + " was clicked!", Toast.LENGTH_SHORT);

                    toast.show();
                }
            });
        }
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
