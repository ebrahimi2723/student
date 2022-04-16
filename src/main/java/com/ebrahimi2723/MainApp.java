package com.ebrahimi2723;



import com.ebrahimi2723.data.DataBase;
import com.ebrahimi2723.model.Student;

import static com.ebrahimi2723.io.Io.*;

public class MainApp {
    public static void main(String[] args) {
        while (true){
            switch (Integer.parseInt(input())){
                case 1: 
                    addStudent();
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
    }

    private static void hardDeletByIdcard() {
    }

    private static void showListOfstudent() {
    }

    private static void softdeletByIdCard() {
    }

    private static void addStudent() {
        Student student = new Student();
        print("enter Full name od student");
        student.setFullName(input());
        print("enter Average of mark");
        student.setMark(Float.parseFloat(input()));
        student.setYear(2020);
        student.setIsDeleted(1);
        // ex INSERT INTO `user`( `fullname`, `mark`, `year`, `isdelete`) VALUES ('mohammad','20.0','2020','1')
        String sqlInsert = "INSERT INTO `user`( `fullname`, `mark`, `year`, `isdelete`) VALUES ('"+student.getFullName()+"','"+student.getMark().toString()+"','"+student.getYear().toString()+"','"+ student.getIsDeleted()+"')";
        DataBase dataBase = new DataBase();
        dataBase.sql(sqlInsert);
//        print(sqlInsert);
    }
}
