package organization;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

public class FullDayEmployeeTest {

    FullDayEmployee fullDayEmployee1;
    BusinessTravel businessTravel4;
    BusinessTravel businessTravel5;

    Date dateTest;

    //Создание тестовых данных
    @Before
    public void setUp() throws IncorrectDateException {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2015, 0, 27, 9, 00, 00);
        Date date1 = calendar1.getTime();
        Calendar calendarTest = Calendar.getInstance();
        calendarTest.set(2023, 7, 12, 9, 00, 00);
        dateTest = calendarTest.getTime();
        fullDayEmployee1 = new FullDayEmployee("Иван", "Иванов", JobTitles.BIGBOSS, 50000, date1);
        Calendar calendar14 = Calendar.getInstance();
        calendar14.set(2023, 7, 10, 9, 00, 00);
        Date dateDeparture14 = calendar14.getTime();
        Calendar calendar24 = Calendar.getInstance();
        calendar24.set(2023, 7, 15, 9, 00, 00);
        Date dateArrival24 = calendar24.getTime();
        Calendar calendar15 = Calendar.getInstance();
        calendar15.set(2019, 8, 11, 9, 00, 00);
        Date dateDeparture15 = calendar15.getTime();
        Calendar calendar25 = Calendar.getInstance();
        calendar25.set(2019, 8, 17, 9, 00, 00);
        Date dateArrival25 = calendar25.getTime();
        businessTravel4 = new BusinessTravel(dateDeparture14, dateArrival24, 16000, 700);
        businessTravel5 = new BusinessTravel(dateDeparture15, dateArrival25, 8000, 1000);
        fullDayEmployee1.addBusinessTravel(businessTravel4);
        fullDayEmployee1.addBusinessTravel(businessTravel5);

    }
    //Тестирование метода, возвращающего ежемесячную премию. Она вычисляется как число полных лет, которые проработал
    //сотрудник в компании,деленое на 20. Кроме того, если текущий месяц – январь, то премия увеличивается на размер оклада
    @Test
    public void testBonusMonthly() {
        double expected = (double) 9 / (double) 20;
        double actual = fullDayEmployee1.bonusMonthly();
        Assert.assertEquals(expected, actual, 0.01);
    }
    //Тестирование метода, возвращающего экземпляр класса BusinessTravel по дате в диапазоне между началом и концом командировки
    @Test
    public void testGetBusinessTravel() {
        BusinessTravel expected = businessTravel4;
        BusinessTravel  actual = fullDayEmployee1.getBusinessTravel(dateTest);
        Assert.assertEquals(expected, actual);
    }
    //Тестирование метода, возвращающего среднюю продолжительность командировок работника
    @Test
    public void testLengthBusinessTravel() {
        double expected = (double) (5 + 6) / (double) 2;
        double actual = fullDayEmployee1.lengthBusinessTravel();
        Assert.assertEquals(expected, actual, 0.01);
    }
    //Тестирование метода, возвращающего средний интервал между командировками в днях
    @Test
    public void testIntervalBusinessTravel() {
        double expected = 1423;
        double actual = fullDayEmployee1.intervalBusinessTravel();
        Assert.assertEquals(expected, actual, 0.01);
    }


}