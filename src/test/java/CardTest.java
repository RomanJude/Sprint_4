import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CardTest {

    private String name;
    private boolean expected;

    public CardTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Иван Иванов", true},
                {"Иазфывапролдйцу gд", true},
                {"Иазфывапролдйцу gдq", true},
                {"И з", true},
                {"Иa p", true},
                {"И ", false},
                {"Иазфывапролдйцу gдqq", false},
                {"Иван  Иванов", false},
                {" ИванИванов", false},
                {"ИванИванов ", false},
                {"И и и", false},
                {"Иаз", false},
                {null, false},
                {"", false},
        };
    }

    @Test
    public void printCardholderNamePrint() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

}