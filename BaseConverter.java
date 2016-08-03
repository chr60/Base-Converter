//Christen Reinbeck
//June 1, 2016

import java.util.*;
import java.lang.*;

public class BaseConverter {
	
	
	public static void main(String[] args) {
		if(args[0]==null || args[1]==null){
			System.exit(0);
		}
		
		String input = args[0];
		String b = args[1];
		int base = Integer.parseInt(b);
		double number = 0;
		char[] a = input.toCharArray();
		
		String hex = "", binary = "", bin = "", h = "", decimal = ""; 
		int dec = 0;
		
		//binary
		if(base == 2){
			bin = fullLengthBin(input);
			dec = binToDec(input);
			h = decToHex(dec);
			hex = fullLengthHex(h);
			
		}
		//decimal
		else if(base == 10){
			dec = Integer.parseInt(input);
			binary = decToBin(dec);
			bin = fullLengthBin(binary);
			h = decToHex(dec);
			hex = fullLengthHex(h);
		}
		//hexadecimal
		else{
			hex = input;
			dec = hexToDec(input);
			binary = decToBin(dec);
			bin = fullLengthBin(binary);
			
		}
		
		
		System.out.println("Dec: " + dec);
		System.out.println("Bin: " + bin);
		System.out.println("Hex: " + hex);
		
		
		
	}
	
	public static String fullLengthBin(String in){
		//makes binary 16 digits long
		if(in.length()<16){
			int numZeros = 16 - in.length();
			String extraZero = "0";
			for(int k = 0; k<numZeros; k++){
				in = extraZero + in;
			}
		}
		
		return in;
	}
	
	public static String fullLengthHex(String in){
		//makes hex four digits long
		if(in.length()<4){
			int numZeros = 4 - in.length();
			String extraZero = "0";
			for(int k = 0; k<numZeros; k++){
				in = extraZero + in;
			}
		}
		return in;
	}
	
	public static int binToDec(String in){
		int len = in.length();
		double dec = 0;
		char[] arr = in.toCharArray();
		for(int i=0; i < len; i++){
			if(arr[i] != '0'){
				int x = len-1-i;
				dec = dec + Math.pow(2,x);
			}
		}
		return (int) dec;
		
	}
	
	
	public static String decToBin(double number){
		int newNum = 0;
		String concat = "";
		boolean x = true;
		while(x == true){
			newNum = (int) number % 2;
			number = (int) number * .5;
			if(newNum == 1){
				concat = "1" + concat;
			}else if(newNum == 0){
				concat = "0" + concat;
			}
			if(number < 1){
				x = false;
				
			}

		}
		return concat;
	}
	
	
	public static String decToHex(double number){

			int newNum = 0;
			String concat = "";
			boolean x = true;
			while(x == true){
				newNum = (int) number % 16;
				number = (int) number / 16;
				if(newNum == 15){
					concat = "f" + concat;
				}else if(newNum == 14){
					concat = "e" + concat;
				}else if(newNum == 13){
					concat = "d" + concat;
				}else if(newNum == 12){
					concat = "c" + concat;
				}else if(newNum == 11){
					concat = "b" + concat;
				}else if(newNum == 10){
					concat = "a" + concat;
				}else if(newNum == 9){
					concat = "9" + concat;
				}else if(newNum == 8){
					concat = "8" + concat;
				}else if(newNum == 7){
					concat = "7" + concat;
				}else if(newNum == 6){
					concat = "6" + concat;
				}else if(newNum == 5){
					concat = "5" + concat;
				}else if(newNum == 4){
					concat = "4" + concat;
				}else if(newNum == 3){
					concat = "3" + concat;
				}else if(newNum == 2){
					concat = "2" + concat;
				}else if(newNum == 1){
					concat = "1" + concat;
				}else if(newNum == 0){
					concat = "0" + concat;
				}
				if(number <1){
					x = false;
					
				}

			}
			return concat;
		
	}
	
	public static int hexToDec(String in){
		int len = in.length();
		double dec = 0;
		int num = 0, x = 0;
		char[] arr = in.toCharArray();
		for(int i=0; i < len; i++){
			if(arr[i] != '0'){
			if(arr[i] != 'a' && arr[i] != 'b' && arr[i] != 'c' && arr[i] != 'd' && arr[i] != 'e' && arr[i] != 'f'){
				num = Character.getNumericValue(arr[i]);
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;
			}else if(arr[i] == 'a'){
				num = 10;
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;

			}else if(arr[i] == 'b'){
				num = 11;
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;

			}else if(arr[i] == 'c'){
				num = 12;
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;

			}else if(arr[i] == 'd'){
				num = 13;
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;

			}else if(arr[i] == 'e'){
				num = 14;
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;

			}else if(arr[i] == 'f'){
				num = 15;
				x = len-1-i;
				dec = dec + Math.pow(16,x)*num;

			}
			}
		}
		return (int) dec;
	}
	
}
