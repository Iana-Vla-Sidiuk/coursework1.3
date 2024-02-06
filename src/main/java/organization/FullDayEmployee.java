package organization;

import java.util.*;

public class FullDayEmployee extends Employee implements BusinessTraveller {

    private ArrayList<BusinessTravel> arrayListBusinessTravel; //командировки сотрудника

    public FullDayEmployee() {

        super();
    }

    //Конструктор, который принимает имя и фамилию (должность и жалование - дефолтные)
    public FullDayEmployee(String name, String surname) {

        super(name, surname);
        this.arrayListBusinessTravel = new ArrayList<>();
    }

    //Конструктор, который принимает имя, фамилию, должность, жалование
    public FullDayEmployee(String name, String surname, JobTitles position, int salary) {
        super(name, surname, position, salary);
        this.arrayListBusinessTravel = new ArrayList<>();
    }

    //Конструктор, который принимает имя, фамилию, должность, жалование, дату приема на работу
    public FullDayEmployee(String name, String surname, JobTitles position, int salary, Date dateOfEmployment) {
        super(name, surname, position, salary, dateOfEmployment);
        this.arrayListBusinessTravel = new ArrayList<>();
    }

    //Метод получения командировок сотрудника
    public ArrayList<BusinessTravel> getArrayListBusinessTravel() {
        return arrayListBusinessTravel;
    }

    //Метод изменения командировок сотрудника
    public void setArrayListBusinessTravel(ArrayList<BusinessTravel> arrayListBusinessTravel) {
        this.arrayListBusinessTravel = arrayListBusinessTravel;
    }

    //Метод, возвращающий ежемесячную премию. Она вычисляется как число полных лет, которые проработал сотрудник в компании,
    //деленое на 20. Кроме того, если текущий месяц – январь, то премия увеличивается на размер оклада
    @Override
    public double bonusMonthly() {
        Calendar calendar = Calendar.getInstance();
        Date endDate = new Date();
        long diff = endDate.getTime() - getDateOfEmployment().getTime();
        double res = (double) diff / (double) 31536000000L / (double) 20;
        double bonus = calendar.get(Calendar.MONTH) == 0 ? res + getSalary() : res;
        return bonus;
    }

    //Метод, который добавляет командировку сотруднику
    public void addBusinessTravel(BusinessTravel item) {
        //Проверка на наличие дублей по дате отбытия и дате прибытия в командировку
        boolean flag = true;
        for (int i = 0; i < arrayListBusinessTravel.size(); i++) {
            if (arrayListBusinessTravel.get(i).getDateDeparture() == item.getDateDeparture()
                    || arrayListBusinessTravel.get(i).getDateArrival() == item.getDateArrival()) {
                System.out.println("У данного сотрудника уже существует командировка в указанные даты: " + item.getDateDeparture() +
                        " - " + item.getDateArrival());
                flag = false;
                break;
            }
        }
        if (flag) {
            arrayListBusinessTravel.add(item);
        }
    }

    //Метод, который удаляет командировку у сотрудника
    @Override
    public void removeBusinessTravel(Date dateDeparture) {
        boolean flag = true;
        for (int i = 0; i < arrayListBusinessTravel.size(); i++) {
            if (arrayListBusinessTravel.get(i).getDateDeparture() == dateDeparture) {
                arrayListBusinessTravel.remove(i);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("У данного сотрудника отсутствуют командировки с указанной датой отбытия " + dateDeparture);
        }
    }

    //Метод, возвращающий экземпляр класса BusinessTravel по дате в диапазоне между началом и концом командировки
    @Override
    public BusinessTravel getBusinessTravel(Date date) {
        int index = 0;
        for (int i = 0; i < arrayListBusinessTravel.size(); i++) {
            if (date == arrayListBusinessTravel.get(i).getDateDeparture() || date == arrayListBusinessTravel.get(i).getDateArrival()
                    || date.after(arrayListBusinessTravel.get(i).getDateDeparture())
                    && date.before(arrayListBusinessTravel.get(i).getDateArrival())) {
                index = i;
            }
        }
        return arrayListBusinessTravel.get(index);
    }

    //Метод, возвращающий среднюю продолжительность командировок работника
    @Override
    public double lengthBusinessTravel() {
        double averageLength;
        double count = 0;
        double sum = 0;
        for (int i = 0; i < arrayListBusinessTravel.size(); i++) {
            sum += arrayListBusinessTravel.get(i).periodBusinessTravel();
            count++;
        }
        averageLength = count != 0 ? sum / count : 0; //для коллекции с 0 элементов учитываем, что делить на 0 нельзя
        return averageLength;
    }

    //Метод, возвращающий средний интервал между командировками в днях
    @Override
    public double intervalBusinessTravel() {
        double count = 0;
        double sum = 0;
        double interval;
        double diff = 0;
        //Сортируем командировки работника по возрастанию даты отбытия в командировку
        Collections.sort(arrayListBusinessTravel, new Comparator<BusinessTravel>() {
            @Override
            public int compare(BusinessTravel o1, BusinessTravel o2) {
                return (int) ((o1.getDateDeparture().getTime() - o2.getDateDeparture().getTime()) / 86400000);
            }
        });
        //Подсчитываем средний интервал между командировками в отсортированной коллекции с командировками работника
        for (int i = 0; i < arrayListBusinessTravel.size() - 1; i++) {
            diff = (double) (arrayListBusinessTravel.get(i + 1).getDateDeparture().getTime()
                    - arrayListBusinessTravel.get(i).getDateArrival().getTime()) / (double) 86400000;
            sum = sum + diff;
            count++;
        }
        interval = count != 0 ? sum / count : 0; //для коллекции с 0 элементов учитываем, что делить на 0 нельзя
        return interval;
    }

    //Метод, возвращающий true/false в зависимости от того, есть у сотрудника командировка в указанную дату или нет
    public boolean getBusinessTravel2(Date date) {
        int index = -1;
        boolean flag = true;
        for (int i = 0; i < arrayListBusinessTravel.size(); i++) {
            if (date == arrayListBusinessTravel.get(i).getDateDeparture() || date == arrayListBusinessTravel.get(i).getDateArrival()
                    || date.after(arrayListBusinessTravel.get(i).getDateDeparture())
                    && date.before(arrayListBusinessTravel.get(i).getDateArrival())) {
                index = i;
            }
        }
        flag = index == -1 ? false : true;
        return flag;
    }


}

