class Decoder {

    private static final char [] upperCaseCyrillic = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М',
                                                      'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
                                                      'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    private final static int LETTERS_IN_ALPHABET = 33;

    static String decode(String encodedString, int offset) {
        int index = 0;
        offset = offset % LETTERS_IN_ALPHABET;
        StringBuilder decodedString = new StringBuilder();
        if (encodedString != null) {
            for (char ch : encodedString.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (Character.isUpperCase(ch)) {
                        for (char c: upperCaseCyrillic) {
                            if (c != ch) {
                                index++;
                                continue;
                            }
                            break;
                        }
                        decodedString.append(
                                upperCaseCyrillic[(LETTERS_IN_ALPHABET + index - offset) % LETTERS_IN_ALPHABET]);
                        index = 0;
                    } else {
                        for (char c: upperCaseCyrillic) {
                            if (Character.toLowerCase(c) != ch) {
                                index++;
                                continue;
                            }
                            break;
                        }
                        decodedString.append(Character.toLowerCase(
                                upperCaseCyrillic[(LETTERS_IN_ALPHABET + index - offset) % LETTERS_IN_ALPHABET]));
                        index = 0;
                    }
                } else decodedString.append(ch);
            }
        }
        return decodedString.toString();
    }
}
