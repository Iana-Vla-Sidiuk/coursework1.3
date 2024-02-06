package organization;


import java.util.Date;

public class HalfDayEmployee extends Employee {

    public HalfDayEmployee() {

        super();
    }

    //Конструктор, который принимает имя и фамилию (должность и жалование - дефолтные)
    public HalfDayEmployee(String name, String surname) {

        super(name, surname);
    }

    //Конструктор, который принимает имя, фамилию, должность, жалование
    public HalfDayEmployee(String name, String surname, JobTitles position, int salary) {
        super(name, surname, position, salary);
    }

    //Конструктор, который принимает имя, фамилию, должность, жалование, дату приема на работу
    public HalfDayEmployee(String name, String surname, JobTitles position, int salary, Date dateOfEmployment) {
        super(name, surname, position, salary, dateOfEmployment);
    }
    //Метод, возвращающий ежемесячную премию = 0.
    @Override
    public double bonusMonthly() {
        return 0;
    }


}
