
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateOkTest
{

    // Date inserted
    private Date d;

    // Date expected in the results
    private Date expectedDate;


    // Constructor
    public DateNextDateOkTest(Date d, Date expectedDate) {
        this.d = d;
        this.expectedDate = expectedDate;
    }
 
    @Parameterized.Parameters
    public static List<Date[]> data() {
        List<Date[]> params = new LinkedList<Date[]>();
        params.add(new Date[] {new Date(1700,6,20), new Date(1700,6,21)}); // Test case 1
        params.add(new Date[] {new Date(2005,4,15),new Date(2005,4,16) }); // Test case 2
        params.add(new Date[] {new Date(1901,7,20), new Date(1901,7,21)}); // Test case 3
        params.add(new Date[] {new Date(3456,3,27), new Date(3456,3,28)}); // Test case 4
        params.add(new Date[] {new Date(1500,2,17), new Date(1500,2,18)}); // Test case 5
        params.add(new Date[] {new Date(1700,6,29), new Date(1700,6,30)}); // Test case 6
        params.add(new Date[] {new Date(1800,11,29), new Date(1800,11,30)}); // Test case 7
        params.add(new Date[] {new Date(3453,1,29), new Date(3453,1,30)}); // Test case 8
        params.add(new Date[] {new Date(444,2,29), new Date(444,3,1)}); // Test case 9
        params.add(new Date[] {new Date(2005,4,30), new Date(2005,5,1)}); // Test case 10
        params.add(new Date[] {new Date(3453,1,30), new Date(3453,1,31)}); // Test case 11
        params.add(new Date[] {new Date(3456,3,30), new Date(3456,3,31)}); // Test case 12
        params.add(new Date[] {new Date(1901,7,31), new Date(1901,8,1)}); // Test case 13
        params.add(new Date[] {new Date(3453,1,31), new Date(3453,2,1)}); // Test case 14
        params.add(new Date[] {new Date(3456,12,31),new Date(3457,1,1) }); // Test case 15
        return params;
    }

    @Test
    public void TestNextDate() {
        Date actualDate = d.nextDate();
        Assert.assertEquals(expectedDate, actualDate);
    }

}
