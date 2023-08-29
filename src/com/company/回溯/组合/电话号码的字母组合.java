package company.回溯.组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiu
 * @create 2023-07-16 18:17
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(new 电话号码的字母组合().letterCombinations("234"));
    }

    HashMap<Character, Character[]> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
        back1(digits, 0);
        return res;
    }

    //     index表示 电话号码第几个数字
    void back(String digits, int index) {
        if (index == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) sb.append(c);
            res.add(sb.toString());
            return;
        }
        char[] chars = digits.toCharArray();
        Character[] characters = map.get(index);
        for (int i = 0; i < characters.length; i++) {
            path.add(characters[i]);
            back(digits, index + 1);
            path.removeLast();
        }

    }

    void back1(String digits, int index) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            path.forEach(sb::append);
            res.add(sb.toString());
            return;
        }
        Character[] characters = map.get(digits.charAt(index));
        for (int j = 0; j < characters.length; j++) {
            path.add(characters[j]);
            back1(digits, index + 1);
            path.remove(path.size() - 1);
        }
    }

}
