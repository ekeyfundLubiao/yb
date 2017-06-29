package ag.yinglingedu.com.ag.bean;

/**
 * Created by M 4700 on 2017/5/28.
 */

public class BeanMine {
    private String name;
    private int imgId;

    public BeanMine(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
