import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    File file = new File("D:\\MD2\\Modun2\\modun2thuchanh\\src\\productList.csv");
    List<Product> products = new ArrayList<>();

    public void addProduct(Scanner scanner) {
        Product product = creatProduct(scanner);
        products.add(product);
        saveProduct();
        System.out.println("Them moi san pham thanh cong");
    }

    public Product creatProduct(Scanner scanner) {
        readProduct();
        System.out.println("Nhap ma san pham");
        String id = scanner.nextLine();
        while (true) {
            if (checkID(id) != -1) {
                System.out.println("Trung ma san pham,vui long nhap ma khac");
                id = scanner.nextLine();
            } else {
                break;
            }
        }

        System.out.println("Nhap ten san pham");
        String name = scanner.nextLine();
        while (true) {
            if (name.equals("")) {
                System.out.println("Vui long khong de trong");
            } else {
                break;
            }
        }
        System.out.println("Nhap gia san pham");
        long price = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Nhap so luong san pham");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap mo ta san pham");
        String describe = scanner.nextLine();
        return new Product(id, name, price, amount, describe);
    }

    public int checkID(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public void updateProduct(Scanner scanner) {
        displayProduct();
        System.out.println("Nhap ma san pham can sua: ");
        String id = scanner.nextLine();
        String idNew = "";
        if (checkID(idNew) == -1) {
            System.out.println("Ma san pham moi");
            idNew = scanner.nextLine();
            products.get(checkID(id)).setId(idNew);
            System.out.println("Cap nhat id moi thanh cong");
        } else {
            System.out.println("Khong tim duoc ma san pham voi ma san pham o tren");
        }
        System.out.println("Nhap ten san pham moi");
        String name = scanner.nextLine();
        products.get(checkID(idNew)).setName(name);
        System.out.println("Cap nhat ten moi thanh cong");
        long price = scanner.nextLong();
        scanner.nextLine();
        products.get(checkID(idNew)).setPrice(price);
        System.out.println("cap nhat gia moi thanh cong");
        int amount = Integer.parseInt(scanner.nextLine());
        products.get(checkID(idNew)).setAmount(amount);
        System.out.println("cap nhat so luong moi thanh cong");
        String des = scanner.nextLine();
        products.get(checkID(idNew)).setDescribe(des);
        System.out.println("cao nhat mo ta thanh cong");
        System.out.println("cap nhat san pham moi thanh cong");
        saveProduct();
    }
    public void deleteProduct(Scanner scanner){
        readProduct();
        if (products.size()==0){
            System.out.println("Kho hang dang trong");
        }else {
            System.out.println("Nhap ma san pham can sua");
            String id = scanner.nextLine();
            if (checkID(id) != -1) {
                products.remove(checkID(id));
            } else {
                System.out.println("Khong tim thay ma san pham voi ma san pham tren");
            }
        }
        saveProduct();

    }
    public void searchMaxPrice(){
        long max = 0;
        int k = 0;
        for (int i=0;i<products.size();i++){
               if (max<products.get(i).getPrice()){
                   max = products.get(i).getPrice();
                   k=i;
               }
        }
        System.out.println(products.get(k));
    }
    public void displayProduct() {
        readProduct();
        if (products.size()==0){
            System.out.println("Kho hang dang trong");
        }else {
            for (Product b : products) {
                System.out.println(b);
            }
        }
    }



    public void saveProduct() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (Exception e) {
        }
    }

    public void readProduct() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            products = (ArrayList<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {

        }
    }
}
