package racingcar;

import java.util.regex.Pattern;

public class GameException {
    private static final Pattern LOWER_CASE_PATTERN = Pattern.compile("^[a-z]*$");
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validatePlayerCarNameLengthRange(String carName) {
        if (!(carName.length() <= MAX_CAR_NAME_LENGTH))
            throw new IllegalArgumentException("자동차 이름은 5글자 이하를 입력해야 합니다.");
    }

    public void validatePlayerCarNameType(String carName) {
        if (isNumber(carName))
            throw new IllegalArgumentException("자동차 이름은 숫자 없이 입력해야 합니다.");
    }

    public void validatePlayerCarNameOnlyLowerCase(String carName) {
        if (!LOWER_CASE_PATTERN.matcher(carName).matches())
            throw new IllegalArgumentException("자동차 이름은 소문자로만 입력해야 합니다.");
    }

    public void validatePlayerCarNameBlank(String carName) {
        if (carName.contains(" ") || carName.equals(""))
            throw new IllegalArgumentException("자동차 이름은 공백없이 입력해야 합니다.");
    }

    private boolean isNumber(String carName) {
        for (char carNameWord : carName.toCharArray()) {
            if (Character.isDigit(carNameWord))
                return true;
        }
        return false;
    }
}