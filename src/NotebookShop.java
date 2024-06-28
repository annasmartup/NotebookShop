import java.util.*;

public class NotebookShop {
    private Set<Notebook> notebooks = new HashSet<>();
    private Map<String, String> choice = new HashMap<>();

    public void loadNotebooks() {
        notebooks.add(new Notebook("Lenovo", 4, 128, "Windows", "Black", 300));
        notebooks.add(new Notebook("Acer", 8, 512, "Windows", "White", 700));
        notebooks.add(new Notebook("Asus", 16, 1024, "Windows", "Blue", 1000));
        notebooks.add(new Notebook("Microsoft", 8, 256, "Windows", "Gray", 900));
        notebooks.add(new Notebook("Samsung", 4, 128, "Linux", "Black", 200));
        notebooks.add(new Notebook("Toshiba", 8, 512, "Windows", "Red", 600));
        notebooks.add(new Notebook("Sony", 16, 256, "Windows", "Silver", 950));
        notebooks.add(new Notebook("MSI", 32, 1024, "Windows", "Black", 1500));
        notebooks.add(new Notebook("Razer", 16, 512, "Windows", "Green", 1300));
        notebooks.add(new Notebook("Gigabyte", 8, 256, "Windows", "Gray", 700));
        notebooks.add(new Notebook("Alienware", 32, 2048, "Windows", "Black", 2500));
        notebooks.add(new Notebook("Huawei", 16, 512, "Linux", "Silver", 1100));
        notebooks.add(new Notebook("Xiaomi", 8, 512, "Windows", "Gray", 750));
        notebooks.add(new Notebook("LG", 4, 128, "Windows", "White", 300));
        notebooks.add(new Notebook("Fujitsu", 8, 256, "Windows", "Black", 450));
        notebooks.add(new Notebook("Panasonic", 8, 512, "Windows", "Silver", 850));
        notebooks.add(new Notebook("Vaio", 16, 1024, "Linux", "Black", 1200));
        notebooks.add(new Notebook("Google", 8, 256, "Linux", "White", 650));
        notebooks.add(new Notebook("Medion", 4, 128, "Windows", "Gray", 250));
        notebooks.add(new Notebook("Packard Bell", 8, 256, "Windows", "Black", 400));
        notebooks.add(new Notebook("Epson", 16, 512, "Windows", "Silver", 900));
    }

    public void addChoice(String input, Scanner scanner) {
        switch (input) {
            case "1":
                System.out.print("Выберите минимальный объем ОЗУ (ГБ): ");
                System.out.println("Доступные варианты: 4, 8, 16, 32");
                String ramChoice = scanner.nextLine();
                if (Arrays.asList("4", "8", "16", "32").contains(ramChoice)) {
                    choice.put("ram", ramChoice);
                } else {
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                }
                break;
            case "2":
                System.out.print("Выберите минимальный объем ЖД (ГБ): ");
                System.out.println("Доступные варианты: 128, 256, 512, 1024, 2048");
                String storageChoice = scanner.nextLine();
                if (Arrays.asList("128", "256", "512", "1024", "2048").contains(storageChoice)) {
                    choice.put("storage", storageChoice);
                } else {
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                }
                break;
            case "3":
                System.out.print("Введите операционную систему: ");
                System.out.println("Доступные варианты: Windows, Linux");
                String osChoice = scanner.nextLine();
                if (Arrays.asList("Windows", "Linux").contains(osChoice)) {
                    choice.put("os", osChoice);
                } else {
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                }
                break;
            case "4":
                System.out.println("Доступные цвета:");
                Set<String> availableColors = getAvailableColors();
                for (String color : availableColors) {
                    System.out.println(color);
                }
                System.out.print("Введите цвета через запятую: ");
                String colorsInput = scanner.nextLine().toLowerCase();
                choice.put("color", colorsInput);
                break;
            case "5":
                System.out.println("Минимальная цена: " + getMinPrice());


                System.out.println("Максимальная цена: " + getMaxPrice());
                System.out.print("Введите максимальную цену: ");
                choice.put("price", scanner.nextLine());
                break;
            default:
                System.out.println("Некорректный ввод. Попробуйте снова.");
                break;
        }
    }

    private Set<String> getAvailableColors() {
        Set<String> colors = new HashSet<>();
        for (Notebook notebook : notebooks) {
            colors.add(notebook.getColor().toLowerCase());
        }
        return colors;
    }

    public void filterAndShowNotebooks() {
        List<Notebook> filteredNotebooks = new ArrayList<>(notebooks);

        filteredNotebooks.removeIf(notebook -> {
            for (Map.Entry<String, String> entry : choice.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "ram":
                        int minRam = Integer.parseInt(value);
                        if (notebook.getRam() < minRam) {
                            return true;
                        }
                        break;
                    case "storage":
                        int minStorage = Integer.parseInt(value);
                        if (notebook.getStorage() < minStorage) {
                            return true;
                        }
                        break;
                    case "os":
                        if (!notebook.getOs().equalsIgnoreCase(value)) {
                            return true;
                        }
                        break;
                    case "color":
                        List<String> colors = Arrays.asList(value.split(","));
                        if (!colors.contains(notebook.getColor().toLowerCase())) {
                            return true;
                        }
                        break;
                    case "price":
                        int maxPrice = Integer.parseInt(value);
                        if (notebook.getPrice() > maxPrice) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        });

        System.out.println("Ноутбуки, соответствующие критериям:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }


    public int getMinPrice() {
        int minPrice = Integer.MAX_VALUE;
        for (Notebook notebook : notebooks) {
            if (notebook.getPrice() < minPrice) {
                minPrice = notebook.getPrice();
            }
        }
        return minPrice;
    }

    public int getMaxPrice() {
        int maxPrice = Integer.MIN_VALUE;
        for (Notebook notebook : notebooks) {
            if (notebook.getPrice() > maxPrice) {
                maxPrice = notebook.getPrice();
            }
        }
        return maxPrice;
    }
}