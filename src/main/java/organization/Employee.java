package organization;


import java.util.Date;

public abstract class Employee {
    private String name; //имя работника
    private String surname; //фамилия работника
    private JobTitles position; //должность работника
    private int salary; //жалование работника
    private Date dateOfEmployment; //дата приема на работу

    public Employee() {
    }

    //Конструктор, который принимает имя и фамилию (должность и жалование - дефолтные)
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.position = JobTitles.ENGINEER;
        this.salary = 30000;
    }

    //Конструктор, который принимает имя, фамилию, должность, жалование
    public Employee(String name, String surname, JobTitles position, int salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }

    //Конструктор, который принимает имя, фамилию, должность, жалование, дату приема на работу
    public Employee(String name, String surname, JobTitles position, int salary, Date dateOfEmployment) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    //Метод получения имени
    public String getName() {
        return name;
    }

    //Метод изменения имени
    public void setName(String name) {
        this.name = name;
    }

    //Метод получения фамилии
    public String getSurname() {
        return surname;
    }

    //Метод изменения фамилии
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Метод получения должности
    public JobTitles getPosition() {
        return position;
    }

    //Метод изменения должности
    public void setPosition(JobTitles position) {
        this.position = position;
    }

    //Метод получения жалования
    public int getSalary() {
        return salary;
    }

    //Метод изменения жалования
    public void setSalary(int salary) {
        this.salary = salary;
    }

    //Метод получения даты приема на работу
    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    //Метод изменения даты приема на работу
    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    //Метод вывода информации о работнике в консоль
    public void infoEmployee() {
        System.out.println("Информация о работнике: ");
        System.out.println("Имя: " + name + ", фамилия: " + surname + ", должность: " + position + ", зарплата: "
                + salary + ", дата трудоустройства: " + dateOfEmployment);
    }


    //Метод, возвращающий ежемесячную премию
    public abstract double bonusMonthly();

    //Переопределяем метод equals(Object obj)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (salary != employee.salary) return false;
        if (!name.equals(employee.name)) return false;
        if (!surname.equals(employee.surname)) return false;
        if (position != employee.position) return false;
        return dateOfEmployment.equals(employee.dateOfEmployment);
    }

    //Переопределяем метод hashCode()
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + salary;
        result = 31 * result + dateOfEmployment.hashCode();
        return result;
    }

    //Переопределяем метод toString()
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name = '").append(name).append('\'');
        sb.append(", surname = '").append(surname).append('\'');
        sb.append(", position = ").append(position);
        sb.append(", salary = ").append(salary);
        sb.append(", dateOfEmployment = ").append(dateOfEmployment);
        sb.append('}');
        sb.append('\n');
        return sb.toString();
    }
}

