package application.Logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NonTouchingLoop {
	private ArrayList<ArrayList<String> > results ;
	private int n ;
	
	public NonTouchingLoop(int n){
		this.results = new ArrayList<ArrayList<String> >(100);
		this.n = n ;
	}
	
	





	void findSubsets(String[] array, int index, ArrayList<String> combination) {

	if (index == array.length) {
		if(combination.size() == n )
		{
			boolean touching = false ;
			 Map< Character, Integer> hm1  = new HashMap<Character, Integer>();
			for(String loop : combination)
			{
				for(int i=0 ;i<loop.length();i++)
				{
					int count = hm1.containsKey(loop.charAt(i)) ? hm1.get(loop.charAt(i)) : 0;
					if(count >= 1)
						touching = true ;
					hm1.put(loop.charAt(i), count + 1);
				}
			}
			if(!touching)
			{
				ArrayList<String> NonTouching = new ArrayList<String>() ;
				for(int i=0 ;i<combination.size();i++)
					NonTouching.add(combination.get(i)) ;
				this.results.add(NonTouching) ;		
			}
						
		}

	return;

	}

	combination.add(array[index]);

	findSubsets(array, index + 1, combination);

	combination.remove(combination.size()-1);

	findSubsets(array, index + 1, combination);

	}
	
	void printArr() {
		for(int i=0 ;i<this.results.size();i++)
		{
			System.out.print(this.results.get(i));
		
			System.out.println();
		}
	}
	ArrayList<ArrayList<String>> getResults() {
		return this.results ;
	}
	
	public String[] ConvertListIntoStringArray(Integer[][] loops)
	{
		String str="" ;
		String array[] = new String[loops.length] ;
		int in=0 ;
		for(Integer[] list : loops) {
			for(Integer num : list) str+=num;
			array[in++] =str ;
			str="" ;	
		}
		return array ;
	}
	
	public ArrayList<ArrayList<String>>  getNonTouchingLoops(Integer[][] loops) {
		String[] arr = this.ConvertListIntoStringArray(loops) ;
		ArrayList<String> combination = new ArrayList<String>();
		this.findSubsets(arr, 0, combination);
		return this.getResults() ;
		
		
	}
	
	
	
	
	

}
