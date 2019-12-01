public class Decoder {

    static final char [] upperCaseCyrillic = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'M',
                                              'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
                                              'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    static final char [] lowerCaseCyrillic = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м',
                                              'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
                                              'ы', 'ь', 'э', 'ю', 'я'};

    public static String decode(String encodedString, int offset) {
        int index = 0;
        offset = offset % 33;
        StringBuilder decodedString = new StringBuilder();
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
                    decodedString.append(upperCaseCyrillic[(33 + index - offset) % 33]);
                    index = 0;
                } else {
                    for (char c: lowerCaseCyrillic) {
                        if (c != ch) {
                            index++;
                            continue;
                        }
                        break;
                    }
                    decodedString.append(lowerCaseCyrillic[(33 + index - offset) % 33]);
                    index = 0;
                }
            } else decodedString.append(ch);
        }
        return decodedString.toString();
    }
}
