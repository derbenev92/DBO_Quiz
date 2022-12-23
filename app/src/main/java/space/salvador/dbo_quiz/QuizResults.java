package space.salvador.dbo_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import space.salvador.dbo_quiz.Models.Ball;

public class QuizResults extends AppCompatActivity {
    private TextView correctAnswears, incorrectAnswears, level, login4;
    private DatabaseReference mDataBase;
    private String Ball_KEY = "Ball";
    private List<QuestionsList> questionsList;
    private String selectedTopic = "";
    private FirebaseAuth mAuth;
    private String login5;
    private String level5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        init();

        //Начало. Приложение во весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Конец. Приложение во весь экран

        final AppCompatButton startNewQuiz = findViewById(R.id.startNewQuizBtn);
        final TextView correctAnswears = findViewById(R.id.correctAnswears);
        final TextView incorrectAnswears = findViewById(R.id.incorrectAnswears);
        final TextView level = findViewById(R.id.level);
        final TextView login = findViewById(R.id.login);

        //Начало. Получение логина с прошлой страницы
        final String getSelectedTopic2 = getIntent().getStringExtra("login3");
        login.setText(String.valueOf(getSelectedTopic2));
        login5 = getIntent().getStringExtra("login3");
        //Конец. Получение логина с прошлой страницы

        //Начало. Получение названия уровня с прошлой страницы
        String getSelectedTopic = getIntent().getStringExtra("sele");
        level.setText(String.valueOf("Уровень: " + getSelectedTopic));
        questionsList = QuestionsBank.qetQuestions(getSelectedTopic);
        level5 = getIntent().getStringExtra("sele");
        //Конец. Получение названия уровня с прошлой страницы

        //Начало. Получение верных и неверных ответов
        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getInCorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        correctAnswears.setText(String.valueOf("" + getCorrectAnswers) );
        incorrectAnswears.setText(String.valueOf("" + getInCorrectAnswers));
        //Конец. Получение верных и неверных ответов

        //Начало. Код кнопки начать новую викторину и передача результата в БД
        startNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this, Login.class));
                String id = mDataBase.getKey();
                String correct = correctAnswears.getText().toString();
                String incorrect = incorrectAnswears.getText().toString();
                String login = login5.toString();
                String level = level5.toString();
                Ball newBall = new Ball (id, correct, incorrect, login, level);
                mDataBase.push().setValue(newBall);
                finish();
            }
        });
        //Конец. Код кнопки начать новую викторину и передача результата в БД
    }

    public void init (){
        correctAnswears = findViewById(R.id.correctAnswears);
        incorrectAnswears = findViewById(R.id.incorrectAnswears);
        mDataBase = FirebaseDatabase.getInstance().getReference(Ball_KEY);
    }

    //Начало. Код кнопки андроида назад
    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this, MainActivity.class));
        finish();
    }
    //Конец. Код кнопки андроида назад
}