package mishamba.day2.controller.impl;

import com.mishamba.day2.controller.exception.ControllerException;
import com.mishamba.day2.controller.impl.ControllerImpl;
import com.mishamba.day2.model.CustomText;
import mishamba.day2.controller.impl.dataprovider.TextProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ControllerImplTest {

    @Test(dataProviderClass = TextProvider.class, dataProvider = "text provider")
    public void testSplitText(String text , CustomText expectedText) {
        try {
            CustomText actualText = ControllerImpl.getInstance().splitText(text);
            assertEquals(actualText, expectedText);
        } catch (ControllerException exception) {
            fail(exception.toString());
        }
    }
}