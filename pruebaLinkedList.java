public class pruebaLinkedList {
    public static void main(String[] args) {
        
        System.out.println("=== 1. INICIALIZACIÓN Y APPEND ===");
        linkedList ll = new linkedList(10);
        ll.append(20);
        ll.append(30);
        ll.append(40);
        ll.append(50);
        ll.printList(); // Esperado: 10, 20, 30, 40, 50
        
        System.out.println("\n=== 2. MÉTODOS GETTERS ===");
        ll.getHead();   // Esperado: 10
        ll.getTail();   // Esperado: 50
        ll.getLength(); // Esperado: 5

        System.out.println("\n=== 3. PROBANDO PREPEND ===");
        ll.prepend(5);
        ll.printList(); // Esperado: 5, 10, 20, 30, 40, 50
        ll.getHead();   // Esperado: 5
        ll.getLength(); // Esperado: 6

        System.out.println("\n=== 4. PROBANDO GET Y SET ===");
        System.out.println("Get índice 2: " + ll.get(2).value); // Esperado: 20
        System.out.println("Set índice 2 a 99: " + ll.set(2, 99)); // Esperado: true
        System.out.println("Verificando cambio:");
        ll.printList(); // Esperado: 5, 10, 99, 30, 40, 50

        System.out.println("\n=== 5. PROBANDO INSERT ===");
        System.out.println("Insertando 15 en índice 2: " + ll.insert(2, 15));
        ll.printList(); // Esperado: 5, 10, 15, 99, 30, 40, 50
        
        System.out.println("\n=== 6. PROBANDO MEDIO ===");
        System.out.println("Nodo medio actual: " + ll.medio().value); // Esperado: 99 (índice 3 de 7)

        System.out.println("\n=== 7. PROBANDO REVERSE ===");
        ll.reverse();
        ll.printList(); // Esperado: 50, 40, 30, 99, 15, 10, 5
        ll.getHead();   // Esperado: 50
        ll.getTail();   // Esperado: 5

        System.out.println("\n=== 8. PROBANDO ERASE (Índice específico) ===");
        System.out.println("Borrando índice 3 (valor 99): " + ll.erase(3).value);
        ll.printList(); // Esperado: 50, 40, 30, 15, 10, 5

        System.out.println("\n=== 9. PROBANDO REMOVE FIRST Y LAST ===");
        System.out.println("Remove First: " + ll.removeFirst().value); // Esperado: 50
        System.out.println("Remove Last: " + ll.removeLast().value);   // Esperado: 5
        System.out.println("Lista actual:");
        ll.printList(); // Esperado: 40, 30, 15, 10

        System.out.println("\n=== 10. PROBANDO CICLO (Sin ciclo) ===");
        System.out.println("¿Tiene ciclo?: " + ll.ciclo()); // Esperado: false

        // FORZANDO CICLO
        System.out.println("\n=== 11. PROBANDO CICLO (Con ciclo forzado) ===");
        linkedList.Node tailNode = ll.get(3);
        linkedList.Node headNode = ll.get(0);
        tailNode.next = headNode;         
        System.out.println("¿Tiene ciclo ahora?: " + ll.ciclo()); // Esperado: true
        
    }
}