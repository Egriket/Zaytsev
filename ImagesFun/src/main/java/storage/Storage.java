package storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Storage {
    public static List<String> imagesPath;

    private Storage(){}

    static {
        imagesPath = Collections.synchronizedList(new ArrayList<String>());
    }

    public static List<String> getImagesPath() {
        return imagesPath;
    }
}
