package es.victorde.infiniterecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Victor on 3/6/16.
 */
public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>{
    private List<Item> mItemList;
    private Context mContext;

    public AdapterRecyclerView(Context ctx, List<Item> items) {
        mContext = ctx;
        mItemList = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        position = position % mItemList.size();
        Item currentItem = mItemList.get(position);

        holder.mItemText.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
       // return mItemList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mItemText;

        public MyViewHolder(View itemView) {
            super(itemView);

            mItemText = (TextView) itemView.findViewById(R.id.item_text);
        }

    }
}
