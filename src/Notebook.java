import java.util.Objects;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private int price;

    public Notebook(String brand, int ram, int storage, String os, String color, int price) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Модель: " + brand +
                ". ОЗУ: " + ram + " ГБ" +
                ". Объем жесткого диска: " + storage + " ГБ" +
                ". Операционная система: " + os +
                ". Цвет: " + color +
                ". Цена: " + price + " руб.";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Notebook notebook = (Notebook) obj;
        return ram == notebook.ram &&
                storage == notebook.storage &&
                price == notebook.price &&
                Objects.equals(brand, notebook.brand) &&
                Objects.equals(os, notebook.os) &&
                Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, storage, os, color, price);
    }
}