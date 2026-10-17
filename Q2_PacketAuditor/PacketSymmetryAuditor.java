package Q2_PacketAuditor;

public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String payload = "RACECAR";
        int len = payload.length();
        TransactionStack stack = new TransactionStack(len);
        RequestQueue queue = new RequestQueue(len);

        for (int i = 0; i < len; i++) {
            char c = payload.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        boolean isSymmetric = true;
        System.out.println("--- Concurrent LIFO/FIFO Symmetry Audit ---");
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.dequeue();
            System.out.println("Stack Pop: " + stackChar + " | Queue Dequeue: " + queueChar);
            if (stackChar != queueChar) isSymmetric = false;
        }

        System.out.println("Payload: " + payload);
        System.out.println("Audit Result: " + (isSymmetric ? "VERIFIED (Bi-Directional Symmetry Valid)" : "REJECTED"));
    }
}
