package organization;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DepartmentTest {

    Department department1;
    FullDayEmployee fullDayEmployee1;
    FullDayEmployee fullDayEmployee2;
    FullDayEmployee fullDayEmployee3;
    HalfDayEmployee halfDayEmployee4;
    FullDayEmployee fullDayEmployee5;

    Employee [] array1;
    Date dateTest;

    //Создание тестовых данных
    @Before
    public void setUp() throws IncorrectDateException {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2015, 0, 27, 9, 00, 00);
        Date date1 = calendar1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020, 2, 2, 9, 00, 00);
        Date date2 = calendar2.getTime();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2023, 10, 5, 9, 00, 00);
        Date date3 = calendar3.getTime();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2016, 5, 15, 9, 00, 00);
        Date date4 = calendar4.getTime();
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(2018, 7, 19, 9, 00, 00);
        Date date5 = calendar5.getTime();
        Calendar calendarTest = Calendar.getInstance();
        calendarTest.set(2023, 7, 12, 9, 00, 00);
        dateTest = calendarTest.getTime();
        fullDayEmployee1 = new FullDayEmployee("Иван", "Иванов", JobTitles.BIGBOSS, 50000, date1);
        fullDayEmployee2 = new FullDayEmployee("Оксана", "Романова", JobTitles.СLERK, 20000, date2);
        fullDayEmployee3 = new FullDayEmployee("Сергей", "Петров", JobTitles.QAENGINEER, 60000, date3);
        halfDayEmployee4 = new HalfDayEmployee("Алена", "Романова", JobTitles.ENGINEER, 35000, date4);
        fullDayEmployee5 = new FullDayEmployee("Дмитрий", "Костин", JobTitles.DEPARTMENTBOSS, 40000, date5);
        array1 = new Employee[]{fullDayEmployee1, fullDayEmployee2, fullDayEmployee3, halfDayEmployee4, fullDayEmployee5};
        department1 = new Department("1 департамент", array1);
        Calendar calendar14 = Calendar.getInstance();
        calendar14.set(2023, 7, 10, 9, 00, 00);
        Date dateDeparture14 = calendar14.getTime();
        Calendar calendar24 = Calendar.getInstance();
        calendar24.set(2023, 7, 15, 9, 00, 00);
        Date dateArrival24 = calendar24.getTime();
        BusinessTravel businessTravel4 = new BusinessTravel(dateDeparture14, dateArrival24, 16000, 700);
        fullDayEmployee1.addBusinessTravel(businessTravel4);
    }

    //Тестирование метода, который возвращает общее число работников подразделения
    @Test
    public void testCountEmployee() {
        int actual = department1.countEmployee();
        Assert.assertEquals(5, actual);
    }

    //Тестирование метода, который возвращает суммарную зарплату всех работников подразделения
    @Test
    public void testSumSalary() {
        double expected = 50000 + 20000 + 60000 + 35000 + 40000;
        double actual = department1.sumSalary();
        Assert.assertEquals(expected, actual, 0.01);

    }

    //Тестирование метода, который возвращает ссылку на работника по фамилии и имени
    @Test
    public void testReturnEmployee() {
        Employee expected = fullDayEmployee2;
        Employee actual = department1.returnEmployee("Оксана", "Романова");
        Assert.assertEquals(expected, actual);
    }

    //Тестирование метода, который возвращает массив работников отдела
    @Test
    public void testGetArrayEmployee() {
        Employee [] expected = {fullDayEmployee1, fullDayEmployee2, fullDayEmployee3, halfDayEmployee4, fullDayEmployee5};
        Employee [] actual = department1.getArrayEmployee();
        Assert.assertArrayEquals(expected, actual);
    }

    //Тестирование метода, который возвращает список (ArrayList<FullDayEmployee>) штатных сотрудников
    @Test
    public void testListFullDayEmployee() {
        ArrayList<FullDayEmployee> expected = new ArrayList<>();
        expected.add(fullDayEmployee1);
        expected.add(fullDayEmployee2);
        expected.add(fullDayEmployee3);
        expected.add(fullDayEmployee5);
        ArrayList<FullDayEmployee> actual = department1.listFullDayEmployee();
        Assert.assertEquals(expected, actual);
    }

    //Тестирование метода, который возвращает список (ArrayList<HalfDayEmployee>) внешних совместителей
    @Test
    public void testListHalfDayEmployee() {
        ArrayList<HalfDayEmployee> expected = new ArrayList<>();
        expected.add(halfDayEmployee4);
        ArrayList<HalfDayEmployee> actual = department1.listHalfDayEmployee();
        Assert.assertEquals(expected, actual);
    }

    //Тестирование метода, который возвращает список (ArrayList<BusinessTraveller >) сотрудников, находящихся
    // в командировке в данное время
    @Test
    public void testListBusinessTravellerNow() {
        ArrayList<BusinessTraveller> expected = new ArrayList<>();
        ArrayList<BusinessTraveller> actual = department1.listBusinessTravellerNow();
        Assert.assertEquals(expected, actual);
    }

    //Тестирование метода, который возвращает список (ArrayList<BusinessTraveller >) сотрудников, находящихся
    // в командировке указанного числа
    @Test
    public void testListBusinessTraveller() {
        ArrayList<BusinessTraveller> expected = new ArrayList<>();
        expected.add(fullDayEmployee1);
        ArrayList<BusinessTraveller> actual = department1.listBusinessTraveller(dateTest);
        Assert.assertEquals(expected, actual);
    }

    //Тестирование метода, который возвращает массив работников отдела, отсортированный по фамилии и имени работника
    @Test
    public void testSorted() {
        Employee [] expected = {fullDayEmployee1, fullDayEmployee5, fullDayEmployee3, halfDayEmployee4, fullDayEmployee2};
        Employee [] actual = department1.sorted(array1);
        Assert.assertArrayEquals(expected, actual);
    }


}