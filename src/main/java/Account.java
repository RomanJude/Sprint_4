public class Account {

    private final String name;
    private char space = ' ';
    private final int minLenght = 3;
    private final int maxLenght = 19;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        int length = name.length();
        if (name.length() >= minLenght && name.length() <= maxLenght) {
            if (name.contains(String.valueOf(space)) && name.charAt(0) != space && name.charAt(length - 1) != space) {
                int spaceCount = 0;
                for(int i = 0; i <= length-1; i++) {
                    if (name.charAt(i) == space) {
                        spaceCount += 1;
                    }
                }
                if (spaceCount == 1) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}