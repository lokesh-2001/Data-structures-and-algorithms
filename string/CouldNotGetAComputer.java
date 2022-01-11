// Function to find Number of customers who could not get a computer

// Write a function "runCustomerSimulation" that takes following two inputs 
// a) An integer 'n': total number of computers in a cafe and a string: 
// b) A sequence of uppercase letters 'seq': Letters in the sequence occur in pairs. 
// The first occurrence indicates the arrival of a customer; the second indicates the departure 
// of that same customer. 
public class CouldNotGetAComputer {
    static int max_char = 26;

    static int find(int n, char[] seq) {
        // seen[i] = 0, indicates that customer 'i' is not in cafe
        // seen[1] = 1, indicates that customer 'i' is in cafe but
        // computer is not assigned yet.
        // seen[2] = 2, indicates that customer 'i' is in cafe and
        // has occupied a computer.
        char[] seen = new char[max_char];
        int res = 0;
        int occupied = 0;
        for (int i = 0; i < seq.length; i++) {
            int index = seq[i] - 'A';
            if (seen[index] == 0) {
                seen[index] = 1;
                if (occupied < n) {
                    occupied++;
                    seen[index] = 2;
                } else
                    res++;
            }
            else{
                if(seen[index] == 2)
                    occupied --;
                seen[index] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(find(2, "ABBAJJKZKZ".toCharArray()));
        System.out.println(find(3, "GACCBDDBAGEE".toCharArray()));
        System.out.println(find(3, "GACCBGDDBAEE".toCharArray()));
        System.out.println(find(1, "ABCBCA".toCharArray()));
        System.out.println(find(1, "ABCBCADEED".toCharArray()));
    
    }
}
