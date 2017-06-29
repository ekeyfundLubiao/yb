package ag.yinglingedu.com.ag.bean;

/**
 * Created by M 4700 on 2017/6/25.
 */

public class BeanSecKinds {
    private String class_id;
    private String class_name;

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    private String parent_id;

    public BeanSecKinds(String class_id, String class_name, String parent_id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.parent_id = parent_id;
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
