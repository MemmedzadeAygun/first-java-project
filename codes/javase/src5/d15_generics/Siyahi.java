package d15_generics;

public class Siyahi<T> {
	
	Object[] massivim=null;//[i]
	int index=0;
	int inc=0;
	
	public Siyahi(int initial, int increment) {
		massivim=new Object[initial];
		this.inc=increment;
	}
	
	public void elementisilmek(int a) {
		
	}
	
	public void yenisi(T i) {
		
		if(index==massivim.length) {
			Object[] yeniMassiv=new Object[massivim.length+inc];
			for(int j=0; j<massivim.length; j++) {
				yeniMassiv[j]=massivim[j];
			}
			massivim=yeniMassiv;
		}
		
		massivim[index]=i;
		index++;
	}

	public String hamisiniQaytar() {
		String s="[";
		for(int i=0; i<index; i++) {
			
			if(index==i+1){
				s=s+massivim[i];
			}else {
				s=s+massivim[i]+", ";
			}
		}
		return s+"]";
	}
	
}
