package ag.yinglingedu.com.ag.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zaaach.citypicker.model.City;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.bean.BeanFirstKinds;
import ag.yinglingedu.com.ag.bean.BeanSecKinds;

/**
 * Created by M 4700 on 2017/6/25.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="ag.db";//数据库名称
    private static final int SCHEMA_VERSION=1;//版本号,则是升级之后的,升级方法请看onUpgrade方法里面的判断
    private Cursor cursor;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tab_city (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pinyin TEXT);");//城市列表
        db.execSQL("CREATE TABLE tab_kinds_one (_id INTEGER PRIMARY KEY AUTOINCREMENT, class_id TEXT, class_name TEXT);");//分类列表
        db.execSQL("CREATE TABLE tab_kinds_two (_id INTEGER PRIMARY KEY AUTOINCREMENT, class_id TEXT, class_name TEXT ,parent_id TEXT);");//分类列表
    }

    /**
     * 插入一条城市数据
     * @param city
     */
    public void insertCity(City city) {
        ContentValues cv=new ContentValues();
        cv.put("name", city.getName());
        cv.put("pinyin", city.getPinyin());
        getWritableDatabase().insert("tab_city", "name", cv);
    }

    /**
     * 插入一级分类数据
     * @param firstKinds
     */
    public void insertFirKinds(BeanFirstKinds firstKinds) {
        ContentValues cv=new ContentValues();
        cv.put("class_id", firstKinds.getClass_id());
        cv.put("class_name", firstKinds.getClass_name());
        getWritableDatabase().insert("tab_city", "name", cv);
    }

    /**
     * 插入二级分类数据
     * @param secKinds
     */
   public void insertSecKinds(BeanSecKinds secKinds) {
        ContentValues cv=new ContentValues();
        cv.put("class_id", secKinds.getClass_id());
        cv.put("class_name", secKinds.getClass_name());
        cv.put("parent_id", secKinds.getParent_id());
        getWritableDatabase().insert("tab_city", "name", cv);
    }

    /**
     * 查询所有城市数据
     * @return
     */
    public List<City>  getAllCitys(){
        List<City> list = new ArrayList<>();
        cursor = getReadableDatabase().rawQuery("select * from tab_city", null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            list.add(new City(name,pinyin));
        }
        return list;
    }

    /**
     * 查询所有一级分类数据
     * @return
     */
    public List<BeanFirstKinds>  getAllFirKinds(){
        List<BeanFirstKinds> list = new ArrayList<>();
        cursor = getReadableDatabase().rawQuery("select * from tab_kinds_one", null);
        while (cursor.moveToNext()){
            String class_id = cursor.getString(cursor.getColumnIndex("class_id"));
            String class_name = cursor.getString(cursor.getColumnIndex("class_name"));
            list.add(new BeanFirstKinds(class_id,class_name));
        }
        return list;
    }

    /**
     * 查询所有二级分类数据
     * @return
     */
    public List<BeanSecKinds>  getAllSecKinds(){
        List<BeanSecKinds> list = new ArrayList<>();
        cursor = getReadableDatabase().rawQuery("select * from tab_kinds_two", null);
        while (cursor.moveToNext()){
            String class_id = cursor.getString(cursor.getColumnIndex("class_id"));
            String class_name = cursor.getString(cursor.getColumnIndex("class_name"));
            String parent_id = cursor.getString(cursor.getColumnIndex("parent_id"));
            list.add(new BeanSecKinds(class_id,class_name,parent_id));
        }
        return list;
    }

    /**
     * 查找
     * @param name
     * @return
     */
    public String search_city(String name){
        cursor = getReadableDatabase().rawQuery("select * from tab_city where name ='"+name+"'", null);
        if (cursor.moveToNext()){
            String pinyin = cursor.getString(cursor.getColumnIndex("pinyin"));
            return pinyin;
        }
        return null;
    }

    /**
     * 清空表数据
     */
    public void cleanTab(String tabName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from '"+ tabName + "';");
    }



    /**
     * 数据库版本更新
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "tab_city");
        onCreate(db);
    }
}
