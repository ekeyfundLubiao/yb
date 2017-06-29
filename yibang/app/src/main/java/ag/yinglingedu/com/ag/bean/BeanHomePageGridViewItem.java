package ag.yinglingedu.com.ag.bean;

/**
 * Created by M 4700 on 2017/6/2.
 */

public class BeanHomePageGridViewItem {
    private String name;
    private int imageId;

    public BeanHomePageGridViewItem(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
