package space.salvador.dbo_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private String selectedTopic = "";
    private TextView login2;
    private String login3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Начало. Приложение во весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Конец. Приложение во весь экран

        final ImageView backBtn05 = findViewById(R.id.backBtn05);
        final TextView login2 = findViewById(R.id.login2);

        final LinearLayout line_1 = findViewById(R.id.line_1);
        final LinearLayout line_2 = findViewById(R.id.line_2);
        final LinearLayout line_3 = findViewById(R.id.line_3);
        final LinearLayout line_4 = findViewById(R.id.line_4);
        final LinearLayout line_5 = findViewById(R.id.line_5);

        final Button startQuizBtn = findViewById(R.id.startQuizBtn);

        //Начало. Получение логина с прошлой страницы
        final String getlogin2 = getIntent().getStringExtra("login2");
        login2.setText(getlogin2);
        login3 = getIntent().getStringExtra("login2");
        //Конец. Получение логина с прошлой страницы

        //Начало. Код для выбора уровня
        line_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "НОВИЧОК";
                line_1.setBackgroundResource(R.drawable.round_back_white_stroke10);

                line_2.setBackgroundResource(R.drawable.raund_back_white10);
                line_3.setBackgroundResource(R.drawable.raund_back_white10);
                line_4.setBackgroundResource(R.drawable.raund_back_white10);
                line_5.setBackgroundResource(R.drawable.raund_back_white10);

            }
        });

        line_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "СПЕЦИАЛИСТ";
                line_2.setBackgroundResource(R.drawable.round_back_white_stroke10);

                line_1.setBackgroundResource(R.drawable.raund_back_white10);
                line_3.setBackgroundResource(R.drawable.raund_back_white10);
                line_4.setBackgroundResource(R.drawable.raund_back_white10);
                line_5.setBackgroundResource(R.drawable.raund_back_white10);
            }
        });

        line_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "В.СПЕЦИАЛИСТ";
                line_3.setBackgroundResource(R.drawable.round_back_white_stroke10);

                line_2.setBackgroundResource(R.drawable.raund_back_white10);
                line_1.setBackgroundResource(R.drawable.raund_back_white10);
                line_4.setBackgroundResource(R.drawable.raund_back_white10);
                line_5.setBackgroundResource(R.drawable.raund_back_white10);
            }
        });

        line_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "Г.СПЕЦИАЛИСТ";
                line_4.setBackgroundResource(R.drawable.round_back_white_stroke10);

                line_2.setBackgroundResource(R.drawable.raund_back_white10);
                line_3.setBackgroundResource(R.drawable.raund_back_white10);
                line_1.setBackgroundResource(R.drawable.raund_back_white10);
                line_5.setBackgroundResource(R.drawable.raund_back_white10);
            }
        });

        line_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "ДЕЖУРНЫЙ";
                line_5.setBackgroundResource(R.drawable.round_back_white_stroke10);

                line_2.setBackgroundResource(R.drawable.raund_back_white10);
                line_3.setBackgroundResource(R.drawable.raund_back_white10);
                line_1.setBackgroundResource(R.drawable.raund_back_white10);
                line_4.setBackgroundResource(R.drawable.raund_back_white10);
            }
        });
        //Конец. Код для выбора уровня

        //Начало. Код кнопки назад
        backBtn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });
        //Конец. Код кнопки назад

        //Начало. Код кнопки начать и отправки логина на следующую страницу
        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Выберите викторину", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    intent.putExtra("login3", login3);
                    startActivity(intent);
                    finish();
                }
            }
        });
        //Конец. Код кнопки начать и отправки логина на следующую страницу
    }

    //Начало. Код кнопки андроида назад
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this, Login.class));
        finish();
    }
    //Конец. Код кнопки андроида назад
}