package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("/")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    if(numbers.startsWith("//")){
	    	return splitByDelimiter(numbers);
	    }
	    else {
	    	return numbers.split(",|\n");
		}
	}

	private static String[] splitByDelimiter(String numbers){
	    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
	    m.matches();
	    String delimiter = m.group(1);
	    String num = m.group(2);
	    return num.split(delimiter);
	}
    
    private static int sum(String[] numbers){
 	    int total = 0;
 	    int total2 = 0;
 	    ArrayList<String> myArray = new ArrayList<String>();
	    for(String number : numbers)
	    {
	        total2 = toInt(number);
	        if(total2 < 0){
	        	myArray.add(number);
			}
			if(total2 > 1000){
				continue;
			}
			total += toInt(number);
		}
		if(myArray.isEmpty())
			return total;
		else{
			String negatives = "";
			for(String neg : myArray){
				negatives += neg + ",";
			}
			throw new RuntimeException("Negatives not allowed: " +negatives);
		}

 	}

    private static String toString(ArrayList<Integer> number){
    	return String.valueOf(number);
    }
    
    private static void negativeNumbers(String[] numbers){
    	String negativeNum = "";
    	int total = 0;
    	for(String number : numbers){
    		total = toInt(number);
    		if(total < 0){
        		ArrayList<Integer> negative = new ArrayList<Integer>();
				negative.add(total);
				negativeNum += toString(negative);
			}
    	}
    	System.out.println("Negatives not allowed: " + negativeNum);
 		   	
    }
}