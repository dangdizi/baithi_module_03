package ra.bussinessImpl;

import ra.bussiness.IProduct;
import ra.util.Input;

public class Product implements IProduct {
    private int productId;
    private String productName, title, descriptions;
    private float importPrice, exportPrice, interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
        this.interest = interest;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    @Override
    public void inputData() {
        this.productId = Input.nextInt("Id sản phẩm");
        this.productName = Input.nextLine("Tên sản phẩm");
        this.title = Input.nextLine("Tiêu đề sản phẩm");
        this.descriptions = Input.nextLine("Mô tả sản phẩm");
        this.importPrice = Input.nextFloat("Giá nhập vào");
        this.exportPrice = Input.nextFloat("Giá bán");
        this.interest = this.exportPrice - this.importPrice;
        while (true) {
            System.out.println("Trạng thái sản phẩm\n" + "1. Còn hàng\n" + "2. Hết hàng\n");
            byte status = Input.nextByte("lựa chọn");
            if (status == 1) {
                this.productStatus = true;
                break;
            } else if (status == 2) {
                this.productStatus = false;
                break;
            } else {
                System.err.println("Lụa chọn không hợp lệ");
            }
        }


    }

    @Override
    public void displayData() {
        System.out.printf("------------------------------\n");
        System.out.printf("ID: %d\n", getProductId());
        System.out.printf("Tên sản phẩm: %s\n", getProductName());
        System.out.printf("Tiêu đề: %s\n", getTitle());
        System.out.printf("Descriptions: %s\n", getDescriptions());
        System.out.printf("Giá nhập vào: %.2fVND\n", getImportPrice());
        System.out.printf("Giá bán ra: %.2fVND\n", getExportPrice());
        System.out.printf("Lợi nhuận: %.2fVND\n", getInterest());
        System.out.printf("Trạng thái: %s\n", isProductStatus() ? "Còn hàng" : "Hết hàng");
    }
}
