import java.util.*;

class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double calculatePrice(int rentalDays) { return basePricePerDay * rentalDays; }
    public boolean isAvailable() { return isAvailable; }
    public void rent() { isAvailable = false; }
    public void returnCar() { isAvailable = true; }

    @Override
    public String toString() {
        return "🔑 " + carId + " - " + brand + " " + model + " | 💸 ₹" + basePricePerDay + "/day | " + (isAvailable ? "✅ Available" : "❌ Rented");
    }
}

class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "🧍 " + customerId + " - " + name;
    }
}

class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private Date rentalDate;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.rentalDate = new Date();
    }

    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public int getDays() { return days; }

    @Override
    public String toString() {
        return "📝 " + customer.getName() + " rented " + car.getBrand() + " " + car.getModel() +
                " (ID: " + car.getCarId() + ") for " + days + " days 📆 on " + rentalDate;
    }
}

class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findOrCreateCustomer(String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        Customer newCustomer = new Customer("CUS" + (customers.size() + 1), name);
        addCustomer(newCustomer);
        return newCustomer;
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
            System.out.println("\n✅ Car rented successfully! 🎉");
        } else {
            System.out.println("❌ Sorry! Car is not available for rent.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("✅ Car returned successfully by 🧍 " + rentalToRemove.getCustomer().getName());
        } else {
            System.out.println("❌ Car was not rented.");
        }
    }

    public void displayAllCars() {
        System.out.println("\n📋 All Cars in Fleet:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void displayAvailableCars() {
        System.out.println("\n🚗 Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public void displayCustomers() {
        System.out.println("\n👤 Registered Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void searchCar() {
        System.out.print("🔍 Enter brand or model to search: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Car car : cars) {
            if (car.getBrand().toLowerCase().contains(keyword) || car.getModel().toLowerCase().contains(keyword)) {
                System.out.println("🔎 Match: " + car);
                found = true;
            }
        }
        if (!found) System.out.println("❗ No car found for the keyword.");
    }

    public void viewRentalHistory() {
        System.out.println("\n🕓 Rental History:");
        if (rentals.isEmpty()) {
            System.out.println("📭 No rentals yet.");
        } else {
            for (Rental rental : rentals) {
                System.out.println(rental);
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n===============================");
            System.out.println("🚗 Welcome to Car Rental System");
            System.out.println("===============================");
            System.out.println("1️⃣  Rent a Car");
            System.out.println("2️⃣  Return a Car");
            System.out.println("3️⃣  View All Cars");
            System.out.println("4️⃣  View Available Cars");
            System.out.println("5️⃣  Search Car");
            System.out.println("6️⃣  View Customers");
            System.out.println("7️⃣  Rental History");
            System.out.println("8️⃣  Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: rentCarFlow(); break;
                case 2: returnCarFlow(); break;
                case 3: displayAllCars(); break;
                case 4: displayAvailableCars(); break;
                case 5: searchCar(); break;
                case 6: displayCustomers(); break;
                case 7: viewRentalHistory(); break;
                case 8:
                    System.out.println("👋 Thank you for using the Car Rental System! Have a great day 🚘💨");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private void rentCarFlow() {
        System.out.print("\n👤 Enter your name: ");
        String name = scanner.nextLine();
        Customer customer = findOrCreateCustomer(name);

        displayAvailableCars();

        System.out.print("\n🔑 Enter Car ID to rent: ");
        String carId = scanner.nextLine();
        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId) && car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar == null) {
            System.out.println("❌ Invalid Car ID or the car is not available.");
            return;
        }

        System.out.print("📆 Enter rental days: ");
        int days = Integer.parseInt(scanner.nextLine());

        double total = selectedCar.calculatePrice(days);
        System.out.printf("💰 Total Price: ₹%.2f%n", total);

        System.out.print("📝 Confirm rental? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            rentCar(selectedCar, customer, days);
        } else {
            System.out.println("❌ Rental cancelled.");
        }
    }

    private void returnCarFlow() {
        System.out.print("\n🔁 Enter Car ID to return: ");
        String carId = scanner.nextLine();
        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId) && !car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar == null) {
            System.out.println("❌ Car not found or not rented.");
        } else {
            returnCar(selectedCar);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        rentalSystem.addCar(new Car("C001", "Toyota", "Camry", 1200.0));
        rentalSystem.addCar(new Car("C002", "Honda", "Accord", 1500.0));
        rentalSystem.addCar(new Car("C003", "Mahindra", "Thar", 5000.0));
        rentalSystem.addCar(new Car("C004", "BMW", "X5", 10000.0));
        rentalSystem.addCar(new Car("C005", "Audi", "Q7", 15000.0));
        rentalSystem.addCar(new Car("C006", "Ferrari", "296 GTB", 25000.0));

        rentalSystem.menu();
    }
}
