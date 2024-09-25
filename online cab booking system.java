// Passenger.java
public class Passenger {
 private String name;
 private String contactNumber;
 public Passenger(String name, String contactNumber) {
 this.name = name;
 this.contactNumber = contactNumber;
 }
 public String getName() {
 return name;
 }
 public String getContactNumber() {
 return contactNumber;
 }}
// Cab.java
public class Cab {
 private String cabNumber;
 private boolean available;
 public Cab(String cabNumber) {
 this.cabNumber = cabNumber;
 this.available = true; // Initially, all cabs are available
 }
 public String getCabNumber() {
 return cabNumber;
 }
 public boolean isAvailable() {
 return available;
 }
 public void setAvailable(boolean available) {
 this.available = available;
 }
 @Override
 public String toString() {
 return "Cab Number: " + cabNumber + ", Available: " + available;
 }
}
// BookingSystem.java
import java.util.ArrayList;
import java.util.List;
public class BookingSystem {
 private List<Cab> availableCabs;
 public BookingSystem() {
 availableCabs = new ArrayList<>();
 // Assume there are three cabs available initially
 availableCabs.add(new Cab("Cab001"));
 availableCabs.add(new Cab("Cab002"));
 availableCabs.add(new Cab("Cab003"));
 }
 public Cab bookNearestCab(Passenger passenger) {
 // For simplicity, just book the first available cab
 for (Cab cab : availableCabs) {
 if (cab.isAvailable()) {
 cab.setAvailable(false);
 System.out.println("Cab " + cab.getCabNumber() + " booked
for " + passenger.getName());
 return cab;
 }
 }
 System.out.println("Sorry, no cabs available at the moment.");
 return null;
 }
 public void releaseCab(Cab cab) {
 cab.setAvailable(true);
 System.out.println("Cab " + cab.getCabNumber() + " released.");
 }
 public void displayAvailableCabs() {
 System.out.println("Available Cabs:");
 for (Cab cab : availableCabs) {
 System.out.println(cab);
 }
 }
}
// Main.java
public class Main {
 public static void main(String[] args) {
 // Creating a booking system
 BookingSystem bookingSystem = new BookingSystem();
 // Creating passengers
 Passenger passenger1 = new Passenger("Alice", "1234567890");
 Passenger passenger2 = new Passenger("Bob", "9876543210");
 // Displaying available cabs
 bookingSystem.displayAvailableCabs();
 // Booking cabs
 Cab cab1 = bookingSystem.bookNearestCab(passenger1);
 Cab cab2 = bookingSystem.bookNearestCab(passenger2);
 // Displaying available cabs after bookings
 bookingSystem.displayAvailableCabs();
 // Simulating releasing the cabs after some time
 bookingSystem.releaseCab(cab1);
 // Booking another cab for Bob
 Cab cab3 = bookingSystem.bookNearestCab(passenger2);
 // Displaying available cabs after releasing and booking again
 bookingSystem.displayAvailableCabs();
 // Releasing the last cab
 bookingSystem.releaseCab(cab3);
 }
}