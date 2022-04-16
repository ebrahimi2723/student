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
            print("[5]: delete for ever");
            print("[5]: show how many remind capacity");
            switch (Integer.parseInt(input())){
                case 1:
                    try {
                        addStudent();
                    }catch (Exception e){
                        print(e.getMessage());
                    }
                    break;
                case 2:
                    showListOfstudent();
                    break;
                case 3:
                    softdeletByIdCard();
                    break;
                case 4:
                    hardDeletByIdcard();
                    break;
                case 5:
                    showCapcity();
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

    private static void showCapcity() {
       String sqlSelect = "SELECT `capacity` FROM `capacity`";
    }

    private static void hardDeletByIdcard() {
    }

    private static void showListOfstudent() {
    }

    private static void softdeletByIdCard() {
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
        dataBase.sql(sqlInsert);
//        print(sqlInsert);


        ////////////////////////////////// capacity of student + 1 /////////////////////////////////////////////////////



        String selectCapacity= "SELECT `capacity` FROM `capacity`";
       Statement statement = dataBase.selectSql(selectCapacity);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int capacity = resultSet.getInt(1)+1;
            String capacityUpdate = "UPDATE `capacity` SET `capacity`='"+capacity+"' WHERE `id`=0;";
            dataBase.sql(capacityUpdate);
        }
    }
}
