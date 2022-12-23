package space.salvador.dbo_quiz.Models;

import java.util.Comparator;

public class Ball {
    public String id, correct, incorrect, login, level;

    public Ball (){
    }

    public Ball (String id, String correct, String incorrect, String login, String level) {
        this.id = id;
        this.correct = correct;
        this.incorrect = incorrect;
        this.login = login;
        this.level = level;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(String incorrect) {
        this.incorrect = incorrect;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static Comparator<Ball> ByCorrect = new Comparator<Ball>() {
        @Override
        public int compare(Ball one, Ball two) {
            return - Integer.valueOf(one.correct).compareTo(Integer.valueOf(two.correct));
        }
    };

}
