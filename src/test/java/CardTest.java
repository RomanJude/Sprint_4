import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    @DisplayName("Проверка печати имени владельца карты, соответствующего всем требованиям")
    public void printCardholdernameWithAllRequirements(){
        boolean expected = true;
        String name = "Иван Иванов";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка граничного значения из одного символа и пробела")
    public void printCardholdernameOneSymbolAndSpace(){
        boolean expected = false;
        String name = "И ";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка граничного значения имени держателя карты из двух символов и пробела")
    public void printCardholdernameTwoSymbolsAndSpace(){
        boolean expected = true;
        String name = "И з";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка граничного значения имени держателя карты из трёх символов и пробела")
    public void printCardholdernameThreeSymbolsAndSpace(){
        boolean expected = true;
        String name = "Иa p";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка граничного значения имени держателя карты из семнадцати символов и пробела")
    public void printCardholdernameSeventeenSymbolsAndSpace(){
        boolean expected = true;
        String name = "Иазфывапролдйцу gд";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка граничного значения имени держателя карты из восемнадцати символов и пробела")
    public void printCardholdernameEighteenSymbolsAndSpace() {
        boolean expected = true;
        String name = "Иазфывапролдйцу gдq";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка граничного значения имени держателя карты из девятнадцати символов и пробела")
    public void printCardholdernameNineteenSymbolsAndSpace() {
        boolean expected = false;
        String name = "Иазфывапролдйцу gдqq";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка имени держателя карты содержащего два пробела подряд")
    public void printCardholdernameTwoSpaces(){
        boolean expected = false;
        String name = "Иван  Иванов";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка имени держателя карты содержащего пробел в начале")
    public void printCardholdernameWithSpaceInTheBeginning() {
        boolean expected = false;
        String name = " ИванИванов";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка имени держателя карты содержащего пробел в конце")
    public void printCardholdernameWithSpaceInTheEnd() {
        boolean expected = false;
        String name = "ИванИванов ";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка имени держателя карты содержащего пробелы, чередующиеся с символами")
    public void printCardholdernameSymbolAndSpace(){
        boolean expected = false;
        String name = "И и и";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка имени держателя карты не содержащего пробелы")
    public void printCardholdernameWithoutSpace(){
        boolean expected = false;
        String name = "Иаз";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}