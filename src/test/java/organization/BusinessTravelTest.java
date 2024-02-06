package organization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

public class BusinessTravelTest {

    BusinessTravel businessTravel1;

    //Создание тестовых данных
    @Before
    public void setUp() throws IncorrectDateException {
        Calendar calendar11 = Calendar.getInstance();
        calendar11.set(2022, 4, 1, 9, 00, 00);
        Date dateDeparture11 = calendar11.getTime();
        Calendar calendar21 = Calendar.getInstance();
        calendar21.set(2022, 4, 4, 9, 00, 00);
        Date dateArrival21 = calendar21.getTime();
        businessTravel1 = new BusinessTravel(dateDeparture11, dateArrival21, 19000, 500);
    }

    //Тестирование метода, возвращающего число полных дней между датами отбытия и прибытия
    @Test
    public void testPeriodBusinessTravel() {
        double expected = 4 - 1;
        double actual = businessTravel1.periodBusinessTravel();
                Assert.assertEquals(expected, actual, 0.01);
    }

    //Тестирование метода, возвращающего общую сумму затраченных на командировку денег (трансфер + суточные * кол-во дней)
    @Test
    public void testCostBusinessTravel() {
        double expected = 19000 + 500 * (4 - 1);
        double actual = businessTravel1.costBusinessTravel();
        Assert.assertEquals(expected, actual, 0.01);
    }
}