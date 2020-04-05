public class Dec2Base{
	public static void main(String[] args){
		//execute the program if there is 1 parameter else display error message		
		if(args.length > 0)
			//if the first argument is a integer do conversions else display error messages
			if( isNumber(args[0]) ){
				int dec = Integer.parseInt(args[0]);
				System.out.println("Hex = " + Integer.toHexString(dec));
				System.out.println("Oct = " + Integer.toOctalString(dec));
				System.out.println("Bin = " + Integer.toBinaryString(dec));
			}
			else{
				System.out.println("Error invalid integer");
				System.out.println("Usage Example: java DecToBase 15");
			}
		else
			System.out.println("Error: you must enter in a number to convert");
	}
	
	//function to check if a number is a integer
	public static boolean isInteger(String toCheck) {
		try {
			Integer.parseInt(toCheck);
			return true;
		} catch (NumberFormatException numForEx) {
			return false;
		} 
	}
}
