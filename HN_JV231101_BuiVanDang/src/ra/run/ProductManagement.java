package ra.run;

import ra.bussinessImpl.Product;
import ra.util.Input;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManagement {
    private static List<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        int choice = 0;

        while (choice != 7) {
            displayMenu();
            choice = Input.nextInt("Nhập lựa chọn");

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    sortProduct();
                    break;
                case 4:
                    updateProduct(true);
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    updateProduct(false);
                    break;
                case 7:
                    System.out.println("Đã thoát chương trình");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void sortProduct() {
        byte fields, type;
        // nhập dữ liệu trường cần sắp xếp
        while (true) {
            System.out.println("Chọn trường sắp xếp\n" + "1. Tên\n" + "2. giá bán\n" + "3. lợi nhuận\n");
            fields = Input.nextByte("Lựa chọn");

            if (fields < 1 || fields > 3) {
                System.err.println("Lựa chọn không hợp lệ");
            } else {
                break;
            }
        }
        // nhập dữ liệu kiểu sắp xếp
        while (true) {
            System.out.println("Chọn kiểu sắp xếp\n" + "1. tăng dần\n" + "2. giảm dần\n");
            type = Input.nextByte("Lựa chọn");

            if (type < 1 || type > 2) {
                System.err.println("Lựa chọn không hợp lệ");
            } else {
                break;
            }
        }

        List<Product> cloneList = products.stream().collect(Collectors.toList());

        // sắp xếp theo kiểu
        switch (fields) {
            case 1:
                cloneList.sort(Comparator.comparing(Product::getProductName));
                break;
            case 2:
                cloneList.sort(Comparator.comparing(Product::getExportPrice));
                break;
            case 3:
                cloneList.sort(Comparator.comparing(Product::getInterest));
                break;
        }

        if (type == 2) {
            Collections.reverse(cloneList);
        }

        System.out.printf("%s theo %s\n", type == 1 ? "Tăng dần" : "Giảm dần", fields == 1 ? "Tên" : fields == 2 ? "giá bán" : "lợi nhuận");
        cloneList.stream().forEach(Product::displayData);

    }

    private static void updateProduct(boolean delete) {
        int id = Input.nextInt("Nhập id");
        Product findProduct = findById(id);
        if (findProduct == null) {
            System.err.println("Không tìm thấy id");
        } else {
            if (delete) {
                products.remove(findProduct);
                System.out.println("Đã xóa sản phẩm");
            } else {
                findProduct.setProductStatus(!findProduct.isProductStatus());
                System.out.println("đã thay đổi trạng thái");
            }
        }

    }

    private static void searchProduct() {
        String productName = Input.nextLine("Nhập tên cần tìm");
        List<Product> findProduct = findByName(productName);
        if (findProduct.isEmpty()) {
            System.err.println("Không tìm thấy sản phẩm phù hợp");
        } else {
            findProduct.stream().forEach(Product::displayData);
        }
    }

    private static List<Product> findByName(String productName) {
        return products.stream().filter(product -> product.getProductName().contains(productName)).collect(Collectors.toList());
    }

    private static void displayProduct() {
        products.stream().forEach(Product::displayData);
    }

    private static void addNewProduct() {
        int n = Input.nextInt("Nhập số sản phẩm cần thêm");
        for (int i = 0; i < n; i++) {
            System.out.println("Thông tin sản phẩm số " + (i + 1));
            Product product = new Product();
            product.inputData();
            products.add(product);
        }
        System.out.println("Hoàn thành thêm mới");
    }

    private static void displayMenu() {
        System.out.println("****************PRODUCT-MANAGER-MENU***************\n" + "1. Nhập số sản phẩm và nhập thông tin sản phẩm\n" + "2. Hiển thị thông tin các sản phẩm\n" + "3. Sắp xếp sản phẩm\n" + "4. Xóa sản phẩm theo mã sản phẩm\n" + "5. Tìm kiếm sản phẩm theo tên sản phẩm\n" + "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm\n" + "7. Thoát\n");
    }

    private static Product findById (int id) {
        return products.stream().filter(product -> product.getProductId() == id).findFirst().orElse(null);
    }
}
