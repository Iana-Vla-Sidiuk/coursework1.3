package organization;


import java.util.*;

public class Department {
    private String nameDepartment; //имя подразделения
    private Employee[] arrayEmployee = {}; //массив работников подразделения
    private static int counter = 0; //счетчик для создания id (автоинкремент)
    private int id; //id подразделения
    final private static String nameOrganization = "ВЕКТОР"; //имя организации

    private ArrayList<FullDayEmployee> arrayListFullDayEmployee; //коллекция штатных сотрудников
    private ArrayList<HalfDayEmployee> arrayListHalfDayEmployee; //коллекция внешних совместителей
    private ArrayList<BusinessTraveller> arrayListBusinessTraveller; //коллекция сотрудников в командировке

    //Инициализация: каждому новому экземпляру класса Department присваивается id (автоинкремент)
    {
        id = ++counter;
    }

    public Department() {
    }

    //Конструктор, который принимает имя подразделения
    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
        this.arrayEmployee = arrayEmployee;
    }

    //Конструктор, который принимает имя подразделения и массив работников подразделения
    public Department(String nameDepartment, Employee[] arrayEmployee) {
        this.nameDepartment = nameDepartment;
        this.arrayEmployee = arrayEmployee;
    }

    //Метод получения имени подразделения
    public String getNameDepartment() {
        return nameDepartment;
    }

    //Метод изменения имени подразделения
    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    //Метод вывода информации о департаменте в консоль
    public void infoDepartment() {
        System.out.println("Информация о подразделении: ");
        System.out.println("Имя подразделения: " + nameDepartment + ", имя организации: " + nameOrganization + ", id: " + id);
    }

    //Метод вывода информации о работниках департамента в консоль
    public void infoEmployeeOfDepartment() {
        System.out.println("Информация о работниках подразделения: ");
        System.out.println("Имя подразделения: " + nameDepartment);
        System.out.println("Работники: ");
        for (int i = 0; i < arrayEmployee.length; i++) {
            System.out.println("Имя: " + arrayEmployee[i].getName() + ", фамилия: " + arrayEmployee[i].getSurname()
                    + ", должность: " + arrayEmployee[i].getPosition() + ", зарплата: " + arrayEmployee[i].getSalary()
                    + ", дата трудоустройства: " + arrayEmployee[i].getDateOfEmployment());
        }
    }

    //Метод, который возвращает общее число работников подразделения
    public int countEmployee() {
        return arrayEmployee.length;
    }

    //Метод, который возвращает суммарную зарплату всех работников подразделения
    public double sumSalary() {
        double sum = 0;
        for (Employee employee : arrayEmployee) {
            sum += employee.getSalary();
        }
        return sum;
    }

    //Метод, который возвращает ссылку на работника по фамилии и имени
    public Employee returnEmployee(String name, String surname) {
        Employee res = arrayEmployee[0];
        for (int i = 0; i < arrayEmployee.length; i++) {
            if (Objects.equals(name, arrayEmployee[i].getName()) && Objects.equals(surname, arrayEmployee[i].getSurname())) {
                res = arrayEmployee[i];
            }
        }
        return res;
    }

    //Метод увольнения работника (принимает фамилию, имя, должность)
    public void removeEmployee(String name, String surname, JobTitles position) {
        Employee[] array = new Employee[arrayEmployee.length - 1];
        int index = -1;
        //Находим индекс элемента в массиве для работника, которого необходимо удалить
        for (int i = 0; i < arrayEmployee.length; i++) {
            if (name == arrayEmployee[i].getName() && surname == arrayEmployee[i].getSurname()
                    && position == arrayEmployee[i].getPosition()) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Данный работник не существует!");
        } else {
            for (int i = 0; i < arrayEmployee.length; i++) {
                if (i != index) { // Копируем все элементы массива кроме элемента с индексом работника, которого необходимо удалить
                    int newIndex = i < index ? i : i - 1;
                    array[newIndex] = arrayEmployee[i];
                }
            }
            arrayEmployee = array;
            for (int i = 0; i < arrayEmployee.length; i++) {
                System.out.println(arrayEmployee[i].toString());
            }
        }
    }


    //Метод приема работника на работу (принимает ссылку на работника, добавляет новый элемент массива в конец массива
    public void addEmployee(Employee addEmployee) {
        Employee[] array = new Employee[arrayEmployee.length + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i == array.length - 1 ? addEmployee : arrayEmployee[i];
        }
        arrayEmployee = array;
        for (int i = 0; i < arrayEmployee.length; i++) {
            System.out.println(arrayEmployee[i].toString());
        }

    }

    //Метод, который возвращает массив работников отдела
    public Employee[] getArrayEmployee() {
        return arrayEmployee;
    }

    //Метод, который возвращает массив работников отдела, отсортированный по фамилии и имени работника
    public Employee[] sorted(Employee[] sortArray) {

        Arrays.sort(sortArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int emp = o1.getSurname().compareTo(o2.getSurname());
                if (emp == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return emp;
            }
        });
        return sortArray;
    }

    //Метод, возвращающий список (ArrayList<FullDayEmployee>) штатных сотрудников
    public ArrayList<FullDayEmployee> listFullDayEmployee() {
        arrayListFullDayEmployee = new ArrayList<>();
        for (int i = 0; i < arrayEmployee.length; i++) {
            if (arrayEmployee[i] instanceof FullDayEmployee) {
                arrayListFullDayEmployee.add((FullDayEmployee) arrayEmployee[i]);
            }
        }
        return arrayListFullDayEmployee;
    }

    //Метод, возвращающий список (ArrayList<HalfDayEmployee>) внешних совместителей
    public ArrayList<HalfDayEmployee> listHalfDayEmployee() {
        arrayListHalfDayEmployee = new ArrayList<>();
        for (int i = 0; i < arrayEmployee.length; i++) {
            if (arrayEmployee[i] instanceof HalfDayEmployee) {
                arrayListHalfDayEmployee.add((HalfDayEmployee) arrayEmployee[i]);
            }
        }
        return arrayListHalfDayEmployee;
    }

    //Метод, возвращающий список (ArrayList<BusinessTraveller >) сотрудников, находящихся в командировке в данное время
    public ArrayList<BusinessTraveller> listBusinessTravellerNow() {
        arrayListBusinessTraveller = new ArrayList<>();
        Date date = new Date(); //текущая дата
        for (int i = 0; i < listFullDayEmployee().size(); i++) {
            //Проверяем, есть у штатного сотрудника командировка в указанную дату или нет
            if (listFullDayEmployee().get(i).getBusinessTravel2(date)) {
                arrayListBusinessTraveller.add(listFullDayEmployee().get(i));
            }
        }
        return arrayListBusinessTraveller;
    }

    //Метод, возвращающий список (ArrayList<BusinessTraveller >) сотрудников, находящихся в командировке указанного числа
    public ArrayList<BusinessTraveller> listBusinessTraveller(Date date) {
        arrayListBusinessTraveller = new ArrayList<>();
        for (int i = 0; i < listFullDayEmployee().size(); i++) {
            //Проверяем, есть у штатного сотрудника командировка в указанную дату или нет
            if (listFullDayEmployee().get(i).getBusinessTravel2(date)) {
                arrayListBusinessTraveller.add(listFullDayEmployee().get(i));
            }
        }
        return arrayListBusinessTraveller;
    }

    //Переопределяем метод toString()
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("nameDepartment = '").append(nameDepartment).append('\'');
        sb.append(", arrayEmployee = ").append(Arrays.toString(arrayEmployee));
        sb.append(", id=").append(id);
        sb.append(", arrayListFullDayEmployee = ").append(arrayListFullDayEmployee);
        sb.append(", arrayListHalfDayEmployee = ").append(arrayListHalfDayEmployee);
        sb.append(", arrayListBusinessTraveller = ").append(arrayListBusinessTraveller);
        sb.append('}');
        sb.append('\n');
        return sb.toString();
    }
}
