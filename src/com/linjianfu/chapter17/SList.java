package com.linjianfu.chapter17;

public class SList<T> {
    private Node<T> firstNode = new Node<T>(null);

    SListIterator<T> iterator() {
        return new SListIterator<>(firstNode);
    }

    @Override
    public String toString() {
        if (firstNode.next == null) return "[]";
        SListIterator<T> it = this.iterator();
        StringBuilder s = new StringBuilder("[");
        while (it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        s.append("]");
        return s.toString();
    }

    private static class Node<U> {
        private U u;
        private Node<U> next;

        Node(U u, Node<U> next) {
            this.u = u;
            this.next = next;
        }

        Node(U u) {
            this(u, null);
        }
    }

    static class SListIterator<E> {
        private Node<E> current;

        SListIterator(Node<E> node) {
            current = node;
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public E next() {
            current = current.next;
            return current.u;
        }

        public void insert(E e) {
            current.next = new Node<E>(e, current.next);
            current = current.next;
        }

        public void remove() {
            if (current.next != null)
                current.next = current.next.next;
        }
    }
}
