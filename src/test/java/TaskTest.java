import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void SimpleTaskContainsQuery() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");

        boolean expected = true;
        boolean actual = task.matches("Купить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SimpleTaskNotContainsQuery() {
        SimpleTask task = new SimpleTask(1, "купить хлеб");

        boolean expected = false;
        boolean actual = task.matches("Купить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicContainsQuery() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicNotContainsQuery() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Мука");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ProjectContainsQuery() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TopicContainsQuery() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("версии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingNotContainsQuery() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("хлеб");
        Assertions.assertEquals(expected, actual);
    }

}
