// Find the first circular tour that visits all Petrol Pumps
// Suppose there is a circle. There are n petrol pumps on that circle. 
// You are given two sets of data.

// The amount of petrol that every petrol pump has.
// Distance from that petrol pump to the next petrol pump.
// Calculate the first point from where a truck will be able to complete 
// the circle (The truck will stop at each petrol pump and it has infinite 
// capacity). Expected time complexity is O(n). Assume for 1-litre petrol, 
// the truck can go 1 unit of distance.

public class PetrolPumpProblem {
    static class petrolPump {
        int petrol, distance;

        public petrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    // * METHOD 1
    static int printTour1(petrolPump arr[], int n) {
        int start = 0, end = 1;
        int curr = arr[start].petrol - arr[start].distance;
        while (end != start || curr < 0) {
            while (curr < 0 && start != end) {
                curr -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            curr += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;
        }
        return start;
    }

    // * METHOD 2
    static int printTour2(petrolPump p[], int n) {
        int start = 0, deficit = 0;
        int capacity = 0;
        for (int i = 0; i < n; i++) {
            capacity += p[i].petrol - p[i].distance;
            if (capacity < 0) {
                start = i + 1;
                deficit += capacity;
                capacity = 0;
            }
        }
        return (capacity + deficit > 0) ? start : -1;
    }

    public static void main(String[] args) {
        petrolPump[] arr = { new petrolPump(6, 4),
                new petrolPump(3, 6),
                new petrolPump(7, 3) };

        System.out.println("Method 1");
        int start1 = printTour1(arr, arr.length);
        System.out.println(start1 == -1 ? "No Solution" : "Start = " + start1);
        System.out.println();
        System.out.println("Method 2");
        int start2 = printTour1(arr, arr.length);

        System.out.println(start2 == -1 ? "No Solution" : "Start = " + start2);

    }
}
