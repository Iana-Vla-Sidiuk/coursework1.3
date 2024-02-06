package organization;


import java.util.Date;
import java.util.Objects;

public class BusinessTravel {
    private Date dateDeparture; //дата отбытия в командировку
    private Date dateArrival; //дата прибытия из командировки
    private double costTransfer; //стоимость трансфера до места и назад
    private double daily; //суточные

    //Пустой конструктор
    public BusinessTravel() {
    }

    //Конструктор, который принимает дату отбытия в командировку, дату прибытия из командировки, стоимость трансфера,
    // суточные с обработкой исключения
    public BusinessTravel(Date dateDeparture, Date dateArrival, double costTransfer, double daily) throws IncorrectDateException {
        if (dateDeparture.after(dateArrival)){
            throw new IncorrectDateException("Дата отбытия в командировку не может быть позже даты прибытия из командировки!");
        }
        else {
            this.dateDeparture = dateDeparture;
            this.dateArrival = dateArrival;
            this.costTransfer = costTransfer;
            this.daily = daily;
        }
    }

    // Метод получения даты отбытия в командировку
    public Date getDateDeparture() {

        return dateDeparture;
    }

    // Метод изменения даты отбытия в командировку с обработкой исключения
    public void setDateDeparture(Date dateDeparture) throws IncorrectDateException{
        if (dateDeparture.after(getDateArrival())){
            throw new IncorrectDateException("Дата отбытия в командировку не может быть позже даты прибытия из командировки!");
        }
        else {
            this.dateDeparture = dateDeparture;
        }
    }

    // Метод получения даты прибытия из командировки
    public Date getDateArrival() {

        return dateArrival;
    }

    // Метод изменения даты прибытия из командировки с обработкой исключения
    public void setDateArrival(Date dateArrival) throws IncorrectDateException{
        if (dateArrival.before(getDateDeparture())){
            throw new IncorrectDateException("Дата прибытия из командировки не может быть раньше даты отбытия в командировку!");
        }
        else {
            this.dateArrival = dateArrival;
        }

    }

    // Метод получения стоимости трансфера
    public double getCostTransfer() {

        return costTransfer;
    }

    // Метод изменения стоимости трансфера
    public void setCostTransfer(double costTransfer) {

        this.costTransfer = costTransfer;
    }

    // Метод получения суточных
    public double getDaily() {

        return daily;
    }

    // Метод изменения суточных
    public void setDaily(double daily) {
        this.daily = daily;
    }

    //Метод вывода информации о командировке в консоль
    public void businessTravel() {
        System.out.println("Информация о командировке: ");
        System.out.println("Дата отбытия в командировку: " + dateDeparture + ", дата прибытия из командировки: "
                + dateArrival + ", стоимость трансфера: " + costTransfer + ", суточные: " + daily);
    }

    //Метод, возвращающий число полных дней между датами отбытия и прибытия
    public double periodBusinessTravel() {
        long diff = getDateArrival().getTime() - getDateDeparture().getTime();
        double period = (double) diff / (double) 86400000; //переводим миллисекунды в дни
        return period;
    }

    //Метод, возвращающий общую сумму затраченных на командировку денег (трансфер + суточные * кол-во дней)
    public double costBusinessTravel() {
        double sum = getCostTransfer() + (getDaily() * periodBusinessTravel());
        return sum;
    }

    //Переопределяем метод equals(Object obj)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessTravel that = (BusinessTravel) o;

        if (Double.compare(that.costTransfer, costTransfer) != 0) return false;
        if (Double.compare(that.daily, daily) != 0) return false;
        if (!dateDeparture.equals(that.dateDeparture)) return false;
        return dateArrival.equals(that.dateArrival);
    }

    //Переопределяем метод hashCode()
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dateDeparture.hashCode();
        result = 31 * result + dateArrival.hashCode();
        temp = Double.doubleToLongBits(costTransfer);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(daily);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //Переопределяем метод toString()
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusinessTravel{");
        sb.append("dateDeparture = ").append(dateDeparture);
        sb.append(", dateArrival = ").append(dateArrival);
        sb.append(", costTransfer = ").append(costTransfer);
        sb.append(", daily = ").append(daily);
        sb.append('}');
        sb.append('\n');
        return sb.toString();
    }

}

