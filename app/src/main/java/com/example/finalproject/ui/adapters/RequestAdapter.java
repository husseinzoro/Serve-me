package com.example.finalproject.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.finalproject.R;
import com.example.finalproject.models.User;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {

    ArrayList<User> data = new ArrayList<>();

    public RequestAdapter(ArrayList<User> data, RequestCallback callback) {
        this.data = data;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_request, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        holder.bind(this.data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    RequestCallback callback;
    public interface RequestCallback {
        void onClick(User user);
    }

    class RequestViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV ;
        ConstraintLayout root;

        public RequestViewHolder(View view){
            super(view);
            nameTV = view.findViewById(R.id.name_item_textView);
            root= view.findViewById(R.id.content);
        }

        public void bind(User user){
            nameTV.setText(user.getName());
            root.setOnClickListener(view ->{
                callback.onClick(user);
            });
        }
    }
}
