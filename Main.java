import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

public class Main {
    public static void main(String args[]) {
        Cow newCow = new Cow("Gisela", "Kuh");

        System.out.print(newCow);
        newCow.feed();
        System.out.println(newCow);
    }


    public static class Cow {
        private String name;
        private String species;
        private LocalDateTime lastFedAt;

        public Cow(String name, String species) {
            if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Name can't be empty");
                }
            this.name = name;
            this.species = species;
            this.lastFedAt = LocalDateTime.now().minusHours(8);
        }


        public boolean isHungry() {
            Duration sinceLastFed = Duration.between(lastFedAt, LocalDateTime.now());
            return sinceLastFed.toHours() >= 8;
        }

        public void feed() {
            this.lastFedAt = LocalDateTime.now();
            System.out.print(name + " wurde gefuettert");
        }

        public String getName() {
            return name;
        }

        public String getSpecies() {
            return species;
        }

        @Override
        public String toString() {
            return "Cow{name='" + name + "', species='" + species + "', hungry=" + isHungry() + "}";
            }
    }
}
