public class GlidePoint{

	private int x;
	private int y;

	public GlidePoint(String point){
		point = point.replace("(","");
		point = point.replace(")","");
		point = point.trim();
		String[] coordinates = point.split(",");
		this.x = Integer.parseInt(coordinates[0].trim());
		this.y = Integer.parseInt(coordinates[1].trim());
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void moveUp(){
		x++;
		y++;
	}

	public void moveDown(){
		x++;
		y--;
	}

	public void stationary(){
		x++;
	}

	private boolean collidesUpperHoop(GlidePoint hoop){
		if (this.x == hoop.getX()) {
			if(this.y >= hoop.getY()){
				return true;
			}
		}

		return false;
	}

	private boolean collidesLowerHoop(GlidePoint hoop){
		if (this.x == hoop.getX()) {
			if(this.y <= hoop.getY()){
				return true;
			}
		}

		return false;
	}

	private boolean collidesGround(){
		if(y <= 0)
			return true;
		else return false;
	}

	private void printPoint(String action){
		System.out.println(action+": ("+x+", "+y+")");
	}

	private boolean checkCollision(GlidePoint top, GlidePoint bottom){
		if(collidesUpperHoop(top) || collidesLowerHoop(bottom) || collidesGround())
			return true;
		else
			return false;
	}

	public void glide(String actions, GlidePoint top, GlidePoint bottom){
		for(int i =0; i < actions.length(); i++){



			char action = actions.charAt(i);
			if(action == 'U'){
				moveUp();
				printPoint("U");

			}else if(action == 'D'){
				moveDown();
				printPoint("D");

			}else if(action == 'S'){
				stationary();
				printPoint("S");

			}

			boolean collide = checkCollision(top, bottom);

			if(collide){
				System.out.println("Failure");
				return;
			}
		}
		System.out.println("Success");
	}

}