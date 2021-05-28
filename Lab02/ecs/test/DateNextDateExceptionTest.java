
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest
{

    // Date inserted
    private Date d;

    // Constructor
    public DateNextDateExceptionTest(Date d) {
        this.d = d;
    }   
    
    @Parameterized.Parameters
    public static List<Date> data() {
        List<Date> params = new LinkedList<Date>();
        params.add(new Date(1500,2,31)); // Test case 16
        params.add(new Date(1500,2,29)); // Test case 17
        params.add(new Date(-1,10,20)); // Test case 18
        return params;
    }

    @Test
    public void TestDateException() {
        Assert.assertThrows(IllegalArgumentException.class, d);
    }
}
