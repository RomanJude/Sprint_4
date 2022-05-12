import io.qameta.allure.Step;

public class Account {

    public Account(String name) {
        this.name = name;
    }

    private final String name;
    private char space = ' ';
    private final int minLenght = 3;
    private final int maxLenght = 19;

    @Step("Проверка текста для эмбоссирования")// добавил аннотацию в соответствии с замечаниями
    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        }
        int length = name.length();
        boolean isLengthValid = name.length() >= minLenght && name.length() <= maxLenght; // добавил переменную в соответствии с замечаниями
        boolean isEndSpacesValid = name.contains(String.valueOf(space)) && name.charAt(0) != space && name.charAt(length - 1) != space; // добавил переменную в соответствии с замечаниями
        return isLengthValid && isEndSpacesValid && countSpaces();
    }

    @Step("Подсчёт количества пробелов")
    // добавил аннотацию в соответствии с замечаниями и вынес подсчёт пробелов в отдельный метод
    private boolean countSpaces() {
        int spaceCount = 0;
        for (int i = 0; i <= name.length() - 1; i++) {
            if (name.charAt(i) == space) {
                spaceCount += 1;
            }
        }
        return spaceCount == 1;
    }
}