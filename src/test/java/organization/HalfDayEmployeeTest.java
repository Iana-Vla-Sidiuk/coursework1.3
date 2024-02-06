package organization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

public class HalfDayEmployeeTest {
    HalfDayEmployee halfDayEmployee4;

    //Создание тестовых данных
    @Before
    public void setUp() {
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2016, 5, 15, 9, 00, 00);
        Date date4 = calendar4.getTime();
        halfDayEmployee4 = new HalfDayEmployee("Алена", "Романова", JobTitles.ENGINEER, 35000, date4);
    }

    //Тестирование метода, возвращающего ежемесячную премию = 0.
    @Test
    public void testBonusMonthly() {
        double expected = 0;
        double actual = halfDayEmployee4.bonusMonthly();
        Assert.assertEquals(expected, actual, 0.01);
    }
}