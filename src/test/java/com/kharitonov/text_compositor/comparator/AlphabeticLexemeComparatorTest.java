package com.kharitonov.text_compositor.comparator;

import com.kharitonov.text_compositor.component.TextComponent;
import com.kharitonov.text_compositor.data_provider.StaticDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.assertEquals;

public class AlphabeticLexemeComparatorTest {
    private final Comparator<TextComponent> comparator =
            new AlphabeticLexemeComparator();

    @DataProvider
    @Test
    public Object[][] dataCompare() {
        TextComponent component1 = StaticDataProvider.LEXEME_COMPARE_1;
        TextComponent component2 = StaticDataProvider.LEXEME_COMPARE_2;
        return new Object[][]{
                {component1, component2, 3},
                {component2, component1, -3},
                {component1, component1, 0}
        };
    }

    @Test(dataProvider = "dataCompare")
    public void testCompare(TextComponent component1,
                            TextComponent component2,
                            int expected) {
        int actual = comparator.compare(component1, component2);
        assertEquals(actual, expected);
    }
}