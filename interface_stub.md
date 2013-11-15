Stub out some of the class and method signatures for a media player. Pseudo code is fine.
What sorts of considerations can be made to minimize code? Do these considerations outweigh readibility?

For example:

```java
public interface SystemAudio {

    boolean open(Stream mediaStream);
    
    boolean close(Stream mediaStream);

}

public class AndroidSystemAudio implements SystemAudio {

    @Override
    public boolean open(Stream mediaStream) {
        ...
    }
    
    @Override
    public boolean close(Stream mediaStream) {
        ...
    }
    
}

public class DesktopSystemAudio implements SystemAudio {

    ...
    
}
```
