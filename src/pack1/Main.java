package pack1;
import java.util.Scanner;
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

	     
	        System.out.println("\n==============================");
	        System.out.println("ANTRENMAN ÖZETİ: " + currentWorkout.getWorkoutName());
	        System.out.println("Toplam Kaldırılan Hacim: " + currentWorkout.calculateTotalVolume() + " kg");
	        System.out.println("Harika İlerlemeye devam et.");
	        System.out.println("===============================");
	        

	        input.close();
	    }
	}

