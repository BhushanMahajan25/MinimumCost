import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinCost {
	
	private Long calculateCost(Integer noOfPersons, List<Long> costArray) {
		// Sort the price array 
        Collections.sort(costArray); 
        Long totalCost = new Long(0); 
      
        // Calculate minimum price of n-2 most costly person 
        for (Integer i = noOfPersons - 1; i > 1; i -= 2) 
        { 
            if (i == 2) 
            { 
                totalCost += costArray.get(2) + costArray.get(0); 
            } 
            else
            { 
                Long firstCost = costArray.get(i) + costArray.get(0) + 2 * costArray.get(1); 
                Long secondCost = costArray.get(i) + costArray.get(i-1) + 2 * costArray.get(0); 
                totalCost += Math.min(firstCost, secondCost); 
            } 
        } 
        // Calculate the minimum price of the two cheapest person 
        if (noOfPersons == 1) 
        { 
            totalCost += costArray.get(0); 
        } 
        else
        { 
            totalCost += costArray.get(1); 
        } 
        return totalCost; 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Enter testCases- ");
		Integer testCases = sc.nextInt();
		
		for(Integer t = 0; t < testCases; t++) {
			System.out.print("Enter noOfPersons- ");
			Integer noOfPersons = sc.nextInt();
			
			System.out.print("Enter cost- ");
			List<Long> costArray = new ArrayList<Long>();
			for(Integer i = 0; i < noOfPersons; i++) {
				Long cost = sc.nextLong();
				costArray.add(cost);
			}
			
			Collections.sort(costArray);
			MinCost obj = new MinCost();
			Long minCost = obj.calculateCost(noOfPersons, costArray);
			System.out.println("min cost:: " + minCost);	
		}
		sc.close();
	}

}
