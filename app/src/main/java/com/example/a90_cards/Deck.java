package com.example.a90_cards;

public class Deck {

    Node first;
    private static int size = 0;

    private class Node {
        Node next;
        Card card;

        public Node(Card card) {
            this.card = card;
        }
    }

    public void push(Card card) {
        Node node = new Node(card);

        if (first == null){
            first = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public Card pop() {
        Node temp = first;

        if (first.next == null) {
            first = null;
        } else {
            first = first.next;
        }

        size--;
        return temp.card;
    }

    public Card peek() {
        return first.card;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
