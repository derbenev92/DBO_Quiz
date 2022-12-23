package space.salvador.dbo_quiz;

public class QuestionsList {

    private String option1, option2, option3, option4, quastion, answer;
    private String userSelectedAnswer;

    public QuestionsList(String quastion, String option1, String option2, String option3, String option4,  String answer, String userSelectedAnswer) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.quastion = quastion;
        this.answer = answer;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuastion() {
        return quastion;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}
