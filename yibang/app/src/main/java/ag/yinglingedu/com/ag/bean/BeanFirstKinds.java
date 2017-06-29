package ag.yinglingedu.com.ag.bean;

/**
 * Created by M 4700 on 2017/6/25.
 */

public class BeanFirstKinds {
    private String class_id;
    private String class_name;

    public BeanFirstKinds(String class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_id() {

        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}
