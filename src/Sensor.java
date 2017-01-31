
public class Sensor {
	private int[] distance = new int[2500];
	

	
	public Sensor(){
		
		for(int i = 0; i < 2500; i++){
			distance[i] = (int) (Math.random() * 200);
		}
		
		int i = (int) (Math.random() * 2450);
		for(int j = i; j < i +25 ; j++){
			distance[j] = -1;
			//TODO add noise
			//TODO add more parking spaces
		}
		for(int x = 0; x < 2500; x++){
			System.out.println(distance[x]);
			}
	}

	
	public int[] getDistance(int position){
		int[] distance = new int[5];
		for(int i = 0; i < 5; i++ ){
			distance[i] = this.distance[i +  (position * 5)];
		}
		return distance;
	}
	
}
