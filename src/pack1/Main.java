package pack1;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("---- GymProgress Pro: Antrenman Takip Sistemi ----");
        
        System.out.print("Bugünkü antrenman programınız (örn: Push Day): ");
        String workoutName = input.nextLine();
        Workout currentWorkout = new Workout(workoutName);

        boolean addingSets = true;

        while (addingSets) {
            System.out.println("\nSet Bilgilerini Girin:");
            
            System.out.print("Egzersiz Adı: ");
            String name = input.next();
            name += input.nextLine(); 
            
            System.out.print("Ağırlık (kg): ");
            int weight = input.nextInt();
            
            System.out.print("Tekrar Sayısı: ");
            int reps = input.nextInt();

            currentWorkout.addSet(new WorkoutSet(name, weight, reps));

            System.out.print("Başka set eklemek istiyor musunuz? (E/H): ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("H")) {
                addingSets = false;
            }
        }

        System.out.println("\n===============================");
        System.out.println("ANTRENMAN ÖZETİ: " + currentWorkout.getWorkoutName());
        System.out.println("Toplam Kaldırılan Hacim: " + currentWorkout.calculateTotalVolume() + " kg");
        System.out.println("===============================");

    
        try {
         
            FileWriter fileWriter = new FileWriter("antrenman_gecmisi.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.println("Antrenman: " + currentWorkout.getWorkoutName() + " | Toplam Hacim: " + currentWorkout.calculateTotalVolume() + " kg");
            
            printWriter.close();
            System.out.println("Veriler başarıyla 'antrenman_gecmisi.txt' dosyasına kaydedildi!");
        } catch (IOException e) {
          
            System.out.println("Dosya kaydedilirken bir hata oluştu: " + e.getMessage());
        }

        input.close();
    }
}