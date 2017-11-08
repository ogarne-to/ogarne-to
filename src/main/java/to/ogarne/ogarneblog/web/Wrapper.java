package to.ogarne.ogarneblog.web;

import java.util.List;

public class Wrapper<T> {
    private List<T> objects;

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }
}
