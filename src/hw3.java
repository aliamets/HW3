import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hw3 {
    static Random random;
    static Scanner sc;

    public static void main(String[] args) {
        gameChose();
    }

    static void gameChose() {
        int x;
        do {
            sc = new Scanner(System.in);
            System.out.print("Выбери игру:\n" +
                    "1. Игра в цифры\n2. Игра в слова\n");
            x = sc.nextInt();
            if (x == 1) {
                guessTheNumber();

            } else if (x == 2) {
                guessTheWord();
            }

        } while (x != 1 || x != 2);
        return;
    }

    static void guessTheNumber() {
        int answer;
        random = new Random();
        sc = new Scanner(System.in);
        int count = 0;
        int maxCount = 3;
        System.out.println("Давай сыграем в игру угадай число?");
        System.out.println("Введите число от 0 до 9");
        answer = random.nextInt(10);
        do {
            count++;
            int userAnswer = sc.nextInt();
            if (userAnswer == answer) {
                System.out.println("Победа! Ты молодец!");
                break;
            } else if (userAnswer > answer) {
                System.out.println("Слишком большое число");
            } else {
                System.out.println("Слишком маленькое число");
            }
            if (count == maxCount) {
                System.out.println("Вы проиграли!\nПравильный ответ - " + answer);
            }
        } while (count != maxCount);
        System.out.println("Хочешь сыграть еще?\n" + " ДА \"1\" " + " НЕТ \"0\"");
        if (sc.nextInt() == 1) {
            gameChose();
        }
    }


    static void guessTheWord() {
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        random = new Random();
        sc = new Scanner(System.in);
        String guess = null;
        int randomIndex = random.nextInt(words.length);
        String word = words[randomIndex];
        System.out.println(Arrays.toString(words));
        do {
            System.out.print("Guess the word: ");
            guess = sc.next();
            for (int i = 0; i < 15; i++)
                if (i < word.length() && i < guess.length() &&
                        word.charAt(i) == guess.charAt(i))
                    System.out.print(word.charAt(i));
                else
                    System.out.print((word.equals(guess)) ? "" : "#");
            System.out.println();
        } while (!word.equals(guess));
        String str = "";
        System.out.println("Хочешь сыграть еще?\n" + " ДА \"1\" " + " НЕТ \"0\"");
        if (sc.nextInt() == 1) {
            gameChose();
        }
    }
}