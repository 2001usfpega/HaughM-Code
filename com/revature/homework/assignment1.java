package com.revature.homework;

public class assignment1 {

	public static void main(String[] args) {
		do {// 1
			int[] input = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
			int[] out = bubbleSort(input);
			for (int i : input) {
				System.out.print(i);
			}
			System.out.println();
			for (int i : out) {
				System.out.print(i);
			}
			System.out.println();
		} while (false);
		for (int i : fibonacci()) {// 2
			System.out.println(i);
		}
		do {// 3
			String input = "Its going to reverse Me!";
			System.out.println(input);
			System.out.println(reverseString(input));
		} while (false);
		do {// 4
			int input = 5;
			System.out.println("Nfactorial of " + input);
			System.out.println(nFactorial(input));
		} while (false);
		do {// 5
			String input1 = "The quick brown fox jumped over the lazy dog.";
			int input2 = 15;
			System.out.println("first " + input2 + " char from: \"" + input1 + "\"");
			System.out.println(getSubstring(input1, input2));
		} while (false);
		do {// 6
			for (int i = 1; i <= 20; i++) {
				System.out.println("Is " + i + " even? " + isEven(i));
			}
		} while (false);
		do {// 7
			ArrayList<Employee> ar = new ArrayList<Employee>();
			ar.add(new Employee("Alice", "Packing", 30));
			ar.add(new Employee("Charlie", "Unpacking", 30));
			ar.add(new Employee("Bob", "Packing", 25));
			ar.add(new Employee("Alice", "Unpacking", 30));
			ar.add(new Employee("Charlie", "Packing", 30));
			ar.add(new Employee("Bob", "Driver", 50));
			System.out.println("Unsorted");
			for (int i = 0; i < ar.size(); i++)
				System.out.println(ar.get(i));

			Collections.sort(ar, new AgeCompareror());

			System.out.println("\nSorted by age");
			for (int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i));
			}
			Collections.sort(ar, new NameCompareror());

			System.out.println("\nSorted by name");
			for (int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i));
			}
			Collections.sort(ar, new DepartmentCompareror());

			System.out.println("\nSorted by department");
			for (int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i));
			}
		} while (false);// 7
		palendromes(); // 8
		for (int i : primes()) {// 9
			System.out.println(i);
		}
		do {// 10
			Integer[] input = array1To100();
			double d = 54.28d;
			for (int i : input) {
				System.out.println("Min of this pair: " + min(i, d));
			}
		} while (false);
		System.out.println("sum of numbers retreved from other package: " + getFromOtherPackage());// 11
		evens();// 12
		pyramid();// 13
		do { //14
			SwitchDemonstrator s = new SwitchDemonstrator(1, 245.4);
			s = new SwitchDemonstrator(2, 245.4);
			s = new SwitchDemonstrator(3, 245.4);
			for(String out:s.outputStringArray){
				System.out.println(out);
			}
		} while(false);
		do {//15
			MathWhiz m = new MathWhiz();
			double a = 1245.2;
			int g = 3;
			System.out.println(a+" + "+g+ " = "+m.addition(a, g));
			System.out.println(a+" - "+g+ " = "+m.subtraction(a, g));
			System.out.println(a+" * "+g+ " = "+m.multiplication(a, g));
			System.out.println(a+" / "+g+ " = "+m.division(a, g));
		}while(false);
		String [] in = {"weee"};
		InputLenghtFinder.main(in);//16
		try {// 17
			simpleInterest();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		do{
			UppercaseChecker u = new UppercaseChecker();
			System.out.println(u.changeToCase("Wahh"));
			System.out.println(u.hasCase("foo"));
			System.out.println(u.hasCase("FOO"));
			System.out.println(u.toIntAndModify("300"));
		}while(false);// 18
		arrayListDemo();// 19
		readFromFile();// 20
	}

	// 1
	static int[] bubbleSort(int... input) {
		// runs the bubble sort algorithm on an arbitrarily long array
		// first clone the input to prevent unexpected array modifications
		int[] holder = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			holder[i] = input[i];
		}
		boolean c; // continuation check, falls out of scope if inside the do loop
		int g = 1; // trade memory for slight speed efficiency
		do {
			c = false;
			for (int i = 0; i < holder.length - g; i++) {
				if (holder[i] > holder[i + 1]) {
					int temp = holder[i];// holds the value
					holder[i] = holder[i + 1];// swaps the low value back
					holder[i + 1] = temp;// writes the value forward
					c = true;// count
				}
			}
			g++;
		} while (c);
		return holder;
	}

	// 2
	static int[] fibonacci() {
		return iterativeAdditionSequence(25, 0, 1);
	}

	static int[] iterativeAdditionSequence(int toDo, int n0, int n1) { // runs the fibonacci equation on any two numbers
																		// for any length
		int[] out = new int[toDo];
		for (int i = 0; i < toDo; i++) {
			out[i] = n0;
			int holder = n0 + n1;
			n0 = n1;
			n1 = holder;
		}
		return out;
	}

	// 3
	static String reverseString(String input) {
		String out = "";// you need a holder so you don't overwrite data you need latter, warning makes
						// strings a ton of times
		for (int i = input.length() - 1; i >= 0; i--) {// walks through the string backwards and appends to the output
			out += input.charAt(i);
		}
		return out;
	}

	// 4
	static int nFactorial(int in) {
		int out = 1;
		for (int i = in; i > 0; i--) {
			out = i * out;
		}
		return out;
	}

	// 5
	static String getSubstring(String str, int idx) {
		String out = "";
		for (int i = 0; i < idx; i++) {
			out += str.charAt(i);
		}
		return out;
	}

	// 6
	static boolean isEven(int input) {
		return dividesCleanly(input, 2);
	}

	static boolean dividesCleanly(int numerator, int denominator) {
		int product = numerator / denominator;
		return (product * denominator) == numerator;
	}

	// 7
	// com.revature.homework.employee
	// 8
	static void palendromes() {
		PalendromeSeperator p = new PalendromeSeperator();
		for (String s : p.getInput()) {
			System.out.print(s + ", ");
		}
		System.out.println();
		for (String s : p.getPalendromes()) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}

	// 9

	static Integer[] array1To100() {
		Integer[] out = new Integer[100];
		for (int i = 0; i < 100; i++) {
			out[i] = i + 1;
		}
		return out;
	}

	static ArrayList<Integer> primes() {
		return primes(array1To100());
	}

	static ArrayList<Integer> primes(Integer[] integers) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		next: for (int i : integers) {
			if (i > -2 && i < 2) { // one, zero and -1 isn't considered prime
				continue;
			}
			for (int n = 2; n <= Math.sqrt(i); n++) { // for i/n=r where n > sqrt(i) r is always either not an integer
														// or >Sqrt(I)
				if (i % n == 0) {
					continue next;
				}
			}

			out.add(i);
		}
		return out;
	}

	// 10
	static Number min(Number n1, Number n2) {
		return n1.doubleValue() > n2.doubleValue() ? n2 : n1;
	}

	// 11
	static Float getFromOtherPackage() {
		System.out.println(com.revature.homework2.Question11Holder.float1);
		System.out.println(com.revature.homework2.Question11Holder.getFloat2());
		return com.revature.homework2.Question11Holder.float1 + com.revature.homework2.Question11Holder.getFloat2();
	}

	// 12
	static void evens() {
		evens(array1To100());
	}

	static Integer[] evens(Integer[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i : input) {
			if (isEven(i)) {
				output.add(i);
			}
		}
		Integer[] out = new Integer[output.size()];
		return output.toArray(out);
	}
	// 13

	static void pyramid() {
		pyramid(false, 4);
	}

	static void pyramid(boolean nextIsOne, int levels) {
		for (int y = 1; y <= levels; y++) {
			for (int x = 1; x <= y; x++) {
				System.out.print(nextIsOne ? 1 + " " : 0 + " ");
				nextIsOne = !nextIsOne;
			}
			System.out.println();
		}
	}

	// 17
	static double simpleInterest() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double a = 0;
		double b = 0;
		double c = 0;
		System.out.println("Input Principle:");
		a = Double.valueOf(reader.readLine());
		System.out.println();
		System.out.println("Input rate of return as a decimal value (not percentage):");
		b = Double.valueOf(reader.readLine());
		System.out.println();
		System.out.println("Input Years:");
		c = Double.valueOf(reader.readLine());
		System.out.println();
		Double out = simpleInterest(a, b, c);
		System.out.println(out);
		return out;
	}

	static double simpleInterest(double a, double b, double c) {
		return a * b * c;
	}

	// 19
	static ArrayList<Integer> arrayListDemo() {
		ArrayList<Integer> holder = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			holder.add(i);
		}
		int out = 0;
		for (int i : holder) {
			if (isEven(i)) {
				out += i;
			}
		}
		System.out.println(out);
		out = 0;
		for (int i : holder) {
			if (!isEven(i)) {
				out += i;
			}
		}
		System.out.println(out);
		Integer[] temp = new Integer[10];
		ArrayList<Integer> filter = primes(holder.toArray(temp));
		holder.removeAll(filter);
		for (Integer i : holder) {
			System.out.println(i);
		}
		return holder;
	}

	// 20
	static ArrayList<String[]> readFromFile() {
		InputStream in = null;
		File file = new File("Homework1Q20Input.txt");
		StringBuilder sb = new StringBuilder();
		ArrayList<String[]> output = new ArrayList<String[]>();
		try {
			in = new FileInputStream(file);
			int b = 0;
			while ((b = in.read()) != -1) {
				char c = (char) b;
				sb.append(c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(file.getAbsolutePath());
		}
		for (String s : sb.toString().split("\r\n")) {
			output.add(s.split(":"));
		}
		// replace me with that file IO!
		for (String[] s : output) {
			System.out.println("Name: " + s[0] + " " + s[1] + " age: " + s[2] + " state: " + s[3]);
		}
		return output;
	}
}
