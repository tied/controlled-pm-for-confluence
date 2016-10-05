package ut.com.davidkoudela.confluence.controlledpm.context;

import com.atlassian.confluence.plugins.createcontent.api.contextproviders.BlueprintContext;
import com.davidkoudela.confluence.controlledpm.context.ControlledPMHostContextProvider;
import junit.framework.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: Testing {@link ControlledPMHostContextProvider}
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-04-28
 */
public class ControlledPMHostContextProviderTest {
    class ControlledPMHostContextProviderDummy extends ControlledPMHostContextProvider {
        public BlueprintContext updateBlueprintContext(BlueprintContext blueprintContext) {
            return super.updateBlueprintContext(blueprintContext);
        }
    }

    @Test
    public void testUpdateBlueprintContext() {
        ControlledPMHostContextProviderDummy controlledPMContextProviderDummy = new ControlledPMHostContextProviderDummy();
        BlueprintContext blueprintContext1 = new BlueprintContext();
        BlueprintContext blueprintContext2 = new BlueprintContext();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 2; i++) {
            blueprintContext1 = controlledPMContextProviderDummy.updateBlueprintContext(blueprintContext1);
            Date date = new Date();
            blueprintContext2 = controlledPMContextProviderDummy.updateBlueprintContext(blueprintContext2);
            String blueprintString1 = blueprintContext1.getMap().values().toString();
            String blueprintString2 = blueprintContext2.getMap().values().toString();
            if (0 != blueprintString1.compareTo(blueprintString2)) {
                continue;
            }
            Assert.assertEquals("[<time datetime=\"" + dateFormat.format(date) + "\" />]", blueprintString1);
            return;
        }
        Assert.fail("Blueprints are not equal even after several iterations.");
    }
}
