package com.hust.edu.shared;

import java.util.List;
import java.util.Scanner;

public class Admin extends HustPerson
{
    /**
     *
     * @param id :  id of admin
     * @param fullname : name of admin
     */
    public Admin(int id, String fullname)
    {
        super(id, fullname);
    }

    /**
     *
     * @return id of admin
     */
    public int getAdminId()
    {
        return id;
    }

    /**
     *
     * @param id : id of admin
     * @return : admin who have this id
     */
    public static Admin getAdminById(int id)
    {
        for (Admin x : Database.adminList)
            if(x.getAdminId() == id)
                return x;
        return null;
    }


    /**
     * Data management: Student List, Lecturer List, Course List
     */
    private void dataManagement(Scanner input) {
        System.out.println("\n\n____________QUAN LY DU LIEU____________\n");
        System.out.println("1. Bo sung danh sach sinh vien");
        System.out.println("2. Bo sung danh sach giang vien");
        System.out.println("3. Bo sung danh sach hoc phan");
        System.out.println("4. Chinh sua thong tin sinh vien");
        System.out.println("5. Chinh sua thong tin giang vien");
        System.out.println("Chon chuc nang : ");
        switch (input.nextInt()){
            case 1:
            {
                // Add student
                Database.addStudentList();
                break;

            }
            case 2:
            {
                // Add lecturer
                Database.addLecturerList();
                break;

            }
            case 3:
            {
                // Add course
                Database.addCourseList();

                break;
            }
            case 4:
                System.out.print("Nhap vao MSSV cua sinh vien can sua: ");
                int studentId = input.nextInt();
                Student x = Student.getStudentById(studentId);
                if(x != null)
                    x.updateStudentInfo();
                else
                    System.err.println("Khong tim thay sinh vien co MSSV " + studentId);

                break;

            case 5:
                System.out.print("Nhap vao MSSV cua sinh vien can sua: ");
                int lecturerId = input.nextInt();
                Lecturer y = Lecturer.getLecturerById(lecturerId);
                if(y != null)
                    y.updateLecturerInfo();
                else
                    System.err.println("Khong tim thay sinh vien co MSSV " + lecturerId);

                break;

        }
    }

    /**
     * Search Tool : Student, Lecturer, Course, Student Fee, Lecturer Salary, Point, ...
     */
    private void search(Scanner input){
        System.out.println("\n\n____________TRA CUU____________\n");
        System.out.println("1. Tra cuu thong tin sinh vien");
        System.out.println("2. Tra cuu thong tin giang vien ");
        System.out.println("3. Tra cuu thong tin hoc phan");
        System.out.println("4. Tra cuu hoc phi sinh vien");
        System.out.println("5. Tra cuu luong giang vien");
        System.out.println("6. Tra cuu bang diem sinh vien");
        System.out.println("7. Tra cuu danh sach lop sinh vien ");
        System.out.println("8. Tra cuu danh muc hoc phan sinh vien ");
        switch (input.nextInt()){
            case 1:
            {
                /* Show student information */
                System.out.print("Nhap vao MSSV can in: ");
                Student.getStudentInfo(input.nextInt());
                break;
            }
            case 2:
            {
                /* Show lecturer information */
                System.out.print("Nhap vao ma giang vien can in: ");
                Lecturer.getLecturerInfo(input.nextInt());
                break;
            }
            case 3:
            {
                /* Show course information */
                System.out.print("Nhap vao ma hoc phan can in: ");
                Course.getCourseInfo(input.nextLine());
                break;
            }
            case 4:
                System.out.println("Chuc nang nay chua co");
                break;

            case 5:
                System.out.println("Chuc nang nay chua co");
                break;

            case 6:
                System.out.println("Chuc nang nay chua co");
                break;
            case 7:
                System.out.println("Nhap ma lop hoc : ");
                List<Enroll> enrolList2 = Enroll.getEnrollbyCourseId(input.nextInt());
                for(Enroll x: enrolList2){
                    System.out.println(Student.getStudentById(x.getStudentId()).getFullName());
                }
                break;
            case 8:
                System.out.println("Nhap ma so sinh vien : ");
                List<Enroll> enrolList = Enroll.getEnrollbyStudentId(input.nextInt());
                for(Enroll x: enrolList){
                    System.out.println(Class.getClassById(x.getClassId()).getCorrespondingCourse().courseName);
                }
                break;
        }
    }

    /**
     * Education Management : Point Import, ...
     */
    public void educationManagement(Scanner input){
        System.out.println("\n\n____________QUAN LY DAO TAO____________\n");
        System.out.println("1. Nhap diem ");
        System.out.println("2. Dang ky hoc tap");
        System.out.println("Chon chuc nang : ");
        switch (input.nextInt()){
            case 1:
                Enroll.point(input);
                break;
            case 2:
            {
                System.out.println("Nhap vao MSSV cua sinh vien can dang ky: ");
                int studentId = input.nextInt();
                Enroll.enrol(studentId);
                break;
            }
        }

    }


    /**
     * Generate
     */
    public void generate(Scanner input){
        String dangxuat;
        do
        {
            System.out.println("\n\n____________MENU____________\n");
            System.out.println("1. Quan ly du lieu.");
            System.out.println("2. Tra cuu.");
            System.out.println("3. Quan ly dao tao.");
            System.out.println("4. Dang xuat.");
            System.out.print("\nChon chuc nang: ");
            switch (input.nextInt()){
                case 1:
                    dataManagement(input);
                    break;
                case 2:
                    search(input);
                    break;
                case 3:
                    educationManagement(input);
                    break;
                case 4:
                    Database.userType = 0;
                    break;
            }
            if(Database.userType == 0)
                break;
            System.out.print("Ban co muon tiep tuc khong? (C/K) ");
            input.nextLine();
            dangxuat = input.nextLine();
        } while (dangxuat.equals("c") || dangxuat.equals("C"));
    }


}