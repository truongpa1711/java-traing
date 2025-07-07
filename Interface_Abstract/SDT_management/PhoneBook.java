package Interface_Abstract.SDT_management;

import java.util.ArrayList;
import java.util.Collections;

public class PhoneBook extends Phone {
    public static class Contact{
        private String name;
        private String phone;

        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
    private ArrayList<Contact> phoneList = new ArrayList<>();

    @Override
    void insertPhone(String name, String phone) {
        for (Contact c : phoneList) {
            if (c.getName().equals(name)) {
                ArrayList<String> existingPhones = new ArrayList<>();
                Collections.addAll(existingPhones, c.getPhone().split(" : "));
                if (!existingPhones.contains(phone)) {
                    c.setPhone(c.getPhone() + " : " + phone);
                    System.out.println("Đã cập nhật thêm số cho " + name + ": " + phone);
                } else {
                    System.out.println("Số điện thoại đã tồn tại cho người dùng: " + name);
                }
                return; // stop after found the name
            }
        }

        // Nếu không tìm thấy tên, thì thêm mới
        phoneList.add(new Contact(name, phone));
        System.out.println("Đã thêm mới liên hệ: " + name + " - " + phone);
    }


    @Override
    void removePhone(String name) {
        for (Contact c : phoneList) {
            if (c.getName().equals(name)) {
                phoneList.remove(c);
                System.out.println("Đã xóa liên hệ: " + name);
                return; // stop after found the name
            }
        }
        System.out.println("Không tìm thấy liên hệ để xóa: " + name);
    }

    @Override
    void searchPhone(String name) {
        for (Contact c : phoneList) {
            if (c.getName().equals(name)) {
                System.out.println("Thông tin liên hệ: " + c.getName() + " - " + c.getPhone());
                return; // stop after found the name
            }
        }
        System.out.println("Không tìm thấy liên hệ: " + name);
    }

    @Override
    void updatePhone(String name, String newPhone) {
        for (Contact c : phoneList) {
            if (c.getName().equals(name)) {
                ArrayList<String> existingPhones = new ArrayList<>();
                Collections.addAll(existingPhones, c.getPhone().split(" : "));
                if (!existingPhones.contains(newPhone)) {
                    c.setPhone(c.getPhone() + " : " + newPhone);
                    System.out.println("Đã cập nhật số điện thoại cho " + name + ": " + newPhone);
                } else {
                    System.out.println("Số điện thoại đã tồn tại cho người dùng: " + name);
                }
                return; // stop after found the name
            }
        }
        System.out.println("Không tìm thấy liên hệ để cập nhật: " + name);
    }

    @Override
    void sort() {
        if (phoneList.isEmpty()) {
            System.out.println("Danh sách liên hệ trống, không có gì để sắp xếp.");
            return;
        }
        Collections.sort(phoneList, (c1, c2) -> c1.getName().compareTo(c2.getName()));
        System.out.println("Danh sách liên hệ đã được sắp xếp theo tên.");
        for (Contact c : phoneList) {
            System.out.println(c.getName() + " - " + c.getPhone());
        }
    }
}