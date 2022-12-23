package space.salvador.dbo_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import space.salvador.dbo_quiz.Models.Ball;


public class RatingActivity extends AppCompatActivity {
    private int myBalls = 0;
    private RecyclerView recyclerView;
    private List<Ball> result;
    private BallAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_layout);
        //Начало. Приложение во весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Конец. Приложение во весь экран
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Ball");

        result = new ArrayList<>();

        recyclerView = findViewById(R.id.user_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        adapter = new BallAdapter(result);
        recyclerView.setAdapter(adapter);

        updateList();

    }
    //Начало. Код инфы рейтинга Неко
    private void updateList(){
        List<Ball> list = new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot sd : snapshot.getChildren()){
                    Ball ball = sd.getValue(Ball.class);
                    if(ball != null) list.add(ball);
                }

                List<Ball> listBalls = new ArrayList<>();
                for(Ball ball : list){
                    if(listBalls.isEmpty()){
                        listBalls.add(ball);
                    } else {
                        boolean isSame = false;
                        int index = 0;
                        for(int j = 0; j < listBalls.size(); j++){
                            isSame = listBalls.get(j).login.equals(ball.login);
                            if(isSame){
                                index = j;
                                break;
                            }
                        }
                        if(!isSame){
                            listBalls.add(ball);
                        } else {
                            String count = String.valueOf((Integer.parseInt(
                                    listBalls.get(index).correct) + Integer.parseInt(ball.correct)));
                            listBalls.set(index, new Ball(
                                    ball.id,
                                    count,
                                    ball.incorrect,
                                    ball.login,
                                    ball.level
                            ));
                        }
                    }
                }
                Collections.sort(listBalls, new Comparator<Ball>() {
                    @Override
                    public int compare(Ball bl, Ball br) {
                        return Integer.parseInt(bl.getCorrect()) - Integer.parseInt(br.getCorrect());
                    }
                });

                // listBalls.sort(Comparator.comparing(o -> o.correct));
                Collections.reverse(listBalls);
                adapter.updateAdapter(listBalls);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    //Конец. Код инфы рейтинга Неко

    //Начало. Код кнопки назад
    public void onClickbackbtn (View view)
    {
        startActivity(new Intent(RatingActivity.this, Login.class));
        finish();
    }
    //Конец. Код кнопки назад
}
