package variable;

public class Animal {

    void AnimalSound() {
        System.out.println("동물의 소리: ");
    }

    static class Dog extends Animal {
        @Override
        void AnimalSound() {
            System.out.println("왈! 왈!");
        }
    }

    static class Cat extends Animal {
        @Override
        void AnimalSound() {
            System.out.println("미야옹~ 미야몽~");
        }
    }

    static class Pig extends Animal {
        @Override
        void AnimalSound() {
            System.out.println("꿀! 꿀!");
        }
    }

        public static void main(String[] args) {
            Animal animal = new Animal();
            animal.AnimalSound();

            Dog dog = new Dog();
            dog.AnimalSound();

            Cat cat = new Cat();
            cat.AnimalSound();

            Pig pig = new Pig();
            pig.AnimalSound();

            }
        }
    
