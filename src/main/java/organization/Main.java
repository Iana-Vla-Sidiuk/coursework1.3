package organization;


import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IncorrectDateException {

        //Создаем даты приема на работу
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

        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(2019, 10, 28, 9, 00, 00);
        Date date6 = calendar6.getTime();

        Calendar calendar7 = Calendar.getInstance();
        calendar7.set(2015, 2, 22, 9, 00, 00);
        Date date7 = calendar7.getTime();

        //Создаем работников
        FullDayEmployee fullDayEmployee1 = new FullDayEmployee("Иван", "Иванов", JobTitles.BIGBOSS, 50000, date1);
        FullDayEmployee fullDayEmployee2 = new FullDayEmployee("Оксана", "Романова", JobTitles.СLERK, 20000, date2);
        FullDayEmployee fullDayEmployee3 = new FullDayEmployee("Сергей", "Петров", JobTitles.QAENGINEER, 60000, date3);
        HalfDayEmployee halfDayEmployee4 = new HalfDayEmployee("Алена", "Романова", JobTitles.ENGINEER, 35000, date4);
        FullDayEmployee fullDayEmployee5 = new FullDayEmployee("Дмитрий", "Костин", JobTitles.DEPARTMENTBOSS, 40000, date5);

        FullDayEmployee fullDayEmployee6 = new FullDayEmployee("Ольга", "Сазонова", JobTitles.QAENGINEER, 45000, date6);
        HalfDayEmployee halfDayEmployee7 = new HalfDayEmployee("Александра", "Орлова", JobTitles.ENGINEER, 40000, date7);

        //Создаем массивы работников
        Employee[] array1 = new Employee[]{fullDayEmployee1, fullDayEmployee2, fullDayEmployee3, halfDayEmployee4, fullDayEmployee5};
        Employee[] array2 = new Employee[]{fullDayEmployee6, halfDayEmployee7};

        //Создаем департаменты
        Department department1 = new Department("1 департамент", array1);
        Department department2 = new Department("2 департамент", array2);
        Department department3 = new Department("3 департамент");


        //Вызываем метод получения информации о работнике
        fullDayEmployee2.infoEmployee();

        //Вызываем метод получения информации о подразделении
        System.out.println("================================");
        department2.infoDepartment();

        //Вызываем метод получения информации о массиве работников подразделения
        System.out.println("================================");
        department1.infoEmployeeOfDepartment();

        //Вызываем метод получения информации о количестве работников подразделения
        System.out.println("================================");
        System.out.println("Количество работников подразделения: " + department1.countEmployee());

        //Вызываем метод получения информации о суммарной зарплате работников подразделения
        System.out.println("================================");
        System.out.println("Суммарная зарплата работников подразделения: " + department1.sumSalary());

        //Вызываем метод возврата ссылки на работника по имени и фамилии
        System.out.println("================================");
        System.out.println("Ссылка на работника по имени и фамилии: " + department1.returnEmployee("Оксана", "Романова"));


        //Вызываем метод удаления работника
        System.out.println("================================");
        System.out.println("Вывод массива работников после удаления работника из массива: ");
        department1.removeEmployee("Дмитрий", "Костин", JobTitles.DEPARTMENTBOSS);
        //Проверяем количество работников после удаления работника из массива
        System.out.println("Количество работников подразделения после удаления работника: " + department1.countEmployee());

        //Вызываем метод добавления работника
        System.out.println("================================");
        department1.addEmployee(fullDayEmployee5);
        //Проверяем количество работников после добавления работника из массива
        System.out.println("Количество работников подразделения после добавления нового работника: " + department1.countEmployee());


        //Проверяем получение массива
        System.out.println("================================");
        System.out.println("Вывод полученного массива: ");
        Employee[] e = department1.getArrayEmployee();
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i].toString());
        }

        //Проверяем получение отсортированного массива
        System.out.println("================================");
        System.out.println("Вывод массива, отсортированного по фамилии и имени: ");
        department1.sorted(department1.getArrayEmployee());
        for (int i = 0; i < array1.length; i++) {
            System.out.println(e[i].toString());
        }

        System.out.println("================================");
        System.out.printf("Ежемесячная премия сотрудника %s %s: %.2f\n", fullDayEmployee5.getName(), fullDayEmployee5.getSurname(),
                fullDayEmployee5.bonusMonthly());

        //Создаем даты отбытия в командировку
        Calendar calendar11 = Calendar.getInstance();
        calendar11.set(2022, 4, 1, 9, 00, 00);
        Date dateDeparture11 = calendar11.getTime();

        Calendar calendar12 = Calendar.getInstance();
        calendar12.set(2022, 5, 16, 9, 00, 00);
        Date dateDeparture12 = calendar12.getTime();

        Calendar calendar13 = Calendar.getInstance();
        calendar13.set(2022, 11, 15, 9, 00, 00);
        Date dateDeparture13 = calendar13.getTime();

        Calendar calendar14 = Calendar.getInstance();
        calendar14.set(2023, 7, 10, 9, 00, 00);
        Date dateDeparture14 = calendar14.getTime();

        Calendar calendar15 = Calendar.getInstance();
        calendar15.set(2019, 8, 11, 9, 00, 00);
        Date dateDeparture15 = calendar15.getTime();

        Calendar calendar16 = Calendar.getInstance();
        calendar16.set(2020, 2, 2, 9, 00, 00);
        Date dateDeparture16 = calendar16.getTime();

        Calendar calendar17 = Calendar.getInstance();
        calendar17.set(2016, 4, 21, 9, 00, 00);
        Date dateDeparture17 = calendar17.getTime();


        //Создаем даты прибытия из командировки
        Calendar calendar21 = Calendar.getInstance();
        calendar21.set(2022, 4, 4, 9, 00, 00);
        Date dateArrival21 = calendar21.getTime();

        Calendar calendar22 = Calendar.getInstance();
        calendar22.set(2022, 5, 18, 9, 00, 00);
        Date dateArrival22 = calendar22.getTime();

        Calendar calendar23 = Calendar.getInstance();
        calendar23.set(2022, 11, 18, 9, 00, 00);
        Date dateArrival23 = calendar23.getTime();

        Calendar calendar24 = Calendar.getInstance();
        calendar24.set(2023, 7, 15, 9, 00, 00);
        Date dateArrival24 = calendar24.getTime();

        Calendar calendar25 = Calendar.getInstance();
        calendar25.set(2019, 8, 17, 9, 00, 00);
        Date dateArrival25 = calendar25.getTime();

        Calendar calendar26 = Calendar.getInstance();
        calendar26.set(2020, 2, 3, 9, 00, 00);
        Date dateArrival26 = calendar26.getTime();

        Calendar calendar27 = Calendar.getInstance();
        calendar27.set(2016, 4, 24, 9, 00, 00);
        Date dateArrival27 = calendar27.getTime();

        //Создаем командировки
        BusinessTravel businessTravel1 = new BusinessTravel(dateDeparture11, dateArrival21, 19000, 500);
        BusinessTravel businessTravel2 = new BusinessTravel(dateDeparture12, dateArrival22, 11000, 600);
        BusinessTravel businessTravel3 = new BusinessTravel(dateDeparture13, dateArrival23, 25000, 400);
        BusinessTravel businessTravel4 = new BusinessTravel(dateDeparture14, dateArrival24, 16000, 700);
        BusinessTravel businessTravel5 = new BusinessTravel(dateDeparture15, dateArrival25, 8000, 1000);
        BusinessTravel businessTravel6 = new BusinessTravel(dateDeparture16, dateArrival26, 9000, 900);
        BusinessTravel businessTravel7 = new BusinessTravel(dateDeparture17, dateArrival27, 15000, 800);

        //Вызываем метод получения информации о командировке
        System.out.println("================================");
        businessTravel1.businessTravel();

        //Вызываем метод, возвращающий число полных дней между датами отбытия и прибытия
        System.out.println("================================");
        System.out.printf("Количество полных дней командировки с датой отбытия %td.%tm.%tY и датой прибытия " +
                        "%td.%tm/%tY: %.0f\n", businessTravel1.getDateDeparture(), businessTravel1.getDateDeparture(),
                businessTravel1.getDateDeparture(), businessTravel1.getDateArrival(), businessTravel1.getDateArrival(),
                businessTravel1.getDateArrival(), businessTravel1.periodBusinessTravel());

        //Вызываем метод, возвращающий общую сумму затраченных на командировку денег (трансфер + суточные * кол-во дней)
        System.out.println("================================");
        System.out.printf("Сумма затраченных на командировку денег: %.2f\n", businessTravel1.costBusinessTravel());


        //Вызываем метод, который добавляет командировку сотруднику
        System.out.println("================================");
        System.out.println("Командировки работника " + fullDayEmployee1.getName() + " " + fullDayEmployee1.getSurname()
                + " после добавления командировок работнику:");
        fullDayEmployee1.addBusinessTravel(businessTravel1);
        fullDayEmployee1.addBusinessTravel(businessTravel2);
        fullDayEmployee1.addBusinessTravel(businessTravel3);
        fullDayEmployee1.addBusinessTravel(businessTravel4);
        fullDayEmployee1.addBusinessTravel(businessTravel5);
        System.out.println(fullDayEmployee1.getArrayListBusinessTravel());

        System.out.println("Командировки работника " + fullDayEmployee2.getName() + " " + fullDayEmployee2.getSurname()
                + " после добавления командировок работнику:");
        fullDayEmployee2.addBusinessTravel(businessTravel1);
        fullDayEmployee2.addBusinessTravel(businessTravel4);

        System.out.println(fullDayEmployee2.getArrayListBusinessTravel());

        //Вызываем метод, который удаляет командировку у сотрудника
        System.out.println("================================");
        System.out.println("Командировки работника " + fullDayEmployee1.getName() + " " + fullDayEmployee1.getSurname()
                + " после удаления командировки с датой отбытия " + dateDeparture15 + ":");
        fullDayEmployee1.removeBusinessTravel(dateDeparture15);
        System.out.println(fullDayEmployee1.getArrayListBusinessTravel());

        //Вызываем метод, который возвращает экземпляр класса BusinessTravel по дате в диапазоне между началом и концом командировки
        Calendar calendarTest = Calendar.getInstance();
        calendarTest.set(2023, 7, 12, 9, 00, 00);
        Date dateTest = calendarTest.getTime();
        System.out.println("================================");
        System.out.println("Командировка, в диапазоне которой находится указанная дата " + dateTest + ":");
        System.out.println(fullDayEmployee1.getBusinessTravel(dateTest));

        //Вызываем метод, который возвращает среднюю продолжительность командировок работника
        System.out.println("================================");
        System.out.println("Средняя продолжительность командировок работника " + fullDayEmployee1.getName()
                + " " + fullDayEmployee1.getSurname() + ":");
        System.out.printf("%.2f\n", fullDayEmployee1.lengthBusinessTravel());

        //Вызываем метод, который возвращает средний интервал между командировками в днях
        System.out.println("================================");
        System.out.println("Средний интервал между командировками работника " + fullDayEmployee1.getName()
                + " " + fullDayEmployee1.getSurname() + ":");
        System.out.printf("%.2f\n", fullDayEmployee1.intervalBusinessTravel());

        //Вызываем метод, который возвращает список (ArrayList<FullDayEmployee>) штатных сотрудников
        System.out.println("================================");
        System.out.println("Штатные сотрудники департамента " + department1.getNameDepartment() + ":");
        System.out.println(department1.listFullDayEmployee());

        //Вызываем метод, который возвращает список (ArrayList<HalfDayEmployee>) внешних совместителей
        System.out.println("================================");
        System.out.println("Внешние совместители департамента " + department1.getNameDepartment() + ":");
        System.out.println(department1.listHalfDayEmployee());

        //Вызываем метод, возвращающий список (ArrayList<BusinessTraveller >) сотрудников, находящихся в командировке в данное время
        System.out.println("================================");
        System.out.println("Работники департамента " + department1.getNameDepartment()
                + ", которые в данный момент находятся в командировке:");
        System.out.println(department1.listBusinessTravellerNow());

        //Вызываем метод, возвращающий список (ArrayList<BusinessTraveller >) сотрудников, находящихся в командировке указанного числа
        System.out.println("================================");
        System.out.println("Работники департамента " + department1.getNameDepartment()
                + ", находящиеся в командировке указанного числа " + dateTest + ":");
        System.out.println(department1.listBusinessTraveller(dateTest));


        System.out.println("================================");
        //Получаем информацию о командировке, даты отбытия/прибытия которой планируем изменить
        businessTravel1.businessTravel();
        //Создаем тестовую некорректную дату отбытия в командировку (на год позже валидной)
        Calendar calendar111 = Calendar.getInstance();
        calendar111.set(2023, 4, 1, 9, 00, 00);
        Date dateDeparture111 = calendar111.getTime();
        System.out.println("Изменим на год позже дату отбытия в командировку " + dateDeparture11 + " на "
                + dateDeparture111 + ": ");
        //Вызываем метод изменения даты отбытия в командировку, который может выбросить исключение
        try {
            businessTravel1.setDateDeparture(dateDeparture111);
        } catch (IncorrectDateException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        //Получаем информацию о командировке, даты отбытия/прибытия которой планируем изменить
        businessTravel1.businessTravel();
        //Создаем тестовую некорректную дату прибытия из командировки (на год раньше валидной)
        Calendar calendar112 = Calendar.getInstance();
        calendar112.set(2021, 4, 4, 9, 00, 00);
        Date dateArrival112 = calendar112.getTime();
        System.out.println("Изменим на год раньше дату прибытия из командировки " + dateArrival21 + " на "
                + dateArrival112 + ": ");
        //Вызываем метод изменения даты прибытия из командировки, который может выбросить исключение
        try {
            businessTravel1.setDateArrival(dateArrival112);
        } catch (IncorrectDateException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
        //Получаем информацию о командировке, даты отбытия/прибытия которой пытались изменить
        businessTravel1.businessTravel();


        //Создаем тестовые некорректные даты отбытия/прибытия (дата отбытия в командировку на год позже даты прибытия)
        System.out.println("================================");
        Calendar calendar41 = Calendar.getInstance();
        calendar41.set(2023, 7, 10, 9, 00, 00);
        Date dateDeparture41 = calendar41.getTime();
        Calendar calendar42 = Calendar.getInstance();
        calendar42.set(2022, 7, 14, 9, 00, 00);
        Date dateArrival42 = calendar42.getTime();
        System.out.println("Создадим командировку с некорректными датами: дата отбытия " + dateDeparture41 +
                ", дата прибытия " + dateArrival42 + ":");
        //Создаем командировку с невалидными датами, чтобы получить исключение
        BusinessTravel businessTravel51 = new BusinessTravel();
        try {
            businessTravel51 = new BusinessTravel(dateDeparture41, dateArrival42, 14000, 600);
        } catch (IncorrectDateException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
        //Получаем информацию о командировке, даты отбытия/прибытия которой пытались изменить
        businessTravel51.businessTravel();

    }
}
