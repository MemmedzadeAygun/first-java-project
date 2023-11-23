package oop;

public class BookMain {

	public static void main(String[] args) {
		Book myBook=new Book("Insanin yoneldiyi tek hedef, hedefini elde etmek ucun dayanmadan gosterdiyi cabasidir","Fyodor Dostoyevski");
		System.out.println("Sitat:"+myBook.getTitle()+" "+"Muellif:"+myBook.getAuthor());

	}

}
