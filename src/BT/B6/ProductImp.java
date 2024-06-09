package BT.B6;

import java.util.Scanner;

public class ProductImp {
    public static ProductB6[] productArray = new ProductB6[100];
    public static int currentProductIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        productProgram(sc);
    }

    public static void productProgram(Scanner sc) {
        do {
            System.out.println("==============MENU==============");
            System.out.println("1. Add Product");
            System.out.println("2. Show Product");
            System.out.println("3. Caculate Profit");
            System.out.println("4. Sort by Profit Product (high to low)");
            System.out.println("5. Sort by Price Product (low to high)");
            System.out.println("6. Search by Name Product");
            System.out.println("7. Add Product quantity");
            System.out.println("8. Sell Product");
            System.out.println("9. Change Product Status");
            System.out.println("0. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    showProduct(sc);
                    break;
                case 3:
                    caculateProfit(sc);
                    break;
                case 4:
                    sortByProfit(sc);
                    break;
                case 5:
                    sortByPrice(sc);
                    break;
                case 6:
                    searchProductByName(sc);
                    break;
                case 7:
                    addProductQuantity(sc);
                    break;
                case 8:
                    sellProductByName(sc);
                    break;
                case 9:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice. Try again.");
            }

        } while (true);
    }

    //opt 1
    public static void addProduct(Scanner sc) {
        System.out.println("Enter the number of Products");
        int numberOfBooks = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            productArray[currentProductIndex] = new ProductB6();
            productArray[currentProductIndex].inputData(sc);
            currentProductIndex++;
        }
    }

    //opt 2
    public static void showProduct(Scanner sc) {
        for (int i = 0; i < currentProductIndex; i++) {
            productArray[i].displayData();
        }
        if (currentProductIndex == 0) {
            System.out.println("No books found");
        }
    }

    //opt 3
    public static void caculateProfit(Scanner sc) {
        for (int i = 0; i < currentProductIndex; i++) {
            productArray[i].setProfit(productArray[i].getExportPrice() - productArray[i].getImportPrice());
            System.out.println(productArray[i].getProfit());
        }
    }

    //opt 4
    public static void sortByProfit(Scanner sc) {
        for (int i = 0; i < currentProductIndex; i++) {
            for (int j = i + 1; j < currentProductIndex; j++) {
                if (productArray[i].getProfit() < productArray[j].getProfit()) {
                    ProductB6 temp = productArray[i];
                    productArray[i] = productArray[j];
                    productArray[j] = temp;
                }
            }
        }
        System.out.println("Finish Sorting by Profit (high to low)");
    }

    //opt5
    public static void sortByPrice(Scanner sc) {
        System.out.println("Enter start money:");
        float startMoney = Float.parseFloat(sc.nextLine());
        System.out.println("Enter end money");
        float endMoney = Float.parseFloat(sc.nextLine());
        for (int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getExportPrice() <= endMoney && productArray[i].getExportPrice() >= startMoney) {
                for (int j = i + 1; j < currentProductIndex; j++) {
                    if (productArray[j].getExportPrice() <= endMoney && productArray[j].getExportPrice() >= startMoney) {
                        if (productArray[i].getExportPrice() > productArray[j].getExportPrice()) {
                            ProductB6 temp = productArray[i];
                            productArray[i] = productArray[j];
                            productArray[j] = temp;
                        }
                    }
                }
            }
        }
        System.out.println("Finish Sorting by Price (low to high)");
    }

    //opt6
    public static void searchProductByName(Scanner sc) {
        System.out.println("Enter the name of the product you want to search");
        String name = sc.nextLine();
        int count = 0;
        for (int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getProductName().toLowerCase().contains(name.toLowerCase())) {
                productArray[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No product found");
        }
    }

    //opt7
    public static void addProductQuantity(Scanner sc) {
        System.out.println("Enter id of Products to change quantity");
        String id = sc.nextLine();
        int index = findIndexById(id);
        if (index != -1) {
            do {
                System.out.println("1. Plus quantity Product");
                System.out.println("2. Minus quantity Product");
                System.out.println("3. Exit");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter product quantity to plus");
                        int quantityP = Integer.parseInt(sc.nextLine());
                        productArray[index].setQuantity(productArray[index].getQuantity() + quantityP);
                        break;
                    case 2:
                        System.out.println("Enter product quantity to minus");
                        int quantityM = Integer.parseInt(sc.nextLine());
                        if (productArray[index].getQuantity() >= quantityM) {
                            productArray[index].setQuantity(productArray[index].getQuantity() - quantityM);
                        } else {
                            //bc minus too much so set quantity =0
                            productArray[index].setQuantity(0);
                        }
                        break;
                    case 3:
                        productProgram(sc);
                        break;
                    default:
                        System.err.println("Invalid choice. Try again.");
                }
            } while (true);
        }

    }

    public static int findIndexById(String id) {
        for (int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getProductId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //opt8
    public static void sellProductByName(Scanner sc) {
        System.out.println("Enter product name to sell");
        String name = sc.nextLine();
        int index = findIndexByName(sc, name);
        if (index != -1) {
            System.out.println("Enter number products to sell");
            do {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= productArray[index].getQuantity()) {
                    productArray[index].setQuantity(productArray[index].getQuantity() - quantity);
                    break;
                } else {
                    System.err.println("Invalid number. Bigger than real quantity. Try again.");
                }
            } while (true);

        } else {
            System.out.println("None product had found");
        }
    }

    public static int findIndexByName(Scanner sc, String name) {
        for (int i = 0; i < currentProductIndex; i++) {
            if (productArray[i].getProductName().equalsIgnoreCase(name)) {
                System.out.println("Product: " + productArray[i].getProductName() + " is choose");
                System.out.println("Do you really want to sell this product? Yes/No");
                String choice = "";
                do {
                    choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        System.err.println("Invalid choice. Try again.");
                    }
                } while (true);
                if (choice.equalsIgnoreCase("yes")) {
                    return i;
                } else {
                    //choose no -> doesnt sell
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void changeProductStatus(Scanner sc) {
        System.out.println("Enter product id:");
        String id = sc.nextLine();
        int index = findIndexById(id);
        if (index != -1) {
            if (productArray[index].getProductStatus()) {
                productArray[index].setProductStatus(false);
            } else {
                productArray[index].setProductStatus(true);
            }
        }
        System.out.println("Finish change status.");
    }
}
