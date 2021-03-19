package com.example.databasecrudwithimage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Company.db";

    public static final String Table1_Name="Department";
    public static final String T1_Column1="Dept_Id";
    public static final String T1_Column2="Dept_Name";

    public static final String Table2_Name="Employee";
    public static final String T2_Column1="Emp_Id";
    public static final String T2_Column2="Emp_Name";
    public static final String T2_Column3="Emp_Email";
    public static final String T2_Column4="Emp_Password";
    public static final String T2_Column5="Emp_Image";
    public static final String T2_Column6="Emp_Department";

    public SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_Name, null, 1);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("Create Table Department (Dep_Id INTEGER PRIMARY KEY AUTOINCREMENT,Dep_Name TEXT)");
//        sqLiteDatabase.execSQL("Create Table Employee (Emp_Id INTERGER PRIMARY KEY AUTOINCREMENT, Emp_Name TEXT,Emp_Email TEXT,Emp_Password TEXT,Emp_Image BLOB,Emp_Department INTEGER, FOREIGN KEY (Emp_Department) REFERENCES Department (Dep_Id) )");

        sqLiteDatabase.execSQL("Create Table "+Table1_Name+" ("+T1_Column1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+T1_Column2+" TEXT)");
        sqLiteDatabase.execSQL("Create Table "+Table2_Name+" ("+T2_Column1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+T2_Column2+" TEXT,"+T2_Column3+" TEXT,"+T2_Column4+" TEXT,"+T2_Column5+" BLOB,"+T2_Column6+" INTEGER, FOREIGN KEY ("+T2_Column6+") REFERENCES "+Table1_Name+" ("+T1_Column1+") )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table1_Name);
        db.execSQL("DROP TABLE IF EXISTS "+Table2_Name);
        onCreate(db);
    }

    public boolean insertDept(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(T1_Column2,name);

        long result=db.insert(Table1_Name,null,contentValues); //-ve value on error
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }

    public Cursor getAllDept()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+Table1_Name,null);
        return result;
    }

    public boolean insertEmployee(String name,String email,String password,byte[] image,int dept)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(T2_Column2,name);
        contentValues.put(T2_Column3,email);
        contentValues.put(T2_Column4,password);
        contentValues.put(T2_Column5,image);
        contentValues.put(T2_Column6,dept);
        long result=db.insert(Table2_Name,null,contentValues); //-ve value on error
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
    public Cursor getAllEmployees()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+Table2_Name+" join "+Table1_Name+" ON "+Table2_Name+"."+T2_Column6+"="+Table1_Name+"."+T1_Column1,null);
        return result;
    }
//    public boolean updateData(int id,String name, String course , int fees){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(Column1,id);
//        contentValues.put(Column2,name);
//        contentValues.put(Column3,course);
//        contentValues.put(Column4,fees);
//        long result=db.update(Table_Name,contentValues,"St_Id=?",new String[]{ String.valueOf(id) });
//        if(result==-1)
//        {
//            return false;
//        }else
//        {
//            return true;
//        }
//    }
//    public boolean delete(int id)
//    {
//        SQLiteDatabase db=this.getWritableDatabase();
//        long result=db.delete(Table_Name,"St_Id=?",new String[]{String.valueOf(id)});
//        if(result==-1)
//        {
//            return false;
//        }else
//        {
//            return true;
//        }
//    }
}
