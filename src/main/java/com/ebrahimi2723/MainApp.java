package com.ebrahimi2723;



import com.ebrahimi2723.data.DataBase;
import com.ebrahimi2723.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ebrahimi2723.io.Io.*;

public class MainApp {
    public static void main(String[] args) {
        while (true){

            print("Hi welcome to student program please select one option");
            print("[1]: add new student");
            print("[2]: list of student");
            print("[3]: delete student");
            print("[4]: delete student For ever");
            print("[5]: Remind Capacity");


            switch (Integer.parseInt(input())){

                case 1:
                    try {
                        addStudent();
                    }catch (Exception e){
                        print(e.getMessage());
                    }
                    break;


                case 2:
                    try {
                        showListOfstudent();

                    }catch (Exception e){
                        print(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        softdeletByIdCard();
                    }catch (Exception e){
                        print(e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        hardDeletByIdcard();

                    }catch (Exception e){
                        print(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        showCapcity();

                    }catch (Exception e){
                        print(e.getMessage());
                    }
                    break;
                case 0:
                    print("Have Nice Day!");
                    return;
                default:
                    print("invalid selection");
                    break;
            }
        }
    }

    private static void showCapcity() throws SQLException {


       String sqlSelect = "SELECT `capacity` FROM `capacity`";
        DataBase dataBase = new DataBase();
        Statement statement = dataBase.selectSql(sqlSelect);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int capacity = 100 -resultSet.getInt(1);
            print("Capacity remind is: "+capacity+"");
            print(resultSet.getInt(1)+" Student is regeneration is complete");
        }
    }

    private static void hardDeletByIdcard() throws SQLException {
        print("For Remove student enter his StudentID \n *** WARNING INFORMATION IS NEVER CAME BACK ***");
        int studentId = Integer.parseInt(input());
        String sql ="DELETE FROM `user` WHERE `id`="+studentId;
        DataBase dataBase = new DataBase();
        dataBase.sqlInsert(sql);
        decreseCapacity();

    }

    private static void showListOfstudent() throws SQLException {

        String sql ="SELECT * FROM `user` ";
        DataBase dataBase = new DataBase();
       Statement statement = dataBase.selectSql(sql);
       ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            print("StudentID : "+resultSet.getInt(1)+"  _ Name: "+resultSet.getString(2)+"  _ Mark: "+resultSet.getFloat(3)+"  _ Year: "+resultSet.getInt(4)+"  _ soft delete: "+resultSet.getInt(5)+"");
        }
    }

    private static void softdeletByIdCard() throws SQLException {
        print("For Remove student enter his StudentID");
        int studentId = Integer.parseInt(input());
        String sql = "UPDATE `user` SET `isdelete`='0' WHERE `id`="+studentId;
        DataBase dataBase = new DataBase();
        dataBase.sqlInsert(sql);
       decreseCapacity();
    }

    private static void addStudent() throws Exception {
        ///////////////////////////create new object from student///////////////////////////////////////////////////////


        Student student = new Student();
        print("enter Full name od student");
        student.setFullName(input());
        print("enter Average of mark");
        student.setMark(Float.parseFloat(input()));
        student.setYear(2020);
        student.setIsDeleted(1);



        ///////////////////////////creat sql order for insert student in dataBase///////////////////////////////////////
        // ex INSERT INTO `user`( `fullname`, `mark`, `year`, `isdelete`) VALUES ('mohammad','20.0','2020','1')/////////


        String sqlInsert = "INSERT INTO `user`( `fullname`, `mark`, `year`, `isdelete`) VALUES ('"+student.getFullName()+
                "','"+student.getMark().toString()+"','"+student.getYear().toString()+"','"+ student.getIsDeleted()+"')";
        DataBase dataBase = new DataBase();
        dataBase.sqlInsert(sqlInsert);
//        print(sqlInsert);


        ////////////////////////////////// capacity of student + 1 /////////////////////////////////////////////////////



        String selectCapacity= "SELECT `capacity` FROM `capacity`";
       Statement statement = dataBase.selectSql(selectCapacity);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int capacity = resultSet.getInt(1)+1;
            String capacityUpdate = "UPDATE `capacity` SET `capacity`='"+capacity+"' WHERE `id`=0;";
            dataBase.sqlInsert(capacityUpdate);
        }
    }

   public static void decreseCapacity() throws SQLException {
        DataBase dataBase = new DataBase();
       String sqlCapcity = "SELECT  `capacity` FROM `capacity`";
       Statement statement = dataBase.selectSql(sqlCapcity);
       ResultSet resultSet = statement.getResultSet();
       int Capacity = 0;
       while (resultSet.next()){
           Capacity = resultSet.getInt(1)-1;
       }

       String updateCapacity = "UPDATE `capacity` SET `capacity`='"+Capacity+"'";
       dataBase.sqlInsert(updateCapacity);
       print("Remove successfully");
   }

    public static boolean checkisSoftDeleted(int value){
        String sql = "SELECT `` FROM `user` WHERE 1"
    }
}
