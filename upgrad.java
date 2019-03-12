import java.util.ArrayList;
import java.util.*;
public class upgrad {
	
	//array lists to store input data
	static ArrayList<String> event = new ArrayList<String>();
	static ArrayList<String> name = new ArrayList<String>();
	static ArrayList<Double> cgpa = new ArrayList<Double>();
	static ArrayList<Integer> token = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int i, no_of_events = in.nextInt();
		
		upgrad object = new upgrad();
		
		//taking input
		for(i=0;i<no_of_events;i++) {
			event.add(in.next());
			if(event.get(i).equals("ENTER")) {
				name.add(in.next());
				cgpa.add(in.nextDouble());
				token.add(in.nextInt());
			}
			else if(event.get(i).equals("SERVED")) object.serve();
			else System.out.println("Invalid event type");
		}
		
		//Printing final output
		for(i=0;i<name.size();i++) System.out.println(name.get(i));
		in.close();
	}
	
	//function to serve the entry and remove that from the list
	void serve() {
		int i, j, n = name.size();
		
		//sorting cgpa, names and tokens according to cgpa
		for(i=0;i<n-1;i++) {
			for(j=0;j<n-i-1;j++) {
				if(cgpa.get(j) < cgpa.get(j+1)) {
					double t = cgpa.get(j);
					cgpa.add(j, cgpa.get(j+1)); cgpa.remove(j+1);
					cgpa.add(j+1, t); cgpa.remove(j+2);
					
					String t2 = name.get(j);
					name.add(j, name.get(j+1)); name.remove(j+1);
					name.add(j+1, t2); name.remove(j+2);
					
					int t3 = token.get(j);
					token.add(j, token.get(j+1)); token.remove(j+1);
					token.add(j+1, t3); token.remove(j+2);
				}
			}
		}
		
		//comparing and removing on the basis of cgpa
		if(!cgpa.get(0).equals(cgpa.get(1))) remove(0);
		
		//comparing and removing on the basis of names if cgpa is equal
		else if(!name.get(0).equals(name.get(1))) {
			if(name.get(0).compareTo(name.get(1))<0) remove(0);
			else remove(1);
		}
		
		//comparing and removing on the basis of tokens if cgpa and names
		else {
			if(token.get(0)<token.get(1)) remove(0);
			else remove(1);
		}
	}
	
	//function to remove an entry from the list
	void remove(int x) {
		cgpa.remove(x);
		name.remove(x);
		token.remove(x);
	}
}