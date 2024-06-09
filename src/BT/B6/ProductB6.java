package BT.B6;

import java.util.Scanner;

public class ProductB6 {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity = 0;
    private String description;
    private boolean status;

    public ProductB6(){}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getProductStatus() {
        return status;
    }

    public void setProductStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc){
        this.productId = inputProductId(sc);
        this.productName = inputProductName(sc);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = inputExportPrice(sc);
        this.profit = this.exportPrice - this.importPrice;
        this.quantity = inputQuantity(sc);
        this.description = inputDescription(sc);
        this.status = inputStatus(sc);
    }

    public void displayData(){
        System.out.printf("Product ID: %s     Name: %s\n" +
                "ImportPrice: %f    ExportPrice: %f\n" +
                "Profit: %f     Quantity: %d\n" +
                "Description: %s\n" +
                "Status: %s",this.productId,this.productName,this.importPrice,this.exportPrice,this.profit,this.quantity,this.description,this.status);
    }

    public String inputProductId(Scanner sc){
        String regax = "P\\d{3}";
        System.out.println("Enter Product ID: ");
        do {
            String productId = sc.nextLine();
            if(productId.matches(regax)){
                boolean isExist = false;
                for (int i = 0; i < ProductImp.currentProductIndex; i++){
                    if(ProductImp.productArray[i].getProductId().equals(productId)){
                        isExist = true;
                        break;
                    }
                }
                if(!isExist){
                    return productId;
                }else {
                    System.out.println("Product ID already exists!");
                }
            }else {
                System.err.println("Invalid Product ID! Must start with Pxxx");
            }
        }while(true);
    }
    public String inputProductName(Scanner sc){
        String regax = "\\w{6,50}";
        System.out.println("Enter Product Name: ");
        do {
            String productName = sc.nextLine();
            if(productName.matches(regax)){
                return productName;
            }else {
                System.out.println("Product Name does not match. Try again!");
            }
        }while(true);
    }

    public float inputImportPrice(Scanner sc){
        System.out.println("Enter Import Price: ");
        do {
            float importPrice = Float.parseFloat(sc.nextLine());
            if(importPrice > 0){
                return importPrice;
            }else {
                System.out.println("Import Price does not exist. Try again!");
            }
        }while(true);
    }
    public float inputExportPrice(Scanner sc){
        System.out.println("Enter Export Price: ");
        do {
            float exportPrice = Float.parseFloat(sc.nextLine());
            if(exportPrice > this.getImportPrice()- this.getImportPrice()*0.2){
                return exportPrice;
            }else {
                System.err.println("Export Price does not exist. Try again!");
            }
        }while(true);
    }
    public int inputQuantity(Scanner sc){
        System.out.println("Enter Quantity: ");
        do {
            int quantity = Integer.parseInt(sc.nextLine());
            if(quantity > 0){
                return quantity;
            }
            else {
                System.err.println("Quantity does not exist. Try again!");
            }
        }while(true);
    }
    public String inputDescription(Scanner sc){
        System.out.println("Enter Description: ");
        return sc.nextLine();
    }
    public boolean inputStatus(Scanner sc){
        System.out.println("Enter Status: ");
        do {
            String status = sc.nextLine();
            if(status.equals("true") || status.equals("false")){
                return Boolean.parseBoolean(status);
            }else {
                System.err.println("Status does not exist. Try again!");
            }
        }while(true);
    }
}
