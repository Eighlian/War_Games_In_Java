package cosc1337;

public class TTTbutton extends WarGames {
	
	private int value;
	
	public TTTbutton() {
		this.setState(0);
		
	}
	
	public void setState(int state) {
		if (state == 0) {
			this.setText(" - ");
			this.value = 0;
		}
		else if (state == 1) {
			this.setText(" X ");
			this.value = 1;
		}
		else if (state == -1) {
			this.setText(" O ");
			this.value = -1;
		}
		else {
			System.out.println("setState() called with illegal state");
		}
	}
	
	private void setText(String string) {
		// TODO Auto-generated method stub
		
	}

	public int getValue() {
		return value;
	}
	
	public void changeState() {
		if (this.value == -1)
			this.setState(0);
		else if (this.value == 0)
			this.setState(1);
		else if (this.value == 1)
			this.setState(-1);
	}

	public void setPrefSize(int buttonSize, int buttonSize2) {
		// TODO Auto-generated method stub
		
	}

	public void setOnAction(WarGames warGames) {
		// TODO Auto-generated method stub
		
	}
}

