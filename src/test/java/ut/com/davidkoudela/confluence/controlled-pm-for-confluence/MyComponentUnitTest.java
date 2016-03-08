package ut.com.davidkoudela.confluence.controlled-pm-for-confluence;

import org.junit.Test;
import com.davidkoudela.confluence.controlled-pm-for-confluence.api.MyPluginComponent;
import com.davidkoudela.confluence.controlled-pm-for-confluence.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}