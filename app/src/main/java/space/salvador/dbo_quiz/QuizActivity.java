package space.salvador.dbo_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;
    private TextView login2;
    private String login3 = "";
    private String selectedTopic = "";

    private AppCompatButton option1, option2, option3, option4;
    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int seconds = 0;
    private int totalTimeInMins = 10;

    private List<QuestionsList> questionsList;

    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.level);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        login2 = findViewById(R.id.login2);
        nextBtn = findViewById(R.id.nextBtn);

        //Начало. Приложение во весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Конец. Приложение во весь экран



        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopic);

        questionsList = QuestionsBank.qetQuestions(getSelectedTopic);

        selectedTopic = getIntent().getStringExtra("selectedTopic");

        //Начало. Получение логина с прошлой страницы
        final String getSelectedTopic2 = getIntent().getStringExtra("login3");
        login2.setText(getSelectedTopic2);
        login3 = getIntent().getStringExtra("login3");
        //Конец. Получение логина с прошлой страницы

        startTimer(timer);

        questions.setText((currentQuestionPosition+1)+"/"+questionsList.size());
        question.setText(questionsList.get(0).getQuastion());
        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());

        //Начало. Кнопка назад
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();
                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });
        //Конец. Кнопка назад

        //Начало. Код выбора ответа
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });
        //Конец. Код выбора ответа

        //Начало. Код кнопки следующий вопрос
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Пожалуйста сделайте выбор", Toast.LENGTH_SHORT).show();
                } else {
                    changeNextQuastion();
                }
            }
        });
        //Конец. Код кнопки следующий вопрос
    }

    //Начало. Код таймера и передачи логина на следующую страницу
    private void startTimer (TextView timerTextView) {
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0){
                    totalTimeInMins--;
                    seconds = 59;
                } else if (seconds ==0 && totalTimeInMins ==0) {
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(QuizActivity.this,"Время вышло",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                    intent.putExtra( "correct", getCorrectAnswers());
                    intent.putExtra("incorrect",getInCorrectAnswers());
                    intent.putExtra("login3", login3);
                    startActivity(intent);
                    finish();
                }
                else {
                    seconds --;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1) {
                            finalMinutes = "0"+finalMinutes;
                        }
                        if (finalSeconds.length() ==1) {
                            finalSeconds = "0"+finalSeconds;
                        }
                        timerTextView.setText(finalMinutes+ ":" + finalSeconds);
                    }
                });
            }
        },1000,1000);


    }
    //Конец. Код таймера и передачи логина на следующую страницу

    //Начало. Подсчет верных и неверных ответов
    private int getCorrectAnswers (){
        int correctAnswers = 0;
        for (int i = 0; i < questionsList.size() ;i++){
            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }
    private int getInCorrectAnswers (){

        int correctAnswers = 0;

        for (int i = 0; i < questionsList.size() ;i++){

            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }
    //Конец. Подсчет верных и неверных ответов

    //Начало. Код кнопки андроида назад
    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();
        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }
    //Начало. Код кнопки андроида назад

    //Начало. Код покраски верного ответа и передача данных на следующую страницу
    private void revealAnswer (){
        final String getAnswer = questionsList.get(currentQuestionPosition).getAnswer();
        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if  (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if  (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if (option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }

    private void changeNextQuastion () {
        currentQuestionPosition++;
        if ((currentQuestionPosition+1) == questionsList.size()) {
            nextBtn.setText("Готово");
        }
        if (currentQuestionPosition < questionsList.size()){
            selectedOptionByUser = "";
            option1.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsList.size());
            question.setText(questionsList.get(currentQuestionPosition).getQuastion());
            option1.setText(questionsList.get(currentQuestionPosition).getOption1());
            option2.setText(questionsList.get(currentQuestionPosition).getOption2());
            option3.setText(questionsList.get(currentQuestionPosition).getOption3());
            option4.setText(questionsList.get(currentQuestionPosition).getOption4());
        }
        else {
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect",getInCorrectAnswers());
            intent.putExtra("sele", selectedTopic);
            intent.putExtra("login3", login3);
            startActivity(intent);
            finish();
        }
    }
    //Начало. Код покраски верного ответа и передача данных на следующую страницу
}