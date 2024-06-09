package BT.B5;

import java.util.Scanner;

public class Main {
    public static Product[] productArray = new Product[100];
    public static int currentProductIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuProductManagement(sc);
    }
    public static void menuProductManagement(Scanner sc) {
        do {
            System.out.println("==========PRODUCT MANAGEMENT==========");
            System.out.println("1. Add Product");
            System.out.println("2. Show Products");
            System.out.println("3. Sort Products With Price");
            System.out.println("4. Edit Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Find Product By Name");
            System.out.println("7. Find Product By Price Spread");
            System.out.println("8. Exit");
            int choice2 = Integer.parseInt(sc.nextLine());
            switch (choice2) {
                case 1:
                    inputListProduct(sc);
                    break;
                case 2:
                    displayProduct(sc);
                    break;
                case 3:
                    sortProductWithPrice();
                    break;
                case 4:
                    updateProduct(sc);
                    break;
                case 5:
                    deleteProduct(sc);
                    break;
                case 6:
                    searchProductByName(sc);
                    break;
                case 7:
                    searchProductByPrice(sc);
                    break;
                case 8:
                    System.exit(0);
            }
        } while (true);
    }
    public static void inputListProduct(Scanner sc) {
        System.out.println("Enter Number of Product");
        int numberOfProducts = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfProducts; i++) {
            productArray[currentProductIndex] = new Product();
            productArray[currentProductIndex].inputData(sc);
            currentProductIndex++;
        }
    }

    public static void displayProduct(Scanner sc) {
        for (int i = 0; i < currentProductIndex; i++) {
            productArray[i].displayData();
        }
    }

    public static void sortProductWithPrice() {
        for (int i = 0; i < currentProductIndex; i++) {
            for (int j = i + 1; j < currentProductIndex; j++) {
                if (productArray[i].getPrice() > productArray[j].getPrice()) {
                    Product temp = productArray[i];
                    productArray[i] = productArray[j];
                    productArray[j] = temp;
                }
            }
        }
        System.out.println("Finished sort products by price (low to high)");
    }

    public static void updateProduct(Scanner sc) {
        System.out.println("Enter Product ID (example: C00x)");
        String productId = sc.nextLine();
        int indexUpdate = getIndexProductById(productId);
        if (indexUpdate != -1) {
            boolean isExit = true;
            do {
                System.out.println("1. Update Product Name");
                System.out.println("2. Update Product Price");
                System.out.println("3. Update Product Description");
                System.out.println("4. Update Product Date Created");
                System.out.println("5. Update Product Category ID");
                System.out.println("6. Update Product Status");
                System.out.println("7. Exit");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        productArray[indexUpdate].setProductName(productArray[indexUpdate].inputProductName(sc));
                        break;
                    case 2:
                        productArray[indexUpdate].setPrice(productArray[indexUpdate].inputProductPrice(sc));
                        break;
                    case 3:
                        productArray[indexUpdate].setDescription(productArray[indexUpdate].inputProductDescription(sc));
                        break;
                    case 4:
                        productArray[indexUpdate].setCreated(productArray[indexUpdate].inputProductCreated(sc));
                        break;
                    case 5:
//                        productArray[indexUpdate].setCatagoryId(productArray[indexUpdate].inputCategoryId(sc));
                        break;
                    case 6:
                        productArray[indexUpdate].setStatus(productArray[indexUpdate].inputStatus(sc));
                        break;
                    case 7:
                        menuProductManagement(sc);
                        break;
                    default:
                        isExit = false;
                }
            } while (isExit);
        } else {
            System.err.println("Invalid Category ID");
        }
    }

    public static void deleteProduct(Scanner sc) {
        System.out.println("Enter Product id to delete (C00x):");
        String productId = sc.nextLine();
        int indexDelete = getIndexProductById(productId);
        if (indexDelete != -1) {
            for (int i = indexDelete; i < currentProductIndex; i++) {
                productArray[i] = productArray[i + 1];
            }
            currentProductIndex--;
        } else {
            System.err.println("Invalid Product ID");
        }
    }

    public static void searchProductByName(Scanner sc) {
        System.out.println("Enter Product name: ");
        String productNameSearch = sc.nextLine();
        int cntProduct = 0;
        System.out.printf("Product with that name (%s): ", productNameSearch);
        for (int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getProductName().toLowerCase().equals(productNameSearch)) {
                productArray[i].displayData();
                cntProduct++;
            }
        }
        System.out.printf("There are %d products had found", cntProduct);
    }

    public static void searchProductByPrice(Scanner sc) {
        System.out.println("Enter Product start price (low to high):");
        double productPriceSearchStart = Double.parseDouble(sc.nextLine());
        System.out.println("Enter Product end price (low to high):");
        double productPriceSearchEnd = Double.parseDouble(sc.nextLine());
        int cntProduct = 0;
        for(int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getPrice() >= productPriceSearchStart &&
                    productArray[i].getPrice() <= productPriceSearchEnd) {
                productArray[i].displayData();
            }
        }
        System.out.printf("There are %d products had found", cntProduct);

    }

    //tim index. ko thay thi =-1
    public static int getIndexProductById(String productId) {
        for (int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }
}
