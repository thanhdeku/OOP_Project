package com.hust.edu.shared;

import java.util.List;
import java.util.Scanner;

public class Lecturer extends HustPerson
{
    private String department;

    /* Ham khoi dung - Constructor */
    public Lecturer(int id, String name, String department)
    {
        super(id, name);
        this.department = department;
    }

    /* Tim teacher trong danh sach */
    public static Lecturer getLecturerById(int id)
    {
        for (Lecturer x : Database.lecturerList)
            if(x.id == id)
                return x;
        return null;
    }

    public String getDepartment() {
        return department;
    }

    /* In thong tin teacher */
    public static void getLecturerInfo(int id)
    {

        Lecturer x = getLecturerById(id);
        if(x != null)
        {
            System.out.println("_____________________________________________________________");
            System.out.println(" ");
            System.out.println("        Name         : " + x.getFullName());
            System.out.println("        Id           : " + x.getId());
            System.out.println("        Birthday     : " + x.getBirthdate());
            System.out.println("        Department   : " + x.getDepartment());
            System.out.println(" ");
            System.out.println("_____________________________________________________________");
        }
        else
            System.err.println("Khong tim thay sinh vien co MSSV " + id);
    }

    /* Cap nhat thong tin teacher */
    public void updateLecturerInfo()
    {
        Scanner input = new Scanner(System.in);

        int select;
        System.out.println("1. Ten.");
        System.out.println("2. Ngay sinh.");
        System.out.println("3. So dien thoai.");
        System.out.println("4. Email.");
        System.out.println("5. Dia chi.");
        System.out.println("Chon muc muon thay doi: ");
        select = input.nextInt();
        switch(select)
        {
            case 1:
                System.out.print("Nhap ten giang vien : ");
                this.nameUpdate(input.nextLine());
                break;
            case 2:
            {
                System.out.print("Nhap ngay sinh moi (DD/mm/yyyy): ");
                this.setBirthdate(input.nextLine());
                break;
            }
            case 3:
            {
                System.out.print("Nhap so dien thoai moi: ");
                this.phone = input.nextLine();
                break;
            }
            case 4:
            {
                System.out.print("Nhap email moi: ");
                this.mail = input.nextLine();
                break;
            }
            case 5:
            {
                System.out.print("Nhap dia chi moi: ");
                this.address = input.nextLine();
                break;
            }
            default:
                System.out.println("Khong tim thay thong tin!");
        }
    }

    public void userInfo(Scanner input){
        System.out.println("\n\n____________THONG TIN NGUOI DUNG____________\n");
        System.out.println("1. Doi mat khau");
        System.out.println("2. Thong tin ca nhan ");
        System.out.println("3. Cap nhat thong tin ca nhan");
        switch (input.nextInt()){
            case 1:
                changePassword(input);
                break;
            case 2:
                Lecturer.getLecturerInfo(this.id);
                break;
            case 3:
                this.updateLecturerInfo();
                break;
        }
    }

    public void changePassword(Scanner input){
        Login login = Login.getLoginById(this.getId());
        Login.updatePassword(login,input);

    }

    public void search(Scanner input){
        System.out.println("\n\n____________TRA CUU____________\n");
        System.out.println("1. Tra cuu thong tin sinh vien");
        System.out.println("2. Tra cuu thong tin giang vien ");
        System.out.println("3. Tra cuu thong tin hoc phan");
        System.out.println("4. Tra cuu danh sach lop sinh vien ");
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
                System.out.println("Nhap ma lop hoc : ");
                List<Enroll> enrolList2 = Enroll.getEnrollbyCourseId(input.nextInt());
                for(Enroll x: enrolList2){
                    System.out.println(Student.getStudentById(x.getStudentId()).getFullName());
                }
                break;

        }
    }

    public void generate(Scanner input){
        String dangxuat;
        do
        {
            System.out.println("\n\n____________MENU____________\n");
            System.out.println("1. Thong tin nguoi su dung");
            System.out.println("2. Tra cuu");
            System.out.println("3. Nhap diem");
            System.out.println("4. Dang xuat");
            System.out.print("\nChon chuc nang: ");
            switch (input.nextInt()){
                case 1:
                    this.userInfo(input);
                    break;
                case 2:
                    this.search(input);
                    break;
                case 3:
                    Enroll.point(input);
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