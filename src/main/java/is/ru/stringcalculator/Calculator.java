package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	    } else {
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
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
}