package sample.xiangkai.com.materialdesignsamples.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import sample.xiangkai.com.materialdesignsamples.R;

/**
 * Created by xiangkai on 2016/11/15.
 */

public class MainAdapter extends RecyclerView.Adapter {
    String[] labels = {"Tab", "Tab", "FAB", "EB", "ABL"};
    String[] titles = {"TabLayout 顶部标签页", "TabLayout 底部菜单页",
            "FAB + Drawer", "ExtendBehavior", "AppBarLayout"};
    private OnItemClickListener onItemClickListener;
    private Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //第二个参数不能为null，原因尚不知
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvLabel.setText(labels[position]);
        viewHolder.tvTitle.setText(titles[position]);
        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(viewHolder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_label)
        TextView tvLabel;
        @Bind(R.id.tv_title)
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}