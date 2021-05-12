package com.github.jenya705.hints;

import java.util.ArrayList;
import java.util.List;

public class Hints {

    private Hints() {}

    public static List<String> getHints(String str, List<String> options) {
        boolean[] failed = new boolean[options.size()];
        boolean[] savedFailed = new boolean[options.size()];
        int current = 0;
        for (int i = 0; i < str.length(); ++i){
            boolean someNotFailed = false;
            for (int j = 0; j < failed.length; ++j) {
                if (failed[j]) continue;
                if (options.get(j).length() <= i || options.get(j).charAt(i) != str.charAt(i)) {
                    failed[j] = true;
                }
                else {
                    someNotFailed = true;
                }
            }
            if (!someNotFailed) {
                continue;
            }
            savedFailed = failed.clone();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < savedFailed.length; ++i) if (!savedFailed[i]) result.add(options.get(i));
        return result;
    }

}
