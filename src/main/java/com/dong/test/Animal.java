package com.dong.test;



public class Animal {
    void eat() {
        System.out.println("我是Animal,我会吃东西！");
    };
}
class Base {
    Animal animal;

    public Base(Animal animal) {
        this.animal = animal;
    }

    public void baseEat() {
        animal.eat();
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("我是Dog, 我喜欢吃骨头！");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("我是小猫，我很可爱，我爱吃鱼！");
    }
}

class People {
    public void put(Animal animal) {
        animal.eat();
    }
}
