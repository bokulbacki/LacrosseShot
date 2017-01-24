
public class Players
	{
		private String name;
		private int percent;
		private int number;
		private String color;
		
		public Players (String na, int p, int num, String c)
			{
				name=na;
				percent=p;
				number=num;
				color=c;
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getPercent()
			{
				return percent;
			}

		public void setPercent(int percent)
			{
				this.percent = percent;
			}

		public int getNumber()
			{
				return number;
			}

		public void setNumber(int number)
			{
				this.number = number;
			}

		public String getColor()
			{
				return color;
			}

		public void setColor(String color)
			{
				this.color = color;
			}
		
	}
