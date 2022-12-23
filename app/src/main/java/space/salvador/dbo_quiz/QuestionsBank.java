package space.salvador.dbo_quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> line_1Questions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Что такое ДБО?",
                "Дистанционное банковское обслуживаение.", "Динамичное банковское обслуживание.", "Депортамент бизнес онлайн.", "Банковское мобильное приложение.",
                "Дистанционное банковское обслуживаение.", "");

        final QuestionsList question2 = new QuestionsList("Что такое ОСДБО?",
                "Отдел систем ДБО.", "Операционная система ДБО.", "Основная система ДБО.", "Очень важное ДБО.",
                "Отдел систем ДБО.", "");

        final QuestionsList question3 = new QuestionsList("Что такое Kibana?",
                "ПО для создания обращении.", "ПО для закрытия карт.", "Сервис регистрации клиентов.", "ПО для просмотра логов.",
                "ПО для просмотра логов.", "");
        final QuestionsList question4 = new QuestionsList("Что такое Grafana?",
                "Свободная программная система визуализации данных, ориентированная на звонки клиентов.", "ПО для просмотра логов.", "Свободная программная система визуализации данных, ориентированная на данные систем ИТ-мониторинга.", "Свободная операционная система, ориентированная на вывод графиков из Excel.",
                "Свободная программная система визуализации данных, ориентированная на данные систем ИТ-мониторинга.", "");
        final QuestionsList question5 = new QuestionsList("Откуда Grafana получает инфо для вывода графиков и диаграмм?",
                "Из Omnitracker.", "Из базы данных OKA.", "Из таблиц получаемых с помощью sql запросов.", "Из Kibana.",
                "Из таблиц получаемых с помощью sql запросов.", "");
        final QuestionsList question6 = new QuestionsList("Что такое Omnitracker?",
                "ПО для создания обращении.", "ПО для просмотров логов.", "ПО для проверки sql запросов.", "ПО для проверки скорости интернет соединения.",
                "ПО для создания обращении.", "");
        final QuestionsList question7 = new QuestionsList("Что такое Siebel?",
                "Мастер система, где хранятся все данные о платежах (проводки), кредитах, депозитах клиентов.", "Мастер система, где хранятся все обращения клиентов.", "Мастер система, где хранятся данные клиентов, а также заявки на кредит.", "Свободная программная система визуализации данных, ориентированная на данные систем ИТ-мониторинга.",
                "Мастер система, где хранятся данные клиентов, а также заявки на кредит.", "");
        final QuestionsList question8 = new QuestionsList("Что такое ЦФТ?",
                "Свободная программная система визуализации данных, ориентированная на данные систем ИТ-мониторинга.", "Пространство для команд, в котором накопленные знания объединены с возможностями для совместной работы.", "Мастер система, где хранятся все данные о платежах (проводки), кредитах, депозитах клиентов.", "ПО для создания обращении.",
                "Мастер система, где хранятся все данные о платежах (проводки), кредитах, депозитах клиентов.", "");
        final QuestionsList question9 = new QuestionsList("Что такое Confluence?",
                "Пространство для команд, в котором накопленные знания объединены с возможностями для совместной работы.", "Пространство для создания sql запросов", "Пространство для команд, в котором сотрудники прогревают справочники.", "Личный кабиент сотрудников ДИТО.",
                "Пространство для команд, в котором накопленные знания объединены с возможностями для совместной работы.", "");
        final QuestionsList question10 = new QuestionsList("Что такое SCS?",
                "Мастер система, где хранятся все данные о платежах (проводки), кредитах, депозитах клиентов.", "Свободная программная система визуализации данных, ориентированная на данные систем ИТ-мониторинга.", "ПО для создания обращении.", "Самописное ПО для работы сотрудников ОСДБО.",
                "Самописное ПО для работы сотрудников ОСДБО.", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
    }

    private static List<QuestionsList> line_2Questions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Какой формат у установочного файл мобильного приложения для Android?",
                ".IPA", ".APK", ".EXE", ".MP3",
                ".APK", "");

        final QuestionsList question2 = new QuestionsList("Сколько времени хранятся логи в Kibana?",
                "Для МБ - 10 дней, для ИБ - 5 дней (+ текущий).", "Для МБ - 20 дней, для ИБ - 5 дней (+ текущий).", "Для МБ - 20 дней, для ИБ - 5 дней (+ текущий).", "Для МБ - 3 месяца, для ИБ - 5 дней (+ текущий).",
                "Для МБ - 20 дней, для ИБ - 5 дней (+ текущий).", "");

        final QuestionsList question3 = new QuestionsList("Сколько времени хранятся логи в HelpDesk?",
                "3 месяца.", "Также как и в Kibana.", "10 дней.", "3 дня.",
                "3 месяца.", "");
        final QuestionsList question4 = new QuestionsList("В каком ПО добавляется возможность закрытия карт?",
                "Kibana.", "Grafana.", "Omnitracker.", "HelpDesk.",
                "HelpDesk.", "");
        final QuestionsList question5 = new QuestionsList("Какой стандартный SLA обращения для Сопровождения МКБ Онлайн?",
                "8 рабочих часов.", "24 рабочих часа.", "4 рабочих часа.", "30 минут.",
                "24 рабочих часа.", "");
        final QuestionsList question6 = new QuestionsList("Какой стандартный SLA обращений со статусом высокий?",
                "8 рабочих часов.", "30 минут.", "60 минут.", "2 рабочих часа.",
                "8 рабочих часов.", "");
        final QuestionsList question7 = new QuestionsList("Где посмотреть SLA обращения?",
                "SCS->обращение->контроль-срок.", "Omnitracker->обращение->карточка учета-срок.", "Omnitracker->обращение->контроль-срок.", "Omnitracker->примечание->контроль-срок.",
                "Omnitracker->обращение->контроль-срок.", "");
        final QuestionsList question8 = new QuestionsList("Что такое препрод?",
                "Версия МБ/ИБ идентичная или максимально приближенная к боевой версии.", "ПО для просмотров логов.", "Мастер система, где хранятся данные клиентов, а также заявки на кредит.", "Пространство для команд, в котором сотрудники прогревают справочники.",
                "Версия МБ/ИБ идентичная или максимально приближенная к боевой версии.", "");
        final QuestionsList question9 = new QuestionsList("ПДля чего используется JIRA",
                "Для создания задача на разработчиков.", "Для создания обращении клиентами.", "Для создания конференции со смежными отделами.", "Для выгрузки логов с контуров.",
                "Для создания задача на разработчиков.", "");
        final QuestionsList question10 = new QuestionsList("Что такое стрим, в пониманий Сопровождения МКБ Онлайн?",
                "Команда разработчиков отвечающая за весь МКБ Онлайн.", "Команда разработчиков SCS.", "Команда разработчиков занимающие опредленной частью Мкб Онлайн.", "Трансляция на Twith.",
                "Команда разработчиков занимающие опредленной частью Мкб Онлайн.", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
    }

    private static List<QuestionsList> line_3Questions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("В какой форме в БД хранится информация об основных свойствах сущностей предметной области, моделью которой является БД?",
                "в таблицах.", "в индексах.", "в коллекциях.", "в пакетах.",
                "в таблицах.", "");
        final QuestionsList question2 = new QuestionsList("Запросы какого типа используются для получения информации из БД?",
                "delete.", "update.", "select.", "insert.",
                "select.", "");
        final QuestionsList question3 = new QuestionsList("Какое ключевое слово в запросе предшествует имени таблицы, из которой выбираются данные?",
                "where.", "in.", "order.", "from.",
                "from.", "");
        final QuestionsList question4 = new QuestionsList("Вам надо произвести действие лишь с некоторыми записями, а не со всеми записями в таблице. Каким ключевым словом вы в запросе обозначите начало описания условия?",
                "on.", "where.", "in.", "having.",
                "where.", "");
        final QuestionsList question5 = new QuestionsList("Как в БД формально отражаются связи межу сущностями предметной области?",
                "индексом.", "внешним ключом.", "одинаковыми полями в таблицах.", "триггером.",
                "внешним ключом.", "");
        final QuestionsList question6 = new QuestionsList("Вам надо получить данные об объекте из нескольких таблиц, в одной содержится основная информация, в другой дополнительная. Как вы укажите в запросе доп. таблицу?",
                "join.", "union.", "connect.", "also from.",
                "join.", "");
        final QuestionsList question7 = new QuestionsList(" Как называется набор полей в таблице, такой, что в каждой записи этой таблицы набор значений этих полей уникален?",
                "первичный ключ.", "ключ.", "внешний ключ.", "определитель.",
                "ключ.", "");
        final QuestionsList question8 = new QuestionsList("Вам нужно подсчитать к-во записей в таблице, удовлетворяющих какому-то условию. Какую агрегатную функцию вы используете для этого?",
                "sum().", "count().", "ave().", "total().",
                "count().", "");
        final QuestionsList question9 = new QuestionsList("Какова практическая польза от индексов?",
                "никакой, только место занимают.", "обеспечивают непротиворечивость информации в БД.", "ускоряют исполнение запросов.", "сохраняют информацию на случай повреждения таблицы.",
                "ускоряют исполнение запросов.", "");
        final QuestionsList question10 = new QuestionsList("Вы создали таблицу. Вам надо отслеживать, например, логировать, изменения данных в этой таблице производимые др. пользователями. Каким инструментом вы воспользуетесь?",
                "видеокамерой.", "триггером.", "хранимой процедурой.", "партицией.",
                "триггером.", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
    }

    private static List<QuestionsList> line_4Questions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Какой формат у установочного файл мобильного приложения для IOS?",
                ".APK", ".IPA", ".EXE", ".MP3",
                ".IPA", "");

        final QuestionsList question2 = new QuestionsList("На каком языке написано ПО SCS?",
                "Java.", "Python.", "delphi.", "PHP.",
                "delphi.", "");

        final QuestionsList question3 = new QuestionsList("Кто создал SCS?",
                "Дональд Чемберлин и Рэймонд Бойс.", "Сергей Губарев.", "Дмитрий Черненилов.", "Тим Кук.",
                "Сергей Губарев.", "");
        final QuestionsList question4 = new QuestionsList("На чем основано ПО SCS?",
                "На синхронизации с Kibana.", "На синхронизации с Grafana.", "На запросах SQL.", "На синхронизации с HelpDesk.",
                "На запросах SQL.", "");
        final QuestionsList question5 = new QuestionsList("Введите запрос в Kibana для поиска баланса в МБ?",
                "Код клиента и баланс.", "KK AND GetFreeServiceConditions.", "KK AND GetBalance.", "КК AND totalBalance.",
                "КК AND totalBalance.", "");
        final QuestionsList question6 = new QuestionsList("Что такое МСС код?",
                "четырехзначный код, обозначающий адрес торговой точки", "четырехзначный код, обозначающий категорию платежной операции..", "четырехзначный код, обозначающий время выполнения операции.", "шестизначный код, обозначающий категорию платежной операции.",
                "четырехзначный код, обозначающий категорию платежной операции..", "");
        final QuestionsList question7 = new QuestionsList("Где находятся картинки МБ?",
                "БД ORA.", "Woodside.", "БД SYBASE.", "Siebel.",
                "Woodside.", "");
        final QuestionsList question8 = new QuestionsList("Где можно вкл/выкл фичфлаги?",
                "Woodside.", "БД ORA.", "БД SYBASE.", "Siebel.",
                "Woodside.", "");
        final QuestionsList question9 = new QuestionsList("Возможно ли достать QR ЖКХ и привести его в вид QR кода?",
                "ДА, в логах можно найти картинку QR кода.", "Да, с длинного кода из логов и NotePad++.", "Нет, данная информация не логируется.", "Нет, информация логируется в виде длинного кода, который невозможно расшифровать.",
                "Да, с длинного кода из логов и NotePad++.", "");
        final QuestionsList question10 = new QuestionsList("Где можно посмотреть арест/испольнительный на счете?",
                "В Siebel.", "В Kibana.", "В ЦФТ.", "В HelpDesk.",
                "В ЦФТ.", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
    }

    private static List<QuestionsList> line_5Questions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Тестовый вопрос?",
                ".APK", ".IPA", ".EXE", ".MP3",
                ".IPA", "");

        final QuestionsList question2 = new QuestionsList("На каком языке написано ПО SCS?",
                "Java.", "Python.", "delphi.", "PHP.",
                "delphi.", "");

        final QuestionsList question3 = new QuestionsList("Кто создал SCS?",
                "Дональд Чемберлин и Рэймонд Бойс.", "Сергей Губарев.", "Дмитрий Черненилов.", "Тим Кук.",
                "Сергей Губарев.", "");
        final QuestionsList question4 = new QuestionsList("На чем основано ПО SCS?",
                "На синхронизации с Kibana.", "На синхронизации с Grafana.", "На запросах SQL.", "На синхронизации с HelpDesk.",
                "На запросах SQL.", "");
        final QuestionsList question5 = new QuestionsList("Введите запрос в Kibana для поиска баланса в МБ?",
                "Код клиента и баланс.", "KK AND GetFreeServiceConditions.", "KK AND GetBalance.", "КК AND totalBalance.",
                "КК AND totalBalance.", "");
        final QuestionsList question6 = new QuestionsList("Что такое МСС код?",
                "четырехзначный код, обозначающий адрес торговой точки", "четырехзначный код, обозначающий категорию платежной операции..", "четырехзначный код, обозначающий время выполнения операции.", "шестизначный код, обозначающий категорию платежной операции.",
                "четырехзначный код, обозначающий категорию платежной операции..", "");
        final QuestionsList question7 = new QuestionsList("Где находятся картинки МБ?",
                "БД ORA.", "Woodside.", "БД SYBASE.", "Siebel.",
                "Woodside.", "");
        final QuestionsList question8 = new QuestionsList("Где можно вкл/выкл фичфлаги?",
                "Woodside.", "БД ORA.", "БД SYBASE.", "Siebel.",
                "Woodside.", "");
        final QuestionsList question9 = new QuestionsList("Возможно ли достать QR ЖКХ и привести его в вид QR кода?",
                "ДА, в логах можно найти картинку QR кода.", "Да, с длинного кода из логов и NotePad++.", "Нет, данная информация не логируется.", "Нет, информация логируется в виде длинного кода, который невозможно расшифровать.",
                "Да, с длинного кода из логов и NotePad++.", "");
        final QuestionsList question10 = new QuestionsList("Где можно посмотреть арест/испольнительный на счете?",
                "В Siebel.", "В Kibana.", "В ЦФТ.", "В HelpDesk.",
                "В ЦФТ.", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
    }

    public static List<QuestionsList> qetQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "НОВИЧОК":
                return line_1Questions();
            case "СПЕЦИАЛИСТ":
                return line_2Questions();
            case "В.СПЕЦИАЛИСТ":
                return line_3Questions();
            case "ДЕЖУРНЫЙ":
                return line_5Questions();
            default:
                return line_4Questions();

        }
    }
}
