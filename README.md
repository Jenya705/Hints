# Hints
Hints library for java

Very small and useful library
# Example

```java
import com.github.jenya705.hints.Hints;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str = "pr";
        List<String> options = Arrays.asList("pray", "print", "exit", "kill");
        List<String> hints = Hints.getHints(str, options);
        
        System.out.println("I think you are not right with action" +
                ", maybe you want to: " + hints.toString());
        
    }
}
```
