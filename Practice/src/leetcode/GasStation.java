package leetcode;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, begin = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) {
                total += sum;
                sum = 0;
                begin = i+1;
            }
        }
        total += sum;
        return total < 0 ? -1 : begin;
    }
	
	public static void main(String arg[]) {
		GasStation gs = new GasStation();
		int[] gas = {4};
		int[] cost = {5};
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}
}
