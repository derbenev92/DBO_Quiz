package space.salvador.dbo_quiz;

import static com.google.android.material.internal.ViewUtils.hideKeyboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText edLogin, edPassword;
    private FirebaseAuth mAuth;
    private Button bGO, bSignUp, bSignIn, bSignOut, bExit, bRating;
    private ImageView mainimgboy;
    private TextView tvUser;
    private String login2 = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Начало. Приложение во весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //Конец. Приложение во весь экран
        init();
    }
    //Начало. Логин в правом верхнем углу
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if (cUser != null)
        {
            showSigned();
            String username = "Привет, " + cUser.getEmail();
            tvUser.setText(username);
            login2 = cUser.getEmail();
        }
        else
        {
            notshowSigned();
        }
    }
    //Конец. Логин в правом верхнем углу
    private void init()
    {
        mainimgboy = findViewById(R.id.mainimgboy);
        bRating = findViewById(R.id.bRating);
        bExit = findViewById(R.id.bExit);
        bSignOut = findViewById(R.id.bRating);
        tvUser = findViewById(R.id.tvUser);
        bGO = findViewById(R.id.bGO);
        bSignUp = findViewById(R.id.bSignUp);
        bSignIn = findViewById(R.id.bSignIn);
        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);
        mAuth = FirebaseAuth.getInstance();

    }
    //Начало. Код регистрации
    public void onClickSignUp (View view)
    {
        if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString()))
        {
            mAuth.createUserWithEmailAndPassword(edLogin.getText().toString(), edPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            FirebaseUser cUser = mAuth.getCurrentUser();
                            closeKeyboard();
                            if (edPassword.getText().toString().length()<6) {
                                Toast.makeText(getApplicationContext(),"Введите пароль, который более 5 символов!",Toast.LENGTH_SHORT).show();
                            }
                            else

                            if (task.isSuccessful())
                            {
                                showSigned();
                                String username = "Привет, " + cUser.getEmail();
                                tvUser.setText(username);
                                Toast.makeText(getApplicationContext(),"Пользователь успешно зарегистрирован!",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                notshowSigned();
                                Toast.makeText(getApplicationContext(),"Ошибка регистрации!",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

        }

        else
        {

            Toast.makeText(this,"Введите электронную почту и пароль!", Toast.LENGTH_SHORT).show();
        }

    }
    //Конец. Код регистрации

    //Начало. Код авторицаии
    public void onClickSignIn (View view)
    {
        if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString()))
        {
            mAuth.signInWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    FirebaseUser cUser = mAuth.getCurrentUser();
                    closeKeyboard();
                    if (task.isSuccessful())
                    {
                        showSigned();
                        String username = "Привет, " + cUser.getEmail();
                        tvUser.setText(username);
                        Toast.makeText(getApplicationContext(),"Пользователь успешно вошёл!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        notshowSigned();
                        Toast.makeText(getApplicationContext(),"Ошибка входа!",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    //Конец. Код авторицаии

    //Начало. Код выхода
    public void onClickSignOut (View view)
    {
        FirebaseAuth.getInstance().signOut();
        notshowSigned();
    }
    //Конец. Код выхода

    //Начало. Код скрыть/показать
    private void showSigned()
    {
        bGO.setVisibility(View.VISIBLE);
        tvUser.setVisibility(View.VISIBLE);
        bSignOut.setVisibility(View.VISIBLE);
        edLogin.setVisibility(View.GONE);
        edPassword.setVisibility(View.GONE);
        bSignUp.setVisibility(View.GONE);
        bSignIn.setVisibility(View.GONE);
        bSignOut.setVisibility(View.VISIBLE);
        bExit.setVisibility(View.VISIBLE);
        mainimgboy.setVisibility(View.VISIBLE);
    }
    private void notshowSigned()
    {
        bGO.setVisibility(View.GONE);
        tvUser.setVisibility(View.GONE);
        edLogin.setVisibility(View.VISIBLE);
        edPassword.setVisibility(View.VISIBLE);
        bSignUp.setVisibility(View.VISIBLE);
        bSignIn.setVisibility(View.VISIBLE);
        bSignOut.setVisibility(View.GONE);
        bExit.setVisibility(View.GONE);
        bRating.setVisibility(View.GONE);
        mainimgboy.setVisibility(View.GONE);
    }
    //Конец. Код скрыть/показать

    //Начало. Передача логина на следующую страницу
    public void onClickGO (View view)
    {
        Intent i = new Intent(Login.this, MainActivity.class);
        i.putExtra("login2", login2);
        startActivity(i);
    }
    //Конец. Передача логина на следующую страницу

    public void onClickRating(View view){
        Intent i = new Intent(Login.this, RatingActivity.class);
        startActivity(i);
    }
    public void onClickExit (View view)
    {
        FirebaseAuth.getInstance().signOut();
        bGO.setVisibility(View.GONE);
        tvUser.setVisibility(View.GONE);
        edLogin.setVisibility(View.VISIBLE);
        edPassword.setVisibility(View.VISIBLE);
        bSignUp.setVisibility(View.VISIBLE);
        bSignIn.setVisibility(View.VISIBLE);
        bExit.setVisibility(View.GONE);
        bRating.setVisibility(View.GONE);
        mainimgboy.setVisibility(View.GONE);

    }

    //Начало. Код скрытия клавиатуры
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    //Конец. Код скрытия клавиатуры
}