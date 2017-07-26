public abstract class Burguer implements Item
{
	public Packing packing()
	{
		return new Wrapper();
	}

	public abstract float price();
}
