package ut.com.davidkoudela.confluence.controlledpm;

import org.junit.Test;
import com.davidkoudela.confluence.controlledpm.api.MyPluginComponent;
import com.davidkoudela.confluence.controlledpm.impl.MyPluginComponentImpl;

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