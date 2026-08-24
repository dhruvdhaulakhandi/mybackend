package co.example.mybackend;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;        // "Car" ya "Bike"
    private String brand;       // e.g. Honda, Tata
    private String model;       // e.g. City, Nexon
    @Column(name = "manufacture_year")
    private int year;
    private double price;
    private String fuelType;    // Petrol, Diesel, Electric
    private double mileage;     // km/l ya km range
    private String description; // parts/specs details
    private boolean forSale;

    public Vehicle() {}

    public Vehicle(String type, String brand, String model, int year, double price,
                   String fuelType, double mileage, String description, boolean forSale) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.description = description;
        this.forSale = forSale;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getFuelType() { return fuelType; }
    public double getMileage() { return mileage; }
    public String getDescription() { return description; }
    public boolean isForSale() { return forSale; }
}
