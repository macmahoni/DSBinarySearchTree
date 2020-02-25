//Chin-Chap & MacMahon

public class Packet implements Comparable <Packet>{
	
	int number;
	String data;
	
	public Packet(int num, String s) {
		data = s;
		number = num;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getData() {
		return data;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Packet p) {
		if(p.getNumber() > this.getNumber()) {
			return -1;
		}
		if(p.getNumber() < this.getNumber()) {
			return 1;
		}
		if(p.getNumber() == this.getNumber()) {
			return 0;
		}
		return 0;
	}
	
	public String toString() {
		return data;
	}
}
