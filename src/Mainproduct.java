import java.sql.SQLOutput;
import java.util.Scanner;

public class Mainproduct {
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();
        managerProduct.readProduct();
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        try {
            do {
                System.out.println("1.Xem danh sach      "+"2.Them moi      "+"3.Cap nhat      "+"4.Xoa\n"+"5.Sap xep      "
                        +"6.Tim san pham co gia tri dat nhat      "
                        +"7.Doc tu file      "+"8.Ghi vao file");
                System.out.println("Chon chuc nang bang cach nhap so tuong ung");
                 choice = Integer.parseInt(scanner.nextLine());
                 switch (choice){
                     case 1:managerProduct.displayProduct();
                         break;
                     case 2:managerProduct.addProduct(scanner);
                     break;
                     case 3:managerProduct.updateProduct(scanner);
                         break;
                     case 4:managerProduct.deleteProduct(scanner);
                     break;
                     case 6:managerProduct.searchMaxPrice();
                     case 7:managerProduct.readProduct();
                         System.out.println("Doc file thanh cong");
                     break;
                     case 8:managerProduct.saveProduct();
                         System.out.println("Luu file thanh cong");
                     break;
                 }

            }while (choice!=9);
        }catch (Exception e){
            System.out.println("Vui long nhap so");
        }
    }

}
