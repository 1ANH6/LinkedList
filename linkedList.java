public class linkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        
        public Node(int value) {
            this.value = value;
        }
    }
    /* 
        Constructor de la clase linkedList.
        Inicializa la lista creando el primer nodo.
        Recibe: 'value' (int) - El valor para el nodo inicial.
    */
    public linkedList(int value) {
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
    }

    // Imprime el valor del primer nodo (head).
    public void getHead() {
        System.out.println("Head:" + head.value);
    }

    // Imprime el valor del último nodo (tail).
    public void getTail() {
        System.out.println("Tail:" + tail.value);
    }

    // Imprime la longitud actual de la lista.
    public void getLength() {
        System.out.println("Length:" + length);
    }

    /* 
        Agrega un nuevo nodo al final de la lista.
        Recibe: 'value' (int) - El valor a insertar.
    */
    public void append(int value) {
        if(length == 0) {
            Node newNode = new Node(value);
            length = 1;
            head = newNode;
            tail = newNode;
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }
 
    
    //Recorre la lista desde el principio e imprime cada valor.     
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* 
        Elimina el último nodo de la lista.
        Retorna: El Nodo que fue eliminado (o null si estaba vacía).
    */
    public Node removeLast() {
        if(length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    /* 
        Elimina el primer nodo de la lista.
        Retorna: El Nodo que fue eliminado (o null si estaba vacía).
    */
    public Node removeFirst() {
        if(length == 0) {
            return null;
        }
        length--;
        if(length == 0) {
            Node temp = head;
            head = null;
            tail = null;
            return temp; 
        }
        Node temp = head.next;
        Node nod = head;
        head = temp;
        return nod;
    }

    /* 
        Agrega un nuevo nodo al principio de la lista.
        Recibe: 'value' (int) - El valor a insertar.
    */
    public void prepend(int value) {
        if(length == 0) {
            Node newNode = new Node(value);
            length = 1;
            head = newNode;
            tail = newNode;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++; // Agregado el incremento de length
    }

    /* 
        Obtiene el nodo que se encuentra en un índice específico.
        Recibe: 'id' (int) - La posición del nodo (0-indexado).
        Retorna: El Nodo encontrado (o null si el índice es inválido).
    */
    public Node get(int id) {
        if(id < 0 || id >= length) {
            return null;
        } 
        Node temp = head;
        for(int i = 0; i < id; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /* 
        Modifica el valor de un nodo en un índice específico.
        Recibe: 'id' (int) - La posición del nodo. 'value' (int) - El nuevo valor.
        Retorna: 'true' si se modificó con éxito, 'false' si el índice era inválido.
    */
    public boolean set(int id, int value) {
        if(id < 0 || id >= length) {
            return false;
        }
        Node temp = head;
        for(int i = 0; i < id; i++) {
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    /* 
        Encuentra y devuelve el nodo central de la lista.
        Retorna: El Nodo central (el de la derecha si es par, o null si vacía).
    */
    public Node medio() {
        if(head == null) {
            return null;
        }
        Node nod1 = head; 
        Node nod2 = head; 
        while(!(nod1 == null || nod1 == tail)) {
            nod1 = nod1.next.next;
            nod2 = nod2.next;
        }
        return nod2;
    }

    /* 
        Detecta si la lista contiene un ciclo (bucle cerrado).
        Retorna: 'true' si detecta un ciclo, 'false' si no.
    */
    public boolean ciclo() {
        if(head == null || head.next == null) {
            return false; 
        }
        Node nod1 = head;
        Node nod2 = head;
        while(nod2 != null && nod2.next != null) {
            nod1 = nod1.next;
            nod2 = nod2.next.next;
            if(nod1 == nod2) {
                return true; 
            }
        }
        return false;
    }

    /* 
        Invierte la dirección de todos los enlaces de la lista.
        El primer nodo pasa a ser el último y viceversa.
    */
    public void reverse() {
        if(length <= 1) {
            return;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        Node nxt = temp.next; 
        Node ant = null;     

        for(int i = 0; i < length; i++) {
            nxt = temp.next;  
            temp.next = ant; 
            ant = temp;      
            temp = nxt;       
        }
    }

    /* 
        Inserta un nuevo nodo en una posición específica de la lista.
        Recibe: 'id' (int) - El índice donde insertar. 'value' (int) - El valor a insertar.
        Retorna: 'true' si se insertó con éxito, 'false' si el índice es inválido.
    */
    public boolean insert(int id, int value) {
        if(id < 0 || id > length) {
            return false;
        } 
        if(id == 0) {
            prepend(value);
            return true;
        }
        if(id == length) {
            append(value);
            return true;
        }
        int i = 0;
        Node temp = head;
        while(i < id-1) {
            temp = temp.next;
            i++;
        }
        Node nxt = temp.next;
        Node newNode = new Node(value);
        temp.next = newNode;
        newNode.next = nxt;
        length++;
        return true;
    }

    /* 
        Elimina un nodo en una posición específica de la lista.
        Recibe: 'id' (int) - El índice del nodo a eliminar.
        Retorna: El Nodo que fue eliminado (o null si el índice es inválido o lista vacía).
    */
    public Node erase(int id) {
        if(length == 0) {
            return null;
        }
        if(id < 0 || id >= length) {
            return null;
        }
        if(id == 0) {
            return removeFirst();
        }
        if(id == length-1) {
            return removeLast();
        }
        int i = 0;
        Node temp = head;
        while(i < id-1) {
            temp = temp.next;
            i++;
        }
        length--;
        Node reg = temp.next;
        temp.next = temp.next.next;
        return reg;
    }
}