package Activities;

public class MyBook extends Activity5_Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyBook newNovel = new MyBook();
		newNovel.setTitle("Mahabarat");

		System.out.println("Title of book = " + newNovel.getTitle());
	}

	public void setTitle(String title) {

		this.title = title;

	}

}
