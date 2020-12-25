package com.dong.generics;

public class GenericsDemo01 {

    public static void main(String[] args) {
        NotePad<String, String> notePad = new NotePad<String, String>();
        notePad.setKey("曹操");
        notePad.setValue("三国人物");
        System.out.println("人物：" + notePad.getKey());
        System.out.println("角色：" + notePad.getValue());
    }
}

// <k,v>泛型
class NotePad<K, V> {
    private K key;
    private V value;


    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
