package OOP.B13_QLNV;

import java.util.List;

public class QLNV {
    List<Employee> employees;
    public QLNV() {
        this.employees = new java.util.ArrayList<>();
    }
    public QLNV(List<Employee> employees) {
        this.employees = employees;
    }
    public boolean kiemTraNhanVien(String id) {
        for (Employee employee : employees) {
            if (employee.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public void suaNhanVien(String id, Employee newEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID().equals(id)) {
                employees.set(i, newEmployee);
                System.out.println("Da cap nhat thong tin nhan vien voi ID: " + id);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien voi ID: " + id);
    }
    public void xoaNhanVien(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID().equals(id)) {
                employees.remove(i);
                System.out.println("Da xoa nhan vien voi ID: " + id);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien voi ID: " + id);
    }
    public void themNhanVien(Employee employee) {
        for (Employee emp : employees) {
            if (emp.getID().equals(employee.getID())) {
                System.out.println("Nhan vien voi ID: " + employee.getID() + " da ton tai.");
                return;
            }
        }
        employees.add(employee);
        System.out.println("Da them nhan vien moi voi ID: " + employee.getID());
    }

    public void hienThiNhanVien() {
        if (employees.isEmpty()) {
            System.out.println("Khong co nhan vien nao trong danh sach.");
            return;
        }
        for (Employee employee : employees) {
            employee.ShowInfo();
        }
    }

    public void hienThiNhanVienTheoLoai(Employee.Employee_type type) {
        boolean found = false;
        for (Employee employee : employees) {
            if ((type == Employee.Employee_type.Fresher && employee instanceof Fresher) ||
                    (type == Employee.Employee_type.Intern && employee instanceof Intern) ||
                    (type == Employee.Employee_type.Experience && employee instanceof Experience)) {
                employee.ShowInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co nhan vien nao thuoc loai: " + type);
        }
    }

}
