import lesson6.Task3;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TestTask3 {

    Task3 task3 = new Task3();

    public int countAllStudents() {
        int count = 0;
        for (Object s :
                task3.selectAllStudents()) {
//            System.out.println(s);
            count++;
        }
        return count;
    }

    @Test
    public void addAndDeleteTest() {
        String testStudentLastName = "TEST1";
        int countBeforeAdd = countAllStudents();
        task3.addStudent(testStudentLastName, 100);
        int countAfterAdd = countAllStudents();
        if (countBeforeAdd == countAfterAdd) {
            Assert.fail("Не добавился студент");
        }
        task3.deleteStudent(testStudentLastName);
        int afterDeleteStudent = countAllStudents();
        if (afterDeleteStudent > countBeforeAdd) {
            Assert.fail("Не удаляется");
        }
    }

    @Test
    public void updateScoreTest(){
        String testStudentLastName = "TEST2";
        String newScore = String.valueOf(100);
        try {
            task3.addStudent(testStudentLastName, 50);
            task3.updateScore(testStudentLastName, Integer.parseInt(newScore));
            String score = (String) task3.selectStudent(testStudentLastName).get(0);
            String[] strings = score.split(" ");
//            System.out.println(strings[0] + strings[1]);
            Assert.assertEquals(newScore, strings[1]);

        }finally {
            task3.deleteStudent(testStudentLastName);
        }
    }

    @Test
    public void testReadStudent(){
//        25 - количество студентов в базе
        Assert.assertEquals(25, countAllStudents());
    }

    @After
    public void disconnect(){
        task3.disconnect();
        System.out.println("disconnect");
    }

}
