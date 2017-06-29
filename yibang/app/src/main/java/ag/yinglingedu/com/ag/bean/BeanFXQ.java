package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by M 4700 on 2017/6/9.
 */

public class BeanFXQ {
    private String type;

    public List<Integer> getListBeen() {
        return listBeen;
    }

    public void setListBeen(List<Integer> listBeen) {
        this.listBeen = listBeen;
    }

    private List<Integer> listBeen;

    public BeanFXQ(String type, List<Integer> listBeen) {
        this.type = type;
        this.listBeen = listBeen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
