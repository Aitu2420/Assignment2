import java.util.*;
import java.util.stream.Collectors;

public class ACMPFILE {
    // Абстрактный класс Animal
    abstract static class Animal {
        private String name;
        private String diet;
        private int age;
        public Animal(String name, String diet, int age) {
            this.name = name;
            this.diet = diet;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDiet() {
            return diet;
        }
        public void setDiet(String diet) {
            this.diet = diet;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public abstract void makeSound(); // Абстрактный метод и полиморфизм
        @Override
        public String toString() {
            return "Animal{name='" + name + "', diet='" + diet + "', age=" + age + "}";
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Animal animal = (Animal) obj;
            return age == animal.age && Objects.equals(name, animal.name) && Objects.equals(diet, animal.diet);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, diet, age);
        }
    }
    // Конкретные классы животных
    static class Lion extends Animal {
        public Lion(String name, int age) {
            super(name, "Meat", age);
        }
        @Override
        public void makeSound() {
            System.out.println("Roar!");
        }
    }
    static class Elephant extends Animal {
        public Elephant(String name, int age) {
            super(name, "Plants", age);
        }
        @Override
        public void makeSound() {
            System.out.println("Trumpet!");
        }
    }
    static class Zebra extends Animal {
        public Zebra(String name, int age) {
            super(name, "Plants", age);
        }
        @Override
        public void makeSound() {
            System.out.println("Neigh!");
        }
    }
    // Класс Zookeeper
    static class Zookeeper {
        private String name;
        private int age;
        private int yearsOfExperience;
        public Zookeeper(String name, int age, int yearsOfExperience) {
            this.name = name;
            this.age = age;
            this.yearsOfExperience = yearsOfExperience;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public int getYearsOfExperience() {
            return yearsOfExperience;
        }
        public void setYearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
        }
        @Override
        public String toString() {
            return "Zookeeper{name='" + name + "', age=" + age + ", yearsOfExperience=" + yearsOfExperience + "}";
        }
    }
    // Класс Zoo
    static class Zoo {
        private String name;
        private String address;
        private List<Animal> animals;
        public Zoo(String name, String address) {
            this.name = name;
            this.address = address;
            this.animals = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void addAnimal(Animal animal) {
            animals.add(animal);
        }
        //Фильтр по возрасту
        public List<Animal> filterAnimalsByAge(int age) {
            return animals.stream()
                    .filter(animal -> animal.getAge() > age)
                    .collect(Collectors.toList());
        }
        //Фильтр по Имени
        public Animal findAnimalByName(String name) {
            return animals.stream()
                    .filter(animal -> animal.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        public void sortAnimalsByAge() {
            animals.sort(Comparator.comparingInt(Animal::getAge));
        }
        public void showAnimals() {
            animals.forEach(System.out::println);
        }
    }
    public static void main(String[] args) {
        // Создаем животных
        Animal zebra = new Zebra("Ziggy", 3);
        Animal lion = new Lion("Simba", 5);
        Animal elephant = new Elephant("Dumbo", 10);
        // Создаем зоопарк
        Zoo zoo = new Zoo("Safari Park", "123 Jungle Road");
        zoo.addAnimal(zebra);
        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);
        // Показать всех животных
        zoo.showAnimals();
        // Фильтрация животных старше 4 лет
        zoo.filterAnimalsByAge(4).forEach(System.out::println);
        // Поиск животного по имени
        System.out.println(zoo.findAnimalByName("Simba"));
        // Сортировка животных по возрасту
        zoo.sortAnimalsByAge();
        zoo.showAnimals();
        // Проверяем звуки животных
        zebra.makeSound();
        lion.makeSound();
        elephant.makeSound();
    }
}