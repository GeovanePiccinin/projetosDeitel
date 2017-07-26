public class SingletonPatternDemo
{
	public static void main(String[] args)
	{
		//illegal construct - because the construct is private
		//SingleObject singleObject = new SingleObject();
	
		//Get the only available
		SingleObject object = SingleObject.getInstance();
		
		object.showMessage();
			
	}
}
