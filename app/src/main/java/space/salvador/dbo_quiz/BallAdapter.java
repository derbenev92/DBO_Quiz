package space.salvador.dbo_quiz;

import android.content.ClipData;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import space.salvador.dbo_quiz.Models.Ball;

public class BallAdapter extends RecyclerView.Adapter<BallAdapter.BallViewHolder> {

    private List<Ball> list;

    public BallAdapter(List<Ball> list) {this.list = list;}

    @Override
    public BallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BallViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_view_item, parent, false));

    }
    //Начало. Выведение логина и верных ответов
    @Override
    public void onBindViewHolder(@NonNull BallViewHolder holder, int position) {

        Ball user = list.get(position);

        int pos = position + 1;
        String login = pos + " - " + user.login;

        holder.login.setText(login);
        //holder.level.setText(user.level); --убрал выведение название уровня
        holder.correct.setText(user.correct);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class BallViewHolder extends RecyclerView.ViewHolder {

        TextView login, level, correct;

        public BallViewHolder (View itemView){
            super(itemView);

            login = itemView.findViewById(R.id.login);
            //level = itemView.findViewById(R.id.level); --убрал выведение название уровня
            correct = itemView.findViewById(R.id.correct);


        }
    }
    //Конец. Выведение логина и верных ответов

    //Добавил Неко начало
    public void updateAdapter(List<Ball> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    //Добавил Неко конец
}
