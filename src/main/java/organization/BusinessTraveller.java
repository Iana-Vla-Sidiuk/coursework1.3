package organization;


import java.util.Date;

public interface BusinessTraveller {
    //Метод, который добавляет командировку сотруднику
    public void addBusinessTravel(BusinessTravel item);

    //Метод, который удаляет командировку у сотрудника
    public void removeBusinessTravel(Date dateDeparture);

    //Метод, возвращающий экземпляр класса BusinessTravel по дате в диапазоне между началом и концом командировки
    public BusinessTravel getBusinessTravel(Date date);

    //Метод, возвращающий среднюю продолжительность командировок работника
    public double lengthBusinessTravel();

    //Метод, возвращающий средний интервал между командировками в днях
    public double intervalBusinessTravel();

}

